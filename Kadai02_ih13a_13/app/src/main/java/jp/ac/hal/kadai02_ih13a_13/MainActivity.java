package jp.ac.hal.kadai02_ih13a_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    //起動時に実行されるプログラム
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //使う部品を紐づける（インスタンス化）
        //身長・体重の入寮欄（EditText）
        EditText etHieght = findViewById(R.id.hValue);
        EditText etWeight = findViewById(R.id.wValue);

        //計算ボタン（Button）
        Button btCalc = findViewById(R.id.calculate);

        //計算結果の標示欄（TextView）
        final TextView tvResult = findViewById(R.id.resultText);

        //クリックイベントの取得
        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //クリック時の処理を記述する

                //例）結果標示欄のメッセージを変える
                tvResult.setText("エラー");
            }
        });


    }
}
