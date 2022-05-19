package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodhub.R;
import com.example.foodhub.views.components.InputField;
import com.example.foodhub.views.components.TwoTexts;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class SignUp extends BaseActivity {
    public static String mail = "", name = "", pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        InputField email, full_name, password;
        EditText email_et, password_et, name_et;
        Button signup;
        email = findViewById(R.id.signup_email);
        full_name = findViewById(R.id.signup_fullname);
        password = findViewById(R.id.signup_password);
        name_et = full_name.findViewById(R.id.input_field_edit_text);
        email_et = email.findViewById(R.id.input_field_edit_text);
        password_et = password.findViewById(R.id.input_field_edit_text);
        signup = findViewById(R.id.btn_signup_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Verify(name_et.getText().toString(), email_et.getText().toString(), password_et.getText().toString())) {
                    mail = email_et.getText().toString();
                    name = name_et.getText().toString();
                    pass = password_et.getText().toString();

                    go_screen(SignUp.this, VerificationPage.class);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter right data",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        TwoTexts t = findViewById(R.id.signup_login);
        TextView tv = t.findViewById(R.id.two_texts_clickable_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(SignUp.this, Login.class);
            }
        });
        findViewById(R.id.btn_back_header_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SignUp.super.onBackPressed();
            }
        });
    }

    public boolean Verify(String name, String mail, String pass) {
        return name.length() > 0 && pass.length() > 0 && mail.length() > 0;
    }
}