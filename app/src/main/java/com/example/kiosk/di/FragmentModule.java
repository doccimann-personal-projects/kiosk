package com.example.kiosk.di;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.kiosk.screen.main.fragment.cartItem.viewModel.CartItemViewModel;
import com.example.kiosk.screen.main.fragment.kioskProduct.viewModel.KioskProductViewModel;
import com.example.kiosk.screen.menuDescription.fragment.menuDescription.MenuDescriptionFragment;
import com.example.kiosk.screen.menuDescription.fragment.menuDescription.viewModel.MenuDescriptionViewModel;
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
    public CartItemViewModel providesCartItemViewModel() {
        return new CartItemViewModel();
    }

    @Provides
    @FragmentScoped
    public MenuDescriptionViewModel providesMenuDescriptionViewModel(Fragment fragment, FetchKioskProductUseCase fetchKioskProductUseCase) {
        Bundle args = fragment.getArguments();

        if (args != null && args.containsKey(MenuDescriptionFragment.PRODUCT_ID_KEY)) {
            long itemId = args.getLong(MenuDescriptionFragment.PRODUCT_ID_KEY);
            return new MenuDescriptionViewModel(itemId, fetchKioskProductUseCase);
        } else {
            throw new IllegalArgumentException("Item ID not found in arguments");
        }
    }

    @Provides
    @FragmentScoped
    public ResourcesProvider providesResourcesProvider(Fragment fragment) {
        return new DefaultResourcesProvider(fragment.requireContext());
    }
}
