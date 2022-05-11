package com.example.foodhub.views.components;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;

public class AddsField extends LinearLayout {
    Context context;

    public AddsField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        buildComponent();
    }

    void buildComponent() {
        RelativeLayout layout = new RelativeLayout(context);

        RelativeLayout.LayoutParams imgparams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ImageView img = new ImageView(context);
        img.setBackgroundResource(R.drawable.pepper);
        img.setLayoutParams(imgparams);
        img.setId(R.id.adds_pic);


        RelativeLayout.LayoutParams tvparams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvparams.addRule(RelativeLayout.RIGHT_OF, R.id.adds_pic);
        tvparams.setMargins(SizeUtilities.Dp2Px(context, 18), SizeUtilities.Dp2Px(context, 10), 0, 0);
        TextView tv = new TextView(context);
        tv.setText("Pepper julienned");
        tv.setTypeface(getResources().getFont(R.font.sofiapro_semibold));
        tv.setTextColor(context.getColor(R.color.black));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv.setLayoutParams(tvparams);
        tv.setId(R.id.review_field_review);
        tv.setId(R.id.adds_name);


        RelativeLayout.LayoutParams rbparams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rbparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rbparams.setMargins(0, SizeUtilities.Dp2Px(context, 6), 0, 0);
        RadioButton radioButton = new RadioButton(context);
        radioButton.setLayoutParams(rbparams);
        radioButton.setId(R.id.adds_btn);

        radioButton.setButtonTintList(ColorStateList.valueOf(ContextCompat.getColor(context, R.color.primary_color)));


        RelativeLayout.LayoutParams tv2params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tv2params.setMargins(0, SizeUtilities.Dp2Px(context, 10), SizeUtilities.Dp2Px(context, 18), 0);
        TextView tv2 = new TextView(context);
        tv2.setText("+$2.30");
        tv2.setTypeface(getResources().getFont(R.font.sofiapro_reguler));
        tv2.setTextColor(context.getColor(R.color.hint_color));
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv2.setId(R.id.review_field_people);
        tv2params.addRule(RelativeLayout.LEFT_OF, R.id.adds_btn);
        tv2.setLayoutParams(tv2params);
        tv2.setId(R.id.adds_price);


        layout.addView(img);
        layout.addView(tv);
        layout.addView(tv2);
        layout.addView(radioButton);

        this.addView(layout);

    }
}
