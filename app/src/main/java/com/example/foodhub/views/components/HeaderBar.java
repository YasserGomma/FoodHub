package com.example.foodhub.views.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;
import com.makeramen.roundedimageview.RoundedImageView;

public class HeaderBar extends LinearLayout {
    Context context;

    public HeaderBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar);
        String txt = array.getString(R.styleable.HeaderBar_hb_text);
        int img = array.getResourceId(R.styleable.HeaderBar_hb_img, R.drawable.bussiness_man);
        int visable = array.getInt(R.styleable.HeaderBar_hb_img_visable, 1);

        buildComponent(txt, img, visable);
    }

    void buildComponent(String txt, int img_profile, int visable) {
        RelativeLayout layout = new RelativeLayout(context);
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        RelativeLayout.LayoutParams btnparams = new RelativeLayout.LayoutParams(SizeUtilities.Dp2Px(context, 38), SizeUtilities.Dp2Px(context, 38));
        AppCompatButton back_btn = new AppCompatButton(context);
        btnparams.setMargins(SizeUtilities.Dp2Px(context, 1), SizeUtilities.Dp2Px(context, 2), SizeUtilities.Dp2Px(context, 2), SizeUtilities.Dp2Px(context, 2));
        back_btn.setBackgroundDrawable(context.getDrawable(R.drawable.btn_bg_4));
        back_btn.setCompoundDrawablesWithIntrinsicBounds(null, context.getDrawable(R.drawable.back), null, null);
        back_btn.setLayoutParams(btnparams);
        back_btn.setPadding(0, SizeUtilities.Dp2Px(context, 13), 0, 0);
        back_btn.setId(R.id.header_btn);


        RelativeLayout.LayoutParams tvparams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvparams.addRule(RelativeLayout.CENTER_IN_PARENT);
        //tvparams.addRule(RelativeLayout.RIGHT_OF, R.id.header_btn);
        tvparams.setMargins(SizeUtilities.Dp2Px(context, 18), SizeUtilities.Dp2Px(context, 10), 0, 0);
        TextView tv = new TextView(context);
        tv.setText(txt);
        tv.setTypeface(getResources().getFont(R.font.sofiapro_medium));
        tv.setTextColor(context.getColor(R.color.black));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        tv.setLayoutParams(tvparams);
        tv.setId(R.id.review_field_review);
        tv.setId(R.id.header_txt);


        RelativeLayout.LayoutParams rbparams = new RelativeLayout.LayoutParams(SizeUtilities.Dp2Px(context, 38), SizeUtilities.Dp2Px(context, 38));
        rbparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        CardView view = new CardView(context);
        view.setLayoutParams(rbparams);
        view.setRadius(10);

        rbparams = new RelativeLayout.LayoutParams(SizeUtilities.Dp2Px(context, 38), SizeUtilities.Dp2Px(context, 38));
        RoundedImageView img = new RoundedImageView(context);
        img.setLayoutParams(rbparams);
        img.setId(R.id.header_img);
        img.setCornerRadius(10);
        img.setBackgroundResource(img_profile);
        view.addView(img);

        if (visable == 0)
            view.setVisibility(GONE);
        layout.addView(back_btn);
        layout.addView(tv);
        layout.addView(view);

        this.addView(layout);

    }
}
