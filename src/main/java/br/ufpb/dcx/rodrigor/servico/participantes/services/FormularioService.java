package br.ufpb.dcx.rodrigor.servico.participantes.services;

import br.ufpb.dcx.rodrigor.servico.participantes.model.Campo;
import br.ufpb.dcx.rodrigor.servico.participantes.model.Form;
import br.ufpb.dcx.rodrigor.servico.participantes.model.ValidadorDecimal;

public class FormularioService {
    // Método que retorna um formulário com base no ID
    public Form getFormulario(String id) {
        // Cria um novo formulário com título e id fornecido
        Form formulario = new Form(id, "Cadastro de Usuário");

        // Adiciona campos ao formulário
        //formulario.addCampo(new Campo("nome", "Nome", new ValidadorTexto(1, 100), true));
        //formulario.addCampo(new Campo("email", "E-mail", new ValidadorEmail(), true));
        formulario.addCampo(new Campo("altura", "Altura", new ValidadorDecimal(0.5, 2.5), true));
        //formulario.addCampo(new Campo("data_nascimento", "Data de Nascimento", new ValidadorData(), true));

        return formulario;
    }



}
