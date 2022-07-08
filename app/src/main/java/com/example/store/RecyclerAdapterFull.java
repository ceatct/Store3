package com.example.store;

import android.annotation.SuppressLint;
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

public class RecyclerAdapterFull extends RecyclerView.Adapter<RecyclerAdapterFull.MyHolder> {

    private List<Model.Product> products;
    private Context context;

    public RecyclerAdapterFull(Context context, List<Model.Product> products) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view, parent, false);

        return new MyHolder(view);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.name.setText(products.get(position).getTitle());
        // holder.info.setTextAlignment(products.get(position).getBody());
        holder.price.setText(products.get(position).getPrice());
        Picasso.get().load(products.get(position).getUrl()).into(holder.tov);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView tov, info;
        TextView name, price;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tov = itemView.findViewById(R.id.tov);
            info = itemView.findViewById(R.id.info);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}

