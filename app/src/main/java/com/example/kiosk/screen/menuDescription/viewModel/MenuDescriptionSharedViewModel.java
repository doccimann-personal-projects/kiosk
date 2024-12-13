package com.example.kiosk.screen.menuDescription.viewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.kiosk.data.database.cartItem.entity.CartItemRoomEntity;
import com.example.kiosk.model.cartItem.CartItemModel;
import com.example.kiosk.model.kioskProduct.KioskProductModel;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.useCase.cartItem.PersistCartItemUseCase;

public class MenuDescriptionSharedViewModel extends BaseViewModel {
    private final Context context;

    private final PersistCartItemUseCase persistCartItemUseCase;

    public MenuDescriptionSharedViewModel(Context context, PersistCartItemUseCase persistCartItemUseCase) {
        this.context = context;
        this.persistCartItemUseCase = persistCartItemUseCase;
    }

    public void onLoadToCartButtonClicked(KioskProductModel productModel) {
        if (productModel == null) {
            return;
        }

        persistCartItemUseCase.persistProductAsCartItem(productModel);
    }

    @Nullable
    @Override
    protected Runnable initializeFetchData() {
        return null;
    }
}
