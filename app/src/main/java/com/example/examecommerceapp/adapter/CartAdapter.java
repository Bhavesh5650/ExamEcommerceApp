package com.example.examecommerceapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examecommerceapp.R;
import com.example.examecommerceapp.databinding.CartSampleBinding;
import com.example.examecommerceapp.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    List<ProductModel> cartModelList = new ArrayList<>();

    public CartAdapter(List<ProductModel> cartModelList) {

        this.cartModelList = cartModelList;

    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_sample,parent,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        holder.binding.cartSetImage.setImageResource(cartModelList.get(position).image);
        holder.binding.cartSetName.setText(cartModelList.get(position).name);
        holder.binding.cartSetPrice.setText(cartModelList.get(position).price);
        holder.binding.cartDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartModelList.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.binding.cartAddQun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(holder.binding.cartSetQuantity.getText().toString());

                count++;
                holder.binding.cartSetQuantity.setText(String.valueOf(count));
            }
        });
        holder.binding.cartRemoveQun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count = Integer.parseInt(holder.binding.cartSetQuantity.getText().toString());

                count--;
                holder.binding.cartSetQuantity.setText(String.valueOf(Integer.parseInt(holder.binding.cartSetQuantity.getText().toString())-1));

                if(count<=0)
                {
                    cartModelList.remove(position);
                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{

        CartSampleBinding binding;
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CartSampleBinding.bind(itemView);
        }
    }
}
