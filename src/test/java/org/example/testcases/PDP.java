package org.example.testcases;

import org.example.pages.HomePage;
import org.example.pages.Header;
import org.example.pages.PDPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.PropertyReader;

public class PDP extends BaseTestClass {
    private HomePage homePage;
    private PDPage pdPage;

    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        homePage = header.clickOnHome();
    }

    @Test(priority = 1)
    public void samsungGalaxyS6PDP() {
        homePage.clickOnPhones();
        pdPage = homePage.clickOnSamsungGalaxyS6();
        softAssert.assertEquals(pdPage.getProductTagName(), PropertyReader.getData("PHONE"));

        pdPage.clickOnAddToCart();
        softAssert.assertEquals(pdPage.getAlertMessage(), PropertyReader.getAlertMessage("ADD.PRODUCT"));

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void macBookProPDP() {
        homePage.clickOnLaptops();
        pdPage = homePage.clickOnMacBookPro();
        softAssert.assertEquals(pdPage.getProductTagName(), PropertyReader.getData("LAPTOP"));

        pdPage.clickOnAddToCart();
        softAssert.assertEquals(pdPage.getAlertMessage(), PropertyReader.getAlertMessage("ADD.PRODUCT"));

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void aSUSFullHDPDP() {
        homePage.clickOnMonitors();
        pdPage = homePage.clickOnASUSFullHD();
        softAssert.assertEquals(pdPage.getProductTagName(), PropertyReader.getData("MONITOR"));

        pdPage.clickOnAddToCart();
        softAssert.assertEquals(pdPage.getAlertMessage(), PropertyReader.getAlertMessage("ADD.PRODUCT"));

        softAssert.assertAll();
    }

    @AfterMethod
    void afterMethod() {
        pdPage.acceptAlert();
    }

}
