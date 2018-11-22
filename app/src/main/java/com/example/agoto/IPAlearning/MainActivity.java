package com.example.agoto.IPAlearning;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Calendar cal_start = Calendar.getInstance();
    Calendar cal_finish = Calendar.getInstance();
    Date starttime = new Date();//アプリ開始時刻のDateクラスの取得

    //アクセス権限の定義
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);//アプリのアクセス権限の許可を問う
    }

    public void onIPAhyouButtonTapped(View view){
        Intent intent = new Intent(this, IPAtableActivity.class);
        startActivity(intent);
    }

    public void CSVFileWriter(Date starttime,Date fintime) {
        try {
            // Date型の日時をCalendar型に変換
            cal_start.setTime(starttime);
            cal_finish.setTime(fintime);
            //CalendarクラスではMONTHは0月～11月であるから、1を足す
            int month = cal_start.get(Calendar.MONTH)+1;

            // アプリ使用状況ファイル(Application Usages Status File)の作成
            File aus = new File("/storage/sdcard/ExistCheckerFile.txt");//ファイルのパスを格納
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");//Date型の日時のフォーマットを作成

            FileWriter f = new FileWriter(Environment.getExternalStorageDirectory().getPath() + "/" + cal_start.get(Calendar.YEAR) + "." + month + "." + cal_start.get(Calendar.DATE) + "AUS.csv", true);//trueでファイルの最後に書き込み
            PrintWriter p = new PrintWriter(new BufferedWriter(f));

            if(aus.exists()==false){//ファイルがすでにないならフィールドをプリント
                p.print("アプリ起動時間");
                p.print(",");
                p.print("アプリ終了時間");
                p.print(",");
                p.print("アプリ使用時間");
                p.println();
            }

            //アプリ使用状況の計算
            long usetime = cal_finish.getTimeInMillis() - cal_start.getTimeInMillis();//ミリ秒単位でアプリ使用時間を算出
            long hourtime;//時間
            long minutetime;//分
            long secondtime;//秒

            p.print(sdf.format(starttime));//アプリ起動時間をプリント
            p.print(",");
            p.print(sdf.format(fintime));//アプリ終了時間をプリント
            p.print(",");
            usetime = usetime / 1000;//ミリ秒から秒に変換
            if(usetime >= 3600){
                hourtime = usetime / 3600;//時間単位に変換
                p.print((int)(hourtime)+"時間");
                usetime = usetime - (int)hourtime;
            }
            if(usetime >= 60){
                minutetime = usetime / 60;//分単位に変換
                p.print((int)minutetime+"分");
                usetime = usetime - (int)minutetime;
            }
            if(usetime < 60){
                secondtime = usetime;//秒単位に変換
                p.print(secondtime+"秒");
            }
            p.println();
            // ファイルに書き出し閉じる
            p.close();

            System.out.println("ファイル出力完了！");
            Log.d("MainActivity",Environment.getExternalStorageDirectory().getPath());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //アプリ使用状況ファイルの存在を確認するファイルの作成
    public void ExistCheckerFileWriter(){
        try {
            FileWriter f = new FileWriter("ExistCheckerFile.txt", true);
            PrintWriter p = new PrintWriter(new BufferedWriter(f));
            p.print("file is exist.");
            p.close();
            Log.d("MainActivity",Environment.getExternalStorageDirectory().getPath());
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void onResume() {//バックグラウンド復帰時処理
        super.onResume();
        starttime = new Date();//バックグラウンド復帰時刻のCalenderクラスの取得
    }

    public void onPause() {//バックグラウンド移動時処理
            super.onPause();
            Date fintime = new Date();//バックグラウンド移動時刻のCalenderクラスの取得
            CSVFileWriter(starttime,fintime);//csvに出力
    }

//アクセス権限の処理
    public static void verifyStoragePermissions(Activity activity) {
// Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}


