package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CartPage extends Page {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    Random random = new Random();
    int numOfProducts;
    int totalPrice = 0;

    @FindBy(linkText = "Delete")
    List<WebElement> linkDelete;

    @FindBy(xpath = "//tr[@class='success']/td[3]")
    List<WebElement> textPrice;

    @FindBy(id = "totalp")
    WebElement textTotalPrice;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement buttonPlaceOrder;

    @FindBy(id = "name")
    WebElement inputTextName;

    @FindBy(id = "country")
    WebElement inputTextCountry;

    @FindBy(id = "city")
    WebElement inputTextCity;

    @FindBy(id = "card")
    WebElement inputTextCard;

    @FindBy(id = "month")
    WebElement inputTextMonth;

    @FindBy(id = "year")
    WebElement inputTextYear;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement buttonPurchase;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElement textSuccessfulPurchase;

    @FindBy(css = ".lead.text-muted")
    WebElement textDataOfPurchase;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement buttonOk;

    public int getExpectedPrice() {
        visibilityWait(textPrice.get(0));
        for (WebElement price : textPrice) {
            totalPrice += Integer.parseInt(price.getText());
        }
        return totalPrice;
    }

    public int getActualPrice() {
        visibilityWait(textTotalPrice);
        return Integer.parseInt(textTotalPrice.getText());
    }


    public void deleteProduct() {
        numOfProducts = linkDelete.size();
        int index = random.nextInt(numOfProducts);
        totalPrice -= Integer.parseInt(textPrice.get(index).getText());
        clickElement(linkDelete.get(index));
    }

    public boolean isProductDeleted() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return numOfProducts > linkDelete.size();
    }

    public void clickOnPlaceOrder() {
        clickElement(buttonPlaceOrder);
    }

    public void enterPlaceOrderData(String name, String country, String city,
                                    String card, String month, String year) {
        sendText(inputTextName, name);
        sendText(inputTextCountry, country);
        sendText(inputTextCity, city);
        sendText(inputTextCard, card);
        sendText(inputTextMonth, month);
        sendText(inputTextYear, year);
    }

    public void clickOnPurchase() {
        clickElement(buttonPurchase);
    }

    public String getSuccessMessage() {
        visibilityWait(textSuccessfulPurchase);
        return textSuccessfulPurchase.getText();
    }

    public boolean areTheRightDataAppear(String card, String name) {
        return textDataOfPurchase.getText().contains(String.valueOf(totalPrice))
                && textDataOfPurchase.getText().contains(card)
                && textDataOfPurchase.getText().contains(name);
    }

    public HomePage clickOnOk() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickElement(buttonOk);
        return new HomePage(driver);
    }



}
