package com.example.kiosk.widget.listener.kioskItem;

import androidx.annotation.NonNull;

import com.example.kiosk.model.kioskItem.KioskItemModel;
import com.example.kiosk.widget.listener.AdapterListener;

public interface KioskItemListListener extends AdapterListener {
    // Kiosk 상품을 선택할 시 이벤트를 처리하는 메소드
    void onClickItem(@NonNull KioskItemModel model);
}
