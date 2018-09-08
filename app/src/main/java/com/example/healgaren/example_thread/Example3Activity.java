package com.example.healgaren.example_thread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Example3Activity extends AppCompatActivity {

    Button calcBtn;
    TextView calcResultText;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);

        calcBtn = findViewById(R.id.btn_calc);
        calcResultText = findViewById(R.id.text_calc_result);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcResultText.setText("계산 중...");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final int result = calcSomethingBoringJob();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                calcResultText.setText(String.valueOf(result));
                            }
                        });
                    }
                }).start();

            }
        });


    }

    private static int calcSomethingBoringJob() {
        for(int i=0; i<99999999; i++) {
            double a = Math.random();
            double b = Math.sqrt(a);
        }
        return 3;
    }


}
