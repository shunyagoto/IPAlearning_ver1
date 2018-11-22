package com.example.agoto.IPAlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IPAtableActivity extends AppCompatActivity {

    //Date starttime = new Date();//バックグラウンド復帰時刻のCalenderクラスの取得

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


 /*   public void onResume() {//バックグラウンド復帰時処理
        super.onResume();
        starttime = new Date();//バックグラウンド復帰時刻のCalenderクラスの取得
    }

    public void onPause() {//バックグラウンド移動時処理
        super.onPause();
        Date fintime = new Date();//バックグラウンド移動時刻のCalenderクラスの取得
        MainActivity mainactivity = new MainActivity();
        mainactivity.CSVFileWriter(starttime,fintime);
    }*/
}