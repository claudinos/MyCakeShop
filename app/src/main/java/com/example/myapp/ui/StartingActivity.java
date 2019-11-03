package com.example.myapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartingActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.startButton) Button startAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        ButterKnife.bind(this);

        startAnimation.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v==startAnimation){
            Intent intent = new Intent(StartingActivity.this,LoginActivity.class);
            startActivity(intent);
            Animation bounce = AnimationUtils.loadAnimation(this,R.anim.blink_anim);
            startAnimation.startAnimation(bounce);
        }
    }
}
