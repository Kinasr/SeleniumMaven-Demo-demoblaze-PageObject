package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "loginusername")
    WebElement textInputUsername;

    @FindBy(id = "loginpassword")
    WebElement textInputPassword;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement buttonLogin;

    @FindBy(xpath = "(//button[contains(text(),'Close')])[3]")
    WebElement buttonClose;

    public void login(String username, String password) {
        sendText(textInputUsername, username);
        sendText(textInputPassword, password);
        clickElement(buttonLogin);
    }
}
