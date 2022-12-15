package PostCodesIORest.rest.serviceObjects;

public class AllServices {
    public RandomPostcodeService randomPostcode;
    public PostcodesService postcodes;
    public ValidateRandomPostcodeService validator;
    public AutofillPostcodeService autofiller;

    public AllServices(){
        randomPostcode = new RandomPostcodeService();
        postcodes = new PostcodesService();
        validator = new ValidateRandomPostcodeService();
        autofiller = new AutofillPostcodeService();
    }
}

