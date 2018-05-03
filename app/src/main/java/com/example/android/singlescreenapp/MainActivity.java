package com.example.android.singlescreenapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

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

    public void phoneIntent(View view) {
    }

    public void mapIntent(View view) {
    }
}
