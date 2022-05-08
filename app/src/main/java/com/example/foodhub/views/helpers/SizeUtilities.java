package com.example.foodhub.views.helpers;

import android.content.Context;
import android.util.TypedValue;

public class SizeUtilities {
    public static int Px2Dp(final Context context, final int px) {
        return (int)(px / context.getResources().getDisplayMetrics().density);
    }

    public static int Dp2Px(final Context context, final int dp) {
        return (int)(dp * context.getResources().getDisplayMetrics().density);
    }
    public static int Sp2Px(final Context context,final int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
    public static int Dp2Sp( Context context,int dp) {
        return (int) (Dp2Px(context,dp) / context.getResources().getDisplayMetrics().scaledDensity);
    }
}
