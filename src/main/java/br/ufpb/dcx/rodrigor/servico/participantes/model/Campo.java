package br.ufpb.dcx.rodrigor.servico.participantes.model;

public class Campo {

    private String id;
    private String label;
    private ValidadorCampo validador;

    private boolean obrigatorio;


    public Campo(String id, String label, ValidadorCampo validador, boolean obrigatorio) {
        this.id = id;
        this.label = label;
        this.validador = validador;
        this.obrigatorio = obrigatorio;
    }

    public boolean validar(String valor) {
        if (obrigatorio && (valor == null || valor.isEmpty())) {
            return false;
        }
        if (!obrigatorio && (valor == null || valor.isEmpty())) {
            return true;
        }
        return validador.validar(valor);
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

    public void setValidador(ValidadorCampo validador) {
        this.validador = validador;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

}
