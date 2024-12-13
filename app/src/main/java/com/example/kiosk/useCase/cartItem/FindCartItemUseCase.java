package com.example.kiosk.useCase.cartItem;

import com.example.kiosk.data.database.cartItem.repository.CartItemDao;
import com.example.kiosk.model.cartItem.CartItemModel;

import java.util.List;
import java.util.stream.Collectors;

public class FindCartItemUseCase {
    private final CartItemDao cartItemDao;

    public FindCartItemUseCase(CartItemDao cartItemDao) {
        this.cartItemDao = cartItemDao;
    }

    public List<CartItemModel> findAll() {
        return cartItemDao.findAll()
                .stream().map(CartItemModel::fromRoomEntity)
                .collect(Collectors.toList());
    }
}
