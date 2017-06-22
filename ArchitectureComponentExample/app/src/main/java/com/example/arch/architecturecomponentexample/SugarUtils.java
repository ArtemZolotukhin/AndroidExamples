package com.example.arch.architecturecomponentexample;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by arch on 6/21/17.
 */

public class SugarUtils {

    public static void setViewVisibility(View view, Boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public static void showLongTimeToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void showShortTimeToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void showLongTimeToast(Context context, Integer stringId) {
        Toast.makeText(context, stringId, Toast.LENGTH_LONG).show();
    }

    public static void showShortTimeToast(Context context, Integer stringId) {
        Toast.makeText(context, stringId, Toast.LENGTH_SHORT).show();
    }

}
