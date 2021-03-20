package ei.eseptiyadi.invoices.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RequestListInvoice{

	@SerializedName("totaldata")
	private int totaldata;

	@SerializedName("invoicelist")
	private List<InvoicelistItem> invoicelist;

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public int getTotaldata(){
		return totaldata;
	}

	public List<InvoicelistItem> getInvoicelist(){
		return invoicelist;
	}

	public int getCode(){
		return code;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}