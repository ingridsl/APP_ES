package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RecorrenteActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editData;
    private EditText editHora;
    private EditText editNotas;
    private EditText editHorasPre;
    private EditText editItensTot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorrente);

        editNome = (EditText) findViewById(R.id.editNome);
        editData = (EditText) findViewById(R.id.editData);
        editHora = (EditText) findViewById(R.id.editHora);
        editNotas = (EditText) findViewById(R.id.editNotas);
        editHorasPre = (EditText) findViewById(R.id.editHorasPre);
        editItensTot = (EditText) findViewById(R.id.editItensTot);


        Intent intent = getIntent();
    }

    public void salvar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MenuPrincipalActivity.class);


        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String Hora = editHora.getText().toString();
        String Notas = editNotas.getText().toString();
        String HorasPre = editHorasPre.getText().toString();
        String ItensTot = editItensTot.getText().toString();
        startActivity(intent);

    }

    public void cancelar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }
}
