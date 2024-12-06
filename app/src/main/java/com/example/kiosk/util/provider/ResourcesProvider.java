package com.example.kiosk.util.provider;

import android.content.res.ColorStateList;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

public interface ResourcesProvider {

    /**
     * 지정된 문자열 리소스 ID에 해당하는 문자열을 반환합니다.
     *
     * @param resId 문자열 리소스 ID
     * @return 리소스에서 가져온 문자열
     */
    String getString(@StringRes int resId);

    /**
     * 포맷 인자를 포함하여 지정된 문자열 리소스 ID에 해당하는 문자열을 반환합니다.
     *
     * @param resId    문자열 리소스 ID
     * @param formArgs 포맷 인자
     * @return 포맷이 적용된 문자열
     */
    String getString(@StringRes int resId, Object... formArgs);

    /**
     * 지정된 색상 리소스 ID에 해당하는 색상을 반환합니다.
     *
     * @param resId 색상 리소스 ID
     * @return 색상 값 (int)
     */
    int getColor(@ColorRes int resId);

    /**
     * 지정된 색상 상태 목록 리소스 ID에 해당하는 ColorStateList를 반환합니다.
     *
     * @param resId 색상 상태 목록 리소스 ID
     * @return ColorStateList 객체
     */
    ColorStateList getColorStateList(@ColorRes int resId);
}
