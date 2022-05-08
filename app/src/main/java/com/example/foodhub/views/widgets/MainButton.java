package com.example.foodhub.views.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import androidx.appcompat.widget.AppCompatButton;
import com.example.foodhub.R;
import com.example.foodhub.views.helpers.SizeUtilities;
public class MainButton extends AppCompatButton {
    Context context;

    public MainButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setAllCaps(false);
        setTextColor(context.getColor(R.color.white));
        setGravity(Gravity.CENTER);
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        setTypeface(getResources().getFont(R.font.sofiapro_reguler));
        setBackground(getDrawable(context.getColor(R.color.primary_color),28));
    }

    public Drawable getDrawable(int color,int radius) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(SizeUtilities.Dp2Px(context,radius));
        shape.setColor(color);
        return shape;

    }
}
