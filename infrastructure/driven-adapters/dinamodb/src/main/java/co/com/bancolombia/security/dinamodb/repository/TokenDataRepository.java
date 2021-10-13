package co.com.bancolombia.security.dinamodb.repository;

import co.com.bancolombia.security.dinamodb.entity.TokenEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface TokenDataRepository extends CrudRepository<TokenEntity, String> {
}
