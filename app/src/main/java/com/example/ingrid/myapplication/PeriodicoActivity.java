package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.ingrid.myapplication.banco.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PeriodicoActivity extends SuperTela {

    private EditText editNome;
    private EditText editData;
    private EditText editHoraIni;
    private EditText editHoraFin;
    private EditText editNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_periodico);
        super.onCreate(savedInstanceState);

        editNome = (EditText) findViewById(R.id.editNome);
        editData = (EditText) findViewById(R.id.editData);
        editHoraIni = (EditText) findViewById(R.id.editHoraIni);
        editHoraFin = (EditText) findViewById(R.id.editHoraFin);
        editNotas = (EditText) findViewById(R.id.editNotas);
    }

    public void recorrente(View view) {

        Intent intent = new Intent(this, RecorrenteActivity.class);

        String Nome = editNome.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();

        Periodico periodico = new Periodico();
        periodico.setNome(Nome);

        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraInicial;
        try {
            HoraInicial = formatTime.parse(HoraIni);
        } catch (ParseException e){
            HoraInicial = null;
        }
        periodico.setHoraInicial((java.sql.Time)HoraInicial);
        Date HoraFinal;
        try {
            HoraFinal = formatTime.parse(HoraFin);
        } catch (ParseException e){
            HoraFinal = null;
        }
        periodico.setHoraFinal ((java.sql.Time) HoraFinal);

        periodico.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addPeriodico(periodico);


        startActivity(intent);

    }
    public void unico(View view) {

        Intent intent = new Intent(this, UnicoActivity.class);

        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();

        Periodico periodico = new Periodico();
        periodico.setNome(Nome);

        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraInicial;
        try {
            HoraInicial = formatTime.parse(HoraIni);
        } catch (ParseException e){
            HoraInicial = null;
        }
        periodico.setHoraInicial((java.sql.Time)HoraInicial);
        Date HoraFinal;
        try {
            HoraFinal = formatTime.parse(HoraFin);
        } catch (ParseException e){
            HoraFinal = null;
        }
        periodico.setHoraFinal ((java.sql.Time) HoraFinal);

        periodico.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addPeriodico(periodico);

        startActivity(intent);

    }

    public void salvar(View view) {

        Intent intent = new Intent(this, MenuPrincipalActivity.class);

        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();

        Periodico periodico = new Periodico();
        periodico.setNome(Nome);


        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dataTeste;
        try {
            dataTeste = formatData.parse(Data);
        } catch (ParseException e){
            dataTeste = null;
        }
        //periodico.setData(dataTeste);
        //!!!!!!!!!!!!!!!!!!!!!!!!!!

        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraInicial;
        try {
            HoraInicial = formatTime.parse(HoraIni);
        } catch (ParseException e){
            HoraInicial = null;
        }
        periodico.setHoraInicial((java.sql.Time)HoraInicial);
        Date HoraFinal;
        try {
            HoraFinal = formatTime.parse(HoraFin);
        } catch (ParseException e){
            HoraFinal = null;
        }
        periodico.setHoraFinal ((java.sql.Time) HoraFinal);

        periodico.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addPeriodico(periodico);

        startActivity(intent);

    }

    public void cancelar(View view) {

        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }
}