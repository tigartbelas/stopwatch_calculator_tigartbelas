package com.example.stopwatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView head, subhead;
    Button btnIn, btnkalk;
    ImageView bgfront;
    Animation faded, bthead, bthead2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        head = findViewById(R.id.textHead);
        subhead = findViewById(R.id.textsubHead);
        btnIn = findViewById(R.id.btnIn);
        bgfront = findViewById(R.id.bgFront);
        btnkalk = findViewById(R.id.btnkal);

        //load animasi disini
        faded = AnimationUtils.loadAnimation(this, R.anim.fade);
        bthead = AnimationUtils.loadAnimation(this, R.anim.bthead);
        bthead2 = AnimationUtils.loadAnimation(this, R.anim.bthead2);

        //pasang animasi disini
        bgfront.startAnimation(faded);
        head.startAnimation(bthead);
        subhead.startAnimation(bthead);
        btnIn.startAnimation(bthead2);
        btnkalk.startAnimation(bthead2);

        //run activity Stopwatch
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Stopwatch.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        //run activity Kalkulator
        btnkalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Kalkulator.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


        //import font disini
        Typeface MLight = Typeface.createFromAsset(getAssets(),"font/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"font/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(),"font/MRegular.ttf");

        //customize font disini
        head.setTypeface(MRegular);
        subhead.setTypeface(MLight);
        btnIn.setTypeface(MMedium);
        btnkalk.setTypeface(MMedium);
    }
}
