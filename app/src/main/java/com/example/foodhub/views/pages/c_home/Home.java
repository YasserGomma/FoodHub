package com.example.foodhub.views.pages.c_home;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.foodhub.R;
import com.example.foodhub.views.pages.b_account.Profile;
import com.example.foodhub.views.pages.parents.BaseActivity;
import com.google.android.material.navigation.NavigationView;

public class Home extends BaseActivity {

    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context=Home.context;
        ImageView cart = findViewById(R.id.iv_footer_icon_3);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hide_footer();
                replaceFragment(new CartFragment(), R.id.fram_home_fragment);

            }
        });
        replaceFragment(new HomeFragment(), R.id.fram_home_fragment);


      DrawerLayout drawerLayout=findViewById(R.id.drawerlayout);
      findViewById(R.id.btn_home_header_menu).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              drawerLayout.openDrawer(GravityCompat.START);
          }
      });

      NavigationView navigationView=findViewById(R.id.navigationView);
      navigationView.setItemIconTintList(null);

        initNavigationMenu();



    }
    private void initNavigationMenu() {
        NavigationView navigationView = findViewById(R.id.navigationView);
        final DrawerLayout drawer= findViewById(R.id.drawerlayout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                menuSelection(item.getItemId());
                drawer.closeDrawers();
                return true;
            }
        });

    }

    public void menuSelection(int id)
    {
        switch (id)
        {
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
        View v = findViewById(R.id.header);
        v.setVisibility(View.GONE);
    }

    public void show_header() {
        View v = findViewById(R.id.header);
        v.setVisibility(View.VISIBLE);
    }
}