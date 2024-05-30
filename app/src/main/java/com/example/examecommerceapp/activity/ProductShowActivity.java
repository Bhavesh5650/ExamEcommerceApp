package com.example.examecommerceapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.examecommerceapp.MainActivity;
import com.example.examecommerceapp.R;
import com.example.examecommerceapp.databinding.ActivityProductShowBinding;
import com.example.examecommerceapp.model.ProductModel;

public class ProductShowActivity extends AppCompatActivity {

    ActivityProductShowBinding showBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showBinding = ActivityProductShowBinding.inflate(getLayoutInflater());
        setContentView(showBinding.getRoot());

        int pro_image = getIntent().getIntExtra("image",0);
        String pro_price = getIntent().getStringExtra("price");
        String pro_name = getIntent().getStringExtra("name");

        showBinding.showSetImage.setImageResource(pro_image);
        showBinding.showSetName.setText(pro_name);
        showBinding.showSetPrice.setText(pro_price);


        showBinding.showBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        showBinding.showAddToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.cartModelList.add(new ProductModel(pro_name,pro_price,pro_image));
                Toast.makeText(ProductShowActivity.this, "Cart Added Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}