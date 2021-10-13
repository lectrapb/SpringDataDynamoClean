package co.com.bancolombia.security.usecase.searchauthtoken;

import co.com.bancolombia.security.model.token.Token;
import co.com.bancolombia.security.model.token.gateways.TokenRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SearchAuthTokenUseCase {

    private final TokenRepository repository;

    public List<Token> searchToken(){

        return repository.tokens();
    }
}
