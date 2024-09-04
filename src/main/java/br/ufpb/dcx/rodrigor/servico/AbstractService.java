package br.ufpb.dcx.rodrigor.servico;

import br.ufpb.dcx.rodrigor.servico.db.MongoDBRepository;

public class AbstractService {

    protected final MongoDBRepository mongoDBRepository;

    public AbstractService(MongoDBRepository mongoDBRepository) {
        this.mongoDBRepository = mongoDBRepository;
    }

    public MongoDBRepository getMongoDBConnector() {
        return mongoDBRepository;
    }
}
