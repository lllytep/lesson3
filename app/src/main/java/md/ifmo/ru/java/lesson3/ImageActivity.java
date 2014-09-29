package md.ifmo.ru.java.lesson3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new MyAdapter(this));

    }

    class MyAdapter extends BaseAdapter {
        private ArrayList<Item> item = new ArrayList<Item>();
        private LayoutInflater inflater;

        public MyAdapter(Context context){
            inflater = LayoutInflater.from(context);
            for(int i = 0; i < 10; i++){
                item.add(new Item("Image 1", R.drawable.ic_launcher));
            }
        }

        @Override
        public int getCount() {
            return item.size();
        }

        @Override
        public Object getItem(int position) {
            return item.get(position);
        }

        @Override
        public long getItemId(int position) {
            return item.get(position).drawableId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            ImageView picture;
            TextView name;

            if(v == null){
                v = inflater.inflate(R.layout.gridview_image, parent, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }

            picture = (ImageView)v.getTag(R.id.picture);
            name = (TextView)v.getTag(R.id.text);

            Item item = (Item)getItem(position);

            picture.setImageResource(item.drawableId);
            name.setText(item.name);
            return v;
        }

        class Item{
            final String name;
            final int drawableId;

            Item(String name, int drawableId) {
                this.name = name;
                this.drawableId = drawableId;
            }
        }
    }

}
