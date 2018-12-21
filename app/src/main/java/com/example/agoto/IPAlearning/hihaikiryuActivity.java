package com.example.agoto.IPAlearning;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class hihaikiryuActivity extends AppCompatActivity {

    //背景画像
    private ImageView view;
    //各種ボタン
    private Button dot_obutton;
    private Button dental_clickbutton;
    private Button alveolar_clickbutton;
    private Button bisect_equalbutton;
    private Button two_polesbutton;
    private Button hung_bbutton;
    private Button hook_dbutton;
    private Button long_fbutton;
    private Button hung_dbutton;
    private Button comma_Gbutton;

    //画面ピンチ処理の定義
    private float scale = 1f;
    private ScaleGestureDetector detector;
    private boolean stateOnScale = false; //拡大縮小とスライドの同時処理を回避するフラグ

    //画面操作のリスナー
    private View.OnTouchListener ontouchlistener;

    //画面スライド処理の定義
    int currentX;   //Viewの左辺座標：X軸
    int currentY;   //Viewの上辺座標：Y軸

    int currentdot_oX;   //Buttonの左辺座標：X軸
    int currentdot_oY;   //Buttonの上辺座標：Y軸
    int currentdental_clickX;   //Buttonの左辺座標：X軸
    int currentdental_clickY;   //Buttonの上辺座標：Y軸
    int currentalveolar_clickX;   //Buttonの左辺座標：X軸
    int currentalveolar_clickY;   //Buttonの上辺座標：Y軸
    int currentbisect_equalX;   //Buttonの左辺座標：X軸
    int currentbisect_equalY;   //Buttonの上辺座標：Y軸
    int currenttwo_polesX;   //Buttonの左辺座標：X軸
    int currenttwo_polesY;   //Buttonの上辺座標：Y軸
    int currenthung_bX;   //Buttonの左辺座標：X軸
    int currenthung_bY;   //Buttonの上辺座標：Y軸
    int currenthook_dX;   //Buttonの左辺座標：X軸
    int currenthook_dY;   //Buttonの上辺座標：Y軸
    int currentlong_fX;   //Buttonの左辺座標：X軸
    int currentlong_fY;   //Buttonの上辺座標：Y軸
    int currenthung_dX;   //Buttonの左辺座標：X軸
    int currenthung_dY;   //Buttonの上辺座標：Y軸
    int currentcomma_GX;   //Buttonの左辺座標：X軸
    int currentcomma_GY;   //Buttonの上辺座標：Y軸

    int offsetX;    //画面タッチ位置の座標：X軸
    int offsetY;    //画面タッチ位置の座標：Y軸

    //初期位置
    int base_vX; //Viewの左辺座標：X軸
    int base_vY; //Viewの上辺座標：Y軸
    int base_pX; //Buttonの左辺座標：X軸
    int base_pY; //Buttonの上辺座標：Y軸

    //音声再生の定義
    MediaPlayer mMediaPlayer;
    boolean flag = false; //音声再生中か判断するためのフラグ

    Calendar cal_start = Calendar.getInstance();//アプリ開始時刻のCalendarクラスの取得
    Calendar cal_finish = Calendar.getInstance();//アプリ終了時刻のCalendarクラスの取得
    Calendar cal_midnight = Calendar.getInstance();//23:59:59の時間を格納するためのCalendar変数
    Date starttime = new Date();//アプリ開始時刻のDateクラスの取得
    Date midnight = new Date();//23:59:59の時間を格納するためのDate変数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hihaikiryu);

        //画面構成要素のID取得
        view =(ImageView) findViewById(R.id.haikiryu);
        dot_obutton =(Button) findViewById(R.id.dot_o);
        dental_clickbutton =(Button) findViewById(R.id.dental_click);
        alveolar_clickbutton =(Button) findViewById(R.id.alveolar_click);
        bisect_equalbutton=(Button) findViewById(R.id.bisect_equal);
        two_polesbutton =(Button) findViewById(R.id.two_poles);
        hung_bbutton =(Button) findViewById(R.id.hung_b);
        hook_dbutton =(Button) findViewById(R.id.hook_d);
        long_fbutton =(Button) findViewById(R.id.long_f);
        hung_dbutton =(Button) findViewById(R.id.hung_d);
        comma_Gbutton =(Button) findViewById(R.id.comma_G);
    }

    //画面にタッチされた時の処理
    public boolean onTouchEvent(MotionEvent event) {
        //re-route the Touch Events to the ScaleListener class
        //detector.onTouchEvent(event); //拡大縮小処理の呼び出し
        //onTouch(view, event);  //スライド処理の呼び出し
        return super.onTouchEvent(event);
    }

    //図の移動の処理
