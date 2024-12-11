package com.example.kiosk.screen.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiosk.R;
import com.example.kiosk.databinding.ActivityMainBinding;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.home.HomeActivity;
import com.example.kiosk.screen.main.fragment.cartItem.CartItemFragment;
import com.example.kiosk.screen.main.fragment.kioskProduct.KioskProductFragment;
import com.example.kiosk.screen.main.viewModel.MainViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {
    @Inject
    MainViewModel viewModel;

    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler(this.getMainLooper());
        executeFetchJobAfterViewModelInitialized();
    }

    @Override
    protected void initViews() {
        super.initViews();

        binding.backButton.setOnClickListener(v -> {
            viewModel.onBackButtonClicked();
        });

        KioskProductFragment kioskProductFragment = new KioskProductFragment();
        CartItemFragment cartItemFragment = new CartItemFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.kiosk_product_fragment_container, kioskProductFragment)
                .add(R.id.cart_item_fragment_container, cartItemFragment)
                .commit();
    }

    @Override
    protected void observeData() {
        viewModel.navigateToHomeActivity.observe(this, shouldNavigate -> {
            if (shouldNavigate == true) {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);

                viewModel.doneNavigatingToHomeActivity();
            }
        });
    }

    @Override
    protected void executeFetchJobAfterViewModelInitialized() {
        fetchJob = viewModel.getFetchData();

        if (fetchJob != null) {
            handler.post(fetchJob);
        }
    }

    @NonNull
    @Override
    protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}
