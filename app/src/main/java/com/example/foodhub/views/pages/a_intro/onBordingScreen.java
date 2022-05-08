package com.example.foodhub.views.pages.a_intro;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.foodhub.R;
import com.example.foodhub.data.models.OnboardingItem;
import com.example.foodhub.data.source.local.OnboardingData;
import com.example.foodhub.views.adapters.OnboardingAdapter;
import com.example.foodhub.views.pages.b_account.SignUp;
import com.example.foodhub.views.pages.parents.BaseActivity;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

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
                    go_screen(onBordingScreen.this, SignUp.class);
                }
            }
        });
    }


    /**
     *Set content of onboarding screen (image,title,description).
     */
    void setupOnboardingItems()
    {
        ArrayList<OnboardingItem> onboardingItemList = OnboardingData.Items();
        onboardingAdapter=new OnboardingAdapter(onboardingItemList);

    }

    /**
     *build the indicators of onboarding screen.
     */
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

    /**
     *Set the current active indicator.
     */

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