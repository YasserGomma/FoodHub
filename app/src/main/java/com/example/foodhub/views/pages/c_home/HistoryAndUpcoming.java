package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.test_data.HistoryItem;
import com.example.foodhub.views.adapters.HistoryItemAdapter;
import com.example.foodhub.views.components.HeaderBar;
import com.example.foodhub.views.helpers.SizeUtilities;
import com.example.foodhub.views.pages.b_account.Login;

import java.util.ArrayList;

public class HistoryAndUpcoming extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_and_upcoming);
        HeaderBar header = findViewById(R.id.header_cart);
        ImageView header_iv = header.findViewById(R.id.header_img);
        Glide.with(this)
                .load("https://direct-app.net/food/" + Login.user.getPic()) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.profile_pic)  // any image in case of error
                .centerCrop()
                .into(header_iv);
        TextView t1 = findViewById(R.id.toggle_histor_t1);
        TextView t2 = findViewById(R.id.toggle_histor_t2);

        Button header_btn=header.findViewById(R.id.header_btn);

        header_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HistoryAndUpcoming.super.onBackPressed();
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formatToggleButtons(t1, t2);
            }
        });

        //TextView t2 = rootView.findViewById(R.id.toggle_t2);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formatToggleButtons(t2, t1);
                configureHistory();
            }
        });
        recyclerView = findViewById(R.id.rv_history_r1);
        recyclerView.setNestedScrollingEnabled(false);

        // 2. set layoutManger


    }

    public void formatToggleButtons(TextView selected, TextView notSelected) {
        selected.setBackgroundResource(R.drawable.btn_bg);
        selected.setTextColor(HistoryAndUpcoming.this.getColor(R.color.white));
        notSelected.setBackgroundResource(R.drawable.btn_bg_5);
        notSelected.setTextColor(HistoryAndUpcoming.this.getColor(R.color.primary_color));
        int paddingSize = SizeUtilities.Dp2Px(HistoryAndUpcoming.this, 13);
        selected.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
        notSelected.setPadding(paddingSize, paddingSize, paddingSize, paddingSize);
    }

    public void configureHistory() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(HistoryAndUpcoming.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<HistoryItem> historyItems = new ArrayList<>();
        historyItems.add(new HistoryItem());
        historyItems.add(new HistoryItem());
        historyItems.add(new HistoryItem());
        historyItems.add(new HistoryItem());
        historyItems.add(new HistoryItem());
        historyItems.add(new HistoryItem());
        historyItems.add(new HistoryItem());
        historyItems.add(new HistoryItem());

        // 3. create an adapter
        HistoryItemAdapter historyItemAdapter = new HistoryItemAdapter(historyItems);
        // 4. set adapter
        recyclerView.setAdapter(historyItemAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}