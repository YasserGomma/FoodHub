package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class RessetPassword extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resset_password);
        changeBorderOnFocus(R.id.et_resetpassword_email);
    }
}