package br.ufpb.dcx.rodrigor.servico.participantes.services;

import br.ufpb.dcx.rodrigor.servico.participantes.model.ValidadorCampo;

public class ValidadorInteiro implements ValidadorCampo {
    private int min;
    private int max;


    public ValidadorInteiro(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean validar(String valor) {
        return false;
    }
}
