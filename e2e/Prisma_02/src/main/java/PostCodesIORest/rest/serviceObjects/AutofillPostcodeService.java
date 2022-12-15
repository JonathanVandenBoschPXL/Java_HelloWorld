package PostCodesIORest.rest.serviceObjects;

import PostCodesIORest.rest.models.AutofilledPostcodeInfo;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.when;

public class AutofillPostcodeService extends BaseService {
    private String endpoint;

    public AutofillPostcodeService(){
        endpoint = "outcodes/";
    }

    public Response getAutofillPostcodeResponse(String partialPostcode) {
        return when().get(baseUrl + endpoint + partialPostcode + "/nearest");
    }

    public AutofilledPostcodeInfo getAutofillPostcode(String partialPostcode){
        Response response = getAutofillPostcodeResponse(partialPostcode);
        return AutofilledPostcodeInfo.getInfoList(response);
    }
}
