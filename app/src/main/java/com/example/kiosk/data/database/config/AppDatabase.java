package com.example.kiosk.data.database.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.kiosk.data.database.cartItem.entity.CartItemRoomEntity;
import com.example.kiosk.data.database.cartItem.repository.CartItemDao;
import com.example.kiosk.data.database.config.converter.BigIntegerConverter;

@Database(entities = {CartItemRoomEntity.class}, version = 1)
@TypeConverters(value = {BigIntegerConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract CartItemDao cartItemDao();
}
