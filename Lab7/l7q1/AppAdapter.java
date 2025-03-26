package com.example.l7q1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;

import java.util.List;

public class AppAdapter extends ArrayAdapter<AppInfo> {
    public AppAdapter(Context context, List<AppInfo> apps) {
        super(context, 0, apps);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_app, parent, false);
        }

        AppInfo app = getItem(position);
        ((TextView) convertView.findViewById(R.id.appName)).setText(app.getName());
        ((ImageView) convertView.findViewById(R.id.appIcon)).setImageDrawable(app.getIcon());

        return convertView;
    }
}

