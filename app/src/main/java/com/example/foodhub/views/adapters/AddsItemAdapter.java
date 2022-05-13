package com.example.foodhub.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.AddsItem;

import java.util.ArrayList;

public class AddsItemAdapter extends RecyclerView.Adapter<AddsItemAdapter.AddsItemViewHolder> {
    ArrayList<AddsItem> adds = new ArrayList<>();

    public AddsItemAdapter(ArrayList<AddsItem> foods) {
        this.adds = foods;
    }

    @Override
    public AddsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adds, null, false);
        AddsItemViewHolder addsItemViewHolder = new AddsItemViewHolder(v);
        return addsItemViewHolder;
    }

    @Override
    public void onBindViewHolder(AddsItemViewHolder holder, int position) {

        AddsItem item = adds.get(position);

    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    class AddsItemViewHolder extends RecyclerView.ViewHolder {


        public AddsItemViewHolder(View itemView) {
            super(itemView);

        }
    }
}
