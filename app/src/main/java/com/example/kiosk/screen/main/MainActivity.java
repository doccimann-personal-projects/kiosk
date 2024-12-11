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
import com.example.kiosk.screen.main.viewModel.MainSharedViewModel;
import com.example.kiosk.screen.menuDescription.MenuDescriptionActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<MainSharedViewModel, ActivityMainBinding> {
    public static final String PRODUCT_ID_INTENT_KEY = "productId";

    @Inject
    MainSharedViewModel mainSharedViewModel;

    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler(this.getMainLooper());
        executeFetchJobAfterViewModelInitialized();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (fetchJob != null) {
            handler.removeCallbacks(fetchJob);
        }
    }

    @Override
    protected void initViews() {
        super.initViews();

        binding.backButton.setOnClickListener(v -> {
            mainSharedViewModel.onBackButtonClicked();
        });

        KioskProductFragment kioskProductFragment = KioskProductFragment.newInstance();
        CartItemFragment cartItemFragment = CartItemFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.kiosk_product_fragment_container, kioskProductFragment)
                .add(R.id.cart_item_fragment_container, cartItemFragment)
                .commit();
    }

    @Override
    protected void observeData() {
        mainSharedViewModel.navigateToHomeActivity.observe(this, shouldNavigate -> {
            if (shouldNavigate == true) {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);

                mainSharedViewModel.doneNavigatingToHomeActivity();
            }
        });

        mainSharedViewModel.toDescribeProductIdLiveData.observe(this, productId -> {
            if (productId != null) {
                Intent intent = new Intent(this, MenuDescriptionActivity.class);
                intent.putExtra(PRODUCT_ID_INTENT_KEY, productId);
                startActivity(intent);

                mainSharedViewModel.doneNavigatingToMenuDescriptionActivity();
            }
        });
    }

    @Override
    protected void executeFetchJobAfterViewModelInitialized() {
        fetchJob = mainSharedViewModel.getFetchData();

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
