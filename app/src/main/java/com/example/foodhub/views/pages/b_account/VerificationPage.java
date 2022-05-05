package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class VerificationPage extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_page);
        changeBorderOnFocus(R.id.et_verificationpage_verification_1,R.id.et_verificationpage_verification_2,R.id.et_verificationpage_verification_3,R.id.et_verificationpage_verification_4);
    }
}