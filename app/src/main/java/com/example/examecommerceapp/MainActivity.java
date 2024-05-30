package com.example.examecommerceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.examecommerceapp.activity.CartActivity;
import com.example.examecommerceapp.activity.ProductShowActivity;
import com.example.examecommerceapp.adapter.ProductAdapter;
import com.example.examecommerceapp.databinding.ActivityMainBinding;
import com.example.examecommerceapp.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    List<ProductModel> productModelList = new ArrayList<>();
    public static List<ProductModel> cartModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        productModelList.add(new ProductModel("Samsung Galaxy A14","₹21,999",R.drawable.samsung));
        productModelList.add(new ProductModel("One-Plus Television","₹40,999",R.drawable.one_plus));
        productModelList.add(new ProductModel("LG 560 Refrigerator","₹64,999",R.drawable.fridge));
        productModelList.add(new ProductModel("Office Cheir","₹6,999",R.drawable.cheir));
        productModelList.add(new ProductModel("Candes Ceiling Fan","₹9,999",R.drawable.fan));
        productModelList.add(new ProductModel("Premier Elenora Mixer","₹13,999",R.drawable.mixer));
        productModelList.add(new ProductModel("Denial Wellington Watch","₹44,999",R.drawable.watch));

        ProductAdapter adapter = new ProductAdapter(this,productModelList);
        mainBinding.productRv.setAdapter(adapter);

        mainBinding.cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });


    }
}