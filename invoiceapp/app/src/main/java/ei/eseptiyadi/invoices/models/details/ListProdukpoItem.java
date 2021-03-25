package ei.eseptiyadi.invoices.models.details;

import com.google.gson.annotations.SerializedName;

public class ListProdukpoItem{

	@SerializedName("jml_qty")
	private int jmlQty;

	@SerializedName("produk")
	private String produk;

	@SerializedName("harga_satuan")
	private String hargaSatuan;

	@SerializedName("jumlah")
	private int jumlah;

	@SerializedName("satuan")
	private String satuan;

	@SerializedName("kode_produk")
	private String kodeProduk;

	@SerializedName("total_bayar")
	private int totalBayar;

	@SerializedName("diskon")
	private int diskon;

	@SerializedName("potongan_harga")
	private int potonganHarga;

	@SerializedName("keterangan_diskon")
	private String keteranganDiskon;

	public void setJmlQty(int jmlQty){
		this.jmlQty = jmlQty;
	}

	public int getJmlQty(){
		return jmlQty;
	}

	public void setProduk(String produk){
		this.produk = produk;
	}

	public String getProduk(){
		return produk;
	}

	public void setHargaSatuan(String hargaSatuan){
		this.hargaSatuan = hargaSatuan;
	}

	public String getHargaSatuan(){
		return hargaSatuan;
	}

	public void setJumlah(int jumlah){
		this.jumlah = jumlah;
	}

	public int getJumlah(){
		return jumlah;
	}

	public void setSatuan(String satuan){
		this.satuan = satuan;
	}

	public String getSatuan(){
		return satuan;
	}

	public void setKodeProduk(String kodeProduk){
		this.kodeProduk = kodeProduk;
	}

	public String getKodeProduk(){
		return kodeProduk;
	}

	public void setTotalBayar(int totalBayar){
		this.totalBayar = totalBayar;
	}

	public int getTotalBayar(){
		return totalBayar;
	}

	public void setDiskon(int diskon){
		this.diskon = diskon;
	}

	public int getDiskon(){
		return diskon;
	}

	public void setPotonganHarga(int potonganHarga){
		this.potonganHarga = potonganHarga;
	}

	public int getPotonganHarga(){
		return potonganHarga;
	}

	public void setKeteranganDiskon(String keteranganDiskon){
		this.keteranganDiskon = keteranganDiskon;
	}

	public String getKeteranganDiskon(){
		return keteranganDiskon;
	}

	@Override
 	public String toString(){
		return 
			"ListProdukpoItem{" + 
			"jml_qty = '" + jmlQty + '\'' + 
			",produk = '" + produk + '\'' + 
			",harga_satuan = '" + hargaSatuan + '\'' + 
			",jumlah = '" + jumlah + '\'' + 
			",satuan = '" + satuan + '\'' + 
			",kode_produk = '" + kodeProduk + '\'' + 
			",total_bayar = '" + totalBayar + '\'' + 
			",diskon = '" + diskon + '\'' + 
			",potongan_harga = '" + potonganHarga + '\'' + 
			",keterangan_diskon = '" + keteranganDiskon + '\'' + 
			"}";
		}
}