package ei.eseptiyadi.invoices.models.details;

import com.google.gson.annotations.SerializedName;

public class HeaderInvoice{

	@SerializedName("no_suratjalan")
	private String noSuratjalan;

	@SerializedName("tanggal_po")
	private String tanggalPo;

	@SerializedName("kode_bank")
	private String kodeBank;

	@SerializedName("nama_staff")
	private String namaStaff;

	@SerializedName("posisi")
	private String posisi;

	@SerializedName("mata_uang")
	private String mataUang;

	@SerializedName("tanggal_buat")
	private String tanggalBuat;

	@SerializedName("no_staff")
	private String noStaff;

	@SerializedName("no_invoice")
	private String noInvoice;

	@SerializedName("no_po")
	private String noPo;

	public void setNoSuratjalan(String noSuratjalan){
		this.noSuratjalan = noSuratjalan;
	}

	public String getNoSuratjalan(){
		return noSuratjalan;
	}

	public void setTanggalPo(String tanggalPo){
		this.tanggalPo = tanggalPo;
	}

	public String getTanggalPo(){
		return tanggalPo;
	}

	public void setKodeBank(String kodeBank){
		this.kodeBank = kodeBank;
	}

	public String getKodeBank(){
		return kodeBank;
	}

	public void setNamaStaff(String namaStaff){
		this.namaStaff = namaStaff;
	}

	public String getNamaStaff(){
		return namaStaff;
	}

	public void setPosisi(String posisi){
		this.posisi = posisi;
	}

	public String getPosisi(){
		return posisi;
	}

	public void setMataUang(String mataUang){
		this.mataUang = mataUang;
	}

	public String getMataUang(){
		return mataUang;
	}

	public void setTanggalBuat(String tanggalBuat){
		this.tanggalBuat = tanggalBuat;
	}

	public String getTanggalBuat(){
		return tanggalBuat;
	}

	public void setNoStaff(String noStaff){
		this.noStaff = noStaff;
	}

	public String getNoStaff(){
		return noStaff;
	}

	public void setNoInvoice(String noInvoice){
		this.noInvoice = noInvoice;
	}

	public String getNoInvoice(){
		return noInvoice;
	}

	public void setNoPo(String noPo){
		this.noPo = noPo;
	}

	public String getNoPo(){
		return noPo;
	}

	@Override
 	public String toString(){
		return 
			"HeaderInvoice{" + 
			"no_suratjalan = '" + noSuratjalan + '\'' + 
			",tanggal_po = '" + tanggalPo + '\'' + 
			",kode_bank = '" + kodeBank + '\'' + 
			",nama_staff = '" + namaStaff + '\'' + 
			",posisi = '" + posisi + '\'' + 
			",mata_uang = '" + mataUang + '\'' + 
			",tanggal_buat = '" + tanggalBuat + '\'' + 
			",no_staff = '" + noStaff + '\'' + 
			",no_invoice = '" + noInvoice + '\'' + 
			",no_po = '" + noPo + '\'' + 
			"}";
		}
}