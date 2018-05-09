package com.example.dojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ProcessaMedicacaoTest {

    public static final Entrada JOÃO_ALFREDO = new Entrada("João Alfredo", 85, 110);
    public static final Entrada MARIA_DAS_DORES = new Entrada("Maria das dores", 60, 121);
    public static final Entrada TADEU_CARVALHO = new Entrada("Tadeu Carvalho", 95, 199);
    public static final Entrada LUIZA_MENDONÇA = new Entrada("Luiza Mendonça", 55, 39);
    public static final Entrada JOANA_PADILHA = new Entrada("Joana Padilha", 75, 19);

    private ProcessaMedicacao validatePatientMedicines = new ProcessaMedicacao();

    @Test
    public void quandoBatimentosNormaisEntaoNaoFazNada() {
        Resultado result = Resultado.of(JOÃO_ALFREDO);
        Assertions.assertThat(result).isNotNull();
        validaResultado(result, "João Alfredo", 0D, 0D, false);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe121EntaoAplicaCalmante() {
        Resultado result = Resultado.of(MARIA_DAS_DORES);
        Assertions.assertThat(result).isNotNull();
        validaResultado(result, "Maria das dores", 0D, 60D, false);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe150EntaoAplicaCalmante() {
        Resultado result = Resultado.of(TADEU_CARVALHO);
        Assertions.assertThat(result).isNotNull();
        validaResultado(result, "Tadeu Carvalho", 0D, 142.5D, false);
    }

    @Test
    public void quandoBatimentosEstaoAbaixoDe40EntaoAplicaAdrenilina() {
        Resultado result = Resultado.of(LUIZA_MENDONÇA);
        Assertions.assertThat(result).isNotNull();
        validaResultado(result, "Luiza Mendonça", 27.5D, 0D, false);
    }

    @Test
    public void quandoBatimentosEstaoAbaixoDe20EntaoAplicaAdrenilina() {
        Resultado result = Resultado.of(JOANA_PADILHA);
        Assertions.assertThat(result).isNotNull();
        validaResultado(result, "Joana Padilha", 75D, 0D, true);
    }

    @Test
    public void quandoBatimentosEstaoEm20EntaoAplicaAdrenilina() {
        Resultado result = Resultado.of(new Entrada("Joana Padilha", 90, 20));
        Assertions.assertThat(result.getAdrenalina()).isEqualTo(45D);
        Assertions.assertThat(result.isAlarme()).isFalse();
    }

    @Test
    public void quandoBatimentosEstaoEm21EntaoAplicaAdrenilina() {
        Resultado result = Resultado.of(new Entrada("Joana Padilha", 87, 21));
        Assertions.assertThat(result.getAdrenalina()).isEqualTo(43.5);
    }

    @Test
    public void quandoBatimentosEstaoEm40EntaoAplicaAdrenilina() {
        Resultado result = Resultado.of(new Entrada("Joana Padilha", 296, 40));
        Assertions.assertThat(result.getAdrenalina()).isEqualTo(0D);
    }

    @Test
    public void quandoBatimentosEstaoEm41EntaoAplicaAdrenilina() {
        Resultado result = Resultado.of(new Entrada("Joana Padilha", 37, 41));
        Assertions.assertThat(result.getAdrenalina()).isEqualTo(0D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe120EntaoAplicaCalmante() {
        Resultado result = Resultado.of(new Entrada("João Alfredo", 85, 120));
        Assertions.assertThat(result.getCalmante()).isEqualTo(0D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe119EntaoAplicaCalmante() {
        Resultado result = Resultado.of(new Entrada("João Alfredo", 85, 119));
        Assertions.assertThat(result.getCalmante()).isEqualTo(0D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe139EntaoAplicaCalmante() {
        Resultado result = Resultado.of(new Entrada("João Alfredo", 5, 139));
        Assertions.assertThat(result.getCalmante()).isEqualTo(5D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe140EntaoAplicaCalmante() {
        Resultado result = Resultado.of(new Entrada("João Alfredo", 369, 140));
        Assertions.assertThat(result.getCalmante()).isEqualTo(369D);
    }

    @Test
    public void quandoBatimentosEstaoCimaDe141EntaoAplicaCalmante() {
        Resultado result = Resultado.of(new Entrada("João Alfredo", 259, 141));
        Assertions.assertThat(result.getCalmante()).isEqualTo(388.5D);
    }

    @Test
    public void quandoTenhoListaDePacientesEntaoRetoraMedicacaoDaAla() throws IOException {
        List<Resultado> resultados = validatePatientMedicines.processa(this.getClass().getResourceAsStream("file.txt"));
        Assertions.assertThat(resultados).isNotNull()
                .hasSize(5);
        validaResultado(resultados.get(0), "João Alfredo", 0D, 0D, false);
        validaResultado(resultados.get(1), "Maria das dores", 0D, 60D, false);
        validaResultado(resultados.get(2), "Tadeu Carvalho", 0D, 142.5D, false);
        validaResultado(resultados.get(3), "Luiza Mendonça", 27.5D, 0D, false);
        validaResultado(resultados.get(4), "Joana Padilha", 75D, 0D, true);
    }

    private void validaResultado(Resultado result, String paciente, double adrenalina, double calmante, boolean temAlarme) {
        Assertions.assertThat(result.getPaciente()).isEqualTo(paciente);
        Assertions.assertThat(result.getAdrenalina()).isEqualTo(adrenalina);
        Assertions.assertThat(result.getCalmante()).isEqualTo(calmante);
        Assertions.assertThat(result.isAlarme()).isEqualTo(temAlarme);
    }
}
