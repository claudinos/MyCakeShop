package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
public class sellActivity extends AppCompatActivity {
    @BindView(R.id.getGrid) TextView mTextView;
    @BindView(R.id.shop) Button mshop;

    GridView gridView;

    int [] picture = { R.drawable.cake1, R.drawable.cake2, R.drawable.ca1, R.drawable.cake4, R.drawable.wed5, R.drawable.wed3,};
    String []  prices =new String[] {"cake1:$7", "cake2:$8", "cake3:$10", "cake4:$12", "cake5:$12", "cake6:$13"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        ButterKnife.bind(this);
        gridView = (GridView) findViewById(R.id.myGrid);
        gridView.setAdapter(new sellAdapter(this, picture,prices));
        mshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shop = new Intent(sellActivity.this,MainActivity.class);
                startActivity(shop);
            }
        });
    }
}


