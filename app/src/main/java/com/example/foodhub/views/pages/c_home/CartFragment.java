package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.CartItem;
import com.example.foodhub.views.adapters.CartItemAdapter;

import java.util.ArrayList;


public class CartFragment extends Fragment {


    public CartFragment() {
        // Required empty public constructor
    }

    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_cart_r1);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);

        // 2. set layoutManger
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem());
        cartItems.add(new CartItem());
        cartItems.add(new CartItem());
        cartItems.add(new CartItem());
        cartItems.add(new CartItem());
        cartItems.add(new CartItem());


        // 3. create an adapter
        CartItemAdapter cartItemAdapter = new CartItemAdapter(cartItems);
        // 4. set adapter
        recyclerView.setAdapter(cartItemAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return rootView;
    }
}