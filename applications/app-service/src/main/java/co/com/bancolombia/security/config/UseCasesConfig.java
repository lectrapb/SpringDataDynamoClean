package co.com.bancolombia.security.config;

import co.com.bancolombia.security.dinamodb.adapter.TokenRepositoryAdapter;
import co.com.bancolombia.security.dinamodb.repository.TokenDataRepository;
import co.com.bancolombia.security.usecase.registryauthtoken.RegistryAuthTokenUseCase;
import co.com.bancolombia.security.usecase.searchauthtoken.SearchAuthTokenUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.bancolombia.security.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {


    @Bean
    public RegistryAuthTokenUseCase registryAuthTokenUseCase(TokenRepositoryAdapter tokenRepositoryAdapter){
            return new RegistryAuthTokenUseCase(tokenRepositoryAdapter);
    }

    @Bean
    public SearchAuthTokenUseCase searchAuthTokenUseCase(TokenRepositoryAdapter tokenRepositoryAdapter){
            return new SearchAuthTokenUseCase(tokenRepositoryAdapter);
    }
}
