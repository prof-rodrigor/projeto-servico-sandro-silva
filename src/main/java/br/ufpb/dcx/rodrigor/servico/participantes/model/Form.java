package br.ufpb.dcx.rodrigor.servico.participantes.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Form {

    private String id;
    private String titulo;
    private Map<String, Campo> campos;


    public Form(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.campos = new LinkedHashMap<>();
    }

    public void addCampo(Campo campo) {
        campos.put(id, campo);
    }


}
