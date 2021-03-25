package ei.eseptiyadi.invoices.models.details;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RequestDetailInvoice{

	@SerializedName("header_invoice")
	private HeaderInvoice headerInvoice;

	@SerializedName("datatotalpo")
	private Datatotalpo datatotalpo;

	@SerializedName("code")
	private int code;

	@SerializedName("total_produkpo")
	private int totalProdukpo;

	@SerializedName("list_produkpo")
	private List<ListProdukpoItem> listProdukpo;

	@SerializedName("info_partner")
	private InfoPartner infoPartner;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setHeaderInvoice(HeaderInvoice headerInvoice){
		this.headerInvoice = headerInvoice;
	}

	public HeaderInvoice getHeaderInvoice(){
		return headerInvoice;
	}

	public void setDatatotalpo(Datatotalpo datatotalpo){
		this.datatotalpo = datatotalpo;
	}

	public Datatotalpo getDatatotalpo(){
		return datatotalpo;
	}

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setTotalProdukpo(int totalProdukpo){
		this.totalProdukpo = totalProdukpo;
	}

	public int getTotalProdukpo(){
		return totalProdukpo;
	}

	public void setListProdukpo(List<ListProdukpoItem> listProdukpo){
		this.listProdukpo = listProdukpo;
	}

	public List<ListProdukpoItem> getListProdukpo(){
		return listProdukpo;
	}

	public void setInfoPartner(InfoPartner infoPartner){
		this.infoPartner = infoPartner;
	}

	public InfoPartner getInfoPartner(){
		return infoPartner;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"RequestDetailInvoice{" + 
			"header_invoice = '" + headerInvoice + '\'' + 
			",datatotalpo = '" + datatotalpo + '\'' + 
			",code = '" + code + '\'' + 
			",total_produkpo = '" + totalProdukpo + '\'' + 
			",list_produkpo = '" + listProdukpo + '\'' + 
			",info_partner = '" + infoPartner + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}