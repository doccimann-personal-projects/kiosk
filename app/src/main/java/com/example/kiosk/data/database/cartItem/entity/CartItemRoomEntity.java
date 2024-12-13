package com.example.kiosk.data.database.cartItem.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.BigInteger;

@Entity(tableName = "cart_items")
public class CartItemRoomEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String productName;

    private BigInteger pricePerItem;

    private int quantity;

    public CartItemRoomEntity(long id, String productName, BigInteger pricePerItem, int quantity) {
        this.id = id;
        this.productName = productName;
        this.pricePerItem = pricePerItem;
        this.quantity = quantity;
    }

    public static CartItemRoomEntity initialize(long id, String name, BigInteger price) {
        return new CartItemRoomEntity(id, name, price, 1);
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public BigInteger getPricePerItem() {
        return pricePerItem;
    }

    public int getQuantity() {
        return quantity;
    }
}
