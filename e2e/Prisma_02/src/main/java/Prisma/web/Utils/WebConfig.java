package Prisma.web.Utils;

import Prisma.common.JSONHelper;

public class WebConfig {
    private static final String webConfigJsonFile = "src/main/java/Prisma/web/webConfig.json";

    public static String getBaseUrl() { return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "baseURL");}

    public static String getDefaultBrowser(){
        return JSONHelper.getJSONStringFromJsonFile(webConfigJsonFile, "defaultBrowser");
    }
}
