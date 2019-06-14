package com.example.stopwatch;

import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import java.lang.reflect.Type;

public class Stopwatch extends AppCompatActivity {

    Chronometer mchronometer;
    long timewhenstopped = 0;
    ImageView anchor;
    Animation animasi, animasi2;
    Button start, pause, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        mchronometer = findViewById(R.id.timer);
        anchor = findViewById(R.id.penunjuk);
        start = findViewById(R.id.start);
        pause = findViewById(R.id.pause);
        reset = findViewById(R.id.reset);

        //ilang button
        pause.setAlpha(0);
        reset.setAlpha(0);

        //load animasi
        animasi = AnimationUtils.loadAnimation(this, R.anim.berputar);
        animasi2 = AnimationUtils.loadAnimation(this, R.anim.pelanmuter);

        //font
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"font/MMedium.ttf");

        //tempel font
        start.setTypeface(MMedium);
        pause.setTypeface(MMedium);
        reset.setTypeface(MMedium);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anchor.startAnimation(animasi);
                start.animate().alpha(1).translationY(140).setDuration(750).start();
                pause.animate().alpha(1).setDuration(300).start();
                reset.animate().alpha(1).setDuration(300).start();
                mchronometer.setBase(SystemClock.elapsedRealtime() + timewhenstopped);
                mchronometer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anchor.startAnimation(animasi2);
                timewhenstopped = mchronometer.getBase() - SystemClock.elapsedRealtime();
                mchronometer.stop();
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anchor.startAnimation(animasi2);
                mchronometer.setBase(SystemClock.elapsedRealtime());
                timewhenstopped = 0;
            }
        });
    }

}
