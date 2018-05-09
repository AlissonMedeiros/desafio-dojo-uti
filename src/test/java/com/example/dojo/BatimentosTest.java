package com.example.dojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BatimentosTest {

    @Test
    public void quandoBatimentosNormaisEntaoNaoFazNada() {
        Batimentos result = new Batimentos(110, 85);
        Validadores.validaResultado(result, 0D, 0D, false);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe121EntaoAplicaCalmante() {
        Batimentos result = new Batimentos(121, 60);
        Validadores.validaResultado(result, 0D, 60D, false);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe150EntaoAplicaCalmante() {
        Batimentos result = new Batimentos(199, 95);
        Validadores.validaResultado(result, 0D, 142.5D, false);
    }

    @Test
    public void quandoBatimentosEstaoAbaixoDe40EntaoAplicaAdrenilina() {
        Batimentos result = new Batimentos(39, 55);
        Validadores.validaResultado(result, 27.5D, 0D, false);
    }

    @Test
    public void quandoBatimentosEstaoAbaixoDe20EntaoAplicaAdrenilina() {
        Batimentos result = new Batimentos(19, 75);
        Validadores.validaResultado(result, 75D, 0D, true);
    }

    @Test
    public void quandoBatimentosEstaoEm20EntaoAplicaAdrenilina() {
        Batimentos result = new Batimentos(20, 90);
        Assertions.assertThat(result.getDoseAdrenalina()).isEqualTo(45D);
        Assertions.assertThat(result.temAlarme()).isFalse();
    }

    @Test
    public void quandoBatimentosEstaoEm21EntaoAplicaAdrenilina() {
        Batimentos result = new Batimentos(21, 87);
        Assertions.assertThat(result.getDoseAdrenalina()).isEqualTo(43.5);
    }

    @Test
    public void quandoBatimentosEstaoEm40EntaoAplicaAdrenilina() {
        Batimentos result = new Batimentos(40, 296);
        Assertions.assertThat(result.getDoseAdrenalina()).isEqualTo(0D);
    }

    @Test
    public void quandoBatimentosEstaoEm41EntaoAplicaAdrenilina() {
        Batimentos result = new Batimentos(41, 37);
        Assertions.assertThat(result.getDoseAdrenalina()).isEqualTo(0D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe120EntaoAplicaCalmante() {
        Batimentos result = new Batimentos(120, 85);
        Assertions.assertThat(result.getDoseCalmante()).isEqualTo(0D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe119EntaoAplicaCalmante() {
        Batimentos result = new Batimentos(119, 85);
        Assertions.assertThat(result.getDoseCalmante()).isEqualTo(0D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe139EntaoAplicaCalmante() {
        Batimentos result = new Batimentos(139, 5);
        Assertions.assertThat(result.getDoseCalmante()).isEqualTo(5D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe140EntaoAplicaCalmante() {
        Batimentos result = new Batimentos(140, 369);
        Assertions.assertThat(result.getDoseCalmante()).isEqualTo(369D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe141EntaoAplicaCalmante() {
        Batimentos result = new Batimentos(141, 259);
        Assertions.assertThat(result.getDoseCalmante()).isEqualTo(388.5D);
    }

}