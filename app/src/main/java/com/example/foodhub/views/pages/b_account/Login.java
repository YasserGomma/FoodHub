package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class Login extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        changeBorderOnFocus(R.id.et_login_email,R.id.et_login_password);
        TextView tv_signin_signup=findViewById(R.id.tv_signin_signup);
        tv_signin_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(Login.this,SignUp.class);
            }
        });

        TextView btn_login_reset_password=findViewById(R.id.btn_login_reset_password);
        btn_login_reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(Login.this,RessetPassword.class);
            }
        });

        findViewById(R.id.btn_back_header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Login.super.onBackPressed();
            }
        });

    }
}