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

public class RecyclerAdapterSearch extends RecyclerView.Adapter {

    private List<ModelSearch.Example> src;
    private Context context;

    public RecyclerAdapterSearch(Context context, List<ModelSearch.Example> src) {
        this.src = src;
        this.context = context;
    }

    @NonNull
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_search_item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    public void onBindViewHolder(@NonNull RecyclerAdapterSearch.MyHolder holder, int position) {

        holder.txt.setText(src.get(position).getName());
        Picasso.get().load(src.get(position).getImage()).into(holder.iimg);

    }

    public int getItemCount() {
        return src.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView iimg;
        TextView txt;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            iimg = itemView.findViewById(R.id.iimg);
            txt = itemView.findViewById(R.id.txt);
        }
    }

}
