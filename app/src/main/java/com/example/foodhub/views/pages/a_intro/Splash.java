package com.example.foodhub.views.pages.a_intro;

import android.os.Bundle;
import android.os.Handler;

import com.example.foodhub.R;
import com.example.foodhub.views.helpers.BaseActivity;

public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goFromActivityToActivity(Splash.this, WelcomeScreen.class);
            }
        },2000);
    }
}