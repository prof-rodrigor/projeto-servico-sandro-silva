package br.ufpb.dcx.rodrigor.servico.participantes.services;

import br.ufpb.dcx.rodrigor.servico.participantes.model.ValidadorCampo;

public class ValidadorTexto implements ValidadorCampo {

    private int min;
    private int max;

    public ValidadorTexto(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean validar(String valor) {
        if (valor == null) {
            return false;
        }
        int length = valor.length();
        return length >= min && length <= max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}

