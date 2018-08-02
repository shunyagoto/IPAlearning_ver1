package com.example.agoto.IPAlearning;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class hihaikiryuActivity extends AppCompatActivity {

    //背景画像
    private ImageView view;
    //各種ボタン
    private Button dot_obutton;
    private Button dental_clickbutton;
    private Button alveolar_clickbutton;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hihaikiryu);

        //画面構成要素のID取得
        view =(ImageView) findViewById(R.id.haikiryu);
        dot_obutton =(Button) findViewById(R.id.dot_o);
        dental_clickbutton =(Button) findViewById(R.id.dental_click);
        alveolar_clickbutton =(Button) findViewById(R.id.alveolar_click);
    }

    //画面にタッチされた時の処理
    public boolean onTouchEvent(MotionEvent event) {
        //re-route the Touch Events to the ScaleListener class
        detector.onTouchEvent(event); //拡大縮小処理の呼び出し
        onTouch(view, event);  //スライド処理の呼び出し
        return super.onTouchEvent(event);
    }

    //図の移動の処理
    public boolean onTouch(View V,MotionEvent event) {
        if (stateOnScale == true) {                  //ピンチインアウト処理をおこなっている時
                return true;                 //スライド処理をしない
            } else {                           //ピンチインアウト処理をおこなっていない時スライド処理開始
                int touching_x = (int) event.getRawX();//タッチしている所のx座標
                int touching_y = (int) event.getRawY();//タッチしている所のy座標
            Button dot_o = dot_obutton;
            Button dental_click = dental_clickbutton;
            Button alveolar_click = alveolar_clickbutton;
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
                        //画像の移動
                        V.layout(currentX, currentY, currentX + V.getWidth(),
                            currentY + V.getHeight());
                        dot_o.layout(currentdot_oX, currentdot_oY, currentdot_oX + dot_o.getWidth(),
                                currentdot_oY + dot_o.getHeight());
                        dental_click.layout(currentdental_clickX, currentdental_clickY, currentdental_clickX + dental_click.getWidth(),
                                currentdot_oY + dental_click.getHeight());
                        alveolar_click.layout(currentalveolar_clickX, currentalveolar_clickY, currentalveolar_clickX + alveolar_click.getWidth(),
                                currentalveolar_clickX + alveolar_click.getHeight());
                        offsetX = touching_x;
                        offsetY = touching_y;
                        break;
                    //画面から指を離したとき
                 case MotionEvent.ACTION_UP:
                     break;
             }
                return true;
            }
        }

    //画面ピンチ処理
    private class ScaleListener
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
    }

    //音声再生処理開始
    public void ondot_oButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.dot_o);
        voicestart(mMediaPlayer);
    }

    public void ondental_clickButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.dental_click);
        voicestart(mMediaPlayer);
    }

    public void onalveolar_clickButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.alveolar_click);
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

}