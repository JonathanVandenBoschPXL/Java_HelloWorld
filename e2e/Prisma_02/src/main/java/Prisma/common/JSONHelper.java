package Prisma.common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONHelper {
    public static String getJSONStringFromJsonFile(String filepath, String element){
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(new FileReader(filepath));
            return data.getOrDefault(element, "").toString();
        } catch (IOException | ParseException e){
            e.printStackTrace();
        }
        return "";
    }
}
