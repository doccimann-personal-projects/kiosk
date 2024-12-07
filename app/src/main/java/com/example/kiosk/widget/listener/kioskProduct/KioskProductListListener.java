package com.example.kiosk.widget.listener.kioskProduct;

import androidx.annotation.NonNull;

import com.example.kiosk.model.kioskProduct.KioskProductModel;
import com.example.kiosk.widget.listener.AdapterListener;

public interface KioskProductListListener extends AdapterListener {
    // Kiosk 상품을 선택할 시 이벤트를 처리하는 메소드
    void onClickItem(@NonNull KioskProductModel model);
}
