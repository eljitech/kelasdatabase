package ei.eseptiyadi.invoices.models.details;

import com.google.gson.annotations.SerializedName;

public class InfoPartner{

	@SerializedName("alamat_perusahaan")
	private String alamatPerusahaan;

	@SerializedName("kode_pos")
	private String kodePos;

	@SerializedName("nama_perusahaan")
	private String namaPerusahaan;

	@SerializedName("kode_pt")
	private String kodePt;

	public void setAlamatPerusahaan(String alamatPerusahaan){
		this.alamatPerusahaan = alamatPerusahaan;
	}

	public String getAlamatPerusahaan(){
		return alamatPerusahaan;
	}

	public void setKodePos(String kodePos){
		this.kodePos = kodePos;
	}

	public String getKodePos(){
		return kodePos;
	}

	public void setNamaPerusahaan(String namaPerusahaan){
		this.namaPerusahaan = namaPerusahaan;
	}

	public String getNamaPerusahaan(){
		return namaPerusahaan;
	}

	public void setKodePt(String kodePt){
		this.kodePt = kodePt;
	}

	public String getKodePt(){
		return kodePt;
	}

	@Override
 	public String toString(){
		return 
			"InfoPartner{" + 
			"alamat_perusahaan = '" + alamatPerusahaan + '\'' + 
			",kode_pos = '" + kodePos + '\'' + 
			",nama_perusahaan = '" + namaPerusahaan + '\'' + 
			",kode_pt = '" + kodePt + '\'' + 
			"}";
		}
}