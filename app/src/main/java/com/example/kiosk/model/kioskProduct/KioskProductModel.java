package com.example.kiosk.model.kioskProduct;

import com.example.kiosk.data.network.kiosk.entity.KioskProductEntity;
import com.example.kiosk.model.CellType;
import com.example.kiosk.model.Model;

import java.math.BigInteger;

public class KioskProductModel extends Model {
    private final String name;

    private final String imageUrl;

    private final BigInteger price;

    private final String description;

    private KioskProductModel(long id, CellType type, String name, String imageUrl, BigInteger price, String description) {
        super(id, type);
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
    }

    public static KioskProductModel fromEntity(KioskProductEntity entity) {
        return new KioskProductModel(entity.id(), CellType.KIOSK_PRODUCT_CELL, entity.name(), entity.imageUrl(), entity.price(), entity.description());
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigInteger getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
