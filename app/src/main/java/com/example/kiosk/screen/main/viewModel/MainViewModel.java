package com.example.kiosk.screen.main.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kiosk.screen.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {
    private final MutableLiveData<Boolean> _navigateToHomeActivity = new MutableLiveData<>(false);
    public final LiveData<Boolean> navigateToHomeActivity = _navigateToHomeActivity;

    public void onBackButtonClicked() {
        _navigateToHomeActivity.postValue(true);
    }

    public void doneNavigatingToHomeActivity() {
        _navigateToHomeActivity.postValue(false);
    }
}
