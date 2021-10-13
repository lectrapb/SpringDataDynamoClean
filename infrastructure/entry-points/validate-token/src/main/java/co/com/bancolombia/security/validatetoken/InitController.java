package co.com.bancolombia.security.validatetoken;


import co.com.bancolombia.security.model.token.gateways.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @Autowired
    private TokenRepository tokenRepository;

    @GetMapping("/init")
    public String createTable(){
        tokenRepository.init();
        return "Tabla creada";
    }
}
