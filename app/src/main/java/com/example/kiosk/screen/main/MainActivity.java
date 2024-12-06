package com.example.kiosk.screen.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewbinding.ViewBinding;

import com.example.kiosk.R;
import com.example.kiosk.databinding.ActivityMainBinding;
import com.example.kiosk.screen.base.BaseActivity;
import com.example.kiosk.screen.base.BaseViewModel;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    @Override
    protected void observeData() {

    }

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected ViewBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
}
