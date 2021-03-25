package ei.eseptiyadi.invoices.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ei.eseptiyadi.invoices.R;
import ei.eseptiyadi.invoices.models.list.InvoicelistItem;
import ei.eseptiyadi.invoices.views.DetailInvoiceActivity;

public class AdapterListInvoice extends RecyclerView.Adapter<AdapterListInvoice.MyViewHolder> {

    Context context;
    List<InvoicelistItem> invoicelistItems;

    public AdapterListInvoice (Context context, List<InvoicelistItem> invoicelistItems) {
        this.context = context;
        this.invoicelistItems = invoicelistItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listinvoice, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtnoInvoice.setText(invoicelistItems.get(position).getNoInvoice());
        // 2801923813 - Wirda Anggraeni
        holder.txtdetailInvoice.setText(invoicelistItems.get(position).getNoStaff() + " - " + invoicelistItems.get(position).getNamaStaff());
        holder.txtstatusInvoice.setText("");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "No Invoice yang Dipilih adalah " + invoicelistItems.get(position).getNoInvoice(), Toast.LENGTH_SHORT).show();

                String noInvoice = invoicelistItems.get(position).getNoInvoice();

                Intent kirimNoInvoice = new Intent(context, DetailInvoiceActivity.class);
                kirimNoInvoice.putExtra("NOINVOICE", noInvoice);
                context.startActivity(kirimNoInvoice);
            }
        });
    }

    @Override
    public int getItemCount() {
        return invoicelistItems.size();
    }

    // Buat Class MyViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Deklarasi View
        TextView txtnoInvoice, txtdetailInvoice, txtstatusInvoice;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtnoInvoice = (TextView)itemView.findViewById(R.id.list_noInvoice);
            txtdetailInvoice = (TextView)itemView.findViewById(R.id.list_noDetailPO);
            txtstatusInvoice = (TextView)itemView.findViewById(R.id.list_statusInvoice);
        }
    }
}
