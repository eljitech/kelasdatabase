package ei.eseptiyadi.invoices.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import ei.eseptiyadi.invoices.R;

public class ListInvoiceActivity extends AppCompatActivity {

    // Deklarasi
    RecyclerView listInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listinvoice);

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