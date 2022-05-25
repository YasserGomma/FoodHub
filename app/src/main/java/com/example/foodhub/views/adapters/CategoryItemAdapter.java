package com.example.foodhub.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodhub.R;
import com.example.foodhub.data.source.remote.Category;
import com.example.foodhub.views.pages.c_home.FoodByCategoryFragment;

import java.util.ArrayList;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder> {
    public static String category_id_CI_adapter = "";
    public static String category_name_CI_adapter = "";

    ArrayList<Category> categories = new ArrayList<>();
    Context context;
    FragmentManager fragmentManager;

    public CategoryItemAdapter(Context context, FragmentManager fragmentManager, ArrayList<Category> categories) {
        this.categories = categories;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public CategoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_item, null, false);
        CategoryItemViewHolder categoryItemViewHolder = new CategoryItemViewHolder(v);
        return categoryItemViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryItemViewHolder holder, int position) {

        Category c = categories.get(position);
        holder.tv.setText(c.cat_name);
        Glide.with(context)
                .load("https://direct-app.net/food/" + c.cat_pic) // image url
                .placeholder(R.drawable.ic_launcher_background) // any placeholder to load at start
                .error(R.drawable.logo)  // any image in case of error
                .centerCrop()
                .into(holder.iv);  // imageview

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category_id_CI_adapter = c.id;
                category_name_CI_adapter = c.cat_name;
                replaceFragment(new FoodByCategoryFragment(), R.id.fram_home_fragment);
            }
        });
    }

    public void replaceFragment(Fragment fragment, int frameId) {
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

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class CategoryItemViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv;
        RelativeLayout relativeLayout;

        public CategoryItemViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_food_item_img);
            tv = itemView.findViewById(R.id.tv_food_item_name);
            relativeLayout = itemView.findViewById(R.id.layout_category);
        }
    }

}
