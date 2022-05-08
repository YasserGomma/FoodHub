package com.example.foodhub.views.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;

public class InputField extends LinearLayout {
    Context context;

    public InputField(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setOrientation(VERTICAL);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.InputField);
        String label = array.getString(R.styleable.InputField_if_label);
        String hint = array.getString(R.styleable.InputField_if_hint);
        buildComponent(label, hint);
    }

    void buildComponent(String label, String hint) {


        TextView tv = new TextView(context);
        tv.setText(label);
        tv.setTypeface(getResources().getFont(R.font.sofiapro_reguler));
        tv.setTextColor(context.getColor(R.color.hint_color));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        int paddingSize = SizeUtilities.Dp2Px(context, 15);
        tv.setPadding(0, paddingSize, 0, paddingSize);
        tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));


        EditText et = new EditText(context);
        Drawable focusedEditText = getDrawableForEditText(10, Color.parseColor("#FE724C"), 1);
        Drawable unfocusedEditText = getDrawableForEditText(10, Color.parseColor("#FE724C"), 1);

        et.setBackground(getDrawableForEditText(10, Color.parseColor("#D0D2D1"), 1));
        et.setTypeface(getResources().getFont(R.font.sofiapro_medium));
        et.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
        et.setTextColor(context.getColor(R.color.black));
        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, SizeUtilities.Dp2Px(context, 60));
        et.setLayoutParams(params);
        paddingSize = SizeUtilities.Dp2Px(context, 20);
        et.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
        et.setMaxLines(1);
        et.setHint(hint);
        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean isFocused) {
                if (isFocused) {
                    view.setBackgroundResource(R.drawable.et_bg_1);
                } else {
                    view.setBackgroundResource(R.drawable.et_bg);

                }
            }
        });

        InputField.this.addView(tv);
        InputField.this.addView(et);
    }

    public Drawable getDrawableForEditText(int radius, int strokeColor, int strokeRadius) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(SizeUtilities.Dp2Px(context, radius));
        shape.setStroke(SizeUtilities.Dp2Px(context, strokeRadius), strokeColor);
        return shape;

    }
}
