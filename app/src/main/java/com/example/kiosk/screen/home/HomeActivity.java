package com.example.kiosk.screen.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiosk.databinding.ActivityHomeBinding;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.home.viewModel.HomeViewModel;

public class HomeActivity extends BaseActivity<HomeViewModel, ActivityHomeBinding> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void observeData() {

    }

    @Override
    protected HomeViewModel getViewModel() {
        return null;
    }

    @NonNull
    @Override
    protected ActivityHomeBinding getViewBinding() {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }
}
