package com.example.kiosk.screen.main.fragment.cartItem.viewModel;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kiosk.model.cartItem.CartItemModel;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.useCase.cartItem.FindCartItemUseCase;
import com.example.kiosk.useCase.cartItem.PersistCartItemUseCase;

import java.util.List;

public class CartItemViewModel extends BaseViewModel {
    private final PersistCartItemUseCase persistCartItemUseCase;

    private final FindCartItemUseCase findCartItemUseCase;

    public CartItemViewModel(PersistCartItemUseCase persistCartItemUseCase, FindCartItemUseCase findCartItemUseCase) {
        this.persistCartItemUseCase = persistCartItemUseCase;
        this.findCartItemUseCase = findCartItemUseCase;
    }

    private MutableLiveData<List<CartItemModel>> _cartItemListLiveData = new MutableLiveData<>(List.of());
    public LiveData<List<CartItemModel>> cartItemListLiveData = _cartItemListLiveData;

    public void onIncreaseButtonClicked(long itemId) {

    }

    public void onDecreaseButtonClicked(long itemId) {

    }

    public void onCheckoutButtonClicked() {

    }

    public void onCancelButtonClicked() {

    }

    public void onResume() {
        List<CartItemModel> cartItemModelList = findCartItemUseCase.findAll();
        _cartItemListLiveData.postValue(cartItemModelList);
    }

    @Nullable
    @Override
    protected Runnable initializeFetchData() {
        return () -> {
            List<CartItemModel> cartItemModelList = findCartItemUseCase.findAll();
            _cartItemListLiveData.postValue(cartItemModelList);
        };
    }
}
