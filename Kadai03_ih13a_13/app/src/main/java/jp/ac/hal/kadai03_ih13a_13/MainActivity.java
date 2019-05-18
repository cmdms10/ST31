package jp.ac.hal.kadai03_ih13a_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンのインスタンス化
        Button btn4 = findViewById(R.id.four);
        //ボタンクリック時の操作
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //数字を表示
                TextView tvOut = findViewById(R.id.outputArea);
                tvOut.setText("4");
            }
        });
    }
}
