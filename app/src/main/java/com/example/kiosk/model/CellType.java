package com.example.kiosk.model;

public enum CellType {
    EMPTY_CELL(0),
    KIOSK_PRODUCT_CELL(1),
    CART_ITEM_CELL(2);

    private final int value;

    CellType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CellType from(int value) {
        for (CellType type : values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid CellType value: " + value);
    }
}
