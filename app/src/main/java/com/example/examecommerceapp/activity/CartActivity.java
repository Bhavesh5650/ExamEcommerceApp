package com.example.examecommerceapp.activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.examecommerceapp.MainActivity;
import com.example.examecommerceapp.R;
import com.example.examecommerceapp.adapter.CartAdapter;
import com.example.examecommerceapp.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding cartBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartBinding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(cartBinding.getRoot());

        cartBinding.cartBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CartAdapter adapter = new CartAdapter(MainActivity.cartModelList);
        cartBinding.cartRv.setAdapter(adapter);
    }
}