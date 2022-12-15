package PostCodesIORest.rest.serviceObjects;

import PostCodesIORest.rest.models.Postcode;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;

public class ValidateRandomPostcodeService extends BaseService{
    private String endpoint;

    public ValidateRandomPostcodeService(){
        endpoint = "postcodes/";
    }

    public Response getValidationResponse(String postcode){
        return when().get(baseUrl + endpoint + postcode + "/validate");
    }

    public String getValidation(String postcode){
        return Postcode.getPostcode(getValidationResponse(postcode)).toString();
    }


}
