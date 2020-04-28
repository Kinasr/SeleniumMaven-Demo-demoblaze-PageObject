package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends Page{
    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "navbar-brand")
    WebElement linkLogo;

    @FindBy(xpath = "//a[text()='Home ']")
    WebElement linkHome;

    @FindBy(linkText = "Contact")
    WebElement linkContact;

    @FindBy(linkText = "About us")
    WebElement linkAboutUs;

    @FindBy(linkText = "Cart")
    WebElement linkCart;

    @FindBy(linkText = "Log in")
    WebElement linkLogin;

    @FindBy(linkText = "Sign up")
    WebElement linkSignUp;

    @FindBy(linkText = "Log out")
    WebElement linkLogout;

    @FindBy(id = "nameofuser")
    WebElement linkWelcomeUser;

    public HomePage clickOnLogo() {
        clickElement(linkLogo);
        return new HomePage(driver);
    }

    public HomePage clickOnHome() {
        clickElement(linkHome);
        return new HomePage(driver);
    }

    public LoginPage clickOnLogin() {
        clickElement(linkLogin);
        return new LoginPage(driver);
    }

    public SignUpPage clickOnSignUp() {
        clickElement(linkSignUp);
        return new SignUpPage(driver);
    }

    public void clickOnLogout() {
        clickElement(linkLogout);
    }

    public CartPage clickOnCart() {
        clickElement(linkCart);
        return new CartPage(driver);
    }

    public boolean isWelcomeUserDisplayed() {
        visibilityWait(linkWelcomeUser);
        return linkWelcomeUser.isDisplayed();
    }

    public boolean isLoginDisplayed() {
        visibilityWait(linkLogin);
        return linkLogin.isDisplayed();
    }

    public boolean isSignUpDisplayed() {
        visibilityWait(linkSignUp);
        return linkSignUp.isDisplayed();
    }

    public boolean isLogoutDisplayed() {
        visibilityWait(linkLogout);
        return linkLogout.isDisplayed();
    }
}
