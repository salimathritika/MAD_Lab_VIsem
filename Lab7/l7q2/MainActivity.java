package com.example.l7q2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView menuIcon, displayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuIcon = findViewById(R.id.menu_icon);
        displayImage = findViewById(R.id.display_image);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.image1) {
                    displayImage.setImageResource(R.drawable.img_1);  // Direct resource reference
                    displayImage.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Image -1 Selected", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (itemId == R.id.image2) {
                    displayImage.setImageResource(R.drawable.img_2);
                    displayImage.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Image -2 Selected", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        popupMenu.show();
    }


}
