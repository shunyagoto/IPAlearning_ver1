package com.example.agoto.IPAlearning;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class boinActivity extends AppCompatActivity {

    //背景画像
    private ImageView view;
/*    //各種ボタン
    private Button ibutton;
    private Button ybutton;
    private Button bisect_ibutton;
    private Button bisect_ubutton;
    private Button invert_mbutton;
    private Button ubutton;
    private Button Ibutton;
    private Button Ybutton;
    private Button Latin_Upsilonbutton;
    private Button ebutton;
    private Button slashed_obutton;
    private Button mirror_ebutton;
    private Button bisect_obutton;
    private Button gammabutton;
    private Button obutton;
    private Button invert_ebutton;
    private Button likely_epsilonbutton;
    private Button oebutton;
    private Button mirror_epsilonbutton;
    private Button landscape_heartbutton;
    private Button invert_vbutton;
    private Button mirror_cbutton;
    private Button aebutton;
    private Button invert_abutton;
    private Button abutton;
    private Button OEbutton;
    private Button italic_abutton;
    private Button invert_italic_abutton;*/

    //画面ピンチ処理の定義
    private float scale = 1f;
    private ScaleGestureDetector detector;
    private boolean stateOnScale = false; //拡大縮小とスライドの同時処理を回避するフラグ

    //画面操作のリスナー
    private View.OnTouchListener ontouchlistener;

    //画面スライド処理の定義
    int currentX;   //Viewの左辺座標：X軸
    int currentY;   //Viewの上辺座標：Y軸

    private static final int elementCount = 27; //要素数

    int[] currentButtonX = new int[elementCount];   //Buttonの左辺座標：X軸
    int[] currentButtonY = new int[elementCount];   //Buttonの上辺座標：Y軸
    int[] currentWidth = new int[elementCount];   //Buttonの幅
    int[] currentHeight = new int[elementCount];  //Buttonの高さ

    Button[] bList = new Button[elementCount];

    int offsetX;    //画面タッチ位置の座標：X軸
    int offsetY;    //画面タッチ位置の座標：Y軸

    int number=0;

    //初期位置
    int base_vX; //Viewの左辺座標：X軸
    int base_vY; //Viewの上辺座標：Y軸
    int base_bX; //Buttonの左辺座標：X軸
    int base_bY; //Buttonの上辺座標：Y軸

    //音声再生の定義
    MediaPlayer mMediaPlayer;
    boolean flag = false; //音声再生中か判断するためのフラグ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boin);

        //画面構成要素のID取得
        view =(ImageView) findViewById(R.id.boin);

        bList[0] =(Button) findViewById(R.id.button_i);
        bList[1] =(Button) findViewById(R.id.button_y);
        bList[2] =(Button) findViewById(R.id.bisect_i);
        bList[3] =(Button) findViewById(R.id.bisect_u);
        bList[4] =(Button) findViewById(R.id.invert_m);
        bList[5] =(Button) findViewById(R.id.button_u);
        bList[6] =(Button) findViewById(R.id.button_I);
        bList[7] =(Button) findViewById(R.id.button_Y);
        bList[8] =(Button) findViewById(R.id.Latin_Upsilon);
        bList[9] =(Button) findViewById(R.id.button_e);
        bList[10] =(Button) findViewById(R.id.slashed_o);
        bList[11] =(Button) findViewById(R.id.mirror_e);
        bList[12] =(Button) findViewById(R.id.bisect_o);
        bList[13] =(Button) findViewById(R.id.gamma);
        bList[14] =(Button) findViewById(R.id.button_o);
        bList[15] =(Button) findViewById(R.id.invert_e);
        bList[16] =(Button) findViewById(R.id.likely_epsilon);
        bList[17] =(Button) findViewById(R.id.button_oe);
        bList[18] =(Button) findViewById(R.id.mirror_epsilon);
        bList[19] =(Button) findViewById(R.id.landscape_heart);
        bList[20] =(Button) findViewById(R.id.invert_v);
        bList[21] =(Button) findViewById(R.id.mirror_c);
        bList[22] =(Button) findViewById(R.id.button_ae);
        bList[23] =(Button) findViewById(R.id.invert_a);
        bList[24] =(Button) findViewById(R.id.button_a);
        bList[25] =(Button) findViewById(R.id.OE);
        bList[26] =(Button) findViewById(R.id.italic_a);
        bList[27] =(Button) findViewById(R.id.invert_italic_a);

        //画面ピンチ処理の定義
        detector = new ScaleGestureDetector(this,new ScaleListener());

        //リスナーの設定
        view.setOnTouchListener(ontouchlistener);

        //初期位置の獲得 ※佐藤追加
        base_vX = view.getLeft();
        base_vY = view.getTop();
        //base_bX = button.getLeft();
        //base_bY = button.getTop();

    }

    //画面にタッチされた時の処理
    public boolean onTouchEvent(MotionEvent event) {
        //re-route the Touch Events to the ScaleListener class
        detector.onTouchEvent(event); //拡大縮小処理の呼び出し
        onTouch(view, event);  //スライド処理の呼び出し
        return super.onTouchEvent(event);
    }

    //図の移動の処理
    public boolean onTouch(View view,MotionEvent event) {
        if (stateOnScale == true) {      //ピンチインアウト処理をおこなっている時
            return true;                  //スライド処理をしない
        } else {                           //ピンチインアウト処理をおこなっていない時スライド処理開始
            int touching_x = (int) event.getRawX();//タッチしている所のx座標
            int touching_y = (int) event.getRawY();//タッチしている所のy座標
            switch (event.getAction()) {
                //画面にタッチしたとき
                case MotionEvent.ACTION_DOWN:
                        //x,yセット
                        currentX = view.getLeft();//画像の左側の辺の座標（x座標）
                        currentY = view.getTop();//画像の側の辺の座標（y座標）
                    for (int number = 0; number < bList.length; number++) {   //すべてのボタンに対して
                        currentButtonX[number]=bList[number].getLeft(); //ボタンのx座標
                        currentButtonY[number]=bList[number].getTop(); //ボタンのy座標
                        currentWidth[number]=bList[number].getWidth(); //ボタンの幅
                        currentHeight[number]=bList[number].getHeight(); //ボタンの高さ
                    }
                        offsetX = touching_x;
                        offsetY = touching_y;
                    break;
                //画面から指を離さずにスライドしたとき
                case MotionEvent.ACTION_MOVE:
                        int diffX = offsetX - touching_x;//指の移動した分のx距離
                        int diffY = offsetY - touching_y;//指の移動した分のy距離

                        currentX -= diffX;//指を移動した分だけ画像のx座標を移動
                        currentY -= diffY;//指を移動した分だけ画像のy座標を移動
                    //画像の移動
                    view.layout(currentX, currentY, currentX + view.getWidth(),
                            currentY + view.getHeight());

                    for (number = 0; number <= bList.length; number++) { //すべてのボタンに対して移動を行う
                        currentButtonX[number] -= diffX;//指を移動した分だけボタンのx座標を移動
                        currentButtonY[number] -= diffY;//指を移動した分だけボタンのy座標を移動
                        //ボタンの移動
                        bList[number].layout(currentButtonX[number], currentButtonY[number],currentButtonX[number] + currentWidth[number],
                                currentButtonY[number] + currentHeight[number]);
                    }
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
            bList[0].setScaleX(scale);
            bList[0].setScaleY(scale);
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector detector){
            stateOnScale=false; //ピンチインアウト処理の終了
        }
    }

    //音声再生処理開始
    public void oniButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.i);
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
