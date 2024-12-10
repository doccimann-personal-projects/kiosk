package com.example.kiosk.widget.listener.cartItem;

import androidx.annotation.NonNull;

import com.example.kiosk.model.cartItem.CartItemModel;
import com.example.kiosk.widget.listener.AdapterListener;

public interface CartItemListListener extends AdapterListener {
    void onClickItem(@NonNull CartItemModel model);
}
