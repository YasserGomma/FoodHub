package com.example.foodhub.views.pages.a_intro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.foodhub.R;
import com.example.foodhub.views.components.TwoTexts;
import com.example.foodhub.views.pages.b_account.Login;
import com.example.foodhub.views.pages.c_home.Home;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class WelcomeScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        RelativeLayout parent = (RelativeLayout) this.findViewById( R.id.activity_welcome_screen);
        Button skip,start;
        skip=findViewById(R.id.btn_welcome_skip);
        start=findViewById(R.id.btn_welcome_start);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(WelcomeScreen.this, Home.class);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(WelcomeScreen.this,onBordingScreen.class);
            }
        });


        TwoTexts t=findViewById(R.id.two);
        TextView tv=t.findViewById(R.id.two_texts_clickable_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(WelcomeScreen.this, Login.class);
            }
        });






    }

}