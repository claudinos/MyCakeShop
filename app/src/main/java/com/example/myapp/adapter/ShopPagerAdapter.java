package com.example.myapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapp.models.Business;
import com.example.myapp.ui.ShopDetailFragment;

import java.util.List;

public class ShopPagerAdapter extends FragmentPagerAdapter {
    private List<Business> shops;

    public ShopPagerAdapter(FragmentManager fm, int behavior, List<Business> restaurants) {
        super(fm, behavior);
        shops = restaurants;
    }

    @Override
    public Fragment getItem(int position) {
        return ShopDetailFragment.newInstance(shops.get(position));
    }

    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return shops.get(position).getName();
    }
}

