package ei.eseptiyadi.invoices.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ei.eseptiyadi.invoices.R;
import ei.eseptiyadi.invoices.adapter.AdapterListInvoice;
import ei.eseptiyadi.invoices.models.list.InvoicelistItem;
import ei.eseptiyadi.invoices.models.list.RequestListInvoice;
import ei.eseptiyadi.invoices.network.ApiServices;
import ei.eseptiyadi.invoices.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListInvoiceActivity extends AppCompatActivity {

    // Deklarasi
    RecyclerView listInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listinvoice);
        getSupportActionBar().setTitle("List Invoice");

        Log.d("LOG", "LIFECYCLE : OnCreate");

        // Instansiasi
        listInvoice = (RecyclerView)findViewById(R.id.rvListInvoice);

        // Inplementasi
        listInvoice.setHasFixedSize(true);
        listInvoice.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        // Module List Invoice
        tampilkanListInvoice();

    }

    private void tampilkanListInvoice() {
        // Request list data invoice dikerjakan disini
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<RequestListInvoice> requestListInvoiceCall = apiServices.req_listinvoice();

        requestListInvoiceCall.enqueue(new Callback<RequestListInvoice>() {
            @Override
            public void onResponse(Call<RequestListInvoice> call, Response<RequestListInvoice> response) {
                if (response.isSuccessful()) {
                        List<InvoicelistItem> itemInvoice = response.body().getInvoicelist();
                        AdapterListInvoice adapterListInvoice = new AdapterListInvoice(ListInvoiceActivity.this, itemInvoice);
                        listInvoice.setAdapter(adapterListInvoice);
                }
            }

            @Override
            public void onFailure(Call<RequestListInvoice> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LOG", "LIFECYCLE : OnStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LOG", "LIFECYCLE : OnPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LOG", "LIFECYCLE : OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LOG", "LIFECYCLE : OnRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LOG", "LIFECYCLE : OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LOG", "LIFECYCLE : OnResume");
    }
}