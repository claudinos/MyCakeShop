package com.example.myapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.listView) ListView mListView;

  int[] images = {R.drawable.wed5,R.drawable.ca1,R.drawable.cake1,R.drawable.ca7};
  String[] Products = {"weeding cake", "Breakfast cake", "birthday cake", "cake"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);


        MyShopArrayAdapter adapter = new MyShopArrayAdapter(this, android.R.layout.simple_list_item_1, images, Products);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent main = new Intent(ShopActivity.this, BuyActivity.class);
                startActivity(main);
            }
        });
        Intent intent = getIntent();


    }
}
