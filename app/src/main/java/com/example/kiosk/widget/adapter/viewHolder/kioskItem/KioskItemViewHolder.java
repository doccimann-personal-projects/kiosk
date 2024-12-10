package com.example.kiosk.widget.adapter.viewHolder.kioskItem;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.example.kiosk.databinding.ViewholderKioskItemBinding;
import com.example.kiosk.extension.ImageViewExtension;
import com.example.kiosk.model.kioskProduct.KioskProductModel;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.screen.main.fragment.kioskProduct.viewModel.KioskProductViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.viewHolder.ModelViewHolder;
import com.example.kiosk.widget.listener.AdapterListener;
import com.example.kiosk.widget.listener.kioskProduct.KioskProductListListener;

public class KioskItemViewHolder extends ModelViewHolder<KioskProductModel, KioskProductViewModel> {
    private final ViewholderKioskItemBinding binding;

    public KioskItemViewHolder(@NonNull ViewholderKioskItemBinding binding,
                               @NonNull KioskProductViewModel viewModel,
                               @NonNull ResourcesProvider resourcesProvider) {
        super(binding, viewModel, resourcesProvider);
        this.binding = binding;
    }

    @Override
    protected void reset() {
        ImageViewExtension.clear(binding.productImage);
    }

    @Override
    public void bindViews(@NonNull KioskProductModel model, @NonNull AdapterListener adapterListener) {
        if (adapterListener instanceof KioskProductListListener) {
            binding.getRoot().setOnClickListener(v -> {
                ((KioskProductListListener) adapterListener).onClickItem(model);
            });
        }
    }

    @Override
    public void bindData(@NonNull KioskProductModel model) {
        super.bindData(model);

        ImageViewExtension.loadDefault(binding.productImage, model.getImageUrl(), 24f);
        binding.productName.setText(model.getName());
        binding.productPrice.setText(model.getPrice().toString() + "원");
    }
}
