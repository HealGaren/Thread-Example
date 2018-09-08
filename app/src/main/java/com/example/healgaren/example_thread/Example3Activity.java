package com.example.healgaren.example_thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Example3Activity extends AppCompatActivity {

    Button calcBtn;
    TextView calcResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);

        calcBtn = findViewById(R.id.btn_calc);
        calcResultText = findViewById(R.id.text_calc_result);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTask().execute();
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

    class MyTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected void onPreExecute() {
            calcResultText.setText("계산 중...");
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return calcSomethingBoringJob();
        }

        @Override
        protected void onPostExecute(Integer result) {
            calcResultText.setText(String.valueOf(result));
        }
    }

}
