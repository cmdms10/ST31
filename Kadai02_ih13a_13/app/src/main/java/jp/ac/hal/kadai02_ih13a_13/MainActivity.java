package jp.ac.hal.kadai02_ih13a_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    //アプリの起動時に実行されるメソッド
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //使う部品を紐づける（インスタンス化）
        //身長・体重の入寮欄（EditText）
        final EditText etHieght = findViewById(R.id.hValue);
        final EditText etWeight = findViewById(R.id.wValue);

        //計算ボタン（Button）
        Button btCalc = findViewById(R.id.calculate);

        //計算結果の標示欄（TextView）
        final TextView tvResult = findViewById(R.id.resultText);
        final TextView tvJustWeight = findViewById(R.id.justWeight);
        final TextView tvobesity = findViewById(R.id.obesity);

        //クリックイベントの取得
        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //クリック時の処理を記述する
                //入力された身長・体重を取得する
                String Heightstr = etHieght.getText().toString();
                //取得した文字列を数値（float）に変換
                float height = Float.parseFloat(Heightstr);

                String weightstr = etWeight.getText().toString();
                float weight = Float.parseFloat(weightstr);

                //BMI
                Float resultBmi = weight / (height/100 * height/100);

                //適正体重
                Float justWeight = (height/100) * (height/100) * 22;

                //肥満度
                if(resultBmi < 18.5) {
                    tvobesity.setText("低体重");
                }else if (resultBmi < 25) {
                    tvobesity.setText("普通体重");
                }else if(resultBmi < 30) {
                    tvobesity.setText("肥満（1度）");
                }else if(resultBmi < 35) {
                    tvobesity.setText("肥満（2度）");
                }else if(resultBmi < 40) {
                    tvobesity.setText("肥満（3度）");
                }else if(resultBmi > 40) {
                    tvobesity.setText("肥満（4度）");
                }



                //例）結果標示欄のメッセージを変える
//                tvResult.setText("エラー");
                tvResult.setText(String.format("BMI:"+"%.1f",resultBmi));
                //適正体重教示
                tvJustWeight.setText(String.format("適正体重:"+"%.1f",justWeight));












            }
        });


    }
}
