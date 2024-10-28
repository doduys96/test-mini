package pages.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testcore.helper.ConfigFile;

import java.lang.invoke.WrongMethodTypeException;

public class DriverManager {
    private static WebDriver webDriver;
    public DriverManager() {
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void setDriver(String Url) {
        ConfigFile configFile = new ConfigFile();
        switch (configFile.getBrowser()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(chromeOptions);
                webDriver.manage().window().maximize();
                webDriver.get(Url);
                break;
            case "firefox":
                break;
            default:
                throw new WrongMethodTypeException("Browser name is not correct");
        }
    }

    public static void teardownTest(){
        webDriver.quit();
    }
}
