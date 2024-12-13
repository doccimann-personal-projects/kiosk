package com.example.kiosk.screen.menuDescription;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiosk.R;
import com.example.kiosk.databinding.ActivityMenuDescriptionBinding;
import com.example.kiosk.model.kioskProduct.KioskProductModel;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.main.MainActivity;
import com.example.kiosk.screen.menuDescription.fragment.menuDescription.MenuDescriptionFragment;
import com.example.kiosk.screen.menuDescription.fragment.menuDescription.viewModel.MenuDescriptionViewModel;
import com.example.kiosk.screen.menuDescription.viewModel.MenuDescriptionSharedViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MenuDescriptionActivity extends BaseActivity<MenuDescriptionSharedViewModel, ActivityMenuDescriptionBinding> {
    @Inject
    MenuDescriptionSharedViewModel sharedViewModel;

    MenuDescriptionViewModel menuDescriptionFragmentViewModel;

    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler(this.getMainLooper());
    }

    @Override
    protected void initViews() {
        super.initViews();

        binding.menuDescriptionBackButton.setOnClickListener(v -> {
            this.finish();
        });

        binding.btnBackToMain.setOnClickListener(v -> {
            this.finish();
        });

        // load
        binding.btnLoadToCart.setOnClickListener(v -> {
            KioskProductModel productModel = menuDescriptionFragmentViewModel.kioskProductModelLiveData.getValue();
            sharedViewModel.onLoadToCartButtonClicked(productModel);
            this.finish();
        });

        Intent intent = getIntent();
        long productId = intent.getLongExtra(MainActivity.PRODUCT_ID_INTENT_KEY, 0L);

        MenuDescriptionFragment menuDescriptionFragment = MenuDescriptionFragment.newInstance(productId);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.menu_description_fragment_container, menuDescriptionFragment)
                .runOnCommit(() -> {
                    menuDescriptionFragmentViewModel = menuDescriptionFragment.getViewModel();
                })
                .commit();
    }

    @Override
    protected void observeData() {

    }

    @NonNull
    @Override
    protected ActivityMenuDescriptionBinding getViewBinding() {
        return ActivityMenuDescriptionBinding.inflate(getLayoutInflater());
    }
}
