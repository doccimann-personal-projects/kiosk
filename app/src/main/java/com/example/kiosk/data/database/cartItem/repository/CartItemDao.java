package com.example.kiosk.data.database.cartItem.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kiosk.data.database.cartItem.entity.CartItemRoomEntity;

import java.util.List;

@Dao
public interface CartItemDao {
    @Insert
    public void save(CartItemRoomEntity entity);

    @Update
    public void update(CartItemRoomEntity entity);

    @Delete
    public void delete(CartItemRoomEntity entity);

    @Query("SELECT * FROM cart_items")
    public List<CartItemRoomEntity> findAll();
}
