package com.example.kiosk.screen.menuDescription.fragment.menuDescription.viewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kiosk.model.kioskProduct.KioskProductModel;
import com.example.kiosk.screen.base.BaseViewModel;
import com.example.kiosk.useCase.kioskProduct.FetchKioskProductUseCase;

public class MenuDescriptionViewModel extends BaseViewModel {
    private final long productId;

    private final FetchKioskProductUseCase fetchKioskProductUseCase;

    private MutableLiveData<KioskProductModel> _kioskProductModelLiveData = new MutableLiveData<>(null);
    public LiveData<KioskProductModel> kioskProductModelLiveData = _kioskProductModelLiveData;

    public MenuDescriptionViewModel(long productId, FetchKioskProductUseCase fetchKioskProductUseCase) {
        this.productId = productId;
        this.fetchKioskProductUseCase = fetchKioskProductUseCase;
    }

    @Nullable
    @Override
    protected Runnable initializeFetchData() {
        return () -> {
            KioskProductModel model = fetchKioskProductUseCase.findById(productId);
            _kioskProductModelLiveData.postValue(model);
        };
    }
}
