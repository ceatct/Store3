package com.example.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<com.example.store.RecyclerAdapter.MyHolder> {

    private List<Model.Product> products;
    private Context context;

    public RecyclerAdapter(Context context, List<Model.Product> products) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_template, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.name_txt.setText(products.get(position).getTitle());
        holder.price_txt.setText(products.get(position).getPrice());
        Picasso.get().load(products.get(position).getUrl()).into(holder.product_img);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView product_img;
        TextView name_txt, price_txt;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            product_img = itemView.findViewById(R.id.product_img);
            name_txt = itemView.findViewById(R.id.name_txt);
            price_txt = itemView.findViewById(R.id.price_txt);
        }
    }

}
