package com.example.kiosk.screen.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.kiosk.databinding.ActivityMainBinding;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.home.HomeActivity;
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

        // 아래는 Activity 보일러 플레이트입니다
        initViewModelObserver();

        handler = new Handler(this.getMainLooper());
        executeFetchJobAfterViewModelInitialized();
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

    @Override
    protected void initViewModelObserver() {
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        observeData();
    }

    @NonNull
    @Override
    protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}
