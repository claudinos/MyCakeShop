package com.example.myapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapp.R;
import com.example.myapp.adapter.ShopPagerAdapter;
import com.example.myapp.models.Business;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private ShopPagerAdapter adapterViewPager;
    List<Business> shops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        ButterKnife.bind(this);

        shops = Parcels.unwrap(getIntent().getParcelableExtra("cakes"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new ShopPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, shops);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
