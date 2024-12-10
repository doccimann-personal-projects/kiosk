package com.example.kiosk.widget.adapter.viewHolder.cartItem;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.kiosk.databinding.ViewholderCartItemBinding;
import com.example.kiosk.model.cartItem.CartItemModel;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.screen.main.fragment.cartItem.viewModel.CartItemViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.viewHolder.ModelViewHolder;
import com.example.kiosk.widget.listener.AdapterListener;

public class CartItemViewHolder extends ModelViewHolder<CartItemModel, CartItemViewModel> {
    private final ViewholderCartItemBinding binding;

    public CartItemViewHolder(@NonNull ViewholderCartItemBinding binding,
                              @NonNull CartItemViewModel viewModel,
                              @NonNull ResourcesProvider resourcesProvider) {
        super(binding, viewModel, resourcesProvider);
        this.binding = binding;
    }

    @Override
    protected void reset() {

    }

    @Override
    public void bindViews(@NonNull CartItemModel model, @NonNull AdapterListener adapterListener) {
        // 수량 추가 버튼
        binding.cartBtnIncrease.setOnClickListener(v -> {
            viewModel.onIncreaseButtonClicked(model.getId());
        });

        // 수량 감소 버튼
        binding.cartBtnDecrease.setOnClickListener(v -> {
            viewModel.onDecreaseButtonClicked(model.getId());
        });
    }

    @Override
    public void bindData(@NonNull CartItemModel model) {
        super.bindData(model);

        // 장바구니 아이템 이름
        binding.cartItemName.setText(model.getName());

        // 아이템 총 수량
        binding.cartTotalQuantity.setText(model.getQuantity());

        // 아이템 총 가격
        int totalPrice = model.getPricePerItem().intValue() * model.getQuantity();
        binding.cartTotalPrice.setText(totalPrice);
    }
}
