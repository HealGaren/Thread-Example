package com.example.healgaren.example_thread;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {

    int[] selectIdArray = new int[]{
            R.id.btn_example1,
            R.id.btn_example2,
            R.id.btn_example3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        for (int i : selectIdArray) {
            findViewById(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Class nextActivityClass = null;
        switch (v.getId()) {
            case R.id.btn_example1:
                nextActivityClass = Example1Activity.class;
                break;
            case R.id.btn_example2:
                nextActivityClass = Example2Activity.class;
                break;
            case R.id.btn_example3:
                nextActivityClass = Example1Activity.class;
                break;
        }
        startActivity(new Intent(this, nextActivityClass));
    }
}
