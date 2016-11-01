package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PeriodicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodico);

        Intent intent = getIntent();
    }

    public void recorrente(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RecorrenteActivity.class);
        startActivity(intent);

    }
    public void unico(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, UnicoActivity.class);
        startActivity(intent);

    }

    public void salvar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }

    public void cancelar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }
}