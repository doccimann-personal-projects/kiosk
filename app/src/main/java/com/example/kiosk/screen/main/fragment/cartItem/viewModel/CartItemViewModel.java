package com.example.kiosk.screen.main.fragment.cartItem.viewModel;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kiosk.model.cartItem.CartItemModel;
import com.example.kiosk.screen.base.BaseViewModel;

import java.util.List;

public class CartItemViewModel extends BaseViewModel {
    private MutableLiveData<List<CartItemModel>> _cartItemListLiveData = new MutableLiveData<>(List.of());
    public LiveData<List<CartItemModel>> cartItemListLiveData = _cartItemListLiveData;

    public void onIncreaseButtonClicked(long itemId) {
        Log.i("brian", "increase button clicked!");
    }

    public void onDecreaseButtonClicked(long itemId) {
        Log.i("brian", "decrease button clicked!");
    }

    public void onCheckoutButtonClicked() {
        Log.i("brian", "cartItemViewModel.onCheckoutButtonClicked() called!");
    }

    public void onCancelButtonClicked() {
        Log.i("brian", "cartItemViewModel.onCancelButtonClicked() called!");
    }

    @Nullable
    @Override
    protected Runnable initializeFetchData() {
        return () -> {
            Log.i("brian", "cartItemViewModel.initializeFetchData() called!");
        };
    }
}
