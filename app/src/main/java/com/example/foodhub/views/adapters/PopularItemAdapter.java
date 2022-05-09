package com.example.foodhub.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.PopularItem;

import java.util.ArrayList;

public class PopularItemAdapter extends RecyclerView.Adapter<PopularItemAdapter.PopularItemViewHolder> {
    ArrayList<PopularItem> items = new ArrayList<>();

    public PopularItemAdapter(ArrayList<PopularItem> items) {
        this.items = items;
    }

    @Override
    public PopularItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item, null, false);
        PopularItemViewHolder PopularItemViewHolder = new PopularItemViewHolder(v);
        return PopularItemViewHolder;
    }

    @Override
    public void onBindViewHolder(PopularItemViewHolder holder, int position) {

        PopularItem item = items.get(position);
        holder.iv.setImageResource(item.getImage());
        holder.name.setText(item.getName());
        holder.people.setText("( "+item.getNummberOfPeople() + " )");
        holder.rate.setText(item.getRate() + "");
        holder.description.setText(item.getDescription());
        holder.price.setText(item.getPrice() + "");

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PopularItemViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView name, description, price, rate, people;

        public PopularItemViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_popular_background);
            name = itemView.findViewById(R.id.tv_popular_name);
            description = itemView.findViewById(R.id.tv_popular_description);
            price = itemView.findViewById(R.id.tv_popular_price);
            rate = itemView.findViewById(R.id.tv_popular_rate);
            people = itemView.findViewById(R.id.tv_restaurant_num_people);
        }
    }
}
