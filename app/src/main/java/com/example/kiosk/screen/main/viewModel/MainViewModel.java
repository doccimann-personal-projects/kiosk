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
public class MainViewModel extends BaseViewModel {
    private final Context context;

    private final MutableLiveData<Boolean> _navigateToHomeActivity = new MutableLiveData<>(false);
    public final LiveData<Boolean> navigateToHomeActivity = _navigateToHomeActivity;

    @Inject
    public MainViewModel(Context context) {
        this.context = context;
    }

    public void onBackButtonClicked() {
        _navigateToHomeActivity.postValue(true);
    }

    public void doneNavigatingToHomeActivity() {
        _navigateToHomeActivity.postValue(false);
    }

    @Nullable
    @Override
    protected Runnable initializeFetchData() {
        return () -> {
            Toast.makeText(context, "메인 화면 호출 완료", Toast.LENGTH_SHORT).show();
        };
    }
}
