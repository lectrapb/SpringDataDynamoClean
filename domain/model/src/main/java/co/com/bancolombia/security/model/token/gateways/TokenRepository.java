package co.com.bancolombia.security.model.token.gateways;

import co.com.bancolombia.security.model.token.Token;

import java.util.List;

public interface TokenRepository {

    void init();

    List<Token> tokens();

    Token save (Token token);
}
