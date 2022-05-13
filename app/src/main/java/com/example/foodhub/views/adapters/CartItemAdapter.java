package com.example.foodhub.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.CartItem;

import java.util.ArrayList;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {
    ArrayList<CartItem> adds = new ArrayList<>();

    public CartItemAdapter(ArrayList<CartItem> foods) {
        this.adds = foods;
    }

    @Override
    public CartItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart_item, null, false);
        CartItemViewHolder cartItemViewHolder = new CartItemViewHolder(v);
        return cartItemViewHolder;
    }

    @Override
    public void onBindViewHolder(CartItemViewHolder holder, int position) {

        CartItem item = adds.get(position);

    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder {


        public CartItemViewHolder(View itemView) {
            super(itemView);

        }
    }
}
