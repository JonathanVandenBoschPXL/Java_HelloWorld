package Prisma.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Overzichtkinderen extends BasePage{
    public Overzichtkinderen(WebDriver driver) {
        super(driver, "/overzichtkinderen");
    }

    public void childIsVisible(){
        driver.findElement(By.id("kind_card")).isDisplayed();

    }
}
