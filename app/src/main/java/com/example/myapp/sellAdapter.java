package com.example.myapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class sellAdapter extends BaseAdapter{
    private Context vanilla;
    private int[] bread;
    private String[]cake;

    public sellAdapter(Context vanilla, int[] bread,String[]cake) {
        this.vanilla = vanilla;
        this.bread = bread;
        this.cake=cake;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
      return null;

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) vanilla
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View grid = convertView;
        if (convertView == null) {
            grid = inflater.inflate(R.layout.grid,null);
        }
        ImageView pic = (ImageView)grid.findViewById(R.id.grid);
        pic.setImageResource(bread[position]);
        return pic;
    }
}
