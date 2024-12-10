package com.example.kiosk.widget.adapter.viewHolder.mapper;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.kiosk.databinding.ViewholderCartItemBinding;
import com.example.kiosk.databinding.ViewholderEmptyBinding;
import com.example.kiosk.databinding.ViewholderKioskItemBinding;
import com.example.kiosk.model.CellType;
import com.example.kiosk.model.Model;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.screen.main.fragment.cartItem.viewModel.CartItemViewModel;
import com.example.kiosk.screen.main.fragment.kioskProduct.viewModel.KioskProductViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.viewHolder.ModelViewHolder;
import com.example.kiosk.widget.adapter.viewHolder.cartItem.CartItemViewHolder;
import com.example.kiosk.widget.adapter.viewHolder.empty.EmptyViewHolder;
import com.example.kiosk.widget.adapter.viewHolder.kioskItem.KioskItemViewHolder;

public class ModelViewHolderMapper {
    private ModelViewHolderMapper() {
    }

    @SuppressLint("UNCHECKED_CAST")
    public static <M extends Model, VM extends BaseViewModel> ModelViewHolder<M, VM> map(
            @NonNull ViewGroup parent,
            @NonNull CellType type,
            @NonNull VM viewModel,
            @NonNull ResourcesProvider resourcesProvider) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ModelViewHolder<? extends Model, ? extends BaseViewModel> viewHolder = null;

        switch (type) {
            case EMPTY_CELL:
                viewHolder = new EmptyViewHolder(
                        ViewholderEmptyBinding.inflate(inflater, parent, false),
                        viewModel,
                        resourcesProvider
                );
                break;

            case KIOSK_PRODUCT_CELL:
                viewHolder = new KioskItemViewHolder(
                        ViewholderKioskItemBinding.inflate(inflater, parent, false),
                        (KioskProductViewModel) viewModel,
                        resourcesProvider
                );
                break;

            case CART_ITEM_CELL:
                viewHolder = new CartItemViewHolder(
                        ViewholderCartItemBinding.inflate(inflater, parent, false),
                        (CartItemViewModel) viewModel,
                        resourcesProvider
                );
                break;

            default:
                throw new IllegalArgumentException("Unsupported CellType: " + type);
        }

        return (ModelViewHolder<M, VM>) viewHolder;
    }
}
