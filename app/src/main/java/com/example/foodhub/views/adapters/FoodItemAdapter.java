package com.example.foodhub.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.Category;

import java.util.ArrayList;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder> {
    ArrayList<Category> categories = new ArrayList<>();
    Context context;

    public FoodItemAdapter(Context context, ArrayList<Category> categories) {
        this.categories = categories;
        this.context = context;
    }

    @Override
    public FoodItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, null, false);
        FoodItemViewHolder foodItemViewHolder = new FoodItemViewHolder(v);
        return foodItemViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodItemViewHolder holder, int position) {

        Category c = categories.get(position);
        holder.tv.setText(c.cat_name);
        Glide.with(context)
                .load("https://direct-app.net/food/" + c.cat_pic) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.logo)  // any image in case of error
                .centerCrop()
                .into(holder.iv);  // imageview
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class FoodItemViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv;

        public FoodItemViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_food_item_img);
            tv = itemView.findViewById(R.id.tv_food_item_name);
        }
    }
}
