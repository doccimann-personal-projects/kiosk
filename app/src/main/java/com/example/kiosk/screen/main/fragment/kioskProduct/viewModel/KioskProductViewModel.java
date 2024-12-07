package com.example.kiosk.screen.main.fragment.kioskProduct.viewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kiosk.model.kioskProduct.KioskProductModel;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.useCase.kioskProduct.FetchKioskProductUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.scopes.FragmentScoped;

@FragmentScoped
public class KioskProductViewModel extends BaseViewModel {
    private final FetchKioskProductUseCase fetchKioskProductUseCase;

    private MutableLiveData<List<KioskProductModel>> _kioskProductModelListLiveData = new MutableLiveData<>(List.of());
    public LiveData<List<KioskProductModel>> kioskProductModelListLiveData = _kioskProductModelListLiveData;

    @Inject
    public KioskProductViewModel(FetchKioskProductUseCase fetchKioskProductUseCase) {
        this.fetchKioskProductUseCase = fetchKioskProductUseCase;
    }

    @Nullable
    @Override
    protected Runnable initializeFetchData() {
        return () -> {
            _kioskProductModelListLiveData.postValue(fetchKioskProductUseCase.getAllProducts());
        };
    }
}
