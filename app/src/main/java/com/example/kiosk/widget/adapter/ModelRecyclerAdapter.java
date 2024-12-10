package com.example.kiosk.widget.adapter;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.kiosk.model.CellType;
import com.example.kiosk.model.Model;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.viewHolder.ModelViewHolder;
import com.example.kiosk.widget.adapter.viewHolder.mapper.ModelViewHolderMapper;
import com.example.kiosk.widget.listener.AdapterListener;

import java.util.List;

public class ModelRecyclerAdapter<M extends Model, VM extends BaseViewModel> extends ListAdapter<M, ModelViewHolder<M, VM>> {
    private List<M> modelList;
    private final VM viewModel;
    private final ResourcesProvider resourcesProvider;
    private final AdapterListener adapterListener;

    public ModelRecyclerAdapter(@NonNull List<M> modelList,
                                @NonNull VM viewModel,
                                @NonNull ResourcesProvider resourcesProvider,
                                @NonNull AdapterListener adapterListener) {
        super((DiffUtil.ItemCallback<M>) M.DIFF_CALLBACK());

        this.modelList = modelList;
        this.viewModel = viewModel;
        this.resourcesProvider = resourcesProvider;
        this.adapterListener = adapterListener;
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return modelList.get(position).getType().getValue();
    }

    @Override
    @NonNull
    public ModelViewHolder<M, VM> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CellType cellType = CellType.from(viewType);
        return ModelViewHolderMapper.map(parent, cellType, viewModel, resourcesProvider);
    }

    @Override
    @SuppressLint("UNCHECKED_CAST")
    public void onBindViewHolder(@NonNull ModelViewHolder<M, VM> holder, int position) {
        holder.bindData((M) modelList.get(position));
        holder.bindViews((M) modelList.get(position), adapterListener);
    }

    @Override
    public void submitList(@Nullable List<M> list) {
        this.modelList = (list != null) ? list : List.of();
        super.submitList(list);
    }
}
