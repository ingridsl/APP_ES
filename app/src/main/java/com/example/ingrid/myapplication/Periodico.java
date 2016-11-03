package com.example.ingrid.myapplication;
import java.util.Date;
import java.sql.Timestamp;

/**
 * Created by ingrid on 03/11/16.
 */
public class Periodico {
    public int id;
    public String anotacao;
    public Timestamp horaFinal, horaInicial;
    public int repeticao;
    public String local;
    public int prioridade;
    public String frequencia;
    public int faltas;
    public Usuario userID;

}
