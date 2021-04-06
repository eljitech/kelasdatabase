package ei.eseptiyadi.invoices.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ei.eseptiyadi.invoices.R;
import ei.eseptiyadi.invoices.models.details.ListProdukpoItem;

public class AdapterListProduct extends RecyclerView.Adapter<AdapterListProduct.MyViewHolder>{

    Context context;
    List<ListProdukpoItem> poItem;

    public AdapterListProduct (Context context, List<ListProdukpoItem> poItem) {
        this.context = context;
        this.poItem = poItem;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_listproduct, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtkdProd.setText(poItem.get(position).getKodeProduk());
        holder.txtnmProd.setText(poItem.get(position).getProduk());
        holder.txtttlUnit.setText("Ordered " + poItem.get(position).getJmlQty() + "/unit");
        holder.txthrgSatuan.setText("IDR.  " + poItem.get(position).getHargaSatuan());

        String ket_diskon = poItem.get(position).getKeteranganDiskon().toString();
        Log.d("LOG", "MSG "  + ket_diskon);

        switch (ket_diskon) {
            case "Diskon" :
                holder.txthrgDiscount.setVisibility(View.VISIBLE);
                holder.txthrgCoret.setVisibility(View.VISIBLE);
                holder.txthrgPotong.setVisibility(View.VISIBLE);
                holder.txthrgDiscount.setText("Discount IDR. " + poItem.get(position).getPotonganHarga());
                holder.txthrgCoret.setText("IDR. " + poItem.get(position).getJumlah());
                holder.txthrgPotong.setText("IDR. " + poItem.get(position).getTotalBayar());
                holder.txthrgPotong.setTextColor(Color.GREEN);
                holder.txthrgCoret.setTextColor(Color.RED);
                break;
            case "Tidak Diskon" :
                holder.txthrgDiscount.setVisibility(View.GONE);
                holder.txthrgCoret.setText("IDR. " + poItem.get(position).getJumlah());
                holder.txthrgPotong.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return poItem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtkdProd, txtnmProd, txtttlUnit, txthrgDiscount, txthrgSatuan, txthrgCoret, txthrgPotong;

        public MyViewHolder( View itemView) {
            super(itemView);

            txtkdProd = (TextView)itemView.findViewById(R.id.kdProduct);
            txtnmProd = (TextView)itemView.findViewById(R.id.nmProduct);
            txtttlUnit = (TextView)itemView.findViewById(R.id.ttlUnit);
            txthrgDiscount = (TextView)itemView.findViewById(R.id.hrgDiscount);
            txthrgSatuan = (TextView)itemView.findViewById(R.id.hrgSatuan);
            txthrgCoret = (TextView)itemView.findViewById(R.id.hrgCoret);
            txthrgPotong = (TextView)itemView.findViewById(R.id.hrgPotong);
        }
    }
}
