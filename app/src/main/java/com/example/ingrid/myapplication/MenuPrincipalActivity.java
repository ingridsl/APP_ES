package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void inserir(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TipoActivity.class);
        startActivity(intent);

    }

    public void calendario(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, CalendarioActivity.class);
        startActivity(intent);
    }

    public void hoje(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, HojeActivity.class);
        startActivity(intent);

    }

    public void tudo(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TudoActivity.class);
        startActivity(intent);

    }

    public void estatistica(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, EstatisticaActivity.class);
        startActivity(intent);

    }
<<<<<<< HEAD
    public void conf(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Conf.class);
=======

    public void conf(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ConfActivity.class);
>>>>>>> 9fdd85c8ea3db4fa84e23a56f0ad61824c0d25e1
        startActivity(intent);
    }

}
