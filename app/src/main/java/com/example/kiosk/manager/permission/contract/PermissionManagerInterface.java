package com.example.kiosk.manager.permission.contract;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiosk.screen.base.BaseActivity;

public interface PermissionManagerInterface<T extends BaseActivity<?, ?>> {
    // TODO 실제 request 메소드들 정의

    /**
     * 선택적 권한을 요청하는 메소드
     * @param activity
     * @param onSuccess
     */
    void requestOptionalPermissions(@NonNull T activity, @Nullable Runnable onSuccess);

    /**
     * 요청 권한이 모두 존재하는지 여부를 반환하는 메소드
     * @param activity
     * @return
     */
    boolean isGrantedAllPermissions(@NonNull T activity);
}
