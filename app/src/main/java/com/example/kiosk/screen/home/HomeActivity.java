package com.example.kiosk.screen.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiosk.databinding.ActivityHomeBinding;
import com.example.kiosk.manager.permission.HomeActivityPermissionManager;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.home.viewModel.HomeViewModel;
import com.example.kiosk.screen.main.MainActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity<HomeViewModel, ActivityHomeBinding> {

    @Inject
    HomeActivityPermissionManager<HomeActivity> permissionManager;

    @Inject
    HomeViewModel viewModel;

    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ViewModel 초기화
        initViewModelObserver();

        handler = new Handler(this.getMainLooper());
        executeFetchJobAfterViewModelInitialized();

        // API 33 이상일 경우 알림 권한 요청 처리
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionManager.requestOptionalPermissions(this, null);
        }
    }

    @Override
    protected void observeData() {
        viewModel.navigateToMainActivity.observe(this, shouldNavigate -> {
            // True인 경우 MainActivity로 이동
            if (shouldNavigate == true) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                viewModel.doneNavigatingToMainActivity();
            }
        });
    }

    @Override
    protected void initViewModelObserver() {
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        observeData();
    }

    @NonNull
    @Override
    protected ActivityHomeBinding getViewBinding() {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
