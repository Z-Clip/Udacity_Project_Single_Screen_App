package com.example.android.singlescreenapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout_portrait);
    }

    /* If a configuration change is detected, execute changeLayoutBasedOnOrientation.
     * Since there are no global variables to preserve, there is no need to override
     * onSaveInstanceState.
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        changeLayoutBasedOnOrientation(newConfig);
    }

    //Change layout based on screen orientation.
    public void changeLayoutBasedOnOrientation (Configuration newConfig) {
        //Portrait orientation
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.main_layout_portrait);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.main_layout_landscape);
        }
    }

    //Send an email.
    public void emailIntent(View view) {
        String[] emailTo = {"GiveUsYourMoney@hotmail.com"};

        Intent sendEmail = new Intent(Intent.ACTION_SENDTO);
        sendEmail.setData(Uri.parse("mailto:"));
        sendEmail.putExtra(Intent.EXTRA_EMAIL,emailTo);
        sendEmail.putExtra(Intent.EXTRA_SUBJECT, "I would love to give you boat loads of money!");
        if (sendEmail.resolveActivity(getPackageManager()) != null) {
            startActivity(sendEmail);
        } else {
            Toast.makeText(this,"Could not launch email app.", Toast.LENGTH_SHORT).show();
        }
    }

    //Make a phone call
    public void phoneIntent(View view) {
        Intent placeCall = new Intent(Intent.ACTION_DIAL);
        placeCall.setData(Uri.parse("tel:5555555555"));
        if (placeCall.resolveActivity(getPackageManager()) != null) {
            startActivity(placeCall);
        } else {
            Toast.makeText(this,"Could not launch phone app.", Toast.LENGTH_SHORT).show();
        }
    }

    //Launch map app
    public void mapIntent(View view) {
        Uri location = Uri.parse("geo:36.588013,-116.943343");

        Intent showMap = new Intent(Intent.ACTION_VIEW,location);
        showMap.setPackage("com.google.android.apps.maps");
        if (showMap.resolveActivity(getPackageManager()) != null) {
            startActivity(showMap);
        }
    }
}
