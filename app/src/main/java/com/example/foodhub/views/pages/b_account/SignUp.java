package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;
import android.util.Log;
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
    public static String mail="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        InputField email;
        EditText email_et, password_et;
        Button signup;
        email = findViewById(R.id.signup_email);
        email_et = email.findViewById(R.id.input_field_edit_text);
        signup=findViewById(R.id.btn_signup_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(Verify()) {

                   mail=email_et.getText().toString();
                   Log.e("mail","mail");
                   go_screen(SignUp.this, VerificationPage.class);
               }
               else
               {
                   Toast.makeText(getApplicationContext(),
                           "Please enter right data",
                           Toast.LENGTH_SHORT).show();
               }
            }
        });
        TwoTexts t=findViewById(R.id.signup_login);
        TextView tv=t.findViewById(R.id.two_texts_clickable_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(SignUp.this, Login.class);
            }
        });
    }
    public boolean Verify()
    {
        return true;
    }
}