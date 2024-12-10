package com.example.kiosk.widget.adapter.viewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.kiosk.model.Model;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.listener.AdapterListener;

abstract public class ModelViewHolder<M extends Model, VM extends BaseViewModel> extends RecyclerView.ViewHolder {
    protected final VM viewModel;
    protected final ResourcesProvider resourcesProvider;

    public ModelViewHolder(@NonNull ViewBinding binding,
                           @NonNull VM viewModel,
                           @NonNull ResourcesProvider resourcesProvider) {
        super(binding.getRoot());
        this.viewModel = viewModel;
        this.resourcesProvider = resourcesProvider;
    }

    abstract protected void reset();

    abstract public void bindViews(@NonNull M model, @NonNull AdapterListener adapterListener);

    public void bindData(@NonNull M model) {
        reset();
    }
}
