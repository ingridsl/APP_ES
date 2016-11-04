package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ingrid.myapplication.banco.*;

public class UnicoActivity extends AppCompatActivity {
    private EditText editNome;
    private EditText editData;
    private EditText editHoraIni;
    private EditText editHoraFin;
    private EditText editNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unico);


        editNome = (EditText) findViewById(R.id.editNome);
        editData = (EditText) findViewById(R.id.editData);
        editHoraIni = (EditText) findViewById(R.id.editHoraIni);
        editHoraFin = (EditText) findViewById(R.id.editHoraFin);
        editNotas = (EditText) findViewById(R.id.editNotas);



        DataBaseHelper mInstance = DataBaseHelper.getInstance().addUsuario(usuario);

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

        Unico unico = new Unico();
        unico.setNome(Nome);
        unico.setHoraInicial(HoraIni);
        unico.setHoraFinal(HoraFin);
        unico.setData(Data);
        unico.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addUnico(unico);

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

        Unico unico = new Unico();
        unico.setNome(Nome);
        unico.setHoraInicial(HoraIni);
        unico.setHoraFinal(HoraFin);
        unico.setData(Data);
        unico.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addUnico(unico);

        startActivity(intent);

    }

    public void cancelar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }
}
