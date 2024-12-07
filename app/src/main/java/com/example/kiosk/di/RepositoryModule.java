package com.example.kiosk.di;

import com.example.kiosk.data.repository.kiosk.DefaultKioskProductRepository;
import com.example.kiosk.data.repository.kiosk.KioskProductRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {
    @Provides
    @Singleton
    public KioskProductRepository providesKioskProductRepository() {
        return new DefaultKioskProductRepository();
    }
}
