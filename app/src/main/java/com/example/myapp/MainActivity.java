package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.startButton) Button mStartButton;
//    @BindView(R.id.textView)
//    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mStartButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mStartButton) {
            Intent intent = new Intent(MainActivity.this, ShopActivity.class);
            startActivity(intent);
        }
    }
}