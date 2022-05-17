package com.example.foodhub.views.pages.a_intro;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.User;
import com.example.foodhub.interfaces.EndPoints;
import com.example.foodhub.views.components.TwoTexts;
import com.example.foodhub.views.networking.RetrofitCreation;
import com.example.foodhub.views.pages.b_account.Login;
import com.example.foodhub.views.pages.c_home.Home;
import com.example.foodhub.views.pages.parents.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        RelativeLayout parent = this.findViewById(R.id.activity_welcome_screen);
        Button skip, start;
        skip = findViewById(R.id.btn_welcome_skip);
        start = findViewById(R.id.btn_welcome_start);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(WelcomeScreen.this);
                String mail = preferences.getString("mail", "");
                String password = preferences.getString("pass", "");

                if (!mail.equalsIgnoreCase("") && !password.equalsIgnoreCase("")) {
                    EndPoints Api = RetrofitCreation.getInstance();
                    Call<User> call = Api.login(mail, password, "user", "login");
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Login.user = response.body();
                            go_screen(WelcomeScreen.this, Home.class);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please login first",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(WelcomeScreen.this, onBoardingScreen.class);
            }
        });


        TwoTexts t = findViewById(R.id.two);
        TextView tv = t.findViewById(R.id.two_texts_clickable_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_screen(WelcomeScreen.this, Login.class);
            }
        });


    }

}