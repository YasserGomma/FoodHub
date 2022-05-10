package com.example.foodhub.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.FoodItem;

import java.util.ArrayList;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder> {
    ArrayList<FoodItem> foods = new ArrayList<>();

    public FoodItemAdapter(ArrayList<FoodItem> foods) {
        this.foods = foods;
    }

    @Override
    public FoodItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, null, false);
        FoodItemViewHolder foodItemViewHolder = new FoodItemViewHolder(v);
        return foodItemViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodItemViewHolder holder, int position) {

        FoodItem c = foods.get(position);
        holder.iv.setImageResource(c.getImage());
        holder.tv.setText(c.getName());
    }

    @Override
    public int getItemCount() {
        return foods.size();
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
