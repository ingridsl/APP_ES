package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ingrid.myapplication.banco.*;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class RecorrenteActivity extends SuperTela {

    private EditText editNome;
    private EditText editData;
    private EditText editHora;
    private EditText editNotas;
    private EditText editHorasPre;
    private EditText editItensTot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_recorrente);
        super.onCreate(savedInstanceState);

        editNome = (EditText) findViewById(R.id.editNome);
        editData = (EditText) findViewById(R.id.editData);
        editHora = (EditText) findViewById(R.id.editHora);
        editNotas = (EditText) findViewById(R.id.editNotas);
        editHorasPre = (EditText) findViewById(R.id.editHorasPre);
        editItensTot = (EditText) findViewById(R.id.editItensTot);
    }

    public void salvar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);

        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String Hora = editHora.getText().toString();
        String Notas = editNotas.getText().toString();
        String HorasPre = editHorasPre.getText().toString();
        String ItensTot = editItensTot.getText().toString();

        Recorrente recorrente = new Recorrente();
        recorrente.setNome(Nome);
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraTeste;
        try {
            HoraTeste = formatTime.parse(Hora);
        } catch (ParseException e){
            HoraTeste = null;
        }
        recorrente.setHoraFinal((java.sql.Time)HoraTeste);

        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dataTeste;
        try {
            dataTeste = formatData.parse(Data);
        } catch (ParseException e){
            dataTeste = null;
        }
        recorrente.setDataFinal(dataTeste);

        recorrente.setHorasDia(Integer.parseInt(HorasPre));
        recorrente.setTotalItens(Integer.parseInt(ItensTot));
        recorrente.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addRecorrente(recorrente);
        startActivity(intent);
    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);
    }

}
