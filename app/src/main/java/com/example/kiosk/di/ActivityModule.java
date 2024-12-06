package com.example.kiosk.di;

import com.example.kiosk.manager.permission.HomeActivityPermissionManager;
import com.example.kiosk.screen.home.HomeActivity;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.scopes.ActivityScoped;

@Module
@InstallIn(ActivityComponent.class)
public class ActivityModule {
    @Provides
    @ActivityScoped
    public HomeActivityPermissionManager<HomeActivity> providesHomeActivityPermissionManager() {
        return new HomeActivityPermissionManager<>();
    }
}
