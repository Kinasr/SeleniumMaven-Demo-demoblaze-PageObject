package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;

public class HomePage extends Page{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.carousel-item.active img")
    WebElement parentActiveImg;

    @FindBy(css = "img[alt='First slide']")
    WebElement firstSlide;

    @FindBy(css = "img[alt='Second slide']")
    WebElement secondSlide;

    @FindBy(css = "img[alt='Third slide']")
    WebElement thirdSlide;

    @FindBy(css = "a[data-slide='next']")
    WebElement arrowRight;

    @FindBy(css = "a[data-slide='prev']")
    WebElement arrowLeft;

    @FindBy(linkText = "CATEGORIES")
    WebElement linkCategories;

    @FindBy(linkText = "Phones")
    WebElement linkPhones;

    @FindBy(linkText = "Laptops")
    WebElement linkLaptops;

    @FindBy(linkText = "Monitors")
    WebElement linkMonitors;

    @FindBy(linkText = "Samsung galaxy s6")
    WebElement linkSamsungGalaxyS6;

    @FindBy(linkText = "MacBook Pro")
    WebElement linkMacBookPro;

    @FindBy(linkText = "ASUS Full HD")
    WebElement linkASUSFullHD;

    @FindBy(id = "next2")
    WebElement buttonNextPage;

    public void rightSlider() {
        clickElement(arrowRight);
    }

    public void leftSlider() {
        clickElement(arrowLeft);
    }

    public void clickOnCategories() {
        clickElement(linkCategories);
    }

    public void clickOnPhones() {
        clickElement(linkPhones);
    }

    public void clickOnLaptops() {
        clickElement(linkLaptops);
    }

    public void clickOnMonitors() {
        clickElement(linkMonitors);
    }

    public void clickOnNext () {
        clickElement(buttonNextPage);
    }

    public PDPage clickOnSamsungGalaxyS6() {
        clickElement(linkSamsungGalaxyS6);
        return new PDPage(driver);
    }

    public PDPage clickOnMacBookPro() {
        clickElement(linkMacBookPro);
        return new PDPage(driver);
    }

    public PDPage clickOnASUSFullHD() {
        clickElement(linkASUSFullHD);
        return new PDPage(driver);
    }

    public String getActiveImage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return parentActiveImg.getAttribute("alt");
    }

    public boolean isSamsungGalaxyS6Exists() {
        visibilityWait(linkSamsungGalaxyS6);
        return linkSamsungGalaxyS6.isDisplayed();
    }

    public boolean isMacBookProExists() {
        visibilityWait(linkMacBookPro);
        return linkMacBookPro.isDisplayed();
    }

    public boolean isASUSFullHDExists() {
        visibilityWait(linkASUSFullHD);
        return linkASUSFullHD.isDisplayed();
    }

    public boolean isFirstSlideDisplayed() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return firstSlide.isDisplayed();
    }

    public boolean isSecondSlideDisplayed() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return secondSlide.isDisplayed();
    }

    public boolean isThirdSlideDisplayed() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return thirdSlide.isDisplayed();
    }

    public String getUrl() {
        visibilityWait(linkCategories);
        return driver.getCurrentUrl();
    }
}
