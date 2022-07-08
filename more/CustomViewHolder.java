package com.example.store;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView name_txt, price_txt;
    ImageView product_img;
    RecyclerView rv;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        name_txt = itemView.findViewById(R.id.name_txt);
        price_txt = itemView.findViewById(R.id.price_txt);
        product_img = itemView.findViewById(R.id.product_img);
        rv = itemView.findViewById(R.id.product_img);

    }
}
