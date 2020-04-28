package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PDPage extends Page{
    public PDPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "name")
    WebElement tagProductName;

    @FindBy(linkText = "Add to cart")
    WebElement linkAddToCart;

    public void clickOnAddToCart() {
        clickElement(linkAddToCart);
    }

    public String getProductTagName() { return tagProductName.getText(); }
}
