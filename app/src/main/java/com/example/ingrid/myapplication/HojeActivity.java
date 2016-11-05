package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ingrid.myapplication.banco.SuperTela;

public class HojeActivity extends SuperTela {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_hoje);
        super.onCreate(savedInstanceState);
    }
}
