package com.example.agoto.IPAlearning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class AUSActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //private List<String[]> CsvNameList = new ArrayList<String[]>();
    private String filename;
    private String[] splitname;
    private List<String> CsvList = new ArrayList<String>();
    private List<String> CsvNameList = new ArrayList<String>();
    private ListView lv;
    private File[] files;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aus);

        String sdPath = Environment.getExternalStorageDirectory().getPath();
        files = new File(sdPath).listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile() && files[i].getName().endsWith("AUS.csv")) {
                    filename = files[i].getName();
                    splitname = filename.split("AUS.csv",0);
                    CsvNameList.add(splitname[0]);
                    CsvList.add(filename);
                }
            }

        }
        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        BaseAdapter adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.list, CsvNameList);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        // クリックリスナーをセット
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {

        Intent intent = new Intent(
                this.getApplicationContext(), SubActivity.class);

        // clickされたpositionのtextとphotoのID
        String selectedText = CsvList.get(position);
        // インテントにセット
        intent.putExtra("Text", selectedText);

        // SubActivityへ遷移
        startActivity(intent);
    }

}