/*    public boolean onTouch(View V,MotionEvent event) {
        if (stateOnScale == true) {                  //ピンチインアウト処理をおこなっている時
            return true;                 //スライド処理をしない
        } else {                           //ピンチインアウト処理をおこなっていない時スライド処理開始
            int touching_x = (int) event.getRawX();//タッチしている所のx座標
            int touching_y = (int) event.getRawY();//タッチしている所のy座標
            Button dot_o = dot_obutton;
            Button dental_click = dental_clickbutton;
            Button alveolar_click = alveolar_clickbutton;
            Button bisect_equal = bisect_equalbutton;
            Button two_poles = two_polesbutton;
            Button hung_b = hung_bbutton;
            Button hook_d = hook_dbutton;
            Button long_f = long_fbutton;
            Button hung_d = hung_dbutton;
            Button comma_G = comma_Gbutton;

            switch (event.getAction()) {
                //画面にタッチしたとき
                case MotionEvent.ACTION_DOWN:
                    //x,yセット
                    currentX = V.getLeft();//画像の左側の辺の座標（x座標）
                    currentY = V.getTop();//画像の側の辺の座標（y座標）

                    currentdot_oX = dot_o.getLeft();
                    currentdot_oY = dot_o.getTop();
                    currentdental_clickX = dental_click.getLeft();
                    currentdental_clickY = dental_click.getTop();
                    currentalveolar_clickX = alveolar_click.getLeft();
                    currentalveolar_clickY = alveolar_click.getTop();
                    currentbisect_equalX = bisect_equal.getLeft();
                    currentbisect_equalY = bisect_equal.getTop();
                    currenttwo_polesX = two_poles.getLeft();
                    currenttwo_polesY = two_poles.getTop();
                    currenthung_bX = hung_b.getLeft();
                    currenthung_bY = hung_b.getTop();
                    currenthook_dX = hook_d.getLeft();
                    currenthook_dY = hook_d.getTop();
                    currentlong_fX = long_f.getLeft();
                    currentlong_fY = long_f.getTop();
                    currenthung_dX = hung_d.getLeft();
                    currenthung_dY = hung_d.getTop();
                    currentcomma_GX = comma_G.getLeft();
                    currentcomma_GY = comma_G.getTop();

                    offsetX = touching_x;
                    offsetY = touching_y;
                    break;
                //画面から指を離さずにスライドしたとき
                case MotionEvent.ACTION_MOVE:
                    int diffX = offsetX - touching_x;//指の移動した分のx距離
                    int diffY = offsetY - touching_y;//指の移動した分のy距離

                    currentX -= diffX;//指を移動した分だけ画像のx座標を移動
                    currentY -= diffY;//指を移動した分だけ画像のy座標を移動

                    currentdot_oX -= diffX;
                    currentdot_oY -= diffY;
                    currentdental_clickX -= diffX;
                    currentdental_clickY -= diffY;
                    currentalveolar_clickX -= diffX;
                    currentalveolar_clickY -= diffY;
                    currentbisect_equalX -= diffX;
                    currentbisect_equalY-= diffY;
                    currenttwo_polesX -= diffX;
                    currenttwo_polesY -= diffY;
                    currenthung_bX -= diffX;
                    currenthung_bY -= diffY;
                    currenthook_dX -= diffX;
                    currenthook_dY -= diffY;
                    currentlong_fX -= diffX;
                    currentlong_fY -= diffY;
                    currenthung_dX -= diffX;
                    currenthung_dY -= diffY;
                    currentcomma_GX -= diffX;
                    currentcomma_GY -= diffY;

                    //画像の移動
                    V.layout(currentX, currentY, currentX + V.getWidth(),
                            currentY + V.getHeight());
                    dot_o.layout(currentdot_oX, currentdot_oY, currentdot_oX + dot_o.getWidth(),
                            currentdot_oY + dot_o.getHeight());
                    dental_click.layout(currentdental_clickX, currentdental_clickY, currentdental_clickX + dental_click.getWidth(),
                            currentdot_oY + dental_click.getHeight());
                    alveolar_click.layout(currentalveolar_clickX, currentalveolar_clickY, currentalveolar_clickX + alveolar_click.getWidth(),
                            currentalveolar_clickX + alveolar_click.getHeight());
                    bisect_equal.layout(currentbisect_equalX, currentbisect_equalY, currentbisect_equalX + bisect_equal.getWidth(),
                            currentbisect_equalY + bisect_equal.getHeight());
                    two_poles.layout(currenttwo_polesX, currenttwo_polesY, currenttwo_polesX + two_poles.getWidth(),
                            currenttwo_polesY + two_poles.getHeight());
                    hung_b.layout(currenthung_bX, currenthung_bY, currenthung_bX + hung_b.getWidth(),
                            currenthung_bY + hung_b.getHeight());
                    hook_d.layout(currenthook_dX, currenthook_dY, currenthook_dX + hook_d.getWidth(),
                            currenthook_dY + hook_d.getHeight());
                    long_f.layout(currentlong_fX, currentlong_fY, currentlong_fX + long_f.getWidth(),
                            currentlong_fY + long_f.getHeight());
                    hung_d.layout(currenthung_dX, currenthung_dY, currenthung_dX + hung_d.getWidth(),
                            currenthung_dY + hung_d.getHeight());
                    comma_G.layout(currentcomma_GX, currentcomma_GY, currentcomma_GX + comma_G.getWidth(),
                            currentcomma_GY + comma_G.getHeight());

                    offsetX = touching_x;
                    offsetY = touching_y;
                    break;
                //画面から指を離したとき
                case MotionEvent.ACTION_UP:
                    break;
            }
            return true;
        }
    }*/

    //画面ピンチ処理
