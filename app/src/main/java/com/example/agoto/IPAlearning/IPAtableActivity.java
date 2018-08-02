package com.example.agoto.IPAlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IPAtableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipatable);
    }

    public void onHaikiryuButtonTapped(View view){
        Intent intent = new Intent(this, haikiryuActivity.class);
        startActivity(intent);
    }

    public void onBoinButtonTapped(View view){
        Intent intent = new Intent(this, boinActivity.class);
        startActivity(intent);
    }

    public void onHihaikiryuButtonTapped(View view){
        Intent intent = new Intent(this, hihaikiryuActivity.class);
        startActivity(intent);
    }

    public void onOtherButtonTapped(View view){
        Intent intent = new Intent(this, otherActivity.class);
        startActivity(intent);
    }
}