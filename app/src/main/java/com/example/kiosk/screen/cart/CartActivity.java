package com.example.kiosk.screen.cart;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiosk.databinding.ActivityCartBinding;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.cart.viewModel.CartViewModel;

public class CartActivity extends BaseActivity<CartViewModel, ActivityCartBinding> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void observeData() {

    }

    @Override
    protected CartViewModel getViewModel() {
        return null;
    }

    @NonNull
    @Override
    protected ActivityCartBinding getViewBinding() {
        return ActivityCartBinding.inflate(getLayoutInflater());
    }
}
