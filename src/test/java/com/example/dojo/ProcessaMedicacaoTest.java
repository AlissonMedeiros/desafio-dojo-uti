package com.example.dojo;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.example.dojo.Validadores.validaPressao;
import static com.example.dojo.Validadores.validaResultado;

public class ProcessaMedicacaoTest {

    private ProcessaMedicacao validatePatientMedicines = new ProcessaMedicacao();

    @Test
    public void quandoTenhoListaDePacientesEntaoRetoraMedicacaoParaBatimentos() throws IOException {
        List<Resultado> resultados = validatePatientMedicines.processa(this.getClass().getResourceAsStream("file.txt"));
        Assertions.assertThat(resultados).isNotNull()
                .hasSize(5);
        validaResultado(resultados.get(0), "João Alfredo", 0D, 0D, false);
        validaResultado(resultados.get(1), "Maria das dores", 0D, 60D, false);
        validaResultado(resultados.get(2), "Tadeu Carvalho", 0D, 142.5D, false);
        validaResultado(resultados.get(3), "Luiza Mendonça", 27.5D, 0D, false);
        validaResultado(resultados.get(4), "Joana Padilha", 75D, 0D, true);
    }

    @Test
    public void quandoTenhoListaDePacientesEntaoRetoraMedicacaoParaPressao() throws IOException {
        List<Resultado> resultados = validatePatientMedicines.processa(this.getClass().getResourceAsStream("file.txt"));
        Assertions.assertThat(resultados).isNotNull()
                .hasSize(5);
        validaPressao(resultados.get(0), "Hipertensão 2", 0, 0, 50, false);
        validaPressao(resultados.get(1), "Normal", 0, 0, 0, false);
        validaPressao(resultados.get(2), "Crise Hipertensiva", 0, 0, 0, false);
        validaPressao(resultados.get(3), "Pressão baixa", 25, 0, 0, false);
        validaPressao(resultados.get(4), "Pré-Hipertensão", 0, 25, 0, false);
    }

    @Test
    public void quandoTenhoComMedicoesNormaisEntaoNaoGeraMedicacao() {
        List<Resultado> resultados = validatePatientMedicines.processa(listaSaudavel());
        validaResultado(resultados.get(0), "João Alfredo", 0D, 0D, false);
        validaResultado(resultados.get(1), "Maria das dores", 0D, 0D, false);
        validaPressao(resultados.get(0), "Normal", 0, 0, 0, false);
        validaPressao(resultados.get(1), "Normal", 0, 0, 0, false);

    }

    private List<Entrada> listaSaudavel() {
        return Arrays.asList(new Entrada("João Alfredo", 85, 120, "12:8")
                , new Entrada("Maria das dores", 65, 83, "11:7"));
    }


}
