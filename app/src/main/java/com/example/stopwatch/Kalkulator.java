package com.example.stopwatch;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Kalkulator extends AppCompatActivity {

    private double hasilAkhir = 0.0;
    private String angka1 = "";
    private String angka2 = "";
    private TextView hasil;
    private Button btJumlah, btKurang, btKali, btBagi;
    private EditText edAngka1, edAngka2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        edAngka1 = findViewById(R.id.edit1);
        edAngka2 = findViewById(R.id.edit2);
        hasil = findViewById(R.id.hasilnya);
        btJumlah = findViewById(R.id.btplus);
        btKurang = findViewById(R.id.btmin);
        btKali = findViewById(R.id.btperkalian);
        btBagi = findViewById(R.id.btbagi);

        //import font
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"font/MMedium.ttf");

        //pasang font
        btJumlah.setTypeface(MMedium);
        btKurang.setTypeface(MMedium);
        btBagi.setTypeface(MMedium);
        btKali.setTypeface(MMedium);
        hasil.setTypeface(MMedium);
    }

    public void btJumlah(View V){
        angka1 = edAngka1.getText().toString();
        angka2 = edAngka2.getText().toString();

        if (angka1.equalsIgnoreCase("") || (angka2.equalsIgnoreCase(""))){
            edAngka1.setFocusable(true);
        }
        else{
            double angkaA = Double.parseDouble(angka1);
            double angkaB = Double.parseDouble(angka2);
            hasilAkhir = angkaA + angkaB;
            String hasilString = String.valueOf(hasilAkhir);
            hasil.setText(hasilString);
        }
    }

    public void KlikKurang(View V) {
        angka1 = edAngka1.getText().toString();
        angka2 = edAngka2.getText().toString();

        if (angka1.equalsIgnoreCase("") || (angka2.equalsIgnoreCase(""))) {
            edAngka1.setFocusable(true);
        } else {
            double angkaA = Double.parseDouble(angka1);
            double angkaB = Double.parseDouble(angka2);
            hasilAkhir = angkaA - angkaB;
            String hasilString = String.valueOf(hasilAkhir);
            hasil.setText(hasilString);
        }
    }

    public void KlikKali(View V) {
        angka1 = edAngka1.getText().toString();
        angka2 = edAngka2.getText().toString();

        if (angka1.equalsIgnoreCase("") || (angka2.equalsIgnoreCase(""))) {
            edAngka1.setFocusable(true);
        } else {
            double angkaA = Double.parseDouble(angka1);
            double angkaB = Double.parseDouble(angka2);
            hasilAkhir = angkaA * angkaB;
            String hasilString = String.valueOf(hasilAkhir);
            hasil.setText(hasilString);
        }
    }

    public void KlikBagi(View V) {
        angka1 = edAngka1.getText().toString();
        angka2 = edAngka2.getText().toString();

        if (angka1.equalsIgnoreCase("") || (angka2.equalsIgnoreCase(""))) {
            edAngka1.setFocusable(true);
        } else {
            double angkaA = Double.parseDouble(angka1);
            double angkaB = Double.parseDouble(angka2);
            hasilAkhir = angkaA / angkaB;
            String hasilString = String.valueOf(hasilAkhir);
            hasil.setText(hasilString);
        }
    }


}
