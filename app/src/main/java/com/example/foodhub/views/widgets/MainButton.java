package com.example.foodhub.views.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatButton;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;

public class MainButton extends AppCompatButton {
    Context context;

    public MainButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MainButton);
        int bg = array.getColor(R.styleable.MainButton_bg_color, getResources().getColor(R.color.primary_color));
        int txt_color = array.getColor(R.styleable.MainButton_text_color, getResources().getColor(R.color.white));
        setAllCaps(true);
        setTextColor(txt_color);
        setGravity(Gravity.CENTER);
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        setTypeface(getResources().getFont(R.font.sofiapro_reguler));
        setBackground(getDrawable(bg, 28));
    }

    public Drawable getDrawable(int color, int radius) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(SizeUtilities.Dp2Px(context, radius));
        shape.setColor(color);
        return shape;

    }
}
