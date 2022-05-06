package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class RessetPassword extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resset_password);
        changeBorderOnFocus(R.id.et_resetpassword_email);

        Button btn_resetpassword_resetpassword=findViewById(R.id.btn_resetpassword_resetpassword);
        btn_resetpassword_resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RessetPassword.this,"New Password sent to your email!",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_back_header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RessetPassword.super.onBackPressed();
            }
        });
    }
}