package com.example.foodhub.views.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;

public class AddDeletItem extends LinearLayout {
    Context context;

    public AddDeletItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        buildComponent();

    }

    void buildComponent() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(SizeUtilities.Dp2Px(context, 32), SizeUtilities.Dp2Px(context, 32));

        Button btn_delete = new Button(context);
        btn_delete.setLayoutParams(params);
        btn_delete.setBackgroundResource(R.drawable.btn1_bg);
        btn_delete.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.minus, 0, 0);
        btn_delete.setPadding(0, SizeUtilities.Dp2Px(context, 15), 0, 0);


        Button btn_add = new Button(context);
        btn_add.setLayoutParams(params);
        btn_add.setBackgroundResource(R.drawable.btn_bg);
        btn_add.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.plus, 0, 0);
        btn_add.setPadding(0, SizeUtilities.Dp2Px(context, 5), 0, 0);

        params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(SizeUtilities.Dp2Px(context, 5),SizeUtilities.Dp2Px(context, -10),SizeUtilities.Dp2Px(context, 5),0);
        TextView tv = new TextView(context);
        tv.setText("02");
        tv.setTypeface(getResources().getFont(R.font.sofiapro_semibold));
        tv.setTextColor(context.getColor(R.color.black));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        tv.setLayoutParams(params);
        //
        this.addView(btn_delete);
        this.addView(tv);
        this.addView(btn_add);


    }


}
