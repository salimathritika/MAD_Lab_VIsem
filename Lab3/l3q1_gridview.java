package com.example.l3q1_gridview;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.BaseAdapter;

public class MainActivity extends AppCompatActivity {

    private int[] photoIds = {
            R.drawable.img, R.drawable.img_1, R.drawable.img_2,
            R.drawable.img_3, R.drawable.img_4, R.drawable.img_5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);
        PhotoAdapter adapter = new PhotoAdapter();
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(MainActivity.this, "Clicked on photo " + (position + 1), Toast.LENGTH_SHORT).show();
        });
    }

    private class PhotoAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return photoIds.length; // Number of photos in the array
        }

        @Override
        public Object getItem(int position) {
            return null; // Not used in this case
        }

        @Override
        public long getItemId(int position) {
            return position; // Return position as the ID
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(MainActivity.this);
                imageView.setLayoutParams(new GridView.LayoutParams(200, 200)); // Set size of images
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(photoIds[position]);
            return imageView;
        }
    }
}
