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
        Intent intent = new Intent(this, TipoActivity.class);
        startActivity(intent);
    }

    public void calendario(View view) {
        Intent intent = new Intent(this, CalendarioActivity.class);
        startActivity(intent);
    }

    public void hoje(View view) {
        Intent intent = new Intent(this, HojeActivity.class);
        startActivity(intent);

    }

    public void tudo(View view) {
        Intent intent = new Intent(this, TudoActivity.class);
        startActivity(intent);

    }

    public void estatistica(View view) {
        Intent intent = new Intent(this, EstatisticaActivity.class);
        startActivity(intent);

    }

    public void conf(View view) {
        Intent intent = new Intent(this, ConfActivity.class);
        startActivity(intent);
    }

}
