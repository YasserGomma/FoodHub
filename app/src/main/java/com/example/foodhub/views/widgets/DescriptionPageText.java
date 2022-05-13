package com.example.foodhub.views.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.foodhub.R;

public class DescriptionPageText extends AppCompatTextView {
    Context context;

    public DescriptionPageText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setTypeface(getResources().getFont(R.font.sofiapro_reguler));
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        setTextColor(context.getColor(R.color.hint_color));

    }
}
