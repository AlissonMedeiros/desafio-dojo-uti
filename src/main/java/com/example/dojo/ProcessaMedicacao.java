package com.example.dojo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ProcessaMedicacao {

    private static final Type TYPE = new TypeToken<List<Entrada>>() {}.getType();
    private static Gson gson = new Gson();

    public List<Resultado> processa(InputStream file) throws IOException {
        List<Entrada> data = paserFileToJSON(file);
        return processa(data);
    }

    public List<Resultado> processa(List<Entrada> data) {
        List<Resultado> resultados = new ArrayList<>();
        for( Entrada entrada : data) {
            Batimentos batimentos = new Batimentos(entrada.batimentos, entrada.peso);
            Pressao pressao = Pressao.of(entrada.pressao);
            resultados.add(new Resultado(entrada.nome, batimentos, pressao));
        }
        return resultados;
    }

    private List<Entrada> paserFileToJSON(InputStream file) {
        JsonReader reader = new JsonReader(new InputStreamReader(file));
        return gson.fromJson(reader, TYPE);
    }

}
