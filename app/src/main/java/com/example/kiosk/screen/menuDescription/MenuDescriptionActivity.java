package com.example.kiosk.screen.menuDescription;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiosk.databinding.ActivityMenuDescriptionBinding;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.menuDescription.viewModel.MenuDescriptionViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MenuDescriptionActivity extends BaseActivity<MenuDescriptionViewModel, ActivityMenuDescriptionBinding> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
