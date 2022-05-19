package com.example.foodhub.views.pages.c_home;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.views.pages.a_intro.WelcomeScreen;
import com.example.foodhub.views.pages.b_account.Login;
import com.example.foodhub.views.pages.b_account.Profile;
import com.example.foodhub.views.pages.parents.BaseActivity;
import com.google.android.material.navigation.NavigationView;

public class Home extends BaseActivity {

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = Home.context;

        NavigationView navigationView = findViewById(R.id.navigationView);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.tv_header_menu_name);
        TextView navUserEmail = headerView.findViewById(R.id.tv_header_menu_email);

        ImageView menu_iv = headerView.findViewById(R.id.iv_header_menu_pic);

        Button logout = navigationView.findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().clear().apply();
                go_screen(Home.this, WelcomeScreen.class);
            }
        });

        Glide.with(Home.this)
                .load("https://direct-app.net/food/" + Login.user.getPic()) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.profile_pic)  // any image in case of error
                .centerCrop()
                .into(menu_iv);
        navUsername.setText(Login.user.getName());
        navUserEmail.setText(Login.user.getEmail());
        ImageView cart = findViewById(R.id.iv_footer_icon_3);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide_footer();
                replaceFragment(new CartFragment(), R.id.fram_home_fragment);

            }
        });
        // tv_home_header_address

        View header = findViewById(R.id.header_cart);
        ImageView header_iv = header.findViewById(R.id.iv_home_header_photo);
        Glide.with(Home.this)
                .load("https://direct-app.net/food/" + Login.user.getPic()) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.profile_pic)  // any image in case of error
                .centerCrop()
                .into(header_iv);


        replaceFragment(new HomeFragment(), R.id.fram_home_fragment);


        DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        findViewById(R.id.btn_home_header_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        initNavigationMenu();


    }

    private void initNavigationMenu() {
        NavigationView navigationView = findViewById(R.id.navigationView);
        final DrawerLayout drawer = findViewById(R.id.drawerlayout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                menuSelection(item.getItemId());
                drawer.closeDrawers();
                return true;
            }
        });

    }

    public void menuSelection(int id) {
        switch (id) {
            case R.id.profile:
                go_screen(Home.this, Profile.class);
                break;
            case R.id.payment:
                go_screen(Home.this, CardActivity.class);
                break;
            case R.id.orders:
                go_screen(Home.this, HistoryAndUpcoming.class);
                break;
            default:

        }
    }

    public void hide_footer() {
        View v = findViewById(R.id.footer);
        v.setVisibility(View.GONE);
    }

    public void show_footer() {
        View v = findViewById(R.id.footer);
        v.setVisibility(View.VISIBLE);
    }

    public void hide_header() {
        View v = findViewById(R.id.header_cart);
        v.setVisibility(View.GONE);
    }

    public void show_header() {
        View v = findViewById(R.id.header_cart);
        v.setVisibility(View.VISIBLE);
    }
}