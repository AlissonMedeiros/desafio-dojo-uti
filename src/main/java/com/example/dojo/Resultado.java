package com.example.dojo;

public class Resultado {

    public final String paciente;
    public final double adrenalina;
    public final double calmante;
    public final int captopril;
    public final int atenolol;
    public final int furosemida;
    public final boolean hidralazina;
    public final boolean alarme;
    public final String diagnostico;

    protected Resultado(String paciente, Batimentos batimentos, Pressao pressaoEntrada) {
        this.paciente = paciente;
        this.adrenalina = batimentos.getDoseAdrenalina();
        this.calmante = batimentos.getDoseCalmante();
        this.captopril = pressaoEntrada.captopril;
        this.atenolol = pressaoEntrada.atenolol;
        this.furosemida = pressaoEntrada.furosemida;
        this.hidralazina = pressaoEntrada.aplicaHidralazina;
        this.alarme = batimentos.temAlarme();
        this.diagnostico = pressaoEntrada.diagnostico;
    }

}
