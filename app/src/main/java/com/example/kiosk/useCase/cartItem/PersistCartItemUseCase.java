package com.example.kiosk.useCase.cartItem;

import com.example.kiosk.data.database.cartItem.entity.CartItemRoomEntity;
import com.example.kiosk.data.database.cartItem.repository.CartItemDao;
import com.example.kiosk.model.kioskProduct.KioskProductModel;

public class PersistCartItemUseCase {
    private final CartItemDao cartItemDao;

    public PersistCartItemUseCase(CartItemDao cartItemDao) {
        this.cartItemDao = cartItemDao;
    }

    public void persistProductAsCartItem(KioskProductModel productModel) {
        CartItemRoomEntity.initialize(productModel.getId(), productModel.getName(), productModel.getPrice());
    }
}
