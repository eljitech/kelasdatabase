<?php 
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
        }

        echo json_encode($response);
    } else {
        $response["message"] = "Sory, API ini memerlukan method POST";
        $response["code"] = 401;
        $response["status"] = false;

        echo json_encode($response);
    }
?>