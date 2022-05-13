package com.example.foodhub.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.PopularItem;

import java.util.ArrayList;

public class PopularItemAdapter2 extends RecyclerView.Adapter<PopularItemAdapter2.PopularItemViewHolder> {
    ArrayList<PopularItem> items = new ArrayList<>();

    public PopularItemAdapter2(ArrayList<PopularItem> items) {
        this.items = items;
    }

    @Override
    public PopularItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular_item, null, false);
        PopularItemViewHolder PopularItemViewHolder = new PopularItemViewHolder(v);
        return PopularItemViewHolder;
    }

    @Override
    public void onBindViewHolder(PopularItemViewHolder holder, int position) {

        PopularItem item = items.get(position);
        if (position > 0) {
            holder.iv.setImageResource(item.getImage());
            holder.name.setText(item.getName());
            holder.people.setText("( " + item.getNummberOfPeople() + " )");
            holder.rate.setText(item.getRate() + "");
            holder.description.setText(item.getDescription());
            holder.price.setText(item.getPrice() + "");

        } else {
            holder.cardView.setVisibility(View.GONE);
            holder.invisable.setText("Found 10 results");
        }

    }

    @Override
    public int getItemCount() {
        return items.size() - 1;
    }

    class PopularItemViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView name, description, price, rate, people, invisable;
        CardView cardView;

        public PopularItemViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_popular_background);
            name = itemView.findViewById(R.id.tv_popular_name);
            description = itemView.findViewById(R.id.tv_popular_description);
            price = itemView.findViewById(R.id.tv_popular_price);
            rate = itemView.findViewById(R.id.tv_popular_rate);
            people = itemView.findViewById(R.id.tv_restaurant_num_people);
            invisable = itemView.findViewById(R.id.tv_popular_invisable);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
