package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ingrid.myapplication.banco.*;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class PeriodicoActivity extends AppCompatActivity {


    private EditText editNome;
    private EditText editData;
    private EditText editHoraIni;
    private EditText editHoraFin;
    private EditText editNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodico);


        editNome = (EditText) findViewById(R.id.editNome);
        editData = (EditText) findViewById(R.id.editData);
        editHoraIni = (EditText) findViewById(R.id.editHoraIni);
        editHoraFin = (EditText) findViewById(R.id.editHoraFin);
        editNotas = (EditText) findViewById(R.id.editNotas);

        Intent intent = getIntent();
    }

    public void recorrente(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RecorrenteActivity.class);

        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();

        Periodico periodico = new Periodico();
        periodico.setNome(Nome);
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        periodico.setHoraFinal(formatTime.format(HoraIni));
        periodico.setHoraFinal(formatTime.format(HoraFin));
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        periodico.setData(formatDate.format(Data));
        periodico.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addRecorrente(recorrente);


        startActivity(intent);

    }
    public void unico(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, UnicoActivity.class);

        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();
        startActivity(intent);

    }

    public void salvar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MenuPrincipalActivity.class);

        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();
        startActivity(intent);

    }

    public void cancelar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }
}