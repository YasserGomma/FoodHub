package com.example.foodhub.interfaces;

import com.example.foodhub.data.source.remote.RestaurantSearch;
import com.example.foodhub.data.source.remote.Root;
import com.example.foodhub.data.source.remote.User;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EndPoints {

    @FormUrlEncoded
    @POST("/food/serv.php/")
    public Call<User> login(@Field("email") String email, @Field("pass") String pass, @Field("type") String type, @Field("method") String method );
    @FormUrlEncoded
    @POST("/food/serv.php/")
    public Call<JsonObject> register(@Field("method") String method, @Field("type") String type, @Field("email") String email, @Field("pass") String pass, @Field("name") String name, @Field("mobile") String mobile);
    @FormUrlEncoded
    @POST("/food/serv.php/")
    public Call<Root> home(@Field("method") String method);
    @FormUrlEncoded
    @POST("/food/serv.php/")
    public Call<ArrayList<RestaurantSearch>> restaurantSearch(@Field("method") String method,@Field("keyword") String keyword);


}
