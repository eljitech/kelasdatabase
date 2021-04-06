package ei.eseptiyadi.invoices.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ei.eseptiyadi.invoices.R;
import ei.eseptiyadi.invoices.adapter.AdapterListProduct;
import ei.eseptiyadi.invoices.models.details.ListProdukpoItem;
import ei.eseptiyadi.invoices.models.details.RequestDetailInvoice;
import ei.eseptiyadi.invoices.network.ApiServices;
import ei.eseptiyadi.invoices.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailInvoiceActivity extends AppCompatActivity {

    TextView txgetNoInvoice, txtgetTglBuatInvoice, txtStaff, txtgetNamaPerusahaan, txtgetAlamatCompany, txtgetKodeCompany, txtgetTotalDataProduct;

    RecyclerView rvListProductfromFactur;

    String no_invoice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_invoice);
        getSupportActionBar().setTitle("Detail Item Invoice");

        Bundle getDataIntent = getIntent().getExtras();

        String invoiceGet = getDataIntent.getString("NOINVOICE");

        Log.d("Log", "NOINVOICE " + invoiceGet);

        txgetNoInvoice = (TextView)findViewById(R.id.getNoInvoice);
        txtgetTglBuatInvoice = (TextView)findViewById(R.id.getTglBuatInvoice);
        txtStaff = (TextView)findViewById(R.id.getStaff);
        txtgetNamaPerusahaan = (TextView)findViewById(R.id.getNamaPerusahaan);
        txtgetAlamatCompany = (TextView)findViewById(R.id.getAlamatPerusahaan);
        txtgetKodeCompany = (TextView)findViewById(R.id.getKodePerusahaan);
        txtgetTotalDataProduct = (TextView)findViewById(R.id.totalDataProductfromFactur);
        rvListProductfromFactur = (RecyclerView)findViewById(R.id.rvListProductinFactur);


        txgetNoInvoice.setText(invoiceGet);

        no_invoice = invoiceGet;

        rvListProductfromFactur.setHasFixedSize(true);
        rvListProductfromFactur.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        moduleListProductfromPO(no_invoice);
        moduleRequestDetailInvoice(no_invoice);
    }

    private void moduleListProductfromPO(String no_invoice) {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<RequestDetailInvoice> reqListProduct = apiServices.reqDetailInvoice(no_invoice);

        reqListProduct.enqueue(new Callback<RequestDetailInvoice>() {
            @Override
            public void onResponse(Call<RequestDetailInvoice> call, Response<RequestDetailInvoice> response) {
                if (response.isSuccessful()) {
                    int statuscode = response.body().getCode();

                    if (statuscode == 200) {
                        int totalDataProduct = response.body().getTotalProdukpo();

                        txtgetTotalDataProduct.setText(totalDataProduct + " Ordered Product");
                        List<ListProdukpoItem> poItem = response.body().getListProdukpo();
                        AdapterListProduct adpListProductfromPO = new AdapterListProduct(DetailInvoiceActivity.this, poItem);
                        rvListProductfromFactur.setAdapter(adpListProductfromPO);
                    } else {
                        Toast.makeText(DetailInvoiceActivity.this, "Data tidak ditemukan.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RequestDetailInvoice> call, Throwable t) {

            }
        });
    }

    private void moduleRequestDetailInvoice(String no_invoice) {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<RequestDetailInvoice> reqDetailInvoiceCall = apiServices.reqDetailInvoice(no_invoice);

        reqDetailInvoiceCall.enqueue(new Callback<RequestDetailInvoice>() {
            @Override
            public void onResponse(Call<RequestDetailInvoice> call, Response<RequestDetailInvoice> response) {
                if (response.isSuccessful()) {
                    int coderespone = response.body().getCode();

                    switch (coderespone) {
                        case 200:
                            String tglBuatInvoice = response.body().getHeaderInvoice().getTanggalBuat().toString();
                            String nama_kodestaff = response.body().getHeaderInvoice().getNoStaff() + " - " + response.body().getHeaderInvoice().getNamaStaff();

                            String namaPT = response.body().getInfoPartner().getNamaPerusahaan();
                            String alamatPT = response.body().getInfoPartner().getAlamatPerusahaan() + " - " + response.body().getInfoPartner().getKodePos();
                            String kodePT = response.body().getInfoPartner().getKodePt();

                            txtgetTglBuatInvoice.setText(tglBuatInvoice);
                            txtStaff.setText(nama_kodestaff);

                            txtgetNamaPerusahaan.setText(namaPT);
                            txtgetAlamatCompany.setText(alamatPT);
                            txtgetKodeCompany.setText(kodePT);
                            break;
                        case 404:

                            break;
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<RequestDetailInvoice> call, Throwable t) {

            }
        });
    }
}