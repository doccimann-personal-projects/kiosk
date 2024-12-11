package com.example.kiosk.di;

import android.content.Context;

import com.example.kiosk.screen.home.viewModel.HomeViewModel;
import com.example.kiosk.screen.main.viewModel.MainSharedViewModel;
import com.example.kiosk.screen.menuDescription.viewModel.MenuDescriptionSharedViewModel;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.scopes.ActivityScoped;

@Module
@InstallIn(ActivityComponent.class)
public class ViewModelModule {
    @Provides
    @ActivityScoped
    public HomeViewModel providesHomeViewModel() {
        return new HomeViewModel();
    }

    @Provides
    @ActivityScoped
    public MainSharedViewModel providesMainViewModel(@ActivityContext Context context) {
        return new MainSharedViewModel(context);
    }

    @Provides
    @ActivityScoped
    public MenuDescriptionSharedViewModel providesMenuDescriptionSharedViewModel(@ActivityContext Context context) {
        return new MenuDescriptionSharedViewModel(context);
    }
}
