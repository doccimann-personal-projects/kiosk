package com.example.kiosk.manager.permission.contract;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.kiosk.screen.base.BaseActivity;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AbstractPermissionManager<T extends BaseActivity<?, ?>> {
    protected int currentSdkVersion = Build.VERSION.SDK_INT;

    protected int requestCodeForOptionalPermissions = 7912;

    public void obtainOptionalPermissions(@NonNull String[] permissions,
                                          @NonNull T activity,
                                          @Nullable Runnable onSuccess) {
        boolean allPermissionsGranted = checkIsGrantedAllPermissions(activity, permissions);

        if (allPermissionsGranted) {
            runOnSucceedCallbackOnActivity(activity);
        } else {
            activity.setOnRequestPermissionSucceed(onSuccess);
            ActivityCompat.requestPermissions(activity, permissions, requestCodeForOptionalPermissions);
        }
    }

    protected boolean checkIsGrantedAllPermissions(@NonNull Context context, @NonNull String[] permissions) {
        return Arrays.stream(permissions)
                .allMatch(permission -> {
                    return ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
                });
    }

    public void onRequestPermissionsResult(int requestCode,
                                            @NonNull String[] permissions,
                                            @NonNull int[] grantResults,
                                            @NonNull T activity) {
        boolean allPermissionsGranted = isAllGrantedPermissionResults(grantResults);

        if (allPermissionsGranted) {
            runOnSucceedCallbackOnActivity(activity);
        } else {
            handleGrantPermissionsFailed(requestCode, permissions, activity);
        }
    }

    private boolean isAllGrantedPermissionResults(@NonNull int[] grantResults) {
        return Arrays.stream(grantResults).allMatch(grantResult -> grantResult == PackageManager.PERMISSION_GRANTED);
    }

    private void handleGrantPermissionsFailed(int requestCode, @NonNull String[] permissions, @NonNull T activity) {
        Toast.makeText(activity, "권한이 거부되었습니다", Toast.LENGTH_SHORT).show();
    }

    private void runOnSucceedCallbackOnActivity(@NonNull T activity) {
        try {
            Runnable onSucceedCallback = activity.getOnRequestPermissionSucceed();

            if (onSucceedCallback != null) {
                onSucceedCallback.run();
            }
        } catch (Exception e) {
            Log.e("RunCallback", "Error while running onSucceedCallback", e);
        }
    }
}
