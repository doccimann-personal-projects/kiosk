package com.example.kiosk.screen.main.viewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kiosk.screen.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityScoped;

@ActivityScoped
public class MainSharedViewModel extends BaseViewModel {
    private final Context context;

    // Home으로 돌아갈지 말지
    private final MutableLiveData<Boolean> _navigateToHomeActivity = new MutableLiveData<>(false);
    public final LiveData<Boolean> navigateToHomeActivity = _navigateToHomeActivity;

    // 메뉴 설명을 띄울 product의 id
    private final MutableLiveData<Long> _toDescribeProductIdLiveData = new MutableLiveData<>(null);
    public final LiveData<Long> toDescribeProductIdLiveData = _toDescribeProductIdLiveData;

    @Inject
    public MainSharedViewModel(Context context) {
        this.context = context;
    }

    public void onBackButtonClicked() {
        _navigateToHomeActivity.postValue(true);
    }

    public void doneNavigatingToHomeActivity() {
        _navigateToHomeActivity.postValue(false);
    }

    public void onKioskProductClicked(long productId) {
        _toDescribeProductIdLiveData.postValue(productId);
    }

    public void doneNavigatingToMenuDescriptionActivity() {
        _toDescribeProductIdLiveData.postValue(null);
    }

    @Nullable
    @Override
    protected Runnable initializeFetchData() {
        return null;
    }
}
