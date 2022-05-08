package com.example.foodhub.views.pages.parents;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodhub.R;
import com.example.foodhub.interfaces.CallBack;


/**
 * This Activity ids the base activity for the project, it contains
 * all methods i almost use frequently in the project to prevent the repetition of
 * code snippets.
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * Navigation between two screens
     */
    public void go_screen(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
    }

    /**
     * Handler to make delay for certain time then implement onFinished() which
     * located in CallBack interface.
     */
    public void delay(int duration, CallBack callBack) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callBack.onFinished();
            }
        }, duration);
    }
    /**
     * Change the color of the edit text border if it is focused.
     */
    public void changeBorderOnFocus(int... ids) {
        for(int id:ids) {
            EditText view = findViewById(id);
            view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean isFocused) {
                    if (isFocused == true) {
                        view.setBackgroundResource(R.drawable.et_bg_1);
                    } else {
                        view.setBackgroundResource(R.drawable.et_bg);

                    }
                }
            });
        }
    }

    /**
     * get Edit text text
     */
    public String getEtText(int id)
    {
        EditText et=findViewById(id);
        return et.getText().toString();
    }

    public void replaceFragmen(Fragment fragment,int frameId) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(frameId, fragment, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

}
