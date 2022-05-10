package com.example.foodhub.views.pages.b_account;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.foodhub.R;
import com.example.foodhub.views.components.TwoTexts;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class VerificationPage extends BaseActivity {
    private String code = "";
    EditText et_verificationpage_verification_1, et_verificationpage_verification_2, et_verificationpage_verification_3, et_verificationpage_verification_4;
    TextView mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_page);

        et_verificationpage_verification_1 = findViewById(R.id.et_verificationpage_verification_1);
        et_verificationpage_verification_2 = findViewById(R.id.et_verificationpage_verification_2);
        et_verificationpage_verification_3 = findViewById(R.id.et_verificationpage_verification_3);
        et_verificationpage_verification_4 = findViewById(R.id.et_verificationpage_verification_4);

        mail=findViewById(R.id.tv_verificationpage_email);
        mail.setText("Please type the verification code sent to "+SignUp.mail);

        et_verificationpage_verification_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    if (editable.length() == 1)
                        et_verificationpage_verification_2.requestFocus();
                }
            }
        });

        et_verificationpage_verification_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    if (editable.length() == 1)
                        et_verificationpage_verification_3.requestFocus();
                }
            }
        });

        et_verificationpage_verification_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    if (editable.length() == 1)
                        et_verificationpage_verification_4.requestFocus();
                }
            }
        });
        et_verificationpage_verification_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    if (editable.length() == 1) {
                        code += getEtText(R.id.et_verificationpage_verification_1);
                        code += getEtText(R.id.et_verificationpage_verification_2);
                        code += getEtText(R.id.et_verificationpage_verification_3);
                        code += getEtText(R.id.et_verificationpage_verification_4);
                        if (code.equals("1111")) {
                            go_screen(VerificationPage.this, PhoneRegistration.class);
                        }
                    }
                }
            }
        });
        findViewById(R.id.btn_back_header_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                VerificationPage.super.onBackPressed();
            }
        });
        TwoTexts t=findViewById(R.id.tv_verificationpage_resend);
        TextView tv=t.findViewById(R.id.two_texts_clickable_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(VerificationPage.this)
                        .setTitle("Code sent")
                        .setMessage("Check your mail box again")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });


    }
}