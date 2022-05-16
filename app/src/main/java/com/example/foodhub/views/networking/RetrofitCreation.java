package com.example.foodhub.views.networking;

import com.example.foodhub.interfaces.EndPoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreation {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://direct-app.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static EndPoints Api = null;
    public static EndPoints getInstance() {
        return (Api == null) ? Api = retrofit.create(EndPoints.class) : Api;
    }

    private RetrofitCreation() {
    }

}
