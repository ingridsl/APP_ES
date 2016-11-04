package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    private EditText editLogin;
    private EditText editSenha;
    private EditText editConfSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editLogin = (EditText) findViewById(R.id.editLogin);
        editSenha = (EditText) findViewById(R.id.editSenha);
        editConfSenha = (EditText) findViewById(R.id.editConfSenha);
    }
    public void salvar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void cancelar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
