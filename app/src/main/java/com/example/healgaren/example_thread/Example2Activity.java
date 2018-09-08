package com.example.healgaren.example_thread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Example2Activity extends AppCompatActivity {

    ImageView shuffleImg;
    Button pauseBtn, restartBtn;

    Handler handler = new Handler();

    int currentImageIndex = 0;

    final static int[] SHUFFLE_IMAGE_RESOURCE_ARRAY = {
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        shuffleImg = findViewById(R.id.img_shuffle);
        pauseBtn = findViewById(R.id.btn_pause);
        restartBtn = findViewById(R.id.btn_restart);

        postNextImage();
    }

    private void postNextImage() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentImageIndex++;
                if (currentImageIndex >= SHUFFLE_IMAGE_RESOURCE_ARRAY.length) currentImageIndex = 0;
                shuffleImg.setImageResource(SHUFFLE_IMAGE_RESOURCE_ARRAY[currentImageIndex]);
                postNextImage();
            }
        }, 100);
    }
}
