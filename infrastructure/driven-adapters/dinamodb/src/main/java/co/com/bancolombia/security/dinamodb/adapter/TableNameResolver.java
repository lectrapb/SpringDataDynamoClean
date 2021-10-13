package co.com.bancolombia.security.dinamodb.adapter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TableNameResolver extends DynamoDBMapperConfig.DefaultTableNameResolver {

    private String envProfile;

    @Value("${amazon.dynamodb.tableName}")
    private String singleTableName;

    public TableNameResolver() {}

    public TableNameResolver(String envProfile) {
        this.envProfile=envProfile;
    }

    @Override
    public String getTableName(Class<?> clazz, DynamoDBMapperConfig config) {
        String stageName = envProfile.concat("_");
        String rawTableName = super.getTableName(clazz, config);
        return stageName;
    }
}