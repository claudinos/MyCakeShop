package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.List;

public class MyShopArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mShop;
    private String[] mSell;


    public MyShopArrayAdapter(@NonNull Context context, int resource, String[] mShop, String[] mSell) {
        super(context, resource);
        this.mContext = mContext;
        this.mShop = mShop;
        this.mSell = mSell;
    }

    @Override
    public Object getItem(int X) {
        String shop = mShop[X];
        String sell = mSell[X];
        return String.format("%s \nServes great: %s", shop, sell);
    }

    @Override
    public int getCount() {
        return mShop.length;
    }
}
