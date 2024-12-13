package com.example.kiosk.di;

import android.content.Context;

import androidx.room.Room;

import com.example.kiosk.data.database.cartItem.repository.CartItemDao;
import com.example.kiosk.data.database.config.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {
    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "appDatabase").build();
    }

    @Provides
    @Singleton
    public CartItemDao providesCartItemDao(AppDatabase appDatabase) {
        return appDatabase.cartItemDao();
    }
}
