package br.ufpb.dcx.rodrigor.servico.participantes.services;

import br.ufpb.dcx.rodrigor.servico.participantes.model.ValidadorCampo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidadorData implements ValidadorCampo {

    private String formato;

    public ValidadorData() {
        this.formato = formato;
    }

    @Override
    public boolean validar(String valor) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        sdf.setLenient(false); // Não permite datas inválidas, como 31/02/2023
        try {
            Date data = sdf.parse(valor);
            return true; // A data foi validada corretamente
        } catch (ParseException e) {
            // O valor não corresponde ao formato ou é uma data inválida
            return false;
        }
    }

    public String getFormato() {
        return formato;
    }
}

