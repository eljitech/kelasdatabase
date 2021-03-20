<?php
    // 17 Maret 2021 : Final Module test Kelas Android Batch #1
    $SERVER = "localhost";
    $USERBD = "root";
    $PASSDB = "!!&21adi";
    $DBNAME = "db_invoiceapi";

    $_AUTH = mysqli_connect($SERVER, $USERBD, $PASSDB, $DBNAME);

    if ($_AUTH) {
        $response["message"] = "Akses kedatabase berhasil";
        $response["code"] = 200;
        $response["status"] = true;
    } else {
        $response["message"] = "Akses kedatabase gagal, silahkan coba lagi atau cek konfigurasi";
        $response["code"] = 400;
        $response["status"] = false;
    }

    // echo json_encode($response);

?>