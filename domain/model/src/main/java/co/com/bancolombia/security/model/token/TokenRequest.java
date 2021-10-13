package co.com.bancolombia.security.model.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest {

    private  String relationalId;
    private  String thirdApp;
    private  String product;
    private  String  cid;
    private  String status;
    private  String creationDate;
    private  String updateDate;
    private  String productType;
}
