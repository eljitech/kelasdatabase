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
            $response["message"] = "Data tersedia didatabase";
            $response["code"] = 200;
            $response["totalinvoice"] = $cekketersediaandata[exist_invoice];    
            $response["status"] = true;
            $response["invoicelist"] = array();

            $list_invoice = mysqli_query($_AUTH, "SELECT * FROM tbl_invoice;");

            while($row = mysqli_fetch_array($list_invoice)) {
                $data = array();

                $data['no_invoice'] = $row['no_invoice'];
                $data['tanggal_dibuat'] = $row['tanggal_dibuat'];
                $data['tgl_jatuhtempo'] = $row['tgl_jatuhtempo'];

                array_push($response['invoicelist'], $data);
            }
        }
        echo json_encode($response);
    } else {
        echo "Belum memenuhi syarat, ubah method menjadi POST";
    }
?>