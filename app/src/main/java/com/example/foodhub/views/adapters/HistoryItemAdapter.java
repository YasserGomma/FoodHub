package com.example.foodhub.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.foodhub.R;
import com.example.foodhub.data.models.HistoryItem;

import java.util.ArrayList;

public class HistoryItemAdapter extends RecyclerView.Adapter<HistoryItemAdapter.HistoryItemViewHolder> {
    ArrayList<HistoryItem> adds = new ArrayList<>();

    public HistoryItemAdapter(ArrayList<HistoryItem> foods) {
        this.adds = foods;
    }

    @Override
    public HistoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_upcoming, null, false);
        HistoryItemViewHolder historyItemViewHolder = new HistoryItemViewHolder(v);
        return historyItemViewHolder;
    }

    @Override
    public void onBindViewHolder(HistoryItemViewHolder holder, int position) {

        HistoryItem item = adds.get(position);

    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    class HistoryItemViewHolder extends RecyclerView.ViewHolder {


        public HistoryItemViewHolder(View itemView) {
            super(itemView);

        }
    }
}
