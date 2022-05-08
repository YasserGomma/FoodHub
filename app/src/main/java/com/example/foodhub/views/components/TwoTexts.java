package com.example.foodhub.views.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;

public class TwoTexts extends LinearLayout {
    Context context;
    public TwoTexts(Context context,  AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TwoTexts);
        String text1 = array.getString(R.styleable.TwoTexts_tt_text_1);
        String text2 = array.getString(R.styleable.TwoTexts_tt_text_2);
        int text1_color=array.getResourceId(R.styleable.TwoTexts_tt_text_1_color,0);
        int text2_color=array.getResourceId(R.styleable.TwoTexts_tt_text_2_color,0);
        setOrientation(HORIZONTAL);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        buildComponent(text1,text2,text1_color,text2_color);

    }
    void buildComponent(String t1, String t2,int c1,int c2) {


        TextView tv = new TextView(context);
        tv.setText(t1);
        tv.setTypeface(getResources().getFont(R.font.sofiapro_medium));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv.setTextColor(context.getColor(c1));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMarginEnd(SizeUtilities.Dp2Px(context, 8));
        tv.setLayoutParams(params);


        TextView tv2 = new TextView(context);
        tv2.setText(t2);
        tv2.setTypeface(getResources().getFont(R.font.sofiapro_medium));
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv2.setTextColor(context.getColor(c2));
        tv2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        TwoTexts.this.addView(tv);
        TwoTexts.this.addView(tv2);
    }
}
