package com.example.agoto.IPAlearning;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WebSiteActivity extends AppCompatActivity {

    String eigonokai_name = "①国際音声記号とは？ - 英語の会";
    String multilingirl_name = "②国際音声記号 (IPA) を覚えると、英語やフランス語、どんな言語の発音も簡単になる理由";
    String eigobiyori_name = "③国際音声記号って何? どんな言語の発音でもできるようになる地図です";
    String wikipedia_name = "④国際音声記号 - Wikipedia";

    Calendar cal_start = Calendar.getInstance();//アプリ開始時刻のCalendarクラスの取得
    Calendar cal_finish = Calendar.getInstance();//アプリ終了時刻のCalendarクラスの取得
    Calendar cal_midnight = Calendar.getInstance();//23:59:59の時間を格納するためのCalendar変数
    Date starttime = new Date();//アプリ開始時刻のDateクラスの取得
    Date midnight = new Date();//23:59:59の時間を格納するためのDate変数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_site);
        TextView eigonokai = (TextView)findViewById(R.id.eigonokai);
        eigonokai.setText(eigonokai_name);
        TextView multilingirl = (TextView)findViewById(R.id.textView2);
        multilingirl.setText(multilingirl_name);
        TextView eigobiyori = (TextView)findViewById(R.id.textView3);
        eigobiyori.setText(eigobiyori_name);
        TextView wikipedia = (TextView)findViewById(R.id.textView4);
        wikipedia.setText(wikipedia_name);
    }

    public void CSVFileWriter(Date starttime,Date fintime) {
        try {
            // Date型の日時をCalendar型に変換
            cal_start.setTime(starttime);
            cal_finish.setTime(fintime);
            //CalendarクラスではMONTHは0月～11月であるから、1を足す
            int month = cal_start.get(Calendar.MONTH)+1;

            // アプリ使用状況ファイル(Application Usages Status File)の作成
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");//Date型の日時のフォーマットを作成

            FileWriter f = new FileWriter(Environment.getExternalStorageDirectory().getPath() + "/" + cal_start.get(Calendar.YEAR) + "." + month + "." + cal_start.get(Calendar.DATE) + "AUS.csv", true);//trueでファイルの最後に書き込み
            PrintWriter p = new PrintWriter(new BufferedWriter(f));

            String aus = String.valueOf(cal_start.get(Calendar.YEAR) + "." + month + "." + cal_start.get(Calendar.DATE));
            File ecf = new File("/storage/sdcard/"+aus+"AUS.csv");//ファイルのパスを格納

            //日にちをまたいで学習したときの処理
            if(cal_start.get(Calendar.YEAR)!=cal_finish.get(Calendar.YEAR) || cal_start.get(Calendar.MONTH)!=cal_finish.get(Calendar.MONTH) || cal_start.get(Calendar.DATE)!=cal_finish.get(Calendar.DATE)){
                cal_midnight.set(cal_start.get(Calendar.YEAR),cal_start.get(Calendar.MONTH),cal_start.get(Calendar.DATE),23,59,59);
                midnight = cal_midnight.getTime();//Calendar型からDate型
                p.print(sdf.format(starttime));//アプリ起動時間をプリント
                p.print(",");
                p.print(sdf.format(midnight));//アプリ終了時間(23:59:59)をプリント
                p.print(",");
                //アプリ使用状況の計算
                long usetime = cal_midnight.getTimeInMillis() - cal_start.getTimeInMillis();//ミリ秒単位でアプリ使用時間を算出
                long hourtime;//時間
                long minutetime;//分
                long secondtime;//秒
                usetime = usetime / 1000;//ミリ秒から秒に変換
                if(usetime >= 3600){
                    hourtime = usetime / 3600;//時間単位に変換
                    p.print((int)(hourtime)+"時間");
                    usetime = usetime - (int)hourtime * 3600;
                }
                if(usetime >= 60){
                    minutetime = usetime / 60;//分単位に変換
                    p.print((int)minutetime+"分");
                    usetime = usetime - (int)minutetime * 60;
                }
                if(usetime < 60){
                    secondtime = usetime;//秒単位に変換
                    p.print(secondtime+"秒");
                }
                p.print(",");
                p.print("webサイト選択画面");
                p.println();
                p.close();
                cal_start.set(cal_finish.get(Calendar.YEAR),cal_finish.get(Calendar.MONTH),cal_finish.get(Calendar.DATE),0,0,0);
                starttime = cal_start.getTime();//Calendar型からDate型
                CSVFileWriter(starttime,fintime);//再帰
            }

            if(ecf.exists()){//ファイルが存在することを確認
                FileReader filereader = new FileReader(ecf);//FileReaderクラスのオブジェクトを生成する
                int data;
                data = filereader.read();//ファイルの先頭の文字を読み込む
                String firstword =String.valueOf((char)data);//型変換
                if(firstword.equals("ア")){
                }else {
                    p.print("アプリ起動時間");
                    p.print(",");
                    p.print("アプリ終了時間");
                    p.print(",");
                    p.print("アプリ使用時間");
                    p.print(",");
                    p.print("画面名");
                    p.println();
                }
            }

            p.print(sdf.format(starttime));//アプリ起動時間をプリント
            p.print(",");
            p.print(sdf.format(fintime));//アプリ終了時間をプリント
            p.print(",");

            //アプリ使用状況の計算
            long usetime = cal_finish.getTimeInMillis() - cal_start.getTimeInMillis();//ミリ秒単位でアプリ使用時間を算出
            long hourtime;//時間
            long minutetime;//分
            long secondtime;//秒
            usetime = usetime / 1000;//ミリ秒から秒に変換
            if(usetime >= 3600){
                hourtime = usetime / 3600;//時間単位に変換
                p.print((int)(hourtime)+"時間");
                usetime = usetime - (int)hourtime * 3600;
            }
            if(usetime >= 60){
                minutetime = usetime / 60;//分単位に変換
                p.print((int)minutetime+"分");
                usetime = usetime - (int)minutetime * 60;
            }
            if(usetime < 60){
                secondtime = usetime;//秒単位に変換
                p.print(secondtime+"秒");
            }
            p.print(",");
            p.print("webサイト選択画面");
            p.println();
            // ファイルに書き出し閉じる
            p.close();

            System.out.println("ファイル出力完了！");
            Log.d("MainActivity", Environment.getExternalStorageDirectory().getPath());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void onResume() {//activity表示時＆バックグラウンド復帰時処理
        super.onResume();
        starttime = new Date();//バックグラウンド復帰時刻のCalenderクラスの取得
    }

    public void onPause() {//バックグラウンド移動時処理
        super.onPause();
        Date fintime = new Date();//バックグラウンド移動時刻のCalenderクラスの取得
        CSVFileWriter(starttime,fintime);//csvに出力
    }

    public void EigonokaiUrlTapped(View view){
        CountFileWriter(eigonokai_name);
        Uri uri = Uri.parse("https://eigonokai.jp/phonetics/2-%E5%9B%BD%E9%9A%9B%E9%9F%B3%E5%A3%B0%E8%A8%98%E5%8F%B7%E3%81%A8%E3%81%AF%EF%BC%9F/");
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }

    public void MultilingirlUrlTapped(View view){
        CountFileWriter(multilingirl_name);
        Uri uri = Uri.parse("https://www.multilingirl.com/2014/12/blog-post_12.html");
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }

    public void EigobiyoriUrlTapped(View view){
        CountFileWriter(eigobiyori_name);
        Uri uri = Uri.parse("https://ipa-mania.com/international-phonetic-alphabet/");
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }

    public void WikipediaUrlTapped(View view){
        CountFileWriter(wikipedia_name);
        Uri uri = Uri.parse("https://ja.wikipedia.org/wiki/%E5%9B%BD%E9%9A%9B%E9%9F%B3%E5%A3%B0%E8%A8%98%E5%8F%B7");
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }

    public void CountFileWriter(String url_name){
        try {
            int month = cal_start.get(Calendar.MONTH)+1;
            FileWriter f = new FileWriter(Environment.getExternalStorageDirectory().getPath() + "/" + cal_start.get(Calendar.YEAR) + "." + month + "." + cal_start.get(Calendar.DATE) + "Count.csv", true);//trueでファイルの最後に書き込み
            PrintWriter p = new PrintWriter(new BufferedWriter(f));
            p.print(url_name);
            p.println();
            p.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
