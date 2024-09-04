package br.ufpb.dcx.rodrigor.servico.participantes.model;

public enum CategoriaParticipante {
    ALUNO("Aluno"),
    PROFESSOR("Professor"),
    TECNICO_ADMINISTRATIVO("Técnico Administrativo"),
    OUTRO("Outro");

    private final String valor;

    CategoriaParticipante(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
}