package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    private static WebDriver _driver = null;

    public static WebDriver getDriver() {
        String browser = PropertyReader.getProperty("BROWSER");

        if (_driver == null){
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    _driver = new ChromeDriver(chromeOptions());
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    _driver = new ChromeDriver(headlessChromeOptions());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    _driver = new FirefoxDriver();
                    break;
                case "headless-firefox":
                    WebDriverManager.firefoxdriver().setup();
                    _driver = new FirefoxDriver(headlessFirefoxOptions());
                    break;
                default:
                    System.out.println("Invalid browser option");
                    System.exit(1);
            }
        }
        return _driver;
    }

    public static void stopDriver() {
        _driver.quit();
        _driver = null;
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.addArguments("--lang=de");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    private static ChromeOptions headlessChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("windows-size=3000,2000");
        return options;
    }

    private static FirefoxOptions headlessFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        return options;
    }

}
