package com.example.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<StoreDataProduct> products;

    public CustomAdapter(Context context, List<StoreDataProduct> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_product_template, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.name_txt.setText(products.get(position).getAuthor());
        holder.price_txt.setText(products.get(position).getTitle());

        if (products.get(position).getUrlToImage()!=null){
            Picasso.get().load(products.get(position).getUrlToImage()).into(holder.product_img);
        }

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
