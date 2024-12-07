package com.example.kiosk.screen.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.kiosk.databinding.ActivityMainBinding;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.home.HomeActivity;
import com.example.kiosk.screen.main.viewModel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {
    private MainViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewModelObserver();
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
    protected void initViewModelObserver() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        observeData();
    }

    @Override
    protected MainViewModel getViewModel() {
        return null;
    }

    @NonNull
    @Override
    protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}
