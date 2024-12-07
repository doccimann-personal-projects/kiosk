package com.example.kiosk.di;

import com.example.kiosk.screen.main.fragment.kioskProduct.viewModel.KioskProductViewModel;
import com.example.kiosk.useCase.kioskProduct.FetchKioskProductUseCase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.FragmentScoped;

@Module
@InstallIn(FragmentComponent.class)
public class FragmentModule {
    @Provides
    @FragmentScoped
    public KioskProductViewModel providesKioskProductViewModel(FetchKioskProductUseCase fetchKioskProductUseCase) {
        return new KioskProductViewModel(fetchKioskProductUseCase);
    }
}
