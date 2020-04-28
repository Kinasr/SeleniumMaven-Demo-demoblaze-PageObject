package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 15);
    }

    protected void visibilityWait(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void alertWait() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendText(WebElement element, String text) {
        visibilityWait(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getAlertMessage() {
        alertWait();
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        alertWait();
        driver.switchTo().alert().accept();
    }

}
