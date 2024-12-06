package com.example.kiosk.util.provider;

import android.content.Context;
import android.content.res.ColorStateList;

import androidx.core.content.ContextCompat;

public class DefaultResourcesProvider implements ResourcesProvider {
    private final Context context;

    public DefaultResourcesProvider(Context context) {
        this.context = context;
    }

    @Override
    public String getString(int resId) {
        return context.getString(resId);
    }

    @Override
    public String getString(int resId, Object... formArgs) {
        return context.getString(resId, formArgs);
    }

    @Override
    public int getColor(int resId) {
        return ContextCompat.getColor(context, resId);
    }

    @Override
    public ColorStateList getColorStateList(int resId) {
        return context.getColorStateList(resId);
    }
}
