package com.example.kiosk.screen.main.fragment.cartItem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kiosk.databinding.FragmentCartItemBinding;
import com.example.kiosk.model.cartItem.CartItemModel;
import com.example.kiosk.screen.base.BaseFragment;
import com.example.kiosk.screen.main.fragment.cartItem.viewModel.CartItemViewModel;
import com.example.kiosk.screen.main.viewModel.MainSharedViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.ModelRecyclerAdapter;
import com.example.kiosk.widget.listener.cartItem.CartItemListListener;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CartItemFragment extends BaseFragment<CartItemViewModel, FragmentCartItemBinding> {
    @Inject
    MainSharedViewModel mainSharedViewModel;

    @Inject
    CartItemViewModel viewModel;

    @Inject
    ResourcesProvider resourcesProvider;

    private ModelRecyclerAdapter<CartItemModel, CartItemViewModel> adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("brian", "CartItemFragment.onCreate() called!");
        super.onCreate(savedInstanceState);

        adapter = new ModelRecyclerAdapter<>(List.of(), viewModel, resourcesProvider, new CartItemListListener() {
            @Override
            public void onClickItem(@NonNull CartItemModel model) {
                Intent intent = new Intent();
                intent.putExtra("productId", model.getId());
            }
        });
    }

    @Override
    protected void initViews() {
        super.initViews();

        // 어댑터 장착
        binding.cartItemRecyclerView.setAdapter(adapter);

        // 버튼 클릭 리스너 초기화
        binding.btnCheckout.setOnClickListener(v -> {
            viewModel.onCheckoutButtonClicked();
        });

        binding.btnBack.setOnClickListener(v -> {
            viewModel.onCancelButtonClicked();
        });
    }

    @Override
    protected void observeData() {
        Log.i("brian", "cartItemFragment.observeData() called!");

        viewModel.cartItemListLiveData.observe(this, modelList -> {
            adapter.submitList(modelList);
        });
    }

    @Override
    protected CartItemViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected FragmentCartItemBinding getViewBinding() {
        return FragmentCartItemBinding.inflate(getLayoutInflater());
    }

    public static CartItemFragment newInstance() {
        return new CartItemFragment();
    }
}
