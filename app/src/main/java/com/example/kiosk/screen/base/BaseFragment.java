package com.example.kiosk.screen.base;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<VM extends BaseViewModel, VB extends ViewBinding> extends Fragment {
    private Handler handler;

    protected VB binding;

    protected Runnable fetchJob = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler(this.requireContext().getMainLooper());
        fetchJob = getViewModel().fetchData;

        if (fetchJob != null) {
            handler.post(fetchJob);
        }
    }

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

        if (fetchJob != null) {
            handler.removeCallbacks(fetchJob);
        }
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
