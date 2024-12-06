package com.example.kiosk.screen.home;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiosk.databinding.ActivityHomeBinding;
import com.example.kiosk.manager.permission.HomeActivityPermissionManager;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.home.viewModel.HomeViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity<HomeViewModel, ActivityHomeBinding> {
    @Inject
    HomeActivityPermissionManager<HomeActivity> permissionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // API 33 이상일 경우 알림 권한 요청 처리
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionManager.requestOptionalPermissions(this, null);
        }
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
