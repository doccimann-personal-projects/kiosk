package com.example.kiosk.screen.menuDescription.fragment.menuDescription;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.kiosk.databinding.FragmentMenuDescriptionBinding;
import com.example.kiosk.extension.ImageViewExtension;
import com.example.kiosk.model.kioskProduct.KioskProductModel;
import com.example.kiosk.screen.base.BaseFragment;
import com.example.kiosk.screen.menuDescription.fragment.menuDescription.viewModel.MenuDescriptionViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MenuDescriptionFragment extends BaseFragment<MenuDescriptionViewModel, FragmentMenuDescriptionBinding> {
    public static final String PRODUCT_ID_KEY = "productId";

    @Inject
    MenuDescriptionViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("brian", "MenuDescriptionFragment.onCreate() called!");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void observeData() {
        viewModel.kioskProductModelLiveData.observe(this, productModel -> {
            if (productModel != null) {
                initViewsOnProductModelInitialized(productModel);
            }
        });
    }

    @Override
    protected void initViews() {
        super.initViews();
    }

    private void initViewsOnProductModelInitialized(KioskProductModel productModel) {
        ImageViewExtension.loadDefault(binding.menuDescriptionImage, productModel.getImageUrl(), 0f);
        binding.menuDescriptionName.setText(productModel.getName());
        binding.menuDescriptionPrice.setText(productModel.getPrice().toString());
        binding.menuDescriptionDetails.setText(productModel.getName());
    }

    @Override
    protected MenuDescriptionViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected FragmentMenuDescriptionBinding getViewBinding() {
        return FragmentMenuDescriptionBinding.inflate(getLayoutInflater());
    }

    public static MenuDescriptionFragment newInstance(long productId) {
        MenuDescriptionFragment fragment = new MenuDescriptionFragment();

        Bundle bundle = new Bundle();
        bundle.putLong(PRODUCT_ID_KEY, productId);

        fragment.setArguments(bundle);
        return fragment;
    }
}
