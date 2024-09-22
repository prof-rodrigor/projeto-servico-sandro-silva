package br.ufpb.dcx.rodrigor.servico.participantes.controllers;

import br.ufpb.dcx.rodrigor.servico.Keys;
import br.ufpb.dcx.rodrigor.servico.participantes.model.Campo;
import br.ufpb.dcx.rodrigor.servico.participantes.model.Form;
import br.ufpb.dcx.rodrigor.servico.participantes.services.ValidadorInteiro;
import br.ufpb.dcx.rodrigor.servico.participantes.services.ParticipanteService;
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

    public void processarDados(Context ctx) {
        ParticipanteService formularioService = ctx.appData(Keys.FORMULARIO_SERVICE.key());
        String formId = ctx.formParam("formId");

        Form form = formularioService.getFormulario();

        if (form != null) {
            for (Campo campo : form.getCampos().values()) {
                String valor = ctx.formParam(campo.getId());
                if (campo.validar(valor)) {
                    // Processa o campo se válido
                    System.out.println("Campo " + campo.getId() + " válido: " + valor);
                } else {
                    // Se inválido, exibe mensagem de erro
                    System.out.println("Erro na validação do campo " + campo.getId());
                    ctx.status(400);
                    return;
                }
            }
            // Se todos os campos forem válidos, faz algo com os dados processados
            System.out.println("Todos os campos foram validados com sucesso.");
            ctx.status(200);
        } else {
            ctx.status(404).result("Formulário não encontrado.");
        }
    }


}
