package com.example.kiosk.manager.permission;

import android.Manifest;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.kiosk.manager.permission.contract.AbstractPermissionManager;
import com.example.kiosk.manager.permission.contract.PermissionManagerInterface;
import com.example.kiosk.screen.base.BaseActivity;

import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class HomeActivityPermissionManager<T extends BaseActivity<?, ?>> extends AbstractPermissionManager<T> implements PermissionManagerInterface<T> {
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    private static final String[] permissions = new String[]{Manifest.permission.POST_NOTIFICATIONS};

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    public void requestOptionalPermissions(@NonNull T activity, @Nullable Runnable onSuccess) {
        obtainOptionalPermissions(permissions, activity, onSuccess);
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    public boolean isGrantedAllPermissions(@NonNull T activity) {
        return checkIsGrantedAllPermissions(activity, permissions);
    }
}
