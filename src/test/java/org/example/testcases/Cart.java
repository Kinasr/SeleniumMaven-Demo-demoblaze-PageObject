package org.example.testcases;

import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.FakeDataGenerator;
import utilities.PropertyReader;
import java.util.HashMap;

public class Cart extends BaseTestClass {
    private HomePage homePage;
    private CartPage cartPage;
    private final FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();

    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        cartPage = header.clickOnCart();
    }

    @Test(priority = 1)
    public void cartTotalPrice() {
        Assert.assertEquals(cartPage.getActualPrice(), cartPage.getExpectedPrice());
    }

    @Test(priority = 2)
    public void cartDelete() throws InterruptedException {
        cartPage.deleteProduct();
        Assert.assertTrue(cartPage.isProductDeleted());
    }

    @Test(priority = 3)
    public void cartPlaceOrder() throws InterruptedException {
        HashMap<String, String> data;

        cartPage.clickOnPlaceOrder();
        data = fakeDataGenerator.getPlaceOrderData();
        cartPage.enterPlaceOrderData(data.get("NAME"), data.get("COUNTRY"), data.get("CITY"),
                data.get("CARD"), data.get("MONTH"), data.get("YEAR"));
        cartPage.clickOnPurchase();
        softAssert.assertEquals(cartPage.getSuccessMessage(), PropertyReader.getAlertMessage("SUCCESSFUL.PURCHASE"));
        softAssert.assertTrue(cartPage.areTheRightDataAppear(data.get("CARD"), data.get("NAME")));

        homePage = cartPage.clickOnOk();
        softAssert.assertEquals(homePage.getUrl(), PropertyReader.getData("HOME.URL"));
        softAssert.assertAll();
    }
}
