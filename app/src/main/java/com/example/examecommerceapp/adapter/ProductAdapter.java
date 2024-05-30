package com.example.examecommerceapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examecommerceapp.R;
import com.example.examecommerceapp.activity.ProductShowActivity;
import com.example.examecommerceapp.databinding.ProductSampleBinding;
import com.example.examecommerceapp.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<ProductModel> productModelList = new ArrayList<>();
    Context context;

    public ProductAdapter(Context context,List<ProductModel> productModelList) {

        this.productModelList = productModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_sample,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.binding.sampleSetProName.setText(productModelList.get(position).name);
        holder.binding.sampleSetProPrice.setText(productModelList.get(position).price);
        holder.binding.sampleSetProImage.setImageResource(productModelList.get(position).image);
        holder.binding.sampleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(), ProductShowActivity.class);
                intent.putExtra("image",productModelList.get(position).image);
                intent.putExtra("price",productModelList.get(position).price);
                intent.putExtra("name",productModelList.get(position).name);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        ProductSampleBinding binding;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ProductSampleBinding.bind(itemView);
        }
    }
}
