package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;
import android.view.View;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class ResetPassword extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resset_password);
        findViewById(R.id.btn_back_header_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                ResetPassword.super.onBackPressed();
            }
        });
    }
}