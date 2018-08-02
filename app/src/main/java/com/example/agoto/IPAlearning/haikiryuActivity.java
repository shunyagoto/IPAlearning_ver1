package com.example.agoto.IPAlearning;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class haikiryuActivity extends AppCompatActivity{
    //背景画像
    private ImageView iView;
    //各種ボタン
    private Button pButton;
    private Button bButton;
    private Button tButton;
    private Button dButton;
    private Button hook_tButton;
    private Button tail_dButton;
    private Button cButton;
    private Button invert_fButton;
    private Button kButton;
    private Button gButton;
    private Button qButton;
    private Button GButton;
    private Button questionButton;
    private Button mButton;
    private Button hook_mButton;
    private Button nButton;
    private Button righthook_nButton;
    private Button lefthook_nButton;
    private Button righthung_nButton;
    private Button NButton;
    private Button BButton;
    private Button rButton;
    private Button RButton;
    private Button flap_vButton;
    private Button flap_rButton;
    private Button hook_rButton;
    private Button phiButton;
    private Button betaButton;
    private Button fButton;
    private Button vButton;
    private Button thetaButton;
    private Button thButton;
    private Button sButton;
    private Button zButton;
    private Button eshButton;
    private Button ezhButton;
    private Button hook_sButton;
    private Button hook_zButton;
    private Button cedilla_cButton;
    private Button rounded_jButton;
    private Button xButton;
    private Button rounded_yButton;
    private Button XButton;
    private Button invert_RButton;
    private Button DiracButton;
    private Button mirror_questionButton;
    private Button hButton;
    private Button hanged_hButton;
    private Button hook_vButton;
    private Button invert_rButton;
    private Button inverthook_rButton;
    private Button jButton;
    private Button invert_mButton;
    private Button round_iButton;
    private Button I3Button;
    private Button lButton;
    private Button hook_lButton;
    private Button invert_yButton;
    private Button LButton;

    //画面ピンチ処理の定義
    private float scale = 1f;
    private ScaleGestureDetector detector;
    private boolean stateOnScale = false; //拡大縮小とスライドの同時処理を回避するフラグ

    //画面操作のリスナー
    private View.OnTouchListener ontouchlistener;

    //画面スライド処理の定義
    int currentX;   //Viewの左辺座標：X軸
    int currentY;   //Viewの上辺座標：Y軸

    int currentpX;   //Buttonの左辺座標：X軸
    int currentpY;   //Buttonの上辺座標：Y軸
    int currentbX;   //Buttonの左辺座標：X軸
    int currentbY;   //Buttonの上辺座標：Y軸
    int currenttX;   //Buttonの左辺座標：X軸
    int currenttY;   //Buttonの上辺座標：Y軸
    int currentdX;   //Buttonの左辺座標：X軸
    int currentdY;   //Buttonの上辺座標：Y軸
    int currenthook_tX;   //Buttonの左辺座標：X軸
    int currenthook_tY;   //Buttonの上辺座標：Y軸
    int currenttail_dX;   //Buttonの左辺座標：X軸
    int currenttail_dY;   //Buttonの上辺座標：Y軸
    int currentcX;   //Buttonの左辺座標：X軸
    int currentcY;   //Buttonの上辺座標：Y軸
    int currentinvert_fX;   //Buttonの左辺座標：X軸
    int currentinvert_fY;   //Buttonの上辺座標：Y軸
    int currentkX;   //Buttonの左辺座標：X軸
    int currentkY;   //Buttonの上辺座標：Y軸
    int currentgX;   //Buttonの左辺座標：X軸
    int currentgY;   //Buttonの上辺座標：Y軸
    int currentqX;   //Buttonの左辺座標：X軸
    int currentqY;   //Buttonの上辺座標：Y軸
    int currentGX;   //Buttonの左辺座標：X軸
    int currentGY;   //Buttonの上辺座標：Y軸
    int currentquestionX;   //Buttonの左辺座標：X軸
    int currentquestionY;   //Buttonの上辺座標：Y軸
    int currentmX;   //Buttonの左辺座標：X軸
    int currentmY;   //Buttonの上辺座標：Y軸
    int currenthook_mX;   //Buttonの左辺座標：X軸
    int currenthook_mY;   //Buttonの上辺座標：Y軸
    int currentnX;   //Buttonの左辺座標：X軸
    int currentnY;   //Buttonの上辺座標：Y軸
    int currentrighthook_nX;   //Buttonの左辺座標：X軸
    int currentrighthook_nY;   //Buttonの左辺座標：Y軸
    int currentlefthook_nX;   //Buttonの左辺座標：X軸
    int currentlefthook_nY;   //Buttonの上辺座標：Y軸
    int currentrighthung_nX;   //Buttonの左辺座標：X軸
    int currentrighthung_nY;   //Buttonの上辺座標：Y軸
    int currentNX;   //Buttonの左辺座標：X軸
    int currentNY;   //Buttonの上辺座標：Y軸
    int currentBX;   //Buttonの左辺座標：X軸
    int currentBY;   //Buttonの上辺座標：Y軸
    int currentrX;   //Buttonの左辺座標：X軸
    int currentrY;   //Buttonの上辺座標：Y軸
    int currentRX;   //Buttonの左辺座標：X軸
    int currentRY;   //Buttonの上辺座標：Y軸
    int currentflap_vX;   //Buttonの左辺座標：X軸
    int currentflap_vY;   //Buttonの上辺座標：Y軸
    int currentflap_rX;   //Buttonの左辺座標：X軸
    int currentflap_rY;   //Buttonの上辺座標：Y軸
    int currenthook_rX;   //Buttonの左辺座標：X軸
    int currenthook_rY;   //Buttonの上辺座標：Y軸
    int currentphiX;   //Buttonの左辺座標：X軸
    int currentphiY;   //Buttonの上辺座標：Y軸
    int currentbetaX;   //Buttonの左辺座標：X軸
    int currentbetaY;   //Buttonの上辺座標：Y軸
    int currentfX;   //Buttonの左辺座標：X軸
    int currentfY;   //Buttonの上辺座標：Y軸
    int currentvX;   //Buttonの左辺座標：X軸
    int currentvY;   //Buttonの上辺座標：Y軸
    int currentthetaX;   //Buttonの左辺座標：X軸
    int currentthetaY;   //Buttonの上辺座標：Y軸
    int currentthX;   //Buttonの左辺座標：X軸
    int currentthY;   //Buttonの上辺座標：Y軸
    int currentsX;   //Buttonの左辺座標：X軸
    int currentsY;   //Buttonの上辺座標：Y軸
    int currentzX;   //Buttonの左辺座標：X軸
    int currentzY;   //Buttonの上辺座標：Y軸
    int currenteshX;   //Buttonの左辺座標：X軸
    int currenteshY;   //Buttonの上辺座標：Y軸
    int currentezhX;   //Buttonの左辺座標：X軸
    int currentezhY;   //Buttonの上辺座標：Y軸
    int currenthook_sX;   //Buttonの左辺座標：X軸
    int currenthook_sY;   //Buttonの上辺座標：Y軸
    int currenthook_zX;   //Buttonの左辺座標：X軸
    int currenthook_zY;   //Buttonの上辺座標：Y軸
    int currentcedilla_cX;   //Buttonの左辺座標：X軸
    int currentcedilla_cY;   //Buttonの上辺座標：Y軸
    int currentrounded_jX;   //Buttonの左辺座標：X軸
    int currentrounded_jY;   //Buttonの上辺座標：Y軸
    int currentxX;   //Buttonの左辺座標：X軸
    int currentxY;   //Buttonの上辺座標：Y軸
    int currentrounded_yX;   //Buttonの左辺座標：X軸
    int currentrounded_yY;   //Buttonの上辺座標：Y軸
    int currentXX;   //Buttonの左辺座標：X軸
    int currentXY;   //Buttonの上辺座標：Y軸
    int currentinvert_RX;   //Buttonの左辺座標：X軸
    int currentinvert_RY;   //Buttonの上辺座標：Y軸
    int currentDiracX;   //Buttonの左辺座標：X軸
    int currentDiracY;   //Buttonの上辺座標：Y軸
    int currentmirror_questionX;   //Buttonの左辺座標：X軸
    int currentmirror_questionY;   //Buttonの上辺座標：Y軸
    int currenthX;   //Buttonの左辺座標：X軸
    int currenthY;   //Buttonの上辺座標：Y軸
    int currenthanged_hX;   //Buttonの左辺座標：X軸
    int currenthanged_hY;   //Buttonの上辺座標：Y軸
    int currenthook_vX;   //Buttonの左辺座標：X軸
    int currenthook_vY;   //Buttonの上辺座標：Y軸
    int currentinvert_rX;   //Buttonの左辺座標：X軸
    int currentinvert_rY;   //Buttonの上辺座標：Y軸
    int currentinverthook_rX;   //Buttonの左辺座標：X軸
    int currentinverthook_rY;   //Buttonの上辺座標：Y軸
    int currentjX;   //Buttonの左辺座標：X軸
    int currentjY;   //Buttonの上辺座標：Y軸
    int currentinvert_mX;   //Buttonの左辺座標：X軸
    int currentinvert_mY;   //Buttonの上辺座標：Y軸
    int currentround_iX;   //Buttonの左辺座標：X軸
    int currentround_iY;   //Buttonの上辺座標：Y軸
    int currentI3X;   //Buttonの左辺座標：X軸
    int currentI3Y;   //Buttonの上辺座標：Y軸
    int currentlX;   //Buttonの左辺座標：X軸
    int currentlY;   //Buttonの上辺座標：Y軸
    int currenthook_lX;   //Buttonの左辺座標：X軸
    int currenthook_lY;   //Buttonの上辺座標：Y軸
    int currentinvert_yX;   //Buttonの左辺座標：X軸
    int currentinvert_yY;   //Buttonの上辺座標：Y軸
    int currentLX;   //Buttonの左辺座標：X軸
    int currentLY;   //Buttonの上辺座標：Y軸

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
        setContentView(R.layout.activity_haikiryu);

        //画面構成要素のID取得
        iView =(ImageView) findViewById(R.id.haikiryu);
        pButton =(Button) findViewById(R.id.p);
        bButton =(Button) findViewById(R.id.b);
        tButton =(Button) findViewById(R.id.t);
        dButton =(Button) findViewById(R.id.d);
        hook_tButton =(Button) findViewById(R.id.hook_t);
        tail_dButton =(Button) findViewById(R.id.tail_d);
        cButton =(Button) findViewById(R.id.c);
        invert_fButton =(Button) findViewById(R.id.invert_f);
        kButton =(Button) findViewById(R.id.k);
        gButton =(Button) findViewById(R.id.g);
        qButton =(Button) findViewById(R.id.q);
        GButton =(Button) findViewById(R.id.G);
        questionButton =(Button) findViewById(R.id.question);
        mButton =(Button) findViewById(R.id.m);
        hook_mButton =(Button) findViewById(R.id.hook_m);
        nButton =(Button) findViewById(R.id.n);
        righthook_nButton =(Button) findViewById(R.id.righthook_n);
        lefthook_nButton =(Button) findViewById(R.id.lefthook_n);
        righthung_nButton =(Button) findViewById(R.id.righthung_n);
        NButton =(Button) findViewById(R.id.N);
        BButton =(Button) findViewById(R.id.B);
        rButton =(Button) findViewById(R.id.r);
        RButton =(Button) findViewById(R.id.buttonR);
        flap_vButton =(Button) findViewById(R.id.flap_v);
        flap_rButton =(Button) findViewById(R.id.flap_r);
        hook_rButton =(Button) findViewById(R.id.hook_r);
        phiButton =(Button) findViewById(R.id.phi);
        betaButton =(Button) findViewById(R.id.beta);
        fButton =(Button) findViewById(R.id.f);
        vButton =(Button) findViewById(R.id.v);
        thetaButton =(Button) findViewById(R.id.theta);
        thButton =(Button) findViewById(R.id.th);
        sButton =(Button) findViewById(R.id.s);
        zButton =(Button) findViewById(R.id.z);
        eshButton =(Button) findViewById(R.id.esh);
        ezhButton =(Button) findViewById(R.id.ezh);
        hook_sButton =(Button) findViewById(R.id.hook_s);
        hook_zButton =(Button) findViewById(R.id.hook_z);
        cedilla_cButton =(Button) findViewById(R.id.cedilla_c);
        rounded_jButton =(Button) findViewById(R.id.rounded_j);
        xButton =(Button) findViewById(R.id.x);
        rounded_yButton =(Button) findViewById(R.id.rounded_y);
        XButton =(Button) findViewById(R.id.X);
        invert_RButton =(Button) findViewById(R.id.invert_R);
        DiracButton =(Button) findViewById(R.id.Dirac);
        mirror_questionButton =(Button) findViewById(R.id.mirror_question);
        hButton =(Button) findViewById(R.id.h);
        hanged_hButton =(Button) findViewById(R.id.hanged_h);
        hook_vButton =(Button) findViewById(R.id.hook_v);
        invert_rButton =(Button) findViewById(R.id.invert_r);
        inverthook_rButton =(Button) findViewById(R.id.inverthook_r);
        jButton =(Button) findViewById(R.id.j);
        invert_mButton =(Button) findViewById(R.id.invert_m);
        round_iButton =(Button) findViewById(R.id.round_i);
        I3Button =(Button) findViewById(R.id.I3);
        lButton =(Button) findViewById(R.id.l);
        hook_lButton =(Button) findViewById(R.id.hook_l);
        invert_yButton =(Button) findViewById(R.id.invert_y);
        LButton =(Button) findViewById(R.id.L);

        //画面ピンチ処理の定義
        detector = new ScaleGestureDetector(this,new ScaleListener());

        //リスナーの設定
        iView.setOnTouchListener(ontouchlistener);

        //初期位置の獲得 ※佐藤追加
        base_vX = iView.getLeft();
        base_vY = iView.getTop();
        base_pX = pButton.getLeft();
        base_pY = pButton.getTop();
    }

    //図の移動の処理
    public boolean onTouch(View V,MotionEvent event) {
        if(stateOnScale==true){                  //ピンチインアウト処理をおこなっている時
            return true;                 //スライド処理をしない
        }else {                           //ピンチインアウト処理をおこなっていない時スライド処理開始
            int touching_x = (int) event.getRawX();//タッチしている所のx座標
            int touching_y = (int) event.getRawY();//タッチしている所のy座標
            Button p = pButton;
            Button b = bButton;
            Button t = tButton;
            Button d = dButton;
            Button hook_t = hook_tButton;
            Button tail_d = tail_dButton;
            Button c = cButton;
            Button invert_f = invert_fButton;
            Button k = kButton;
            Button g = gButton;
            Button q = qButton;
            Button G = GButton;
            Button question = questionButton;
            Button m = mButton;
            Button hook_m = hook_mButton;
            Button n = nButton;
            Button righthook_n = righthook_nButton;
            Button lefthook_n = lefthook_nButton;
            Button righthung_n = righthung_nButton;
            Button N = NButton;
            Button B = BButton;
            Button r = rButton;
            Button buttonR = RButton;
            Button flap_v = flap_vButton;
            Button flap_r = flap_rButton;
            Button hook_r = hook_rButton;
            Button phi = phiButton;
            Button beta = betaButton;
            Button f = fButton;
            Button v = vButton;
            Button theta = thetaButton;
            Button th = thButton;
            Button s = sButton;
            Button z = zButton;
            Button esh = eshButton;
            Button ezh = ezhButton;
            Button hook_s = hook_sButton;
            Button hook_z = hook_zButton;
            Button cedilla_c = cedilla_cButton;
            Button rounded_j = rounded_jButton;
            Button x = xButton;
            Button rounded_y = rounded_yButton;
            Button X = XButton;
            Button invert_R = invert_RButton;
            Button Dirac = DiracButton;
            Button mirror_question = mirror_questionButton;
            Button h = hButton;
            Button hanged_h = hanged_hButton;
            Button hook_v = hook_vButton;
            Button invert_r = invert_rButton;
            Button inverthook_r = inverthook_rButton;
            Button j = jButton;
            Button invert_m = invert_mButton;
            Button round_i = round_iButton;
            Button I3 = I3Button;
            Button buttonl = lButton;
            Button hook_l = hook_lButton;
            Button invert_y = invert_yButton;
            Button L = LButton;

            switch (event.getAction()) {
                //画面にタッチしたとき
                case MotionEvent.ACTION_DOWN:
                    //x,yセット
                    currentX = V.getLeft();//画像の左側の辺の座標（x座標）
                    currentY = V.getTop();//画像の側の辺の座標（y座標）
                    currentpX = p.getLeft();
                    currentpY = p.getTop();
                    currentbX = b.getLeft();
                    currentbY = b.getTop();
                    currenttX = t.getLeft();
                    currenttY = t.getTop();
                    currentdX = d.getLeft();
                    currentdY = d.getTop();
                    currenthook_tX = hook_t.getLeft();
                    currenthook_tY = hook_t.getTop();
                    currenttail_dX = tail_d.getLeft();
                    currenttail_dY = tail_d.getTop();
                    currentcX = c.getLeft();
                    currentcY = c.getTop();
                    currentinvert_fX = invert_f.getLeft();
                    currentinvert_fY = invert_f.getTop();
                    currentkX = k.getLeft();
                    currentkY = k.getTop();
                    currentgX = g.getLeft();
                    currentgY = g.getTop();
                    currentqX = q.getLeft();
                    currentqY = q.getTop();
                    currentGX = G.getLeft();
                    currentGY = G.getTop();
                    currentquestionX = question.getLeft();
                    currentquestionY = question.getTop();
                    currentmX = m.getLeft();
                    currentmY = m.getTop();
                    currenthook_mX = hook_m.getLeft();
                    currenthook_mY = hook_m.getTop();
                    currentnX = n.getLeft();
                    currentnY = n.getTop();
                    currentrighthook_nX = righthook_n.getLeft();
                    currentrighthook_nY = righthook_n.getTop();
                    currentlefthook_nX = lefthook_n.getLeft();
                    currentlefthook_nY = lefthook_n.getTop();
                    currentrighthung_nX = righthung_n.getLeft();
                    currentrighthung_nY = righthung_n.getTop();
                    currentNX = N.getLeft();
                    currentNY = N.getTop();
                    currentBX = B.getLeft();
                    currentBY = B.getTop();
                    currentrX = r.getLeft();
                    currentrY = r.getTop();
                    currentRX = buttonR.getLeft();
                    currentRY = buttonR.getTop();
                    currentflap_vX = flap_v.getLeft();
                    currentflap_vY = flap_v.getTop();
                    currentflap_rX = flap_r.getLeft();
                    currentflap_rY = flap_r.getTop();
                    currenthook_rX = hook_r.getLeft();
                    currenthook_rY = hook_r.getTop();
                    currentphiX = phi.getLeft();
                    currentphiY = phi.getTop();
                    currentbetaX = beta.getLeft();
                    currentbetaY = beta.getTop();
                    currentfX = f.getLeft();
                    currentfY = f.getTop();
                    currentvX = v.getLeft();
                    currentvY = v.getTop();
                    currentthetaX = theta.getLeft();
                    currentthetaY = theta.getTop();
                    currentthX = th.getLeft();
                    currentthY = th.getTop();
                    currentsX = s.getLeft();
                    currentsY = s.getTop();
                    currentzX = z.getLeft();
                    currentzY = z.getTop();
                    currenteshX = esh.getLeft();
                    currenteshY = esh.getTop();
                    currentezhX = ezh.getLeft();
                    currentezhY = ezh.getTop();
                    currenthook_sX = hook_s.getLeft();
                    currenthook_sY = hook_s.getTop();
                    currenthook_zX = hook_z.getLeft();
                    currenthook_zY = hook_z.getTop();
                    currentcedilla_cX = cedilla_c.getLeft();
                    currentcedilla_cY = cedilla_c.getTop();
                    currentrounded_jX = rounded_j.getLeft();
                    currentrounded_jY = rounded_j.getTop();
                    currentxX = x.getLeft();
                    currentxY = x.getTop();
                    currentrounded_yX = rounded_y.getLeft();
                    currentrounded_yY = rounded_y.getTop();
                    currentXX = X.getLeft();
                    currentXY = X.getTop();
                    currentinvert_RX = invert_R.getLeft();
                    currentinvert_RY = invert_R.getTop();
                    currentDiracX = Dirac.getLeft();
                    currentDiracY = Dirac.getTop();
                    currentmirror_questionX = mirror_question.getLeft();
                    currentmirror_questionY = mirror_question.getTop();
                    currenthX = h.getLeft();
                    currenthY = h.getTop();
                    currenthanged_hX = hanged_h.getLeft();
                    currenthanged_hY = hanged_h.getTop();
                    currenthook_vX = hook_v.getLeft();
                    currenthook_vY = hook_v.getTop();
                    currentinvert_rX = invert_r.getLeft();
                    currentinvert_rY = invert_r.getTop();
                    currentinverthook_rX = inverthook_r.getLeft();
                    currentinverthook_rY = inverthook_r.getTop();
                    currentjX = j.getLeft();
                    currentjY = j.getTop();
                    currentinvert_mX = invert_m.getLeft();
                    currentinvert_mY = invert_m.getTop();
                    currentround_iX = round_i.getLeft();
                    currentround_iY = round_i.getTop();
                    currentI3X = I3.getLeft();
                    currentI3Y = I3.getTop();
                    currentlX = buttonl.getLeft();
                    currentlY = buttonl.getTop();
                    currenthook_lX = hook_l.getLeft();
                    currenthook_lY = hook_l.getTop();
                    currentinvert_yX = invert_y.getLeft();
                    currentinvert_yY = invert_y.getTop();
                    currentLX = L.getLeft();
                    currentLY = L.getTop();

                    offsetX = touching_x;
                    offsetY = touching_y;
                    break;
                //画面から指を離さずにスライドしたとき
                case MotionEvent.ACTION_MOVE:
                    int diffX = offsetX - touching_x;//指の移動した分のx距離
                    int diffY = offsetY - touching_y;//指の移動した分のy距離

                    currentX -= diffX;//指を移動した分だけ画像のx座標を移動
                    currentY -= diffY;//指を移動した分だけ画像のy座標を移動
                    currentpX -= diffX;
                    currentpY -= diffY;
                    currentbX -= diffX;
                    currentbY -= diffY;
                    currenttX -= diffX;
                    currenttY -= diffY;
                    currentdX -= diffX;
                    currentdY -= diffY;
                    currenthook_tX -= diffX;
                    currenthook_tY -= diffY;
                    currenttail_dX -= diffX;
                    currenttail_dY -= diffY;
                    currentcX -= diffX;
                    currentcY -= diffY;
                    currentinvert_fX -= diffX;
                    currentinvert_fY -= diffY;
                    currentkX -= diffX;
                    currentkY -= diffY;
                    currentgX -= diffX;
                    currentgY -= diffY;
                    currentqX -= diffX;
                    currentqY -= diffY;
                    currentGX -= diffX;
                    currentGY -= diffY;
                    currentquestionX -= diffX;
                    currentquestionY -= diffY;
                    currentmX -= diffX;
                    currentmY -= diffY;
                    currenthook_mX -= diffX;
                    currenthook_mY -= diffY;
                    currentnX -= diffX;
                    currentnY -= diffY;
                    currentrighthook_nX -= diffX;
                    currentrighthook_nY -= diffY;
                    currentlefthook_nX -= diffX;
                    currentlefthook_nY -= diffY;
                    currentrighthung_nX -= diffX;
                    currentrighthung_nY -= diffY;
                    currentNX -= diffX;
                    currentNY -= diffY;
                    currentBX -= diffX;
                    currentBY -= diffY;
                    currentrX -= diffX;
                    currentrY -= diffY;
                    currentRX -= diffX;
                    currentRY -= diffY;
                    currentflap_vX -= diffX;
                    currentflap_vY -= diffY;
                    currentflap_rX -= diffX;
                    currentflap_rY -= diffY;
                    currenthook_rX -= diffX;
                    currenthook_rY -= diffY;
                    currentphiX -= diffX;
                    currentphiY -= diffY;
                    currentbetaX -= diffX;
                    currentbetaY -= diffY;
                    currentfX -= diffX;
                    currentfY -= diffY;
                    currentvX -= diffX;
                    currentvY -= diffY;
                    currentthetaX -= diffX;
                    currentthetaY -= diffY;
                    currentthX -= diffX;
                    currentthY -= diffY;
                    currentsX -= diffX;
                    currentsY -= diffY;
                    currentzX -= diffX;
                    currentzY -= diffY;
                    currenteshX -= diffX;
                    currenteshY -= diffY;
                    currentezhX -= diffX;
                    currentezhY -= diffY;
                    currenthook_sX -= diffX;
                    currenthook_sY -= diffY;
                    currenthook_zX -= diffX;
                    currenthook_zY -= diffY;
                    currentcedilla_cX -= diffX;
                    currentcedilla_cY -= diffY;
                    currentrounded_jX -= diffX;
                    currentrounded_jY -= diffY;
                    currentxX -= diffX;
                    currentxY -= diffY;
                    currentrounded_yX -= diffX;
                    currentrounded_yY -= diffY;
                    currentXX -= diffX;
                    currentXY -= diffY;
                    currentinvert_RX -= diffX;
                    currentinvert_RY -= diffY;
                    currentDiracX -= diffX;
                    currentDiracY -= diffY;
                    currentmirror_questionX -= diffX;
                    currentmirror_questionY -= diffY;
                    currenthX -= diffX;
                    currenthY -= diffY;
                    currenthanged_hX -= diffX;
                    currenthanged_hY -= diffY;
                    currenthook_vX -= diffX;
                    currenthook_vY -= diffY;
                    currentinvert_rX -= diffX;
                    currentinvert_rY -= diffY;
                    currentinverthook_rX -= diffX;
                    currentinverthook_rY -= diffY;
                    currentjX -= diffX;
                    currentjY -= diffY;
                    currentinvert_mX -= diffX;
                    currentinvert_mY -= diffY;
                    currentround_iX -= diffX;
                    currentround_iY -= diffY;
                    currentI3X -= diffX;
                    currentI3Y -= diffY;
                    currentlX -= diffX;
                    currentlY -= diffY;
                    currenthook_lX -= diffX;
                    currenthook_lY -= diffY;
                    currentinvert_yX -= diffX;
                    currentinvert_yY -= diffY;
                    currentLX -= diffX;
                    currentLY -= diffY;

                    //画像の移動
                    V.layout(currentX, currentY, currentX + V.getWidth(),
                            currentY + V.getHeight());
                    p.layout(currentpX, currentpY, currentpX + p.getWidth(),
                            currentpY + p.getHeight());
                    b.layout(currentbX, currentbY, currentbX + b.getWidth(),
                            currentbY + b.getHeight());
                    t.layout(currenttX, currenttY, currenttX + t.getWidth(),
                            currenttY + t.getHeight());
                    d.layout(currentdX, currentdY, currentdX + d.getWidth(),
                            currentdY + d.getHeight());
                    hook_t.layout(currenthook_tX, currenthook_tY, currenthook_tX + hook_t.getWidth(),
                            currenthook_tY + hook_t.getHeight());
                    tail_d.layout(currenttail_dX, currenttail_dY, currenttail_dX + tail_d.getWidth(),
                            currenttail_dY + tail_d.getHeight());
                    c.layout(currentcX, currentcY, currentcX + c.getWidth(),
                            currentdY + c.getHeight());
                    invert_f.layout(currentinvert_fX, currentinvert_fY, currentinvert_fX + invert_f.getWidth(),
                            currentinvert_fY + invert_f.getHeight());
                    k.layout(currentkX, currentkY, currentkX + k.getWidth(),
                            currentkY + k.getHeight());
                    g.layout(currentgX, currentgY, currentgX + g.getWidth(),
                            currentgY + g.getHeight());
                    q.layout(currentqX, currentqY, currentqX + q.getWidth(),
                            currentqY + q.getHeight());
                    G.layout(currentGX, currentGY, currentGX + G.getWidth(),
                            currentGY + G.getHeight());
                    question.layout(currentquestionX, currentquestionY, currentquestionX + question.getWidth(),
                            currentquestionY + question.getHeight());
                    m.layout(currentmX, currentmY, currentmX + m.getWidth(),
                            currentmY + m.getHeight());
                    hook_m.layout(currenthook_mX, currenthook_mY, currenthook_mX + hook_m.getWidth(),
                            currenthook_mY + hook_m.getHeight());
                    n.layout(currentnX, currentnY, currentnX + n.getWidth(),
                            currentnY + n.getHeight());
                    righthook_n.layout(currentrighthook_nX, currentrighthook_nY, currentrighthook_nX + righthook_n.getWidth(),
                            currentrighthook_nY + righthook_n.getHeight());
                    lefthook_n.layout(currentlefthook_nX, currentlefthook_nY, currentlefthook_nX + lefthook_n.getWidth(),
                            currentlefthook_nY + lefthook_n.getHeight());
                    righthung_n.layout(currentrighthung_nX, currentrighthung_nY, currentrighthung_nX + righthung_n.getWidth(),
                            currentrighthung_nY + righthung_n.getHeight());
                    N.layout(currentNX, currentNY, currentNX + N.getWidth(),
                        currentNY + N.getHeight());
                    B.layout(currentBX, currentBY, currentBX + B.getWidth(),
                            currentBY + B.getHeight());
                    r.layout(currentrX, currentrY, currentrX + r.getWidth(),
                            currentrY + r.getHeight());
                    buttonR.layout(currentRX, currentRY, currentRX + buttonR.getWidth(),
                            currentRY + buttonR.getHeight());
                    flap_v.layout(currentflap_vX, currentflap_vY, currentflap_vX + flap_v.getWidth(),
                            currentflap_vY + flap_v.getHeight());
                    flap_r.layout(currentflap_rX, currentflap_rY, currentflap_rX + flap_r.getWidth(),
                            currentflap_rY + flap_r.getHeight());
                    hook_r.layout(currenthook_rX, currenthook_rY, currenthook_rX + hook_r.getWidth(),
                            currenthook_rY + hook_r.getHeight());
                    phi.layout(currentphiX, currentphiY, currentphiX + phi.getWidth(),
                            currentphiY + phi.getHeight());
                    beta.layout(currentbetaX, currentbetaY, currentbetaX + beta.getWidth(),
                            currentbetaY + beta.getHeight());
                    f.layout(currentfX, currentfY, currentfX + f.getWidth(),
                            currentfY + f.getHeight());
                    v.layout(currentvX, currentvY, currentvX + v.getWidth(),
                            currentvY + v.getHeight());
                    theta.layout(currentthetaX, currentthetaY, currentthetaX + theta.getWidth(),
                            currentthetaY + theta.getHeight());
                    th.layout(currentthX, currentthY, currentthX + th.getWidth(),
                            currentthY + th.getHeight());
                    s.layout(currentsX, currentsY, currentsX + s.getWidth(),
                            currentsY + s.getHeight());
                    z.layout(currentzX, currentzY, currentzX + z.getWidth(),
                        currentzY + z.getHeight());
                    esh.layout(currenteshX, currenteshY, currenteshX + esh.getWidth(),
                            currenteshY + esh.getHeight());
                    ezh.layout(currentezhX, currentezhY, currentezhX + ezh.getWidth(),
                            currentezhY + ezh.getHeight());
                    hook_s.layout(currenthook_sX, currenthook_sY, currenthook_sX + hook_s.getWidth(),
                            currenthook_sY + hook_s.getHeight());
                    hook_z.layout(currenthook_zX, currenthook_zY, currenthook_zX + hook_z.getWidth(),
                            currenthook_zY + hook_z.getHeight());
                    cedilla_c.layout(currentcedilla_cX, currentcedilla_cY, currentcedilla_cX + cedilla_c.getWidth(),
                        currentcedilla_cY + cedilla_c.getHeight());
                    rounded_j.layout(currentrounded_jX, currentrounded_jY, currentrounded_jX + rounded_j.getWidth(),
                            currentrounded_jY + rounded_j.getHeight());
                    x.layout(currentxX, currentxY, currentxX + x.getWidth(),
                    currentxY + x.getHeight());
                    rounded_y.layout(currentrounded_yX, currentrounded_yY, currentrounded_yX + rounded_y.getWidth(),
                            currentrounded_yY + rounded_y.getHeight());
                    X.layout(currentXX, currentXY, currentXX + X.getWidth(),
                            currentXY + X.getHeight());
                    invert_R.layout(currentinvert_RX, currentinvert_RY, currentinvert_RX + invert_R.getWidth(),
                            currentinvert_RY + invert_R.getHeight());
                    Dirac.layout(currentDiracX, currentDiracY, currentDiracX + Dirac.getWidth(),
                            currentDiracY + Dirac.getHeight());
                    mirror_question.layout(currentmirror_questionX, currentmirror_questionY, currentmirror_questionX + mirror_question.getWidth(),
                            currentmirror_questionY + mirror_question.getHeight());
                    h.layout(currenthX, currenthY, currenthX + h.getWidth(),
                            currenthY + h.getHeight());
                    hanged_h.layout(currenthanged_hX, currenthanged_hY, currenthanged_hX + hanged_h.getWidth(),
                            currenthanged_hY + hanged_h.getHeight());
                    hook_v.layout(currenthook_vX, currenthook_vY, currenthook_vX + hook_v.getWidth(),
                            currenthook_vY + hook_v.getHeight());
                    invert_r.layout(currentinvert_rX, currentinvert_rY, currentinvert_rX + invert_r.getWidth(),
                            currentinvert_rY + invert_r.getHeight());
                    inverthook_r.layout(currentinverthook_rX, currentinverthook_rY, currentinverthook_rX + inverthook_r.getWidth(),
                            currentinverthook_rY + inverthook_r.getHeight());
                    j.layout(currentjX, currentjY, currentjX + j.getWidth(),
                            currentjY + j.getHeight());
                    invert_m.layout(currentinvert_mX, currentinvert_mY, currentinvert_mX + invert_m.getWidth(),
                                    currentinvert_mY + invert_m.getHeight());
                    round_i.layout(currentround_iX, currentround_iY, currentround_iX + round_i.getWidth(),
                            currentround_iY + round_i.getHeight());
                    I3.layout(currentI3X, currentI3Y, currentI3X + I3.getWidth(),
                            currentI3Y + I3.getHeight());
                    buttonl.layout(currentlX, currentlY, currentlX + buttonl.getWidth(),
                            currentlY + buttonl.getHeight());
                    hook_l.layout(currenthook_lX, currenthook_lY, currenthook_lX + hook_l.getWidth(),
                            currenthook_lY + hook_l.getHeight());
                    invert_y.layout(currentinvert_yX, currentinvert_yY, currentinvert_yX + invert_y.getWidth(),
                            currentinvert_yY + invert_y.getHeight());
                    L.layout(currentLX, currentLY, currentLX + L.getWidth(),
                            currentLY + L.getHeight());


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

    //画面にタッチされた時の処理
    public boolean onTouchEvent(MotionEvent event) {
        //re-route the Touch Events to the ScaleListener class
        detector.onTouchEvent(event); //拡大縮小処理の呼び出し
        onTouch(iView,event);  //スライド処理の呼び出し
        return super.onTouchEvent(event);
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
            iView.setScaleX(scale);
            iView.setScaleY(scale);
            pButton.setScaleX(scale);
            pButton.setScaleY(scale);
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector detector){
            stateOnScale=false; //ピンチインアウト処理の終了
        }
    }

    //音声再生処理開始
    public void onpButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.p);
        voicestart(mMediaPlayer);
    }

    public void onbButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.b);
        voicestart(mMediaPlayer);
    }

    public void ontButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.t);
        voicestart(mMediaPlayer);
    }

    public void ondButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.d);
        voicestart(mMediaPlayer);
    }

    public void onhook_tButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.hook_t);
        voicestart(mMediaPlayer);
    }

    public void ontail_dButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.tail_d);
        voicestart(mMediaPlayer);
    }

    public void oncButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.c);
        voicestart(mMediaPlayer);
    }

    public void oninvert_fButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.invert_f);
        voicestart(mMediaPlayer);
    }

    public void onkButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.k);
        voicestart(mMediaPlayer);
    }

    public void ongButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.g);
        voicestart(mMediaPlayer);
    }

    public void onqButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.q);
        voicestart(mMediaPlayer);
    }

    public void onGButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.G);
        voicestart(mMediaPlayer);
    }

    public void onquestionButtonTapped(View view) {
        flag = true;
        mMediaPlayer = MediaPlayer.create(this, R.raw.question);
        voicestart(mMediaPlayer);
    }

    public void onmButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.m);
        voicestart(mMediaPlayer);
    }

    public void onhook_mButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.hook_m);
        voicestart(mMediaPlayer);
    }

    public void onnButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.n);
        voicestart(mMediaPlayer);
    }

    public void onrighthook_nButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.righthook_n);
        voicestart(mMediaPlayer);
    }

    public void onlefthook_nButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.lefthook_n);
        voicestart(mMediaPlayer);
    }

    public void onrighthung_nButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.righthung_n);
        voicestart(mMediaPlayer);
    }

    public void onNButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.N);
        voicestart(mMediaPlayer);
    }

    public void onBButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.B);
        voicestart(mMediaPlayer);
    }

    public void onrButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.r);
        voicestart(mMediaPlayer);
    }

    public void onRButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.R;
        voicestart(mMediaPlayer);
    }


    public void onflap_vButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.flap_v);
        voicestart(mMediaPlayer);
    }

    public void onflap_rButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.flap_r);
        voicestart(mMediaPlayer);
    }

    public void onhook_rButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.hook_r);
        voicestart(mMediaPlayer);
    }

    public void onphiButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.phi);
        voicestart(mMediaPlayer);
    }

    public void onbetaButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.beta);
        voicestart(mMediaPlayer);
    }

    public void onfButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.f);
        voicestart(mMediaPlayer);
    }

    public void onvButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.v);
        voicestart(mMediaPlayer);
    }

    public void onthetaButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.theta);
        voicestart(mMediaPlayer);
    }

    public void onthButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.th);
        voicestart(mMediaPlayer);
    }

    public void onsButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.s);
        voicestart(mMediaPlayer);
    }

    public void onzButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.z);
        voicestart(mMediaPlayer);
    }

    public void oneshButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.esh);
        voicestart(mMediaPlayer);
    }

    public void onezhButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.ezh);
        voicestart(mMediaPlayer);
    }

    public void onhook_sButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.hook_s);
        voicestart(mMediaPlayer);
    }

    public void onhook_zButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.hook_z);
        voicestart(mMediaPlayer);
    }

    public void oncedilla_cButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.cedilla_c);
        voicestart(mMediaPlayer);
    }

    public void onrounded_jButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.rounded_j);
        voicestart(mMediaPlayer);
    }

    public void onxButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.x);
        voicestart(mMediaPlayer);
    }

    public void onrounded_yButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.rounded_y);
        voicestart(mMediaPlayer);
    }

    public void onXButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.X);
        voicestart(mMediaPlayer);
    }

    public void oninvert_RButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.invert_R);
        voicestart(mMediaPlayer);
    }

    public void onDiracButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.Dirac);
        voicestart(mMediaPlayer);
    }

    public void onmirror_questionButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.mirror_question);
        voicestart(mMediaPlayer);
    }

    public void onhButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.h);
        voicestart(mMediaPlayer);
    }

    public void onhanged_hButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.hanged_h);
        voicestart(mMediaPlayer);
    }

    public void onhook_vButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.hook_v);
        voicestart(mMediaPlayer);
    }

    public void oninvert_rButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.invert_r);
        voicestart(mMediaPlayer);
    }

    public void oninverthook_rButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.inverthook_r);
        voicestart(mMediaPlayer);
    }

    public void onjButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.j);
        voicestart(mMediaPlayer);
    }

    public void oninvert_mButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.invert_m);
        voicestart(mMediaPlayer);
    }

    public void onround_iButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.round_i);
        voicestart(mMediaPlayer);
    }

    public void onI3ButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.I3);
        voicestart(mMediaPlayer);
    }

    public void onlButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.l);
        voicestart(mMediaPlayer);
    }

    public void onhook_lButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.hook_l);
        voicestart(mMediaPlayer);
    }

    public void oninvert_yButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.invert_y);
        voicestart(mMediaPlayer);
    }

    public void onLButtonTapped(View view) {
        flag = true;
        //mMediaPlayer = MediaPlayer.create(this, R.raw.L);
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