package com.example.healgaren.example_thread;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Example1Activity extends AppCompatActivity {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh시 mm분 ss초", Locale.KOREA);

    Handler handler = new Handler();
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        text = findViewById(R.id.text);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(simpleDateFormat.format(new Date()));
                    }
                }, 1000);
            }
        });
    }
}
