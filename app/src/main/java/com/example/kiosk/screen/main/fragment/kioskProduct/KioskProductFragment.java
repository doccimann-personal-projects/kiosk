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
import com.example.kiosk.screen.main.viewModel.MainSharedViewModel;
import com.example.kiosk.util.provider.ResourcesProvider;
import com.example.kiosk.widget.adapter.ModelRecyclerAdapter;
import com.example.kiosk.widget.listener.kioskProduct.KioskProductListListener;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KioskProductFragment extends BaseFragment<KioskProductViewModel, FragmentKioskProductBinding> {
    @Inject
    MainSharedViewModel sharedViewModel;

    @Inject
    KioskProductViewModel viewModel;

    @Inject
    ResourcesProvider resourcesProvider;

    private ModelRecyclerAdapter<KioskProductModel, KioskProductViewModel> adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ModelRecyclerAdapter<>(List.of(), viewModel, resourcesProvider, new KioskProductListListener() {
            @Override
            public void onClickItem(@NonNull KioskProductModel model) {
                sharedViewModel.onKioskProductClicked(model.getId());
            }
        });
    }

    @Override
    protected void initViews() {
        super.initViews();

        // 어댑터 장착
        binding.kioskProductRecyclerView.setAdapter(adapter);

        // GridLayoutManager 적용
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3);
        binding.kioskProductRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void observeData() {
        viewModel.kioskProductModelListLiveData.observe(this, modelList -> {
            adapter.submitList(modelList);
        });
    }

    @Override
    public KioskProductViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected FragmentKioskProductBinding getViewBinding() {
        return FragmentKioskProductBinding.inflate(getLayoutInflater());
    }

    public static KioskProductFragment newInstance() {
        return new KioskProductFragment();
    }
}
