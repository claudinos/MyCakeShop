//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//
//import com.example.myapp.R;
//
//public class sellAdapter extends BaseAdapter {
//
//private Context cakes;
//    private int[] pictures;
//    public sellAdapter(Context cakes, int[] pictures) {
//        this.cakes = cakes;
//        this.pictures = pictures;
//
//
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) cakes
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View cake = convertView;
//        if (convertView == null) {
//            cake = inflater.inflate(R.id.myGrid);
//        }
//        ImageView pictureView = (ImageView)cake.findViewById(R.id.getGrid);
//        pictureView.setImageResource(pictures[position]);
//        return pictureView;
//    }
//}
//

