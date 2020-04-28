package org.example.testcases;

import org.example.pages.Header;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import utilities.PropertyReader;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public abstract class BaseTestClass {
    static WebDriver driver;
    public SoftAssert softAssert;
    public Header header;

    @BeforeSuite
    void setUpTest() {
        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(PropertyReader.getProperty("BASE.URL"));
    }

    @BeforeClass
    void beforeClass() {
        header = new Header(driver);
    }

    @BeforeMethod
    void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterSuite(alwaysRun = true)
    void tearDownTest() {
        WebDriverFactory.stopDriver();
    }
}