/*    private class ScaleListener
            extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        public boolean onScaleBegin(ScaleGestureDetector detector){
            stateOnScale=true; //スライド処理を割り込ませない
            return true;
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            view.setScaleX(scale);
            view.setScaleY(scale);
            dot_obutton.setScaleX(scale);
            dot_obutton.setScaleY(scale);
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector detector){
            stateOnScale=false; //ピンチインアウト処理の終了
        }
    }*/

    //音声再生処理開始
    public void ondot_oButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.dot_o);
        voicestart(mMediaPlayer);
    }

    public void ondental_clickButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.dental_click);
        voicestart(mMediaPlayer);
    }

    public void onalveolar_clickButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.alveolar_click);
        voicestart(mMediaPlayer);
    }

    public void onbisect_equalButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.bisect_equal);
        voicestart(mMediaPlayer);
    }

    public void ontwo_polesButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.two_poles);
        voicestart(mMediaPlayer);
    }

    public void onhung_bButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.hung_b);
        voicestart(mMediaPlayer);
    }

    public void onhook_dButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.hook_d);
        voicestart(mMediaPlayer);
    }

    public void onlong_fButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.long_f);
        voicestart(mMediaPlayer);
    }

    public void onhung_dButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.hung_d);
        voicestart(mMediaPlayer);
    }

    public void oncomma_GButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.conma_g);
        voicestart(mMediaPlayer);
    }

    public void voicestart(MediaPlayer mMediaPlayer) {
        this.mMediaPlayer.setLooping(false);
        this.mMediaPlayer.start();//再生開始
        while (flag) {
            if (this.mMediaPlayer.isPlaying()) { //再生中
                flag = true;
            } else {
                this.mMediaPlayer.stop(); //再生停止
                this.mMediaPlayer.reset(); //音声をはじめからに
                this.mMediaPlayer.release(); //メモリの解放
                flag = false; //ループから脱出
            }
        }
    }//音声再生処理終了

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
                p.print("子音（非肺臓気流機構）画面");
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
            p.print("子音（非肺臓気流機構）画面");
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

}