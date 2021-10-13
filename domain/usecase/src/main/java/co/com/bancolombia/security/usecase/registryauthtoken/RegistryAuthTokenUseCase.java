package co.com.bancolombia.security.usecase.registryauthtoken;

import co.com.bancolombia.security.model.token.Token;
import co.com.bancolombia.security.model.token.gateways.TokenRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class RegistryAuthTokenUseCase {

     private final TokenRepository repository;

     public Token saveToken(Token token){
         return repository.save(token);
     }
}
