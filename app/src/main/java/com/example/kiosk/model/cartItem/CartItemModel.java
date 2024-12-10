package com.example.kiosk.model.cartItem;

import com.example.kiosk.model.CellType;
import com.example.kiosk.model.Model;

import java.math.BigInteger;

public class CartItemModel extends Model {
    private final String name;

    private final BigInteger pricePerItem;

    private final int quantity;

    private CartItemModel(long id, CellType type, String name, BigInteger pricePerItem, int quantity) {
        super(id, type);
        this.name = name;
        this.pricePerItem = pricePerItem;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BigInteger getPricePerItem() {
        return pricePerItem;
    }

    public int getQuantity() {
        return quantity;
    }
}