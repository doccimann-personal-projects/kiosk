package com.example.kiosk.screen.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<VM extends BaseViewModel, VB extends ViewBinding> extends Fragment {
    protected VB binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = getViewBinding();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initState();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected void initState() {
        Bundle arguments = getArguments();

        if (arguments != null) {
            getViewModel().storeState(arguments);
        }

        initViews();
        observeData();
    }

    protected void initViews() {
    }

    protected abstract void observeData();

    protected abstract VM getViewModel();

    protected abstract VB getViewBinding();
}
