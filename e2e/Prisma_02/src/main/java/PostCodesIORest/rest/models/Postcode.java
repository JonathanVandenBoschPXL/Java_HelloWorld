package PostCodesIORest.rest.models;

import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Postcode {
    public String postcode;
    public int quality;
    public int eastings;
    public int northings;
    public String country;
    public String nhs_ha;
    public double longitude;
    public double latitude;
    public String european_electoral_region;
    public String primary_care_trust;
    public String region;
    public String lsoa;
    public String msoa;
    public String incode;
    public String outcode;
    public String parliamentary_constituency;
    public String admin_district;
    public String parish;
    public Object admin_county;
    public String admin_ward;
    public Object ced;
    public String ccg;
    public String nuts;

    public static Postcode getPostcode(Response response){
        JSONObject responseAsJSON = response.body().as(JSONObject.class);
        return new Postcode((HashMap<String, Object>) responseAsJSON.get("result"));
    }

    private Postcode(HashMap<String, Object> postcodeAsHashmap){
        postcode = postcodeAsHashmap.get("postcode").toString();
        quality = Integer.parseInt(postcodeAsHashmap.get("quality").toString());
        eastings = Integer.parseInt(postcodeAsHashmap.get("eastings").toString());
        northings = Integer.parseInt(postcodeAsHashmap.get("northings").toString());
        country = postcodeAsHashmap.get("country").toString();
        nhs_ha = postcodeAsHashmap.get("nhs_ha").toString();
        longitude = Double.parseDouble(postcodeAsHashmap.get("longitude").toString());
        latitude = Double.parseDouble(postcodeAsHashmap.get("latitude").toString());
        european_electoral_region = postcodeAsHashmap.get("european_electoral_region").toString();
        primary_care_trust = postcodeAsHashmap.get("primary_care_trust").toString();
        region = postcodeAsHashmap.get("region").toString();
        lsoa = postcodeAsHashmap.get("lsoa").toString();
        msoa = postcodeAsHashmap.get("msoa").toString();
        incode = postcodeAsHashmap.get("incode").toString();
        outcode = postcodeAsHashmap.get("outcode").toString();
        parliamentary_constituency = postcodeAsHashmap.get("parliamentary_constituency").toString();
        admin_district = postcodeAsHashmap.get("admin_district").toString();
        parish = postcodeAsHashmap.get("parish").toString();
        admin_county = postcodeAsHashmap.get("admin_county");
        admin_ward = postcodeAsHashmap.get("admin_ward").toString();
        ced = postcodeAsHashmap.get("ced");
        ccg = postcodeAsHashmap.get("ccg").toString();
        nuts = postcodeAsHashmap.get("nuts").toString();
    }

    public static List<Postcode> getPostcodeList(Response response) {
        JSONObject responseAsJSON = response.body().as(JSONObject.class);
        ArrayList<HashMap<String, Object>> postcodes = (ArrayList<HashMap<String, Object>>) responseAsJSON.get("result");
        List<Postcode> postcodeList = new ArrayList<>();
        for (HashMap<String, Object> postcode: postcodes){
            postcodeList.add(new Postcode(postcode));
        }
        return postcodeList;
    }


}
