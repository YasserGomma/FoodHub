package com.example.foodhub.views.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;
import com.example.foodhub.views.widgets.IllustrativeText;

public class ReviewFiled extends LinearLayout {
    Context context;

    public ReviewFiled(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER_VERTICAL));
        buildComponent();
    }

    void buildComponent() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMarginEnd(SizeUtilities.Dp2Px(context, 8));

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(SizeUtilities.Dp2Px(context, 13), SizeUtilities.Dp2Px(context, 13));
        params1.setMargins(0, SizeUtilities.Dp2Px(context, 5), SizeUtilities.Dp2Px(context, 8), 0);
        ImageView img = new ImageView(context);
        img.setBackgroundResource(R.drawable.star);
        img.setLayoutParams(params1);

        // params.setMargins(0,SizeUtilities.Dp2Px(context, 2),0,0);

        TextView tv = new TextView(context);
        tv.setText("4.5");
        tv.setTypeface(getResources().getFont(R.font.sofiapro_semibold));
        tv.setTextColor(context.getColor(R.color.black));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv.setLayoutParams(new LayoutParams(params));
        tv.setId(R.id.review_field_review);

        TextView tv2 = new TextView(context);
        tv2.setText("(30+)");
        tv2.setTypeface(getResources().getFont(R.font.sofiapro_reguler));
        tv2.setTextColor(context.getColor(R.color.hint_color));
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        tv2.setId(R.id.review_field_people);
        tv2.setLayoutParams(params);

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));


        IllustrativeText illustrativeText = new IllustrativeText(context);
        illustrativeText.setText("See Review");
        illustrativeText.setTextColor(context.getColor(R.color.primary_color));

        View v = new View(context);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(SizeUtilities.Dp2Px(context, 70), SizeUtilities.Dp2Px(context, 1));
        v.setLayoutParams(params2);
        v.setBackgroundColor(context.getColor(R.color.primary_color));

        linearLayout.addView(illustrativeText);
        linearLayout.addView(v);


        this.addView(img);
        this.addView(tv);
        this.addView(tv2);
        this.addView(linearLayout);


    }


}
