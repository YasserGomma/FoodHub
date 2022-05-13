package com.example.foodhub.data.source.local;

import com.example.foodhub.R;
import com.example.foodhub.data.models.OnboardingItem;

import java.util.ArrayList;

public class OnboardingData {
    public static ArrayList<OnboardingItem> Items() {
        ArrayList<OnboardingItem> onboardingItemList = new ArrayList<>();
        OnboardingItem itemPlayOnline1 = new OnboardingItem();
        itemPlayOnline1.setTitle("Browse your menu\nand order directly");
        itemPlayOnline1.setDescription("Our app can send you everywhere,\neven space. For only $2.99 per month");
        itemPlayOnline1.setImage(R.drawable.onboarding_image_1);

        OnboardingItem itemPlayOnline2 = new OnboardingItem();
        itemPlayOnline2.setTitle("Even to space with\nus! Together");
        itemPlayOnline2.setDescription("Our app can send you everywhere,\neven space. For only $2.99 per month");
        itemPlayOnline2.setImage(R.drawable.onboarding_image_2);

        OnboardingItem itemPlayOnline3 = new OnboardingItem();
        itemPlayOnline3.setTitle("Pickup delivery at\nyour door");
        itemPlayOnline3.setDescription("Our app can send you everywhere, \neven space. For only $2.99 per month");
        itemPlayOnline3.setImage(R.drawable.onboarding_image_3);

        onboardingItemList.add(itemPlayOnline1);
        onboardingItemList.add(itemPlayOnline2);
        onboardingItemList.add(itemPlayOnline3);

        return onboardingItemList;

    }


}
