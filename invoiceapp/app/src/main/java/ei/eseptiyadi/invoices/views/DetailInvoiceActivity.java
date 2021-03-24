package ei.eseptiyadi.invoices.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import ei.eseptiyadi.invoices.R;

public class DetailInvoiceActivity extends AppCompatActivity {

    TextView txgetNoInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_invoice);
        getSupportActionBar().setTitle("Detail Item Invoice");

        Bundle getDataIntent = getIntent().getExtras();

        String invoiceGet = getDataIntent.getString("NOINVOICE");

        Log.d("Log", "NOINVOICE " + invoiceGet);

        txgetNoInvoice = (TextView)findViewById(R.id.getNoInvoice);
        txgetNoInvoice.setText(invoiceGet);
    }
}