package org.example.testcases;

import org.example.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.FakeDataGenerator;
import utilities.PropertyReader;

public class Login extends BaseTestClass {
    private LoginPage loginPage;
    private final FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();

    @Override
    @BeforeClass
    void beforeClass() {
        super.beforeClass();
        loginPage = header.clickOnLogin();
    }

    @Test(priority = 1)
    public void loginWithEmptyFields() {
        loginPage.login("","");
        softAssert.assertEquals(loginPage.getAlertMessage(), PropertyReader.getAlertMessage("EMPTY.LOGIN"));
        loginPage.acceptAlert();
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void loginWithValidUsernameAndInvalidPassword() {
        loginPage.login(fakeDataGenerator.getValidUsername(), fakeDataGenerator.getAnyPassword());
        softAssert.assertEquals(loginPage.getAlertMessage(), PropertyReader.getAlertMessage("WRONG.PASSWORD.LOGIN"));
        loginPage.acceptAlert();
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void loginWithInvalidUsername() {
        loginPage.login(fakeDataGenerator.getAnyUsername(),fakeDataGenerator.getAnyPassword());
        softAssert.assertEquals(loginPage.getAlertMessage(), PropertyReader.getAlertMessage("INVALID.LOGIN"));
        loginPage.acceptAlert();
        softAssert.assertAll();
    }

    // SignUp test should be executed
    @Test(priority = 4)
    public void validLogin() {
        loginPage.login(fakeDataGenerator.getValidUsername(), fakeDataGenerator.getValidPassword());
        softAssert.assertTrue(header.isWelcomeUserDisplayed());
        softAssert.assertTrue(header.isLogoutDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 5, dependsOnMethods = "validLogin")
    public void logout() {
        header.clickOnLogout();
        softAssert.assertTrue(header.isLoginDisplayed());
        softAssert.assertTrue(header.isSignUpDisplayed());
        softAssert.assertAll();
    }
}
