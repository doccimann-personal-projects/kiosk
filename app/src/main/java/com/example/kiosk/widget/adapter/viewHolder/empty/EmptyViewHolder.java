package com.example.kiosk.widget.adapter.viewHolder.empty;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.example.kiosk.model.Model;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.viewHolder.ModelViewHolder;
import com.example.kiosk.widget.listener.AdapterListener;

public class EmptyViewHolder extends ModelViewHolder<Model> {
    public EmptyViewHolder(@NonNull ViewBinding binding, @NonNull BaseViewModel viewModel, @NonNull ResourcesProvider resourcesProvider) {
        super(binding, viewModel, resourcesProvider);
    }

    @Override
    protected void reset() {
    }

    @Override
    public void bindViews(@NonNull Model model, @NonNull AdapterListener adapterListener) {
    }
}
