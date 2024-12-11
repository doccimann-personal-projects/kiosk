package com.example.kiosk.screen.menuDescription.viewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.kiosk.screen.base.BaseViewModel;

public class MenuDescriptionSharedViewModel extends BaseViewModel {
    private final Context context;

    public MenuDescriptionSharedViewModel(Context context) {
        this.context = context;
    }

    public void onLoadToCartButtonClicked() {
        Toast.makeText(context, "장바구니 버튼 클릭됨", Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    protected Runnable initializeFetchData() {
        return null;
    }
}
