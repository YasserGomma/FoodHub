package com.example.foodhub.views.pages.c_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.FoodDetails;
import com.example.foodhub.data.test_data.CartItem;
import com.example.foodhub.interfaces.EndPoints;
import com.example.foodhub.views.adapters.CartItemAdapter;
import com.example.foodhub.views.networking.RetrofitCreation;
import com.example.foodhub.views.pages.b_account.PaymentFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CartFragment extends Fragment {
    public static ArrayList<String>ids = new ArrayList<>();
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


        Button btn = rootView.findViewById(R.id.btn_cart_checkout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new PaymentFragment(), R.id.fram_home_fragment);

            }
        });

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_cart_r1);
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);

        // 2. set layoutManger
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CartItem> cartItems = new ArrayList<>();

        ArrayList<Double>prices=new ArrayList<Double>();
        EndPoints Api = RetrofitCreation.getInstance();
        for(String id:ids) {
            Call<FoodDetails> call = Api.foodDetails("food",id);
            call.enqueue(new Callback<FoodDetails>() {
                @Override
                public void onResponse(Call<FoodDetails> call, Response<FoodDetails> response) {
                   // Toast.makeText(getContext(),response.body().name,Toast.LENGTH_LONG).show();
                    CartItem c=new CartItem();
                    c.name=response.body().name;
                    c.descriotion=response.body().description;
                    c.price=response.body().price;
                    c.image=response.body().pic;
                    prices.add(Double.parseDouble(c.price));
                    cartItems.add(c);
                    // 3. create an adapter
                    CartItemAdapter cartItemAdapter = new CartItemAdapter(getContext(),cartItems);
                    // 4. set adapter
                    recyclerView.setAdapter(cartItemAdapter);
                    // 5. set item animator to DefaultAnimator
                    recyclerView.setItemAnimator(new DefaultItemAnimator());

                }


                @Override
                public void onFailure(Call<FoodDetails> call, Throwable t) {

                }
            });
        }




        return rootView;
    }

    public void replaceFragment(Fragment fragment, int frameId) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getParentFragmentManager();
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