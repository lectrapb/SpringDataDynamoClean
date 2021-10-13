package co.com.bancolombia.security.dinamodb.adapter;

import co.com.bancolombia.security.dinamodb.config.MapperConfig;
import co.com.bancolombia.security.dinamodb.entity.TokenEntity;
import co.com.bancolombia.security.dinamodb.repository.TokenDataRepository;
import co.com.bancolombia.security.model.token.Token;
import co.com.bancolombia.security.model.token.gateways.TokenRepository;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TokenRepositoryAdapter implements TokenRepository {

    private final TokenDataRepository tokenDataRepository;
    private final MapperConfig<TokenEntity, Token.TokenBuilder> mapper;


    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    public TokenRepositoryAdapter( DynamoDBMapper dynamoDBMapper,
            TokenDataRepository tokenDataRepository) {

        this.dynamoDBMapper = dynamoDBMapper;
        this.tokenDataRepository = tokenDataRepository;
        this.mapper = new MapperConfig<>(TokenEntity.class, Token.TokenBuilder.class );
    }

    @Override
    public void init() {

        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(TokenEntity.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);
    }

    @Override
    public List<Token> tokens() {

        List<TokenEntity> tokensEnt = (List<TokenEntity>) tokenDataRepository.findAll();
        List<Token> tokens = new ArrayList<>();
        tokensEnt.forEach(token ->{
            tokens.add(mapper.toEntity(token).build());
        } );
        return tokens;
    }

    @Override
    public Token save(Token token) {
        TokenEntity entity = mapper.toData(token);
        TokenEntity data =  tokenDataRepository.save(entity);
        return mapper.toEntity(data).build();
    }
}
