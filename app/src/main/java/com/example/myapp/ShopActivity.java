package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.listView) ListView mListView;

    private String[] shop = new String[] {"weeding", "birthday", "simple cake", "cake" };
    private String[] sell = new String[] {"weeding cake", "Breakfast", "birthday cake", "cake"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        MyShopArrayAdapter adapter = new MyShopArrayAdapter(this, android.R.layout.simple_list_item_1, shop, sell);
        mListView.setAdapter(adapter);
    }

}
