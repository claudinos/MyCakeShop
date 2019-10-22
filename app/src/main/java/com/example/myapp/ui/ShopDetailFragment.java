package com.example.myapp.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.models.Business;
import com.example.myapp.models.Category;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopDetailFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.restaurantImageView)
    ImageView mImageLabel;
    @BindView(R.id.restaurantNameTextView)
    TextView mNameLabel;
    @BindView(R.id.cuisineTextView) TextView mCategoriesLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.saveRestaurantButton) TextView mSaveRestaurantButton;

    private Business mShop;

    public ShopDetailFragment() {
        // Required empty public constructor
    }
    public static ShopDetailFragment newInstance(Business shop) {
        ShopDetailFragment shopDetailFragment = new ShopDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("cake", Parcels.wrap(shop));
        shopDetailFragment.setArguments(args);
        return shopDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShop = Parcels.unwrap(getArguments().getParcelable("cake"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mShop.getImageUrl()).into(mImageLabel);
        List<String> categories = new ArrayList<>();

        for (Category category: mShop.getCategories()) {
            categories.add(category.getTitle());


        }
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);
        mWebsiteLabel.setOnClickListener(this);
        mNameLabel.setText(mShop.getName());
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
        mRatingLabel.setText(Double.toString(mShop.getRating()) + "/5");
        mPhoneLabel.setText(mShop.getPhone());
        mAddressLabel.setText(mShop.getLocation().toString());

        return view;
    }
    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mShop.getUrl()));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mShop.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mShop.getCoordinates().getLatitude()
                            + "," + mShop.getCoordinates().getLongitude()
                            + "?q=(" + mShop.getName() + ")"));
            startActivity(mapIntent);
        }
    }
}

