package com.example.kiosk.widget.adapter.viewHolder.kioskItem;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.example.kiosk.model.kioskItem.KioskItemModel;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.viewHolder.ModelViewHolder;
import com.example.kiosk.widget.listener.AdapterListener;
import com.example.kiosk.widget.listener.kioskProduct.KioskProductListListener;

public class KioskItemViewHolder extends ModelViewHolder<KioskItemModel> {
    private final ViewBinding binding;

    public KioskItemViewHolder(@NonNull ViewBinding binding,
                               @NonNull BaseViewModel viewModel,
                               @NonNull ResourcesProvider resourcesProvider) {
        super(binding, viewModel, resourcesProvider);
        this.binding = binding;
    }

    @Override
    protected void reset() {
        // TODO 구현
    }

    @Override
    public void bindViews(@NonNull KioskItemModel model, @NonNull AdapterListener adapterListener) {
        if (adapterListener instanceof KioskProductListListener) {
            binding.getRoot().setOnClickListener(v -> {
                ((KioskProductListListener) adapterListener).onClickItem(model);
            });
        }
    }

    @Override
    public void bindData(@NonNull KioskItemModel model) {
        super.bindData(model);

        // TODO 구현
    }
}
