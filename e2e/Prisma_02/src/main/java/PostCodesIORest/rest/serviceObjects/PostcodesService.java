package PostCodesIORest.rest.serviceObjects;

import PostCodesIORest.rest.models.Postcode;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.when;

public class PostcodesService extends BaseService{
    private String endpoint;

    public PostcodesService(){
        endpoint = "postcodes/";
    }

    public Response getPostcodeResponse(String postcode){
        return when().get(baseUrl + endpoint + postcode);
    }

    public Postcode getPostcode(String postcode){
        return Postcode.getPostcode(getPostcodeResponse(postcode));
    }

    public Response getPostcodesResponse(double latitude, double longitude){
        return when().get(baseUrl + endpoint + "?lon=" + longitude + "&lat=" + latitude);
    }

    public List<Postcode> getPostcodes(double latitude, double longitude){
        Response response = getPostcodesResponse(latitude, longitude);
        return Postcode.getPostcodeList(response);
    }
}
