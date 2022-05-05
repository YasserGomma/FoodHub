package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class SignUp extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        changeBorderOnFocus(R.id.et_signup_full_name,R.id.et_signup_email,R.id.et_signup_password);


    }
}