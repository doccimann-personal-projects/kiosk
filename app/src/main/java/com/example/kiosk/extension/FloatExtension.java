package com.example.kiosk.extension;

import android.content.res.Resources;

public class FloatExtension {
    private FloatExtension() {

    }

    public static int fromDpToPx(float value) {
        float calculateResult = value * Resources.getSystem().getDisplayMetrics().density;
        return (int) calculateResult;
    }
}
