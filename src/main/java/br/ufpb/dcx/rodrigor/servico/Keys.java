package br.ufpb.dcx.rodrigor.servico;

import br.ufpb.dcx.rodrigor.servico.db.MongoDBRepository;
import br.ufpb.dcx.rodrigor.servico.login.UsuarioService;
import br.ufpb.dcx.rodrigor.servico.participantes.services.ParticipanteService;
import io.javalin.config.Key;

public enum Keys {
    MONGO_DB(new Key<MongoDBRepository>("mongo-db")),
    SERVICO_NOME(new Key<String>("servico.nome")),
    PARTICIPANTE_SERVICE(new Key<ParticipanteService>("participante-service")),
    USUARIO_SERVICE(new Key<UsuarioService>("usuario-service")),
    SERVICO_PING_HOST(new Key<String>("servico.ping.host"))
    ;

    private final Key<?> k;

    <T> Keys(Key<T> key) {
        this.k = key;
    }

    public <T> Key<T> key() {
        @SuppressWarnings("unchecked")
        Key<T> typedKey = (Key<T>) this.k;
        return typedKey;
    }
}