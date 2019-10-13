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

    private int [] picture = { R.drawable.cake1,
            R.drawable.cake2,
            R.drawable.ca1,
            R.drawable.cake4,
            R.drawable.wed5,
            R.drawable.wed3,
    };
    private  String []  prices =new String[] {
            "Narciso rodriguez: $67.2", "Shay & Blue:$ 23.4", "Pure poison dior:$ 73.6", "Bal d'afrique:$ 65.4", "Jimmy choo:$ 560.00", "Boss :$ 562.76"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        ButterKnife.bind(this);
        gridView = (GridView) findViewById(R.id.myGrid);
//        gridView.setAdapter(new sellAdapter(this, picture,prices));
        mshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shop = new Intent(sellActivity.this,MainActivity.class);
                startActivity(shop);
            }
        });
    }
}


