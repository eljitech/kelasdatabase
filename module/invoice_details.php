<?php 
    // 17 Maret 2021 : Final Module test Kelas Android Batch #1
    include '../config/connection.php';

    if ($_SERVER['REQUEST_METHOD'] == POST) {
        $cari_noinvoice = $_POST['no_invoice'];

        // 1. Module Pencarian No Invoice
        $mdl_cariinvoice = mysqli_query($_AUTH, "SELECT COUNT(*) 'invoice_exist' FROM tbl_invoice WHERE no_invoice = '$cari_noinvoice'");
        $get_datainvoice = mysqli_fetch_assoc($mdl_cariinvoice);

        // echo $get_datainvoice['invoice_exist'];

        if ($get_datainvoice['invoice_exist'] == 0) {
            $response["message"] = "Maaf, data invoice tidak ada";
            $response["code"] = 404;
            $response["status"] = false;
        } else {
            $response["message"] = "Data dengan no invoice ". $cari_noinvoice ." berhasil di tampilkan";
            $response["code"] = 200;
            $response["status"] = true;

            // 2. Module Header Invoice berdasarkan No Invoice
            $header_invoice = mysqli_query($_AUTH, "SELECT tbl_invoice.no_invoice, tbl_invoice.tanggal_dibuat, tbl_invoice.mata_uang, tbl_invoice.no_suratjalan, tbl_po.no_po, tbl_po.tanggal_po, tbl_rek_perusahaan.kode_bank, tbl_staff.no_staff, tbl_staff.nama_staff, tbl_staff.posisi FROM tbl_transaksi JOIN tbl_po ON tbl_po.no_po=tbl_transaksi.no_po JOIN tbl_invoice ON tbl_invoice.no_invoice=tbl_transaksi.no_invoice JOIN tbl_rek_perusahaan ON tbl_rek_perusahaan.kode_bank=tbl_invoice.kode_bank JOIN tbl_staff ON tbl_staff.no_staff=tbl_invoice.no_staff WHERE tbl_invoice.no_invoice = '$cari_noinvoice'");
            $profiling_headerinvoice = mysqli_fetch_assoc($header_invoice);

            // echo $profiling_headerinvoice['no_invoice'];

            $response["header_invoice"] = [
                "no_invoice" => $profiling_headerinvoice['no_invoice'],
                "tanggal_buat" => $profiling_headerinvoice['tanggal_dibuat'],
                "mata_uang" => $profiling_headerinvoice['mata_uang'],
                "no_suratjalan" => $profiling_headerinvoice['no_suratjalan'],
                "no_po" => $profiling_headerinvoice['mata_uang'],
                "tanggal_po" => $profiling_headerinvoice['tanggal_po'],
                "kode_bank" => $profiling_headerinvoice['kode_bank'],
                "no_staff" => $profiling_headerinvoice['no_staff'],
                "nama_staff" => $profiling_headerinvoice['nama_staff'],
                "posisi" => $profiling_headerinvoice['posisi']
            ];

            // 3. Module Menampilkan Informasi Data Partner 
            $infopartner = mysqli_query($_AUTH, "SELECT tbl_partner.nama_partner, tbl_partner.alamat_partner, CONCAT(tbl_partner.kota, ' - ', tbl_partner.kode_partner) AS kota_kodepos FROM tbl_partner JOIN tbl_transaksi ON tbl_transaksi.kode_partner=tbl_partner.kode_partner WHERE tbl_transaksi.no_invoice = '$cari_noinvoice'");
            $fetchpartner = mysqli_fetch_assoc($infopartner);

            $response["info_partner"] = [
                "nama_perusahaan" => $fetchpartner['nama_partner'],
                "alamat_perusahaan" => $fetchpartner['alamat_partner'],
                "kode_pos" => $fetchpartner['kota_kodepos']
            ];

            // 4. Module Menampilkan List Data Produk yang Dipesan
            $listprodukpo = mysqli_query($_AUTH, "SELECT tbl_produk.kode_produk, tbl_produk.produk, tbl_produk.harga_satuan, tbl_produk.satuan, tbl_produk.minimum_request, tbl_produk.diskon, tbl_transaksi.jml_qty, tbl_produk.harga_satuan*tbl_transaksi.jml_qty AS jumlah, IF(tbl_transaksi.jml_qty>=tbl_produk.minimum_request, 'Diskon','Tidak Diskon') AS keterangan_diskon, IF(tbl_transaksi.jml_qty>=tbl_produk.minimum_request, ROUND((tbl_produk.harga_satuan * tbl_transaksi.jml_qty) * tbl_produk.diskon/100, 0), 0) AS potongan_harga, tbl_produk.harga_satuan*tbl_transaksi.jml_qty - IF(tbl_transaksi.jml_qty>=tbl_produk.minimum_request, ROUND((tbl_produk.harga_satuan * tbl_transaksi.jml_qty) * tbl_produk.diskon/100, 0), 0) AS total_bayar FROM tbl_transaksi JOIN tbl_produk ON tbl_produk.kode_produk=tbl_transaksi.kode_produk WHERE tbl_transaksi.no_invoice = '$cari_noinvoice'");

            $total_dataprodukpo = mysqli_query($_AUTH, "SELECT COUNT(*) 'total_produkpo' FROM tbl_transaksi JOIN tbl_produk ON tbl_produk.kode_produk=tbl_transaksi.kode_produk WHERE tbl_transaksi.no_invoice = '$cari_noinvoice'");
            $fetch_productpototal = mysqli_fetch_assoc($total_dataprodukpo);

            $response["total_produkpo"] = ROUND($fetch_productpototal['total_produkpo']);
            $response["list_produkpo"] = array();

            while($row = mysqli_fetch_array($listprodukpo)) {
                $data = array();

                $data['kode_produk'] = $row['kode_produk'];
                $data['produk'] = $row['produk'];
                $data['harga_satuan'] = $row['harga_satuan'];
                $data['satuan'] = $row['satuan'];
                $data['diskon'] = ROUND($row['diskon']);
                $data['jml_qty'] = ROUND($row['jml_qty']);
                $data['jumlah'] = ROUND($row['jumlah']);
                $data['keterangan_diskon'] = $row['keterangan_diskon'];
                $data['potongan_harga'] = ROUND($row['potongan_harga']);
                $data['total_bayar'] = ROUND($row['total_bayar']);

                array_push($response['list_produkpo'], $data);
            }

            // 5. Module Menampilkan Total Pembayaran, PPN s/d Ongkir
            $subtotalharga = mysqli_query($_AUTH, "SELECT SUM(tbl_produk.harga_satuan*tbl_transaksi.jml_qty - IF(tbl_transaksi.jml_qty>=tbl_produk.minimum_request, ROUND((tbl_produk.harga_satuan * tbl_transaksi.jml_qty) * tbl_produk.diskon/100, 0), 0)) AS total_bayar FROM tbl_transaksi JOIN tbl_produk ON tbl_produk.kode_produk=tbl_transaksi.kode_produk WHERE tbl_transaksi.no_invoice = '$cari_noinvoice'");
            $fetching_finalharga = mysqli_fetch_assoc($subtotalharga);

            $sub_total = $fetching_finalharga['total_bayar'];

            switch ($sub_total) {
                case 25000000: 
                    $potong_pajak = 25 / 100 * $sub_total;
                    $ongkir = 3 / 100 * $potong_pajak;
                    break;
                    case 30000000: 
                        $potong_pajak = 30 / 100 * $sub_total;
                        $ongkir = 6 / 100 * $potong_pajak;
                        break;
                        case 35000000: 
                            $potong_pajak = 35 / 100 * $sub_total;
                            $ongkir = 9 / 100 * $potong_pajak;
                            break;
                            case 40000000: 
                                $potong_pajak = 40 / 100 * $sub_total;
                                $ongkir = 12 / 100 * $potong_pajak;
                                break;
                                case 45000000: 
                                    $potong_pajak = 45 / 100 * $sub_total;
                                    $ongkir = 15 / 100 * $potong_pajak;
                                    break;
                                    case 50000000: 
                                        $potong_pajak = 50 / 100 * $sub_total;
                                        $ongkir = 18 / 100 * $potong_pajak;
                                        break;
                                        default: 
                                                $potong_pajak = 10 / 100 * $sub_total;
                                                $ongkir = 5 / 100 * $potong_pajak;
                                                break;
            }

            $response["datatotalpo"] = [
                "subtotal" => ROUND($sub_total),
                "ppn" => ROUND($potong_pajak),
                "angkir" => ROUND($ongkir),
                "totalbayar" => ROUND($sub_total - $potong_pajak + $ongkir)
            ];
            
        }

        echo json_encode($response);
    } else {
        $response["message"] = "Sory, API ini memerlukan method POST";
        $response["code"] = 401;
        $response["status"] = false;

        echo json_encode($response);
    }
?>