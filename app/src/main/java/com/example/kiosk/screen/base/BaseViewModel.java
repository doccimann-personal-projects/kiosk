package com.example.kiosk.screen.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {
    // 컴포넌트에서 내부 데이터 처리를 위해 선언
    protected Bundle stateBundle = null;

    protected void storeState(@NonNull Bundle stateBundle) {
        this.stateBundle = stateBundle;
    }
}
