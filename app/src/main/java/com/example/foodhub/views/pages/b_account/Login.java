package com.example.foodhub.views.pages.b_account;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.User;
import com.example.foodhub.interfaces.CallBack;
import com.example.foodhub.interfaces.EndPoints;
import com.example.foodhub.views.components.InputField;
import com.example.foodhub.views.components.TwoTexts;
import com.example.foodhub.views.networking.RetrofitCreation;
import com.example.foodhub.views.pages.c_home.Home;
import com.example.foodhub.views.pages.parents.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends BaseActivity {
    public static String mail, pass;
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InputField email, password;
        TwoTexts signup;
        EditText email_et, password_et;
        Button back, login;
        TextView forget;

        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);

        email_et = email.findViewById(R.id.input_field_edit_text);
        password_et = password.findViewById(R.id.input_field_edit_text);


        login = findViewById(R.id.btn_login_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail = email_et.getText().toString();
                pass = password_et.getText().toString();
                if (mail.length() > 0 && pass.length() > 0) {
                    checkLogin(mail, pass, new CallBack() {
                        @Override
                        public void onFinished() {
                            Toast.makeText(getApplicationContext(),
                                    "Successful Login",
                                    Toast.LENGTH_SHORT).show();
                            go_screen(Login.this, Home.class);
                        }
                    });

                } else {
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

        forget = findViewById(R.id.tv_login_forget);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(Login.this, ResetPassword.class);
            }
        });
        TwoTexts t = findViewById(R.id.login_sign_up);
        TextView tv = t.findViewById(R.id.two_texts_clickable_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(Login.this, SignUp.class);
            }
        });


    }

    void checkLogin(String email, String password, CallBack callback) {
        EndPoints Api = RetrofitCreation.getInstance();
        Call<User> call = Api.login(email, password, "user", "login");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Login.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("mail", email);
                editor.putString("pass", password);
                editor.apply();
                go_screen(Login.this, Home.class);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Invalid Login",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}