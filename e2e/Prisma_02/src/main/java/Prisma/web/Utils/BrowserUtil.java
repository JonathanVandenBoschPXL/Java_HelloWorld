package Prisma.web.Utils;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BrowserUtil {
    public static WebDriver createBrowser(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()){
            case "chrome":
                ChromeDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("no-sandbox");
                options.addArguments("Disable-dev-shm-usage");
                options.addArguments("window-size=1400,800");
                options.addArguments("headless");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                FirefoxDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("no-sandbox");
                firefoxOptions.addArguments("disable-dev-shm-usage");
                firefoxOptions.addArguments("headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Unsupported browser");
        }
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver createBrowser() {return createBrowser(WebConfig.getDefaultBrowser()); }
}
