package com.example.myapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.models.Business;
import com.example.myapp.ui.ShopDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.ShopViewHolder> {
    private List<Business> cakes;
    private Context mContext;

    public ShopListAdapter(Context context, List<Business> restaurants) {
        mContext = context;
        cakes = restaurants;

    }

    @Override
    public ShopListAdapter.ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_list_item, parent, false);
        ShopViewHolder viewHolder = new ShopViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShopListAdapter.ShopViewHolder holder, int position) {
        holder.bindShop(cakes.get(position));
    }

    @Override
    public int getItemCount() {
        return cakes.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.restaurantImageView)
        ImageView mShopImageView;
        @BindView(R.id.restaurantNameTextView)
        TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;


        public ShopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ShopDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("cakes", Parcels.wrap(cakes));
            mContext.startActivity(intent);
        }

        public void bindShop(Business shop) {
            Picasso.get().load(shop.getImageUrl()).into(mShopImageView);
            mNameTextView.setText(shop.getName());
            mCategoryTextView.setText(shop.getCategories().get(0).getTitle());
            mRatingTextView.setText("Rating: " + shop.getRating() + "/5");
        }
    }
}