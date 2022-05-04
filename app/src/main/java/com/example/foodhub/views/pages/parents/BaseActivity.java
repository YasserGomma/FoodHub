package com.example.foodhub.views.pages.parents;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodhub.interfaces.CallBack;


/**
 * This Activity ids the base activity for the project, it contains
 * all methods i almost use frequently in the project to prevent the repetition of
 * code snippets.
 */
public class BaseActivity extends AppCompatActivity {

    /**
     *Navigation between two screens
     */
    public void go_screen(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
    }

    /**
     *Handler to make delay for certain time then implement onFinished() which
     * located in CallBack interface.
     */
    public void delay(int duration, CallBack callBack)
    {
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callBack.onFinished();
            }
        },duration);
    }

}
