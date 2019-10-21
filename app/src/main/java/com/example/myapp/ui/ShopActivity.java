package com.example.myapp.ui;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.MyShopArrayAdapter;
import com.example.myapp.R;
import com.example.myapp.adapter.ShopListAdapter;
import com.example.myapp.models.Business;
import com.example.myapp.models.Cakes;
import com.example.myapp.models.Category;
import com.example.myapp.network.YelpApi;
import com.example.myapp.network.YelpClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private ShopListAdapter mAdapter;

    public List<Business> cakes;


//
//    int[] images = {R.drawable.wed5,R.drawable.ca1,R.drawable.cake1,R.drawable.ca7};
//  String[] Products = {"weeding cake", "Breakfast cake", "birthday cake", "cake"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        YelpApi client = YelpClient.getClient();

        Call<Cakes> call = client.getCakes(location, "cakes");

        call.enqueue(new Callback<Cakes>() {

            @Override
            public void onResponse(Call<Cakes> call, Response<Cakes> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    cakes = response.body().getBusinesses();
                    mAdapter = new ShopListAdapter(ShopActivity.this, cakes);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(ShopActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);


                    showCakes();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<Cakes> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }

        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showCakes() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}