package com.example.kiosk.screen.home.viewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kiosk.screen.base.BaseViewModel;

public class HomeViewModel extends BaseViewModel {
    private final MutableLiveData<Boolean> _navigateToMainActivity = new MutableLiveData<>(false);
    public final LiveData<Boolean> navigateToMainActivity = _navigateToMainActivity;

    public void onOrderButtonClicked() {
        _navigateToMainActivity.postValue(true);
    }

    public void doneNavigatingToMainActivity() {
        _navigateToMainActivity.postValue(false);
    }

    @Nullable
    @Override
    protected Runnable initializeFetchData() {
        return null;
    }
}
