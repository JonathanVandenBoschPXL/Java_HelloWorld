package PostCodesIORest.rest.serviceObjects;

import PostCodesIORest.rest.models.Postcode;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;


public class RandomPostcodeService extends BaseService {
    private String endpoint;

    public RandomPostcodeService(){
        endpoint = "random/postcodes";
    }

    public Postcode getRandomPostcode(){
        return Postcode.getPostcode(getRandomPostcodeResponse());
    }

    public Response getRandomPostcodeResponse(){
        return when().get(baseUrl + endpoint);
    }
}

