package jp.ac.hal.kadai05_ih13a_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    //フィールドの宣言
    ImageView ivE,ivG,ivC,ivP;
    TextView Tv = null,tV = null;
    int m,n,result,dispNum;
    String WL,D="DRAW",W="YOU WIN",L="YOU LOSE",shape,str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //じゃんけん画像のインスタンス化
        ivE = findViewById(R.id.ene);
        ivE.setImageResource(R.drawable.enemy);

        ivG = findViewById(R.id.rock);
        ivG.setImageResource(R.drawable.rock);
        ivC = findViewById(R.id.scissors);
        ivC.setImageResource(R.drawable.scissors);
        ivP = findViewById(R.id.paper);
        ivP.setImageResource(R.drawable.paper);


        this.ivG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m = 0;
                ImageChange();
            }
        });

        this.ivC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m = 1;
                ImageChange();
            }
        });

        this.ivP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m = 2;
                ImageChange();
            }
        });

//        戻る
        Button Ba = findViewById(R.id.back);
        Ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backClick(view);
            }
        });

//        リセット
        Button Re = findViewById(R.id.reset);
        Re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetClick(view);
            }
        });

//        送信
        Button Su = findViewById(R.id.submit);
        Su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitClick(view);
            }
        });
    }

    private void ImageChange() {
        Random r = new Random();
        n = r.nextInt(3);

        switch (n) {
            case 0:
                ivE.setImageResource(R.drawable.rock);
                break;
            case 1:
                ivE.setImageResource(R.drawable.scissors);
                break;
            case 2:
                ivE.setImageResource(R.drawable.paper);
                break;
        }

        if (n == m){
            WL = D;
            result = 0;
        }else{
            if (n == 0){
                switch (m){
                    case 1:
                        WL = L;
                        break;
                    case 2:
                        WL = W;
                        break;
                }
            }else if (n == 1){
                switch (m){
                    case 0:
                        WL = W;
                        break;
                    case 2:
                        WL = L;
                        break;
                }
            }else if (n == 2){
                switch (m){
                    case 0:
                        WL = L;
                        break;
                    case 1:
                        WL = W;
                        break;
                }
            }

            if (WL == W){
                result = 1;
            }else{
                result = 2;
            }
        }

        Toast.makeText(MainActivity.this, WL, Toast.LENGTH_SHORT).show();

        switch (result){
            case 0:
                shape = "△";
                tV = findViewById(R.id.drawNum);
                str = tV.getText().toString();
                dispNum = Integer.parseInt(str);
                dispNum += 1;
                tV.setText(String.valueOf(dispNum));
                break;
            case 1:
                shape = "◯";
                tV = findViewById(R.id.winNum);
                str = tV.getText().toString();
                dispNum = Integer.parseInt(str);
                dispNum += 1;
                tV.setText(String.valueOf(dispNum));
                break;
            case 2:
                shape = "✕";
                tV = findViewById(R.id.loseNum);
                str = tV.getText().toString();
                dispNum = Integer.parseInt(str);
                dispNum += 1;
                tV.setText(String.valueOf(dispNum));
                break;
        }

        Tv = findViewById(R.id.achievement);
        String shapes = Tv.getText().toString();
        Tv.setText(shapes + shape);
    }

    public void backClick(View view){
        ivE.setImageResource(R.drawable.enemy);
    }

//    リッセットボタンの処理
    public void resetClick(View view){
        ivE.setImageResource(R.drawable.enemy);
        TextView ac = findViewById(R.id.achievement);
        TextView dr = findViewById(R.id.drawNum);
        TextView wi = findViewById(R.id.winNum);
        TextView lo = findViewById(R.id.loseNum);
        TextView na = findViewById(R.id.name);
        TextView la = findViewById(R.id.language);
        ac.setText(String.valueOf(""));
        dr.setText(String.valueOf(0));
        wi.setText(String.valueOf(0));
        lo.setText(String.valueOf(0));
        na.setText(String.valueOf(""));
        la.setText(String.valueOf("↑名前を入力"));
    }


    public void submitClick(View view){
        String stri = "";
        TextView su = findViewById(R.id.name);
        TextView la = findViewById(R.id.language);
        stri = su.getText().toString();

        if (stri.length() == 0){
            stri = "名無しの権兵衛";
        }

        TextView wi = findViewById(R.id.winNum);
        TextView lo = findViewById(R.id.loseNum);
        String stri1 = wi.getText().toString();
        int wNum = Integer.parseInt(stri1);
        String stri2 = lo.getText().toString();
        int lNum = Integer.parseInt(stri2);

        if (wNum > lNum){
            la.setText(stri + "さんの勝ちです");
        }else if(wNum < lNum){
            la.setText(stri + "さんの負けです");
        }else{
            la.setText("引き分けです");
        }
    }

}
