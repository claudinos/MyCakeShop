package com.example.myapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuyActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.edit)
    EditText mEdit;
    @BindView(R.id.buy)
    Button mBuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        ButterKnife.bind(this);
        mBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View mBuy) {
        String x = mEdit.getText().toString();
        Toast.makeText(BuyActivity.this, "Received,Choice the cake ", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(BuyActivity.this, sellActivity.class);
        intent.putExtra("x", x);
        startActivity(intent);

    }
}
