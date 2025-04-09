package com.example.menus;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView context_tv=findViewById(R.id.contextMenu);
        registerForContextMenu(context_tv);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu_overflow,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.refresh)
            Toast.makeText(getApplicationContext(),"Clicked on refresh",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.settings)
            Toast.makeText(getApplicationContext(),"Clicked on settings",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.cut)
            Toast.makeText(getApplicationContext(),"Clicked on Cut",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.copy)
            Toast.makeText(getApplicationContext(),"Clicked on Copy",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.paste)
            Toast.makeText(getApplicationContext(),"Clicked on paste",Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }

    public void showPopUpMenu(View v)
    {
        PopupMenu pum=new PopupMenu(this,v);
        MenuInflater inflater=pum.getMenuInflater();
        inflater.inflate(R.menu.menu_popup,pum.getMenu());
        pum.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return onPopupMenuClick(item);
            }
        });
        pum.show();
    }

    private boolean onPopupMenuClick(MenuItem item)
    {
        if(item.getItemId()==R.id.bold)
            Toast.makeText(getApplicationContext(),"Clicked on Bold",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.italic)
            Toast.makeText(getApplicationContext(),"Clicked on Italic",Toast.LENGTH_SHORT).show();
        if(item.getItemId()==R.id.underline)
            Toast.makeText(getApplicationContext(),"Clicked on Underline",Toast.LENGTH_SHORT).show();
        return true;
    }
}