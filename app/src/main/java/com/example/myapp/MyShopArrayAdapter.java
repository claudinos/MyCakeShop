package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyShopArrayAdapter extends BaseAdapter {
    private Context mContext;
     int[] images;
   String[] Products;

    public MyShopArrayAdapter(Context mContext, int simple_list_item_1, int[] images, String[] products) {
        this.mContext = mContext;
        this.images = images;
        this.Products = products;
    }

    @Override
    public Object getItem(int position) {
        int image = images[position];
        String Product = Products[position];
        return String.format("%s  %s", image, Product);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater getLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = getLayoutInflater.inflate(R.layout.userlayout,null);
//        ImageView pictures =(ImageView) view.findViewById(R.id.imageView2);
        TextView sales = (TextView) view.findViewById(R.id.textView);
//        pictures.setImageResource(images[position]);
        sales.setText(Products[position]);
        return view;
    }

    @Override
    public int getCount() {
        return images.length;
    }
}
