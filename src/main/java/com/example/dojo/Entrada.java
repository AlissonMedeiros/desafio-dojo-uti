package com.example.dojo;

public class Entrada {

    public final String nome;
    public final int peso;
    public final int batimentos;
    public final String pressao;

    public Entrada(String paciente, int peso, int batimentos, String pressao) {
        this.nome = paciente;
        this.peso = peso;
        this.batimentos = batimentos;
        this.pressao = pressao;
    }

}
