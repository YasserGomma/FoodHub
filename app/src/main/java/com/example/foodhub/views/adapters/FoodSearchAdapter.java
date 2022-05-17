package com.example.foodhub.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.FoodSearch;
import com.example.foodhub.views.pages.c_home.FoodDetailsFragment;

import java.util.ArrayList;

public class FoodSearchAdapter extends RecyclerView.Adapter<FoodSearchAdapter.FoodSearchViewHolder> {
    ArrayList<FoodSearch> items = new ArrayList<>();
    Context context;
    FragmentManager fragmentManager;

    public FoodSearchAdapter(Context context, FragmentManager fragmentManager, ArrayList<FoodSearch> items) {

        this.items = items;
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    @Override
    public FoodSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular_item, null, false);
        FoodSearchViewHolder foodSearchViewHolder = new FoodSearchViewHolder(v);
        return foodSearchViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodSearchViewHolder holder, int position) {

        FoodSearch item = items.get(position);
        Glide.with(context)
                .load("https://direct-app.net/food/" + item.pic) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.logo)  // any image in case of error
                .centerCrop()
                .into(holder.iv);
        holder.name.setText(item.name);
        holder.people.setText(item.number_of_ratings);
        holder.rate.setText(item.rating);
        holder.description.setText(item.description);
        holder.price.setText(item.price);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragmen(new FoodDetailsFragment(), R.id.fram_home_fragment);


            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void replaceFragmen(Fragment fragment, int frameId) {
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = fragmentManager;
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(frameId, fragment, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    class FoodSearchViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView name, description, price, rate, people, invisable;
        CardView cardView;
        RelativeLayout layout;

        public FoodSearchViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_popular_background);
            name = itemView.findViewById(R.id.tv_popular_name);
            description = itemView.findViewById(R.id.tv_popular_description);
            price = itemView.findViewById(R.id.tv_popular_price);
            rate = itemView.findViewById(R.id.tv_popular_rate);
            people = itemView.findViewById(R.id.tv_restaurant_num_people);
            invisable = itemView.findViewById(R.id.tv_popular_invisable);
            cardView = itemView.findViewById(R.id.card);
            layout = itemView.findViewById(R.id.item_popular_layout);

        }
    }
}
