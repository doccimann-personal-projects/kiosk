package com.example.kiosk.screen.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {
    // Activity가 생성될 시 처음 해야할 동작을 정의하는 비동기 작업 정의
    @Nullable
    protected Runnable fetchData = initializeFetchData();

    // 컴포넌트에서 내부 데이터 처리를 위해 선언
    protected Bundle stateBundle = null;

    protected void storeState(@NonNull Bundle stateBundle) {
        this.stateBundle = stateBundle;
    }

    @Nullable
    abstract protected Runnable initializeFetchData();

    @Nullable
    public Runnable getFetchData() {
        return fetchData;
    }
}
