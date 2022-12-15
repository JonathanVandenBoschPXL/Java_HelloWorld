package PostCodesIORest.rest.models;

import java.util.HashMap;

public class Validation {
    public int status;
    public boolean result;

    private Validation(HashMap<String, Object> validationAsHashmap){
        status = Integer.parseInt(validationAsHashmap.get("status").toString());
        result = Boolean.parseBoolean(validationAsHashmap.get("result").toString());
    }

}
