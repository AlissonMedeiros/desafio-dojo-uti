package com.example.dojo;

public class Entrada {

    private final String nome;
    private final int peso;
    private final int batimentos;

    public Entrada(String paciente, int peso, int batimentos) {
        this.nome = paciente;
        this.peso = peso;
        this.batimentos = batimentos;
    }

    public String getPaciente() {
        return nome;
    }

    public boolean temAlarme() {
        return this.batimentos < 20;
    }

    public double getDoseAdrenalina() {
        if (this.batimentos < 20) return this.peso;
        if (this.batimentos < 40) return this.peso / 2D;
        return 0D;
    }

    public double getDoseCalmante() {
        if (this.batimentos > 140) return this.peso * 1.5D;
        if (this.batimentos > 120) return this.peso;
        return 0D;
    }
}
