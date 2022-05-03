package com.example.foodhub;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class onBordingScreen extends BaseActivity {
    private OnboardingAdapter onboardingAdapter;
    private LinearLayout layoutOnboardingIndicators;
    private MaterialButton btnOnboardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_bording_screen);
        layoutOnboardingIndicators=findViewById(R.id.layoutOnboardingIndicators);
        btnOnboardingAction=findViewById(R.id.btnOnboardingAction);
        setupOnboardingItems();
        ViewPager2 onboardingViewPager=findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);
        setupOnboardingIndicators();
        setCurrentOnboardingIndicator(0);
        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });
        btnOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onboardingViewPager.getCurrentItem()+1<onboardingAdapter.getItemCount())
                {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem()+1);
                }
                else
                {
                    goFromActivityToActivity(onBordingScreen.this,WelcomeScreen.class);
                }
            }
        });
    }
    void setupOnboardingItems()
    {
        List<OnboardingItem> onboardingItemList = new ArrayList<>();
        OnboardingItem itemPlayOnline1 = new OnboardingItem();
        itemPlayOnline1.setTitle("Browse your menu\nand order directly");
        itemPlayOnline1.setDescription("Our app can send you everywhere,\neven space. For only $2.99 per month");
        itemPlayOnline1.setImage(R.drawable.onboarding_image_1);

        OnboardingItem itemPlayOnline2 = new OnboardingItem();
        itemPlayOnline2.setTitle("Even to space with\nus! Together");
        itemPlayOnline2.setDescription("Our app can send you everywhere,\neven space. For only $2.99 per month");
        itemPlayOnline2.setImage(R.drawable.onboarding_image_2);

        OnboardingItem itemPlayOnline3 = new OnboardingItem();
        itemPlayOnline3.setTitle("Pickup delivery at\nyour door");
        itemPlayOnline3.setDescription("Our app can send you everywhere, \neven space. For only $2.99 per month");
        itemPlayOnline3.setImage(R.drawable.onboarding_image_1);

        onboardingItemList.add(itemPlayOnline1);
        onboardingItemList.add(itemPlayOnline2);
        onboardingItemList.add(itemPlayOnline3);

        onboardingAdapter=new OnboardingAdapter(onboardingItemList);

    }
    private void setupOnboardingIndicators(){
        ImageView []indicators=new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams =new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for (int i=0;i<indicators.length;i++)
        {
            indicators[i]=new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
        }
    }
    private void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicators.getChildCount();
        for (int i=0;i<childCount;i++)
        {
            ImageView imageView=(ImageView)layoutOnboardingIndicators.getChildAt(i);
            if(i==index)
            {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_active
            ));
            }else{
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getApplicationContext(),
                        R.drawable.onboarding_indicator_inactive
                ));
            }
        }
    }
}