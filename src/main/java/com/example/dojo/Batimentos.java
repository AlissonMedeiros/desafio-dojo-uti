package com.example.dojo;

public class Batimentos {

    private final double batimentos;
    private final double peso;

    public Batimentos(double batimentos, double peso) {
        this.batimentos = batimentos;
        this.peso = peso;
    }

    public boolean temAlarme() {
        return batimentos < 20;
    }

    public double getDoseAdrenalina() {
        if (batimentos < 20) return peso;
        if (batimentos < 40) return peso / 2D;
        return 0D;
    }

    public double getDoseCalmante() {
        if (batimentos > 140) return peso * 1.5D;
        if (batimentos > 120) return peso;
        return 0D;
    }

}
