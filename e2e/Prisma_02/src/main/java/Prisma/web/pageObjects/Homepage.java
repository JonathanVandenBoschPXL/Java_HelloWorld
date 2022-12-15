package Prisma.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class Homepage extends BasePage {

    public Homepage(WebDriver driver) {
        super(driver, "/home");
    }

    public void resizeHomepage(){
        driver.manage().window().setSize(new Dimension(800,600));
    }

    //public void checkIfLoginButtonIsVisible(){
      //  driver.findElement()
    //}

}
