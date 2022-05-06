package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class PhoneRegistration extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_registration);
        EditText et_phone_registration_phone=findViewById(R.id.et_phone_registration_phone);
        et_phone_registration_phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher("US"));
        findViewById(R.id.btn_back_header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneRegistration.super.onBackPressed();
            }
        });
        findViewById(R.id.btn_back_header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneRegistration.super.onBackPressed();
            }
        });
    }
}