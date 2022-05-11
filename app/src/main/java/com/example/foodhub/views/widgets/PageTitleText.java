package com.example.foodhub.views.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.foodhub.R;

public class PageTitleText extends AppCompatTextView {
    Context context;
    public PageTitleText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.PageTitleText);
        int size = array.getInt(R.styleable.PageTitleText_pt_text_size,40);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setTypeface(getResources().getFont(R.font.sofiapro_medium));
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        setTextColor(context.getColor(android.R.color.black));


    }
}

