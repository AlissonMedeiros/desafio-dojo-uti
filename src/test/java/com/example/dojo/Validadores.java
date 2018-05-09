package com.example.dojo;

import org.assertj.core.api.Assertions;

public class Validadores {

    public static void validaPressao(Pressao result
            , String diagnostico
            , int atenolol
            , int captopril
            , int furosemida
            , boolean hidralazina) {
        Assertions.assertThat(result.diagnostico).isEqualTo(diagnostico);
        Assertions.assertThat(result.atenolol).isEqualTo(atenolol);
        Assertions.assertThat(result.captopril).isEqualTo(captopril);
        Assertions.assertThat(result.furosemida).isEqualTo(furosemida);
        Assertions.assertThat(result.furosemida).isEqualTo(furosemida);
    }

    public static void validaPressao(Resultado result
            , String diagnostico
            , int atenolol
            , int captopril
            , int furosemida
            , boolean hidralazina) {
        Assertions.assertThat(result.diagnostico).isEqualTo(diagnostico);
        Assertions.assertThat(result.atenolol).isEqualTo(atenolol);
        Assertions.assertThat(result.captopril).isEqualTo(captopril);
        Assertions.assertThat(result.furosemida).isEqualTo(furosemida);
        Assertions.assertThat(result.furosemida).isEqualTo(furosemida);
    }

    public static void validaResultado(Batimentos result
            , double adrenalina
            , double calmante
            , boolean temAlarme) {
        Assertions.assertThat(result.getDoseAdrenalina()).isEqualTo(adrenalina);
        Assertions.assertThat(result.getDoseCalmante()).isEqualTo(calmante);
        Assertions.assertThat(result.temAlarme()).isEqualTo(temAlarme);
    }

    public static void validaResultado(Resultado result
            , String paciente
            , double adrenalina
            , double calmante
            , boolean temAlarme) {
        Assertions.assertThat(result.paciente).isEqualTo(paciente);
        Assertions.assertThat(result.adrenalina).isEqualTo(adrenalina);
        Assertions.assertThat(result.calmante).isEqualTo(calmante);
        Assertions.assertThat(result.alarme).isEqualTo(temAlarme);
    }
}
