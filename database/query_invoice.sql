CREATE DATABASE db_invoice;

USE db_invoiceapi;

SHOW TABLES;

-- Drop Relasi table Staff dari table Transaksi
ALTER TABLE tbl_transaksi 
DROP FOREIGN KEY fk_staff2transaksi;

-- Drop Field no_staff dari table Transaksi
DESC tbl_transaksi;

ALTER TABLE `db_invoice`.`tbl_transaksi` DROP PRIMARY KEY, ADD PRIMARY KEY (`id_transaksi`, `no_invoice`, `no_po`, `kode_partner`, `kode_produk`);

ALTER TABLE tbl_transaksi
DROP no_staff;

-- Tambah Field no_staff pada table invoice & set primary key 
ALTER TABLE tbl_invoice
ADD COLUMN no_staff VARCHAR(60) NOT NULL;

DESC tbl_invoice;

-- Edit data pada table invoice 
UPDATE tbl_invoice 
SET no_staff = '8912371237' 
WHERE no_invoice = 'FT/30/01/2021';

UPDATE tbl_invoice 
SET no_staff = '2801923813' 
WHERE no_invoice = 'FT/12/02/2021';

DESC tbl_invoice;

ALTER TABLE `db_invoice`.`tbl_invoice` DROP PRIMARY KEY, ADD PRIMARY KEY (`no_invoice`, `kode_bank`, `no_suratjalan`, `kode_manager`, `no_staff`);

-- Membuat Relasi table staff ke table invoice
ALTER TABLE tbl_invoice
ADD CONSTRAINT fk_staff2invoice
FOREIGN KEY (no_staff) REFERENCES tbl_staff (no_staff);