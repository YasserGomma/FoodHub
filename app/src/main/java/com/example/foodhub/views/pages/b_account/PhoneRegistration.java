package com.example.foodhub.views.pages.b_account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.a_intro.WelcomeScreen;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class PhoneRegistration extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_registration);
        Button btn_phone_registration_send=findViewById(R.id.btn_phone_registration_send);
        btn_phone_registration_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(PhoneRegistration.this)
                        .setTitle("Phone Verification")
                        .setMessage("Check your phone messages")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                go_screen(PhoneRegistration.this, WelcomeScreen.class);
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        EditText et_phone_registration_phone=findViewById(R.id.et_phone_registration_phone);
        et_phone_registration_phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher("US"));

        findViewById(R.id.btn_back_header_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                PhoneRegistration.super.onBackPressed();
            }
        });
    }
}