package co.com.bancolombia.security.validatetoken;


import co.com.bancolombia.security.model.token.Token;
import co.com.bancolombia.security.model.token.TokenRequest;
import co.com.bancolombia.security.usecase.registryauthtoken.RegistryAuthTokenUseCase;
import co.com.bancolombia.security.usecase.searchauthtoken.SearchAuthTokenUseCase;
import co.com.bancolombia.security.validatetoken.config.MapperConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TokenController {

    private final RegistryAuthTokenUseCase registryAuthTokenUseCase;

    private final SearchAuthTokenUseCase searchAuthTokenUseCase;

    private final MapperConfig<TokenRequest, Token.TokenBuilder> mapper;

    public TokenController(RegistryAuthTokenUseCase registryAuthTokenUseCase,
                           SearchAuthTokenUseCase searchAuthTokenUseCase) {
        this.registryAuthTokenUseCase = registryAuthTokenUseCase;
        this.searchAuthTokenUseCase = searchAuthTokenUseCase;
        this.mapper = new MapperConfig<>(TokenRequest.class, Token.TokenBuilder.class );
    }

    @GetMapping("/authToken")
    public List<Token> getTokens(){

        return searchAuthTokenUseCase.searchToken();
    }

    @PostMapping("/authToken")
    public Token saveToken(@RequestBody TokenRequest token){

       return registryAuthTokenUseCase.saveToken(mapper.toEntity(token).build());
    }
}
