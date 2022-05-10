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
import com.example.foodhub.views.pages.c_home.Home;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class Login extends BaseActivity {
    private String mail, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InputField email, password;
        TwoTexts signup;
        EditText email_et, password_et;
        Button back,login;
        TextView forget;

        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);

        email_et = email.findViewById(R.id.input_field_edit_text);
        password_et = password.findViewById(R.id.input_field_edit_text);




        login=findViewById(R.id.btn_login_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail = email_et.getText().toString();
                pass = password_et.getText().toString();
                if(mail.length()>0&&pass.length()>0) {
                    if (checkLogin(mail,pass)) {
                        go_screen(Login.this, Home.class);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Invalid Login",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your email and password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        back = findViewById(R.id.btn_back_header_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Login.super.onBackPressed();
            }
        });

        forget=findViewById(R.id.tv_login_forget);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(Login.this,RessetPassword.class);
            }
        });
        TwoTexts t=findViewById(R.id.login_sign_up);
        TextView tv=t.findViewById(R.id.two_texts_clickable_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(Login.this, SignUp.class);
            }
        });


    }

    boolean checkLogin(String email, String password) {
        if (email.equals("yasser@odc.com") && password.equals("12345"))
            return true;
        return false;
    }
}