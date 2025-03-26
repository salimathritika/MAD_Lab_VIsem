package com.example.l7q1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<AppInfo> appList;
    AppAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        appList = getInstalledApps();
        adapter = new AppAdapter(this, appList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showOptionsDialog(appList.get(position));
                return true;
            }
        });
    }

    private List<AppInfo> getInstalledApps() {
        List<AppInfo> apps = new ArrayList<>();
        PackageManager pm = getPackageManager();
        List<PackageInfo> packages = pm.getInstalledPackages(PackageManager.GET_PERMISSIONS);

        for (PackageInfo packageInfo : packages) {
            ApplicationInfo ai = packageInfo.applicationInfo;
            boolean isSystemApp = (ai.flags & ApplicationInfo.FLAG_SYSTEM) != 0;

            // ✅ Get permissions
            String permissions = getAppPermissions(packageInfo);

            apps.add(new AppInfo(ai.loadLabel(pm).toString(), ai.packageName, ai.loadIcon(pm), isSystemApp, permissions));
        }
        return apps;
    }

    private void showOptionsDialog(AppInfo app) {
        String systemAppStatus = app.isSystemApp() ? "System App" : "User Installed";
        String specialPermissions = app.getPermissions().isEmpty() ? "No Special Permissions" : "Permissions:\n" + app.getPermissions();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(app.getName());

        // ✅ Show system/user status and permissions properly
        builder.setMessage(systemAppStatus + "\n\n" + specialPermissions);

        // ✅ Add the options back
        builder.setPositiveButton("Open App", (dialog, which) -> openApp(app.getPackageName()));
        builder.setNegativeButton("Uninstall", (dialog, which) -> uninstallApp(app.getPackageName()));
        builder.setNeutralButton("View Details", (dialog, which) -> {
            Intent intent = new Intent(MainActivity.this, AppDetailsActivity.class);
            intent.putExtra("package", app.getPackageName());
            startActivity(intent);
        });

        builder.show();
    }


    private String getAppPermissions(PackageInfo packageInfo) {
        if (packageInfo.requestedPermissions != null) {
            return String.join("\n", packageInfo.requestedPermissions);
        }
        return "";
    }

    private void openApp(String packageName) {
        Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) startActivity(intent);
        else Toast.makeText(this, "Cannot open app", Toast.LENGTH_SHORT).show();
    }

    private void uninstallApp(String packageName) {
        Toast.makeText(getApplicationContext(), "Will uninstall app", Toast.LENGTH_SHORT).show();
    }
}
