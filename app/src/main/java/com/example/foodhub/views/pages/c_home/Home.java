package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class Home extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        replaceFragmen(new SearchResturantFragment(),R.id.fram_home_fragment);


    }
}