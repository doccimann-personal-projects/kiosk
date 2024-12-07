package com.example.kiosk.di;

import com.example.kiosk.data.repository.kiosk.KioskProductRepository;
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
}
