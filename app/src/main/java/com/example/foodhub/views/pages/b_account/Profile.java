package com.example.foodhub.views.pages.b_account;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.views.components.InputField;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView iv = findViewById(R.id.iv_profile_pic);
        Glide.with(Profile.this)
                .load("https://direct-app.net/food/" + Login.user.getPic()) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.profile_pic)  // any image in case of error
                .centerCrop()
                .into(iv);


        TextView name = findViewById(R.id.tv_profile_name);
        name.setText(Login.user.getName());

        InputField if_profile_full_name = findViewById(R.id.if_profile_full_name);
        EditText et_profile_full_name = if_profile_full_name.findViewById(R.id.input_field_edit_text);
        et_profile_full_name.setText(Login.user.getName());

        InputField if_profile_email = findViewById(R.id.if_profile_mail);
        EditText et_profile_email = if_profile_email.findViewById(R.id.input_field_edit_text);
        et_profile_email.setText(Login.user.getEmail());

        InputField if_profile_phone = findViewById(R.id.if_profile_phone);
        EditText et_profile_phone = if_profile_phone.findViewById(R.id.input_field_edit_text);
        et_profile_phone.setText(Login.user.getMobile());


    }
}