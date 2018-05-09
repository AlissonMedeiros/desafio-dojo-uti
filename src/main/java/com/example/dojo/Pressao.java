package com.example.dojo;

public enum Pressao {

    NORMAL("Normal", 0, 0, 0, false),
    PRE_HIPERTENSAO("Pré-Hipertensão", 25, 0, 0, false),
    HIPERTENSAO_1("Hipertensão 1", 30, 0, 0, false),
    HIPERTENSAO_2("Hipertensão 2", 0, 0, 50, false),
    CRISE_HIPERTENSIVA("Crise Hipertensiva", 0, 0, 0, true),
    PRESSAO_BAIXA("Pressão baixa", 0, 25, 0, false);

    public final String diagnostico;
    public final int captopril;
    public final int atenolol;
    public final int furosemida;
    public final boolean aplicaHidralazina;

    private Pressao(String diagnostico
            , int captopril
            , int atenolol
            , int furosemida
            , boolean aplicaHidralazina) {
        this.diagnostico = diagnostico;
        this.captopril = captopril;
        this.atenolol = atenolol;
        this.furosemida = furosemida;
        this.aplicaHidralazina = aplicaHidralazina;
    }

    public static Pressao of(String pressao) {
        String[] values = pressao.split(":");
        int pressao1 = Integer.valueOf(values[0]);
        int pressao2 = Integer.valueOf(values[1]);
        return diagnosticarPressao(pressao1, pressao2);
    }

    private static Pressao diagnosticarPressao(int pressao1, int pressao2) {
        if (pressao1 >= 18) return CRISE_HIPERTENSIVA;
        if (pressao1 >= 14) return HIPERTENSAO_2;
        if (pressao1 == 13 && pressao2 >= 9) return HIPERTENSAO_1;
        if (pressao1 == 13 && pressao2 >= 6) return PRE_HIPERTENSAO;
        if (pressao1 <= 9 || pressao2 <= 6) return PRESSAO_BAIXA;
        return NORMAL;
    }

}
