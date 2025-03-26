package com.example.l7q1;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private String name;
    private String packageName;
    private Drawable icon;
    private boolean isSystemApp;
    private String permissions;

    public AppInfo(String name, String packageName, Drawable icon, boolean isSystemApp, String permissions) {
        this.name = name;
        this.packageName = packageName;
        this.icon = icon;
        this.isSystemApp = isSystemApp;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public boolean isSystemApp() {
        return isSystemApp;
    }

    public String getPermissions() {
        return permissions;
    }
}
