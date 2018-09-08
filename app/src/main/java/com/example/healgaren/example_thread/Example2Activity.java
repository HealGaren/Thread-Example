package com.example.healgaren.example_thread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Example2Activity extends AppCompatActivity {

    ImageView shuffleImg;
    Button pauseBtn, restartBtn;

    Handler handler = new Handler();

    final static int STATUS_LOOP = 1;
    final static int STATUS_PAUSE = 2;

    int loopStatus = STATUS_LOOP;

    Runnable onChangeToNextImage = new Runnable() {
        @Override
        public void run() {
            currentImageIndex++;
            if (currentImageIndex >= SHUFFLE_IMAGE_RESOURCE_ARRAY.length) currentImageIndex = 0;
            shuffleImg.setImageResource(SHUFFLE_IMAGE_RESOURCE_ARRAY[currentImageIndex]);
            postNextImage();
        }
    };

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

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loopStatus == STATUS_LOOP) pauseImageShuffle();
                else
                    Toast.makeText(Example2Activity.this, "이미 중지되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loopStatus == STATUS_PAUSE) startLoopNextImage();
                else
                    Toast.makeText(Example2Activity.this, "이미 시작되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        startLoopNextImage();
    }

    private void startLoopNextImage() {
        postNextImage();
        loopStatus = STATUS_LOOP;
    }

    private void postNextImage() {
        handler.postDelayed(onChangeToNextImage, 100);
    }

    private void pauseImageShuffle() {
        handler.removeCallbacks(onChangeToNextImage);
        loopStatus = STATUS_PAUSE;
    }
}
