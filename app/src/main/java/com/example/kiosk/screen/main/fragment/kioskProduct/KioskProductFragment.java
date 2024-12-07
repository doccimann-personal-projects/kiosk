package com.example.kiosk.screen.main.fragment.kioskProduct;

import com.example.kiosk.databinding.FragmentKioskProductBinding;
import com.example.kiosk.screen.base.BaseFragment;
import com.example.kiosk.screen.main.fragment.kioskProduct.viewModel.KioskProductViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KioskProductFragment extends BaseFragment<KioskProductViewModel, FragmentKioskProductBinding> {
    @Inject
    KioskProductViewModel viewModel;

    @Override
    protected void observeData() {

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
