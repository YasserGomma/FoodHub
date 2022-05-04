package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class Login extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        changeBorderOnFocus(R.id.si_email,R.id.si_password);

    }
}