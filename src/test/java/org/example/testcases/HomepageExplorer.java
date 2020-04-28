package org.example.testcases;

import org.example.pages.HomePage;
import org.example.pages.Header;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomepageExplorer extends BaseTestClass {
    private HomePage homePage;

    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        homePage = header.clickOnHome();
    }

    @Test(enabled = false)
    public void SlideRightAndLeftArrow () throws InterruptedException {
        String firstImg;

        firstImg = homePage.getActiveImage();
        homePage.rightSlider();
        softAssert.assertNotEquals(homePage.getActiveImage(), firstImg);
        homePage.leftSlider();
        softAssert.assertEquals(homePage.getActiveImage(), firstImg);

        softAssert.assertAll();
    }

    @Test
    public void SlideRightAndLeftArrow02() throws InterruptedException {
        softAssert.assertTrue(homePage.isFirstSlideDisplayed());
        homePage.rightSlider();
        softAssert.assertTrue(homePage.isSecondSlideDisplayed());
        homePage.rightSlider();
        softAssert.assertTrue(homePage.isThirdSlideDisplayed());
        homePage.leftSlider();
        softAssert.assertTrue(homePage.isSecondSlideDisplayed());

        softAssert.assertAll();
    }

    @Test
    public void Categories() {
        homePage.clickOnPhones();
        softAssert.assertTrue(homePage.isSamsungGalaxyS6Exists());
        homePage.clickOnLaptops();
        softAssert.assertTrue(homePage.isMacBookProExists());
        homePage.clickOnMonitors();
        softAssert.assertTrue(homePage.isASUSFullHDExists());
        homePage.clickOnCategories();
        softAssert.assertTrue(homePage.isSamsungGalaxyS6Exists());
        homePage.clickOnNext();
        softAssert.assertTrue(homePage.isMacBookProExists() && homePage.isASUSFullHDExists());

        softAssert.assertAll();
    }
}
