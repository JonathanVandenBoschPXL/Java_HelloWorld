package Prisma.web.pageObjects;

import Prisma.web.Utils.WebConfig;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver, String endpoint){
        this.driver = driver;
        url = WebConfig.getBaseUrl() + endpoint;
    }

    public void NavigateToPage() {this.driver.get(url);}
}
