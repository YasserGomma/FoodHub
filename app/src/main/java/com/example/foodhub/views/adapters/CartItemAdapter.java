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
import com.example.foodhub.data.test_data.CartItem;

import java.util.ArrayList;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {
    ArrayList<CartItem> adds = new ArrayList<>();
    Context context;

    public CartItemAdapter(Context context,ArrayList<CartItem> foods) {
        this.adds = foods;
        this.context=context;
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

        holder.tv_card_item_name.setText(item.name);
        holder.tv_card_item_description.setText(item.descriotion);
        holder.tv_card_item_price.setText(item.price);
        Glide.with(context)
                .load("https://direct-app.net/food/" + item.image) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.logo)  // any image in case of error
                .centerCrop()
                .into(holder.img);  // imageview

    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder {

        TextView tv_card_item_name,tv_card_item_description,tv_card_item_price;
        ImageView img;
        public CartItemViewHolder(View itemView) {
            super(itemView);
            tv_card_item_name=itemView.findViewById(R.id.tv_card_item_name);
            tv_card_item_description=itemView.findViewById(R.id.tv_card_item_description);
            tv_card_item_price=itemView.findViewById(R.id.tv_card_item_price);
            img=itemView.findViewById(R.id.iv_card_item_image);


        }
    }
}
