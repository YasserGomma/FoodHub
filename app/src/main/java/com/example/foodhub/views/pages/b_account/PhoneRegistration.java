package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodhub.R;
import com.example.foodhub.interfaces.EndPoints;
import com.example.foodhub.views.networking.RetrofitCreation;
import com.example.foodhub.views.pages.c_home.Home;
import com.example.foodhub.views.pages.parents.BaseActivity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneRegistration extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_registration);
        EditText et_phone_registration_phone = findViewById(R.id.et_phone_registration_phone);
        et_phone_registration_phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher("US"));
        Button btn_phone_registration_send = findViewById(R.id.btn_phone_registration_send);
        btn_phone_registration_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EndPoints Api = RetrofitCreation.getInstance();
                Call<RequestBody> call1 = Api.register("signup", "user", SignUp.mail, SignUp.pass, SignUp.name, et_phone_registration_phone.getText().toString());
                call1.enqueue(new Callback<RequestBody>() {
                    @Override
                    public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {
                        Toast.makeText(PhoneRegistration.this, "Check your phone messages", Toast.LENGTH_LONG).show();
                        go_screen(PhoneRegistration.this, Home.class);
                    }

                    @Override
                    public void onFailure(Call<RequestBody> call, Throwable t) {
                        //Toast.makeText(PhoneRegistration.this, t.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("error",t.getMessage());
                        go_screen(PhoneRegistration.this, Home.class);


                    }
                });
            }
        });

        findViewById(R.id.btn_back_header_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                PhoneRegistration.super.onBackPressed();
            }
        });
    }
}