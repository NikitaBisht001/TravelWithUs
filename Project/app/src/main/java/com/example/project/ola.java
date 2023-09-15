package com.example.project;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

public class ola<launchIntent> {
    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.olacabs.customer");
    private PackageManager packageManager;
    {
        Uri uri = Uri.parse("market://details?id=com.olacabs.customer");
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=com.olacabs.customer")));
        }
    }

    void startActivity(Intent intent) {
    }

    public PackageManager getPackageManager() {
        return packageManager;
    }

    public void setPackageManager(PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    protected void onCreate(Bundle savedInstanceState) {
    }
}
