package com.example.foodhub.views.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;

public class CartPricesField extends RelativeLayout {
    Context context;
    String price, total, currency, title;
    int visable;

    public CartPricesField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CartPricesField);
        visable = array.getInt(R.styleable.CartPricesField_cp_total_visable, 0);
        title = array.getString(R.styleable.CartPricesField_cp_title);
        price = array.getString(R.styleable.CartPricesField_cp_price);
        total = array.getString(R.styleable.CartPricesField_cp_total);
        currency = array.getString(R.styleable.CartPricesField_cp_currency);


        setPadding(0, SizeUtilities.Dp2Px(context, 10), 0, SizeUtilities.Dp2Px(context, 10));
        setLayoutParams(new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        buildComponent();
    }

    void buildComponent() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //  params.setMarginEnd(SizeUtilities.Dp2Px(context, 8));
        params.setMargins(0, SizeUtilities.Dp2Px(context, 4), 0, 0);
        TextView tv = new TextView(context);
        tv.setText(title);
        tv.setTypeface(getResources().getFont(R.font.sofiapro_medium));
        tv.setTextColor(context.getColor(R.color.black));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        tv.setLayoutParams(params);
        tv.setId(R.id.price_title);

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params2.addRule(LEFT_OF, R.id.price_urrency);
        params2.setMarginEnd(SizeUtilities.Dp2Px(context, 4));
        TextView tv2 = new TextView(context);
        tv2.setText(price);
        tv2.setTypeface(getResources().getFont(R.font.sofiapro_medium));
        tv2.setTextColor(context.getColor(R.color.black));
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 21);
        tv2.setLayoutParams(params2);
        tv2.setId(R.id.price_price);

        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params3.setMargins(0, SizeUtilities.Dp2Px(context, 6), 0, 0);
        params3.addRule(ALIGN_PARENT_RIGHT);
        TextView tv3 = new TextView(context);
        tv3.setText(currency);
        tv3.setTypeface(getResources().getFont(R.font.sofiapro_reguler));
        tv3.setTextColor(context.getColor(R.color.hint_color));
        tv3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv3.setLayoutParams(params3);
        tv3.setId(R.id.price_urrency);


        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params4.setMargins(0, SizeUtilities.Dp2Px(context, 6), 0, 0);
        params4.addRule(LEFT_OF, R.id.price_price);
        params4.setMarginEnd(SizeUtilities.Dp2Px(context, 10));
        TextView tv4 = new TextView(context);
        tv4.setText(total);
        tv4.setTypeface(getResources().getFont(R.font.sofiapro_reguler));
        tv4.setTextColor(context.getColor(R.color.black));
        tv4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv4.setLayoutParams(params4);
        tv4.setId(R.id.price_total_items);

        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, SizeUtilities.Dp2Px(context, 1));
        params5.addRule(BELOW, R.id.price_title);
        params5.setMargins(0, SizeUtilities.Dp2Px(context, 10), 0, 0);
        View v = new View(context);
        v.setLayoutParams(params5);
        v.setBackgroundColor(context.getColor(R.color.hint_color));


        this.addView(tv);
        this.addView(tv2);
        this.addView(tv3);
        if (visable == 1)
            this.addView(tv4);
        this.addView(v);


    }

}
