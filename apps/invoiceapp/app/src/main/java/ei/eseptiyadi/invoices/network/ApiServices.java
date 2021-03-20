package ei.eseptiyadi.invoices.network;

import ei.eseptiyadi.invoices.models.RequestListInvoice;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("module/list_invoice.php")
    Call<RequestListInvoice> req_listinvoice ();
}
