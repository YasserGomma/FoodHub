package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.View;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.parents.BaseActivity;

public class Home extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        replaceFragmen(new HomeFragment(),R.id.fram_home_fragment);

    }

    public void hide_footer()
    {
        View v=findViewById(R.id.footer);
        v.setVisibility(View.GONE);
    }
    public void show_footer()
    {
        View v=findViewById(R.id.footer);
        v.setVisibility(View.VISIBLE);
    }
}