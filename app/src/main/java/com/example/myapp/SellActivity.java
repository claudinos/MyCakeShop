//package com.example.myapp;
//
//import android.content.Intent;
//import android.graphics.Picture;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.GridView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//public class SellActivity extends AppCompatActivity {
//    @BindView(R.id.getGrid) TextView mTextView;
//    @BindView(R.id.shop) Button mFill;
//    GridView gridView;
//    int [] images = { R.drawable.ca7,R.drawable.ca1, R.drawable.wed5, R.drawable.wed, R.drawable.cake2, R.drawable.cake1,};
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sell);
//                ButterKnife.bind(this);
//                gridView = (GridView) findViewById(R.id.myGrid);
//                gridView.setAdapter(new MyShopArrayAdapter(this, images));
//
//        }
//    }
//
