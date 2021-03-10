<?php
    include '../config/connection.php';

    if ($_SERVER['REQUEST_METHOD'] == GET) {
        $cekexistdata = mysqli_query($_AUTH, "SELECT COUNT(no_invoice) 'exist_invoice' FROM tbl_invoice ORDER BY tanggal_dibuat;");
        $cekketersediaandata = mysqli_fetch_assoc($cekexistdata);

        if($cekketersediaandata[exist_invoice] == 0) {
            $response["message"] = "Data tidak tersedia didatabase";
            $response["code"] = 404;
            $response["status"] = false;
        } else {
            $response["message"] = "Congrat!, Data list invoice tersedia didatabase";
            $response["code"] = 200; 
            $response["status"] = true;
            $response["totalinvoice"] = ROUND($cekketersediaandata[exist_invoice]);
            $response["invoicelist"] = array();

            $list_invoice = mysqli_query($_AUTH, "SELECT tbl_invoice.no_invoice, tbl_invoice.tanggal_dibuat, tbl_invoice.tgl_jatuhtempo, tbl_staff.no_staff, tbl_staff.nama_staff, tbl_staff.posisi FROM tbl_invoice JOIN tbl_staff ON tbl_staff.no_staff=tbl_invoice.no_staff");

            while($row = mysqli_fetch_array($list_invoice)) {
                $data = array();

                $data['no_invoice'] = $row['no_invoice'];
                $data['tanggal_dibuat'] = $row['tanggal_dibuat'];
                $data['tgl_jatuhtempo'] = $row['tgl_jatuhtempo'];
                $data['no_staff'] = $row['no_staff'];
                $data['nama_staff'] = $row['nama_staff'];
                $data['posisi'] = $row['posisi'];

                array_push($response['invoicelist'], $data);
            }
        }
        echo json_encode($response);
    } else {
        echo "Belum memenuhi syarat, ubah method menjadi POST";
    }
?>