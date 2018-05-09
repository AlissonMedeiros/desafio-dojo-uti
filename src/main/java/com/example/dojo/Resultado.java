package com.example.dojo;

public class Resultado {

    private final String paciente;
    private final double adrenalina;
    private final double calmante;
    private final boolean alarme;

    public static Resultado of(Entrada entrada) {
        return new Resultado(entrada.getPaciente(), entrada.getDoseAdrenalina(), entrada.getDoseCalmante(), entrada.temAlarme());
    }

    private Resultado(String paciente, double adrenalina, double calmante, boolean alarme) {
        this.paciente = paciente;
        this.adrenalina = adrenalina;
        this.calmante = calmante;
        this.alarme = alarme;
    }

    public String getPaciente() {
        return paciente;
    }

    public double getAdrenalina() {
        return adrenalina;
    }

    public double getCalmante() {
        return calmante;
    }

    public boolean isAlarme() {
        return alarme;
    }
}
