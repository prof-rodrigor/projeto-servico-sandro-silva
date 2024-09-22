package br.ufpb.dcx.rodrigor.servico.participantes.services;

import br.ufpb.dcx.rodrigor.servico.participantes.model.ValidadorCampo;

import java.util.regex.Pattern;

public class ValidadorEmail implements ValidadorCampo {

    // Expressão regular para validação de e-mail
    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public boolean validar(String valor) {
        if (valor == null || valor.isEmpty()) {
            return false;
        }
        return pattern.matcher(valor).matches();
    }

}

