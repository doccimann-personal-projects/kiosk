package com.example.kiosk.screen.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity<VM extends BaseViewModel, VB extends ViewBinding> extends AppCompatActivity {
    protected VB binding;

    private Runnable onRequestPermissionSucceed = null;

    protected Runnable fetchJob = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.binding = getViewBinding();
        setContentView(binding.getRoot());

        super.onCreate(savedInstanceState);

        initState();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void initState() {
        initViews();
    }

    protected void initViews() {

    }

    protected abstract void observeData();

    protected void initViewModelObserver() {
    }

    @NonNull
    protected abstract VB getViewBinding();

    public Runnable getOnRequestPermissionSucceed() {
        return onRequestPermissionSucceed;
    }

    public void setOnRequestPermissionSucceed(Runnable onRequestPermissionSucceed) {
        this.onRequestPermissionSucceed = onRequestPermissionSucceed;
    }

    protected void executeFetchJobAfterViewModelInitialized() {

    }
}
