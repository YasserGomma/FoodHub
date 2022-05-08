package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;
import android.view.View;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class Login extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


       findViewById(R.id.btn_back_header).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
              Login.super.onBackPressed();
           }
       });

    }
}