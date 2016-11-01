package com.example.ingrid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the entrar button */
    public void entrar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);

    }

}
