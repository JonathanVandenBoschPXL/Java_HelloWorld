package Prisma.web.pageObjects;

import Prisma.web.Utils.BrowserUtil;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AllPages {
    private WebDriver driver;

    public Homepage homepage;
    public Overzichtkinderen overzichtkinderen;

    public AllPages(){
        driver = BrowserUtil.createBrowser();
        homepage = new Homepage(driver);
        overzichtkinderen = new Overzichtkinderen(driver);
    }

    public void sleepBrowser() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5);
    }

    public void refreshBrowser(){
        driver.navigate().refresh();
    }

    public void closeBrowser(){ driver.quit();}
}
