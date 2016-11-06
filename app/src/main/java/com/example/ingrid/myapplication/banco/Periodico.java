package com.example.ingrid.myapplication.banco;
import java.sql.Time;

/**
 * Created by ingrid on 03/11/16.
 */
public class Periodico {
    private int id;
    private String nome;
    private String anotacao;
    private Time horaFinal, horaInicial;
    private int repeticao;
    private String local;
    private int prioridade;
    private String frequencia;
    private int faltas;
    private Usuario userID;
    private boolean segunda, terca, quarta, quinta, sexta, sabado, domingo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Time getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Time horaInicial) {
        this.horaInicial = horaInicial;
    }

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public Usuario getUserID() {
        return userID;
    }

    public void setUserID(Usuario userID) {
        this.userID = userID;
    }

    public boolean getSegunda() {return segunda;  }

    public void setSegunda(boolean segunda) {this.segunda = segunda; }

    public boolean getTerca() {return terca;  }

    public void setTerca(boolean terca) {this.terca = terca; }

    public boolean getQuarta() {return quarta;  }

    public void setQuarta(boolean quarta) {this.quarta = quarta; }

    public boolean getQuinta() {return quinta;  }

    public void setQuinta(boolean quinta) {this.quinta = quinta; }

    public boolean getSexta() {return sexta;  }

    public void setSexta(boolean sexta) {this.sexta = sexta; }

    public boolean getSabado() {return sabado;  }

    public void setSabado(boolean sabado) {this.sabado= sabado; }

    public boolean getDomingo() {return domingo;  }

    public void setDomingo(boolean domingo) {this.domingo= domingo; }

}
