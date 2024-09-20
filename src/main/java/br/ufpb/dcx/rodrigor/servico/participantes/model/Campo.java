package br.ufpb.dcx.rodrigor.servico.participantes.model;

public class Campo {

    private String id;
    private String label;
    private ValidadorCampo validador;


    public Campo(String id, String label, ValidadorCampo validador) {
        this.id = id;
        this.label = label;
        this.validador = validador;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public ValidadorCampo getValidador() {
        return validador;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
