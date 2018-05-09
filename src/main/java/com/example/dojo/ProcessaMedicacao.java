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
        List<Resultado> resultados = new ArrayList<>();
        List<Entrada> data = paserFileToJSON(file);
        for( Entrada entrada : data) {
            resultados.add(Resultado.of(entrada));
        }
        return resultados;
    }

    private List<Entrada> paserFileToJSON(InputStream file) {
        JsonReader reader = new JsonReader(new InputStreamReader(file));
        return gson.fromJson(reader, TYPE);
    }

}
