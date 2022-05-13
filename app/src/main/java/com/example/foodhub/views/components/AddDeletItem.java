package com.example.foodhub.views.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
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
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        ImageView btn_delete = new ImageView(context);
        btn_delete.setLayoutParams(params);
        btn_delete.setBackgroundResource(R.drawable.btn_delet);
        btn_delete.setPadding(SizeUtilities.Dp2Px(context, 3), SizeUtilities.Dp2Px(context, 3), SizeUtilities.Dp2Px(context, 3), SizeUtilities.Dp2Px(context, 3));
        btn_delete.setId(R.id.btn_delete_item);
        btn_delete.setClickable(true);

        ImageView btn_add = new ImageView(context);
        btn_add.setLayoutParams(params);
        btn_add.setBackgroundResource(R.drawable.btn_add);
        btn_delete.setPadding(SizeUtilities.Dp2Px(context, 3), SizeUtilities.Dp2Px(context, 3), SizeUtilities.Dp2Px(context, 3), SizeUtilities.Dp2Px(context, 3));
        btn_delete.setId(R.id.btn_delete_item);
        btn_add.setClickable(true);

        params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(SizeUtilities.Dp2Px(context, 10), 0, SizeUtilities.Dp2Px(context, 10), 0);
        TextView tv = new TextView(context);
        tv.setText("02");
        tv.setTypeface(getResources().getFont(R.font.sofiapro_semibold));
        tv.setTextColor(context.getColor(R.color.black));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        tv.setLayoutParams(params);
        tv.setId(R.id.tv_item_price);
        //
        this.addView(btn_delete);
        this.addView(tv);
        this.addView(btn_add);


    }


}
