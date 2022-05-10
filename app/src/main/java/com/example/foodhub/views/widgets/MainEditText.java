package com.example.foodhub.views.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatEditText;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;

public class MainEditText extends AppCompatEditText {
    Context context;

    public MainEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MainEditText);
        int size = array.getInt(R.styleable.MainEditText_text_size,28);
        setBackground(getDrawableForEditText(10, Color.parseColor("#D0D2D1"), 1));
        setTypeface(getResources().getFont(R.font.sofiapro_medium));
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        setTextColor(context.getColor(R.color.black));
        setInputType(InputType.TYPE_NUMBER_FLAG_SIGNED);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, SizeUtilities.Dp2Px(context, 60));
        setLayoutParams(params);
        int paddingSize = SizeUtilities.Dp2Px(context, 10);
        setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
        setMaxLines(1);
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean isFocused) {
                if (isFocused) {
                    view.setBackgroundResource(R.drawable.et_bg_1);
                } else {
                    view.setBackgroundResource(R.drawable.et_bg);

                }
            }
        });

    }

    public Drawable getDrawableForEditText(int radius, int strokeColor, int strokeRadius) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(SizeUtilities.Dp2Px(context, radius));
        shape.setStroke(SizeUtilities.Dp2Px(context, strokeRadius), strokeColor);
        shape.setColor(context.getColor(R.color.Et_bg_color));
        return shape;

    }
}
