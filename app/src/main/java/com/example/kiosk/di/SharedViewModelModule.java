package com.example.kiosk.di;

import android.content.Context;

import com.example.kiosk.screen.home.viewModel.HomeSharedViewModel;
import com.example.kiosk.screen.main.viewModel.MainSharedViewModel;
import com.example.kiosk.screen.menuDescription.viewModel.MenuDescriptionSharedViewModel;
import com.example.kiosk.useCase.cartItem.PersistCartItemUseCase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.scopes.ActivityScoped;

@Module
@InstallIn(ActivityComponent.class)
public class SharedViewModelModule {
    @Provides
    @ActivityScoped
    public HomeSharedViewModel providesHomeViewModel() {
        return new HomeSharedViewModel();
    }

    @Provides
    @ActivityScoped
    public MainSharedViewModel providesMainViewModel(@ActivityContext Context context) {
        return new MainSharedViewModel(context);
    }

    @Provides
    @ActivityScoped
    public MenuDescriptionSharedViewModel providesMenuDescriptionSharedViewModel(@ActivityContext Context context, PersistCartItemUseCase persistCartItemUseCase) {
        return new MenuDescriptionSharedViewModel(context, persistCartItemUseCase);
    }
}
