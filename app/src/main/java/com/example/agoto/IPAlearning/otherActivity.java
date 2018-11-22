package com.example.agoto.IPAlearning;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class otherActivity extends AppCompatActivity {

    //背景画像
    private ImageView view;
    //各種ボタン
    private Button invert_wbutton;
    private Button wbutton;
    private Button invert_hbutton;
    private Button Hbutton;
    private Button invert_questionbarbutton;
    private Button questionbarbutton;
    private Button roll_cbutton;
    private Button roll_zbutton;
    private Button invert_longrbutton;
    private Button hook_hbutton;
    private Button eshbutton;
    private Button xbutton;

    //画面ピンチ処理の定義
    private float scale = 1f;
    private ScaleGestureDetector detector;
    private boolean stateOnScale = false; //拡大縮小とスライドの同時処理を回避するフラグ

    //画面操作のリスナー
    private View.OnTouchListener ontouchlistener;

    //画面スライド処理の定義
    int currentX;   //Viewの左辺座標：X軸
    int currentY;   //Viewの上辺座標：Y軸

    int currentinvert_wX;   //Buttonの左辺座標：X軸
    int currentinvert_wY;   //Buttonの上辺座標：Y軸
    int currentwX;   //Buttonの左辺座標：X軸
    int currentwY;   //Buttonの上辺座標：Y軸
    int currentinvert_hX;   //Buttonの左辺座標：X軸
    int currentinvert_hY;   //Buttonの上辺座標：Y軸
    int currentHX;   //Buttonの左辺座標：X軸
    int currentHY;   //Buttonの上辺座標：Y軸
    int currentinvert_questionbarX;   //Buttonの左辺座標：X軸
    int currentinvert_questionbarY;   //Buttonの上辺座標：Y軸
    int currentquestionbarX;   //Buttonの左辺座標：X軸
    int currentquestionbarY;   //Buttonの上辺座標：Y軸
    int currentroll_cX;   //Buttonの左辺座標：X軸
    int currentroll_cY;   //Buttonの上辺座標：Y軸
    int currentroll_zX;   //Buttonの左辺座標：X軸
    int currentroll_zY;   //Buttonの上辺座標：Y軸
    int currentinvert_longrX;   //Buttonの左辺座標：X軸
    int currentinvert_longrY;   //Buttonの上辺座標：Y軸
    int currenthook_hX;   //Buttonの左辺座標：X軸
    int currenthook_hY;   //Buttonの上辺座標：Y軸
    int currenteshX;   //Buttonの左辺座標：X軸
    int currenteshY;   //Buttonの上辺座標：Y軸
    int currentxX;   //Buttonの左辺座標：X軸
    int currentxY;   //Buttonの上辺座標：Y軸

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
        setContentView(R.layout.activity_other);

        //画面構成要素のID取得
        view =(ImageView) findViewById(R.id.haikiryu);
        invert_wbutton =(Button) findViewById(R.id.invert_w);
        wbutton =(Button) findViewById(R.id.w);
        invert_hbutton =(Button) findViewById(R.id.invert_h);
        Hbutton =(Button) findViewById(R.id.H);
        invert_questionbarbutton =(Button) findViewById(R.id.invert_questionbar);
        questionbarbutton =(Button) findViewById(R.id.questionbar);
        roll_cbutton =(Button) findViewById(R.id.roll_c);
        roll_zbutton =(Button) findViewById(R.id.roll_z);
        invert_longrbutton =(Button) findViewById(R.id.invert_longr);
        hook_hbutton =(Button) findViewById(R.id.hook_h);
        eshbutton =(Button) findViewById(R.id.esh);
        xbutton =(Button) findViewById(R.id.x);
    }

    //画面にタッチされた時の処理
    public boolean onTouchEvent(MotionEvent event) {
        //re-route the Touch Events to the ScaleListener class
        //detector.onTouchEvent(event); //拡大縮小処理の呼び出し
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
            Button invert_w = invert_wbutton;
            Button w = wbutton;
            Button invert_h = invert_hbutton;
            Button H = Hbutton;
            Button invert_questionbar = invert_questionbarbutton;
            Button questionbar = questionbarbutton;
            Button roll_c = roll_cbutton;
            Button roll_z = roll_zbutton;
            Button invert_longr = invert_longrbutton;
            Button hook_h = hook_hbutton;
            Button esh = eshbutton;
            Button x = xbutton;

            switch (event.getAction()) {
                //画面にタッチしたとき
                case MotionEvent.ACTION_DOWN:
                    //x,yセット
                    currentX = V.getLeft();//画像の左側の辺の座標（x座標）
                    currentY = V.getTop();//画像の側の辺の座標（y座標）

                    currentinvert_wX = invert_w.getLeft();
                    currentinvert_wY = invert_w.getTop();
                    currentwX = w.getLeft();
                    currentwY = w.getTop();
                    currentinvert_hX = invert_h.getLeft();
                    currentinvert_hY = invert_h.getTop();
                    currentHX = H.getLeft();
                    currentHY = H.getTop();
                    currentinvert_questionbarX = invert_questionbar.getLeft();
                    currentinvert_questionbarY = invert_questionbar.getTop();
                    currentquestionbarX = questionbar.getLeft();
                    currentquestionbarY = questionbar.getTop();
                    currentroll_cX = roll_c.getLeft();
                    currentroll_cY = roll_c.getTop();
                    currentroll_zX = roll_z.getLeft();
                    currentroll_zY = roll_z.getTop();
                    currentinvert_longrX = invert_longr.getLeft();
                    currentinvert_longrY = invert_longr.getTop();
                    currenthook_hX = hook_h.getLeft();
                    currenthook_hY = hook_h.getTop();
                    currenteshX = esh.getLeft();
                    currenteshY = esh.getTop();
                    currentxX = x.getLeft();
                    currentxY = x.getTop();

                    offsetX = touching_x;
                    offsetY = touching_y;
                    break;
                //画面から指を離さずにスライドしたとき
                case MotionEvent.ACTION_MOVE:
                    int diffX = offsetX - touching_x;//指の移動した分のx距離
                    int diffY = offsetY - touching_y;//指の移動した分のy距離

                    currentX -= diffX;//指を移動した分だけ画像のx座標を移動
                    currentY -= diffY;//指を移動した分だけ画像のy座標を移動

                    currentinvert_wX -= diffX;
                    currentinvert_wY -= diffY;
                    currentwX -= diffX;
                    currentwY -= diffY;
                    currentinvert_hX -= diffX;
                    currentinvert_hY -= diffY;
                    currentHX -= diffX;
                    currentHY -= diffY;
                    currentinvert_questionbarX -= diffX;
                    currentinvert_questionbarY -= diffY;
                    currentquestionbarX -= diffX;
                    currentquestionbarY -= diffY;
                    currentroll_cX -= diffX;
                    currentroll_cY -= diffY;
                    currentroll_zX -= diffX;
                    currentroll_zY -= diffY;
                    currentinvert_longrX -= diffX;
                    currentinvert_longrY -= diffY;
                    currenthook_hX -= diffX;
                    currenthook_hY -= diffY;
                    currenteshX -= diffX;
                    currenteshY -= diffY;
                    currentxX -= diffX;
                    currentxY -= diffY;

                    //画像の移動
                    V.layout(currentX, currentY, currentX + V.getWidth(),
                            currentY + V.getHeight());
                    invert_w.layout(currentinvert_wX, currentinvert_wY, currentinvert_wX + invert_w.getWidth(),
                            currentinvert_wY + invert_w.getHeight());
                    w.layout(currentwX, currentwY, currentwX + w.getWidth(),
                            currentwY + w.getHeight());
                    invert_h.layout(currentinvert_hX, currentinvert_hY, currentinvert_hX + invert_h.getWidth(),
                            currentinvert_hY + invert_h.getHeight());
                    H.layout(currentHX, currentHY, currentHX + H.getWidth(),
                            currentHY + H.getHeight());
                    invert_questionbar.layout(currentinvert_questionbarX, currentinvert_questionbarY, currentinvert_questionbarX + invert_questionbar.getWidth(),
                            currentinvert_questionbarY + invert_questionbar.getHeight());
                    questionbar.layout(currentquestionbarX, currentquestionbarY, currentquestionbarX + questionbar.getWidth(),
                            currentquestionbarY + questionbar.getHeight());
                    roll_c.layout(currentroll_cX, currentroll_cY, currentroll_cX + roll_c.getWidth(),
                            currentroll_cY + roll_c.getHeight());
                    roll_z.layout(currentroll_zX, currentroll_zY, currentroll_zX + roll_z.getWidth(),
                            currentroll_zY + roll_z.getHeight());
                    invert_longr.layout(currentinvert_longrX, currentinvert_longrY, currentinvert_longrX + invert_longr.getWidth(),
                            currentinvert_longrY + invert_longr.getHeight());
                    hook_h.layout(currenthook_hX, currenthook_hY, currenthook_hX + hook_h.getWidth(),
                            currenthook_hY + hook_h.getHeight());
                    esh.layout(currenteshX, currenteshY, currenteshX + esh.getWidth(),
                            currenteshY + esh.getHeight());
                    x.layout(currentxX, currentxY, currentxX + x.getWidth(),
                            currentxY + x.getHeight());

                    offsetX = touching_x;
                    offsetY = touching_y;
                    break;
                //画面から指を離したとき
                case MotionEvent.ACTION_UP:
                    break;
            }
        }
        return true;
    }

    //画面拡大縮小処理
       /* private class ScaleListener
                extends ScaleGestureDetector.SimpleOnScaleGestureListener {

            public boolean onScaleBegin(ScaleGestureDetector detector) {
                stateOnScale = true; //スライド処理を割り込ませない
                return true;
            }

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                scale *= detector.getScaleFactor();
                view.setScaleX(scale);
                view.setScaleY(scale);
                invert_wbutton.setScaleX(scale);
                invert_wbutton.setScaleY(scale);
                wbutton.setScaleX(scale);
                wbutton.setScaleY(scale);

                return true;
            }

            public void onScaleEnd(ScaleGestureDetector detector) {
                stateOnScale = false; //ピンチインアウト処理の終了
            }
        }*/

    //音声再生処理開始

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

    public void oninvert_wButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.invert_w);
        voicestart(mMediaPlayer);
    }

    public void onwButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.w);
        voicestart(mMediaPlayer);
    }

    public void oninvert_hButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.invert_w);
        voicestart(mMediaPlayer);
    }

    public void onHButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.w);
        voicestart(mMediaPlayer);
    }

    public void oninvert_questionbarButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.invert_questionbar);
        voicestart(mMediaPlayer);
    }

    public void onquestionbarButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.questionbar);
        voicestart(mMediaPlayer);
    }

    public void onroll_cButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.roll_c);
        voicestart(mMediaPlayer);
    }

    public void onroll_zButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.roll_z);
        voicestart(mMediaPlayer);
    }

    public void oninvert_longrButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.invert_longr);
        voicestart(mMediaPlayer);
    }

    public void onhook_hButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.hook_h);
        voicestart(mMediaPlayer);
    }

    public void oneshButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.esh);
        voicestart(mMediaPlayer);
    }

    public void onxButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.x);
        voicestart(mMediaPlayer);
    }
}


