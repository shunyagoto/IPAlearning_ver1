package com.example.agoto.IPAlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        // MainActivityからintentで受け取ったものを取り出す
        String selectedText = intent.getStringExtra("Text");

        TextView textView = findViewById(R.id.selected_text);

        String sdPath = /*Environment.getExternalStorageDirectory().getPath() + "/" + */selectedText + "AUS.csv";

        String text = null;
        String lineBuffer;
        try {
            File file = new File(sdPath);
            if (file.exists()) {
                //FileReaderクラスのオブジェクトを生成する
                //FileReader filereader = new FileReader(file);
                FileInputStream fis = openFileInput(sdPath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
                while ((lineBuffer = reader.readLine()) != null) {
                    text = lineBuffer;
                }
                textView.setText(text);
            } else {
                textView.setText("読み込めませんでした");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
