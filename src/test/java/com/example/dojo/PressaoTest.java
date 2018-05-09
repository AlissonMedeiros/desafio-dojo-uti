package com.example.dojo;


import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PressaoTest {

    @Test
    public void validaHipertensao2() {
        Pressao pressao = Pressao.of("16:11");
        Validadores.validaPressao(pressao, "Hipertensão 2", 0, 0, 50, false);
        Assertions.assertThat(pressao).isEqualTo(Pressao.HIPERTENSAO_2);
    }

    @Test
    public void validaHipertensao1() {
        Pressao pressao = Pressao.of("13:9");
        Validadores.validaPressao(pressao, "Hipertensão 1", 0, 30, 0, false);
        Assertions.assertThat(pressao).isEqualTo(Pressao.HIPERTENSAO_1);
    }

    @Test
    public void validaNormal() {
        Pressao pressao = Pressao.of("12:8");
        Validadores.validaPressao(pressao, "Normal", 0, 0, 0, false);
        Assertions.assertThat(pressao).isEqualTo(Pressao.NORMAL);
    }

    @Test
    public void validaPreHipertensao() {
        Pressao pressao = Pressao.of("13:8");
        Validadores.validaPressao(pressao, "Pré-Hipertensão", 0, 25, 0, false);
        Assertions.assertThat(pressao).isEqualTo(Pressao.PRE_HIPERTENSAO);
    }

    @Test
    public void validaCriseHipertensiva() {
        Pressao pressao = Pressao.of("18:11");
        Validadores.validaPressao(pressao, "Crise Hipertensiva", 0, 0, 0, true);
        Assertions.assertThat(pressao).isEqualTo(Pressao.CRISE_HIPERTENSIVA);
    }

    @Test
    public void validaPressaoBaixa() {
        Pressao pressao = Pressao.of("9:6");
        Validadores.validaPressao(pressao, "Pressão baixa", 25, 0, 0, false);
        Assertions.assertThat(pressao).isEqualTo(Pressao.PRESSAO_BAIXA);
    }

    @Test
    public void validaHipertensao2Com14por9() {
        Pressao pressao = Pressao.of("14:9");
        Assertions.assertThat(pressao).isEqualTo(Pressao.HIPERTENSAO_2);
    }

    @Test
    public void validaHipertensao2Com15por6() {
        Pressao pressao = Pressao.of("15:6");
        Assertions.assertThat(pressao).isEqualTo(Pressao.HIPERTENSAO_2);
    }

    @Test
    public void validaHipertensao2Com17por10() {
        Pressao pressao = Pressao.of("17:10");
        Assertions.assertThat(pressao).isEqualTo(Pressao.HIPERTENSAO_2);
    }

    @Test
    public void validaCriseHipertensivaCom25por23() {
        Pressao pressao = Pressao.of("25:26");
        Assertions.assertThat(pressao).isEqualTo(Pressao.CRISE_HIPERTENSIVA);
    }

    @Test
    public void validaPressaoBaixaCom10por5() {
        Pressao pressao = Pressao.of("10:5");
        Assertions.assertThat(pressao).isEqualTo(Pressao.PRESSAO_BAIXA);
    }

    @Test
    public void validaPressaoNormalCom10por7() {
        Pressao pressao = Pressao.of("10:7");
        Assertions.assertThat(pressao).isEqualTo(Pressao.NORMAL);
    }

    @Test
    public void validaPressaoBaixaCom10por6() {
        Pressao pressao = Pressao.of("10:6");
        Assertions.assertThat(pressao).isEqualTo(Pressao.PRESSAO_BAIXA);
    }

    @Test
    public void validaPressaoBaixaCom9por7() {
        Pressao pressao = Pressao.of("9:7");
        Assertions.assertThat(pressao).isEqualTo(Pressao.PRESSAO_BAIXA);
    }

    @Test
    public void validaPreHipertensao13por6() {
        Pressao pressao = Pressao.of("13:6");
        Assertions.assertThat(pressao).isEqualTo(Pressao.PRE_HIPERTENSAO);
    }

    @Test
    public void validaPreHipertensao13por7() {
        Pressao pressao = Pressao.of("13:7");
        Assertions.assertThat(pressao).isEqualTo(Pressao.PRE_HIPERTENSAO);
    }
    @Test
    public void validaPressaoBaixa13por5() {
        Pressao pressao = Pressao.of("13:5");
        Assertions.assertThat(pressao).isEqualTo(Pressao.PRESSAO_BAIXA);
    }
}