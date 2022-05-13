package com.example.foodhub.views.pages.a_intro;

import android.os.Bundle;

import com.example.foodhub.R;
import com.example.foodhub.interfaces.CallBack;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        delay(2000, new CallBack() {
            @Override
            public void onFinished() {
                go_screen(Splash.this, WelcomeScreen.class);
            }
        });

    }
}