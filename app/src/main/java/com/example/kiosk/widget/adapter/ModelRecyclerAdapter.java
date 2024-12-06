package com.example.kiosk.widget.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.example.kiosk.model.Model;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.viewHolder.ModelViewHolder;
import com.example.kiosk.widget.listener.AdapterListener;

import java.util.List;

public class ModelRecyclerAdapter<M extends Model, VM extends BaseViewModel> extends ListAdapter<Model, ModelViewHolder<Model>> {
    private List<Model> modelList;
    private final VM viewModel;
    private final ResourcesProvider resourcesProvider;
    private final AdapterListener adapterListener;

    public ModelRecyclerAdapter(@NonNull List<Model> modelList,
                                @NonNull VM viewModel,
                                @NonNull ResourcesProvider resourcesProvider,
                                @NonNull AdapterListener adapterListener) {
        super(Model.DIFF_CALLBACK());

        this.modelList = modelList;
        this.viewModel = viewModel;
        this.resourcesProvider = resourcesProvider;
        this.adapterListener = adapterListener;
    }

    @NonNull
    @Override
    public ModelViewHolder<Model> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // TODO ModelViewHolderMapper
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder<Model> holder, int position) {

    }
}
