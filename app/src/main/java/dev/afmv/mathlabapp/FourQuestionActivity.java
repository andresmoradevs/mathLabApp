package dev.afmv.mathlabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class FourQuestionActivity extends AppCompatActivity {

    MediaPlayer playerWin, playerLose;
    LottieAnimationView animLose, animWin;
    TextView tvSelectAnswer;
    Animation scaleUp, scaleDown;
    Button btn44, btn62, btn42, btnNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_question);

        btnNextPage = findViewById(R.id.btn_nextPage);
        btn44 = findViewById(R.id.btn44);
        btn62 = findViewById(R.id.btn62);
        btn42 = findViewById(R.id.btn42);

        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up_answer_animation);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down_answer_animation);

        tvSelectAnswer = findViewById(R.id.tv_select_answer4);
        animWin = findViewById(R.id.animation_win);
        animLose = findViewById(R.id.animation_lose);

        playerLose = MediaPlayer.create(getApplicationContext(),R.raw.oh_no);
        playerWin = MediaPlayer.create(getApplicationContext(),R.raw.win_sound);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //onBack.start();
                Intent intent = new Intent(getApplicationContext(),FourQuestionActivity.class);
                startActivity(intent);

            }
        };

        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FiveQuestionActivity.class);
                startActivity(intent);
            }
        });

        btn44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setVisibility(View.VISIBLE);
                animLose.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();
            }
        });

        btn62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSelectAnswer.setVisibility(View.VISIBLE);
                animLose.setVisibility(View.VISIBLE);
                playerLose.start();
                runnable.run();
            }
        });

        btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animWin.setVisibility(View.VISIBLE);
                btnNextPage.setVisibility(View.VISIBLE);
                playerWin.start();
                btn62.setVisibility(View.INVISIBLE);
                btn44.setVisibility(View.INVISIBLE);
            }
        });


    }
}