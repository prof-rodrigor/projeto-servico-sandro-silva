package br.ufpb.dcx.rodrigor.servico.participantes.controllers;

import br.ufpb.dcx.rodrigor.servico.Keys;
import br.ufpb.dcx.rodrigor.servico.participantes.model.CategoriaParticipante;
import br.ufpb.dcx.rodrigor.servico.participantes.model.Participante;
import br.ufpb.dcx.rodrigor.servico.participantes.services.ParticipanteService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class ParticipanteController {


    public ParticipanteController() {
    }

    public void listarParticipantes(Context ctx) {
        ParticipanteService participanteService = ctx.appData(Keys.PARTICIPANTE_SERVICE.key());
        ctx.attribute("participantes", participanteService.listarParticipantes());
        ctx.render("/participantes/lista_participantes.html");
    }

    // v1/participantes?categoria=<categoria>
    public void participantesPorCategoria(Context ctx) {
        ParticipanteService participanteService = ctx.appData(Keys.PARTICIPANTE_SERVICE.key());
        String categoriaParam = ctx.queryParam("categoria");

        if (categoriaParam != null) {
            try {
                CategoriaParticipante categoria = CategoriaParticipante.valueOf(categoriaParam.toUpperCase());
                var participantes = participanteService.listarParticipantesPorCategoria(categoria);
                if (participantes.isEmpty()) {
                    ctx.status(HttpStatus.NOT_FOUND).result("Nenhum participante encontrado para a categoria: " + categoriaParam);
                } else {
                    ctx.json(participantes);
                }
            } catch (IllegalArgumentException e) {
                ctx.status(HttpStatus.BAD_REQUEST).result("Categoria inválida: " + categoriaParam);
            }
        } else {
            ctx.json(participanteService.listarParticipantes());
        }
    }

    // v1/participantes/<id>
    public void participantePorId(Context ctx) {
        ParticipanteService participanteService = ctx.appData(Keys.PARTICIPANTE_SERVICE.key());
        String id = ctx.pathParam("id");
        var participante = participanteService.buscarParticipantePorId(id);
        if (participante.isPresent()) {
            ctx.json(participante.get());
        } else {
            ctx.status(HttpStatus.NOT_FOUND)
                    .contentType("application/json")
                    .result("{\"message\": \"Participante não encontrado para o id: " + id + "\"}");
        }
    }




    public void mostrarFormularioCadastro(Context ctx) {
        ctx.attribute("categorias", CategoriaParticipante.values());
        ctx.render("/participantes/formulario_participante.html");
    }

    public void adicionarParticipante(Context ctx) {
        ParticipanteService participanteService = ctx.appData(Keys.PARTICIPANTE_SERVICE.key());
        Participante participante = new Participante();
        participante.setNome(ctx.formParam("nome"));
        participante.setSobrenome(ctx.formParam("sobrenome"));
        participante.setEmail(ctx.formParam("email"));
        participante.setTelefone(ctx.formParam("telefone"));
        System.out.println("categoria recebida:"+ctx.formParam("categoria"));
        System.out.println("categoria convertida:"+CategoriaParticipante.valueOf(ctx.formParam("categoria")));
        participante.setCategoria(CategoriaParticipante.valueOf(ctx.formParam("categoria")));

        participanteService.adicionarParticipante(participante);
        ctx.redirect("/participantes");
    }

    public void removerParticipante(Context ctx) {
        ParticipanteService participanteService = ctx.appData(Keys.PARTICIPANTE_SERVICE.key());
        String id = ctx.pathParam("id");
        participanteService.removerParticipante(id);
        ctx.redirect("/participantes");
    }
}