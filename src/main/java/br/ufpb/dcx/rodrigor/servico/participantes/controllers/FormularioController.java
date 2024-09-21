package br.ufpb.dcx.rodrigor.servico.participantes.controllers;

import br.ufpb.dcx.rodrigor.servico.participantes.model.Campo;
import br.ufpb.dcx.rodrigor.servico.participantes.model.Form;
import br.ufpb.dcx.rodrigor.servico.participantes.model.ValidadorInteiro;
import io.javalin.http.Context;

public class FormularioController {

    public void exibirFormulario(Context ctx) {

        Form formulario = new Form("/enviar-formulario", "POST");

        // Adiciona os campos ao formulário
        //ValidadorCampo validadorNome = new ValidadorTexto(1, 100); // Nome deve ter entre 1 e 100 caracteres
        //Campo campoNome = new Campo("nome", "Nome", validadorNome, true);
        //formulario.addCampo(campoNome);

        //ValidadorCampo validadorEmail = new ValidadorEmail(); // Validador específico para e-mail
        //Campo campoEmail = new Campo("email", "E-mail", validadorEmail, true);
        //formulario.addCampo(campoEmail);

        ValidadorInteiro validadorAltura = new ValidadorInteiro(50, 250); // Altura em cm, entre 50 e 250 cm
        Campo campoAltura = new Campo("altura", "Altura (cm)", validadorAltura, true);
        formulario.addCampo(campoAltura);

        //ValidadorCampo validadorDataNascimento = new ValidadorData(); // Validador de data de nascimento
        //Campo campoDataNascimento = new Campo("data_nascimento", "Data de Nascimento", validadorDataNascimento, true);
        //formulario.addCampo(campoDataNascimento);

        // Atribui o formulário ao contexto, para ser utilizado no template HTML
        ctx.attribute("formulario", formulario);

        // Renderiza a página do formulário
        ctx.render("/templates/formulario.html");

    }
}
