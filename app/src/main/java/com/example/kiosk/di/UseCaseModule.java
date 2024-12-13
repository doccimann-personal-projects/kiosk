package com.example.kiosk.di;

import com.example.kiosk.data.database.cartItem.repository.CartItemDao;
import com.example.kiosk.data.network.kiosk.repository.KioskProductRepository;
import com.example.kiosk.useCase.cartItem.FindCartItemUseCase;
import com.example.kiosk.useCase.cartItem.PersistCartItemUseCase;
import com.example.kiosk.useCase.kioskProduct.FetchKioskProductUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UseCaseModule {
    @Provides
    @Singleton
    public FetchKioskProductUseCase providesFetchKioskProductUseCase(KioskProductRepository kioskProductRepository) {
        return new FetchKioskProductUseCase(kioskProductRepository);
    }

    @Provides
    @Singleton
    public PersistCartItemUseCase providesPersistCartItemUseCase(CartItemDao cartItemDao) {
        return new PersistCartItemUseCase(cartItemDao);
    }

    @Provides
    @Singleton
    public FindCartItemUseCase providesFindCartItemUseCase(CartItemDao cartItemDao) {
        return new FindCartItemUseCase(cartItemDao);
    }
}
