package com.example.foodhub.views.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.foodhub.R;

public class IllustrativeText extends AppCompatTextView {
    Context context;

    public IllustrativeText(Context context) {
        super(context);
        this.context = context;
    }

    public IllustrativeText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setTypeface(getResources().getFont(R.font.sofiapro_medium));
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        setId(R.id.illustrative_text);

    }
}
