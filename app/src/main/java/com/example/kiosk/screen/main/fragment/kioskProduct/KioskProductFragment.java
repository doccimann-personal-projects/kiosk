package com.example.kiosk.screen.main.fragment.kioskProduct;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.kiosk.databinding.FragmentKioskProductBinding;
import com.example.kiosk.model.kioskProduct.KioskProductModel;
import com.example.kiosk.screen.base.BaseFragment;
import com.example.kiosk.screen.main.fragment.kioskProduct.viewModel.KioskProductViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.ModelRecyclerAdapter;
import com.example.kiosk.widget.listener.kioskProduct.KioskProductListListener;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KioskProductFragment extends BaseFragment<KioskProductViewModel, FragmentKioskProductBinding> {
    @Inject
    KioskProductViewModel viewModel;

    @Inject
    ResourcesProvider resourcesProvider;

    private ModelRecyclerAdapter<KioskProductModel, KioskProductViewModel> adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("brian", "KioskProductFragment.onCreate() called!");

        super.onCreate(savedInstanceState);

        adapter = new ModelRecyclerAdapter<>(List.of(), viewModel, resourcesProvider, new KioskProductListListener() {
            @Override
            public void onClickItem(@NonNull KioskProductModel model) {
                Toast.makeText(requireContext(), model.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initViews() {
        super.initViews();

        // 어댑터 장착
        binding.recyclerView.setAdapter(adapter);

        // GridLayoutManager 적용
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void observeData() {
        Log.i("brian", "kioskProductFragment.observeData() called!");

        viewModel.kioskProductModelListLiveData.observe(this, modelList -> {
            modelList.forEach(model -> {
                Log.i("brian", model.getName());
            });
            adapter.submitList(modelList);
        });
    }

    @Override
    protected KioskProductViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected FragmentKioskProductBinding getViewBinding() {
        return FragmentKioskProductBinding.inflate(getLayoutInflater());
    }
}
