package com.example.ingrid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editLogin;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = (EditText) findViewById(R.id.editLogin);
        editSenha = (EditText) findViewById(R.id.editSenha);
    }

    public void entrar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }

    public void cadastrar(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);

    }

}
