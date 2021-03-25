package ei.eseptiyadi.invoices.models.list;

import com.google.gson.annotations.SerializedName;

public class InvoicelistItem{

	@SerializedName("tgl_jatuhtempo")
	private String tglJatuhtempo;

	@SerializedName("nama_staff")
	private String namaStaff;

	@SerializedName("posisi")
	private String posisi;

	@SerializedName("no_staff")
	private String noStaff;

	@SerializedName("no_invoice")
	private String noInvoice;

	@SerializedName("tanggal_dibuat")
	private String tanggalDibuat;

	public String getTglJatuhtempo(){
		return tglJatuhtempo;
	}

	public String getNamaStaff(){
		return namaStaff;
	}

	public String getPosisi(){
		return posisi;
	}

	public String getNoStaff(){
		return noStaff;
	}

	public String getNoInvoice(){
		return noInvoice;
	}

	public String getTanggalDibuat(){
		return tanggalDibuat;
	}
}