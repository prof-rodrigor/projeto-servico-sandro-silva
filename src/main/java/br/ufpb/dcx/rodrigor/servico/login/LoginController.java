package br.ufpb.dcx.rodrigor.servico.login;

import br.ufpb.dcx.rodrigor.servico.Keys;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

public class LoginController {
    private static final Logger logger = LogManager.getLogger(LoginController.class);

    public void mostrarPaginaLogin(Context ctx) {
        String teste = ctx.queryParam("teste");
        if(teste != null){
            throw new RuntimeException("Erro de teste a partir do /login?teste=1");
        }

        ctx.render("/login/login.html");
    }

    public void processarLogin(Context ctx) {
       // TODO implementar conexão ao serviço de autenticação
    }

    public void logout(Context ctx) {
        ctx.sessionAttribute("usuario", null);
        ctx.redirect("/login");
    }
}