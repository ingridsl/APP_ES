package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TipoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo);

        Intent intent = getIntent();
    }
    public void periodica(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, PeriodicaActivity.class);
        startActivity(intent);

    }
    public void unica(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, UnicaActivity.class);
        startActivity(intent);

    }
    public void conf(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ConfActivity.class);
        startActivity(intent);

    }
}
