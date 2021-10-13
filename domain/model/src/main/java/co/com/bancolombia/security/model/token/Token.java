package co.com.bancolombia.security.model.token;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Token {

    private final String relationalId;
    private final String thirdApp;
    private final String product;
    private final String  cid;
    private  String status;
    private final String creationDate;
    private final String updateDate;
    private final String productType;
}
