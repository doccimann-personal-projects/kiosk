package com.example.kiosk.screen.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity<VM extends BaseViewModel, VB extends ViewBinding> extends AppCompatActivity {
    protected VB binding;

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
        observeData();
    }

    protected void initViews() {

    }

    protected abstract void observeData();

    protected abstract VM getViewModel();

    protected abstract VB getViewBinding();
}
