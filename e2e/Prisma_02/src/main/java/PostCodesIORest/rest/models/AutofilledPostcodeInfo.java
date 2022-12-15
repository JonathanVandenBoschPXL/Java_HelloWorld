package PostCodesIORest.rest.models;

import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutofilledPostcodeInfo {

        public String outcode;
        public double longitude;
        public double latitude;
        public int northings;
        public int eastings;


    private AutofilledPostcodeInfo(HashMap<String, Object> autofillAsHashmap){
        outcode = autofillAsHashmap.get("outcode").toString();
        longitude = Double.parseDouble(autofillAsHashmap.get("longitude").toString());
        latitude = Double.parseDouble(autofillAsHashmap.get("latitude").toString());
        northings = Integer.parseInt(autofillAsHashmap.get("northings").toString());
        eastings = Integer.parseInt(autofillAsHashmap.get("eastings").toString());

    }

    public static AutofilledPostcodeInfo getInfoList(Response response){
        JSONObject responseAsJSON = response.body().as(JSONObject.class);
        return new AutofilledPostcodeInfo((HashMap<String, Object>) responseAsJSON.get("result"));
    }


}
