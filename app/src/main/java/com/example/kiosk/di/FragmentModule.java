package com.example.kiosk.di;

import androidx.fragment.app.Fragment;

import com.example.kiosk.screen.main.fragment.kioskProduct.viewModel.KioskProductViewModel;
import com.example.kiosk.useCase.kioskProduct.FetchKioskProductUseCase;
import com.example.kiosk.util.provider.DefaultResourcesProvider;
import com.example.kiosk.util.provider.ResourcesProvider;

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

    @Provides
    @FragmentScoped
    public ResourcesProvider providesResourcesProvider(Fragment fragment) {
        return new DefaultResourcesProvider(fragment.requireContext());
    }
}
