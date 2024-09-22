package br.ufpb.dcx.rodrigor.servico.participantes.services;

import br.ufpb.dcx.rodrigor.servico.participantes.model.ValidadorCampo;

public class ValidadorDecimal implements ValidadorCampo {
    private final double min;
    private final double max;


    public ValidadorDecimal(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean validar(String valor) {
        return false;
    }
}
