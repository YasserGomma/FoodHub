package com.example.foodhub.views.pages.a_intro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.b_account.Login;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class WelcomeScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        TextView tv_welcome_sign_in=findViewById(R.id.tv_welcome_sign_in);
        tv_welcome_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(WelcomeScreen.this, Login.class);
            }
        });


        Button btn_welcome_start_with=findViewById(R.id.btn_welcome_start_with);
        btn_welcome_start_with.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(WelcomeScreen.this, onBordingScreen.class);

            }
        });


    }
}