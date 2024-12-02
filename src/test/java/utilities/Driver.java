package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;

public class Driver {

    private Driver(){   }

    public static WebDriver driver;

    public static <String> WebDriver getDriver(){

        if (driver == null){
            java.lang.String brwsr = ConfigReader.getProperty("browser");
            switch (brwsr){
                case "firefox" :
                    driver = new FirefoxDriver();
                    break;
                case "edge" :
                    driver = new EdgeDriver();
                    break;
                case "safari" :
                    driver = new SafariDriver();
                    break;
                default:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-search-engine-choice-screen");
                    driver = new ChromeDriver(options);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
    public static void quitDriver(){
        driver.quit();
        driver = null;
    }

}
