package com.outfittery.pages.mysettings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddAddressPage {

    private WebDriver driver;
    @FindBy(xpath = "//input[@name='firstName']")

    public WebElement firstName;
    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement secondName;
    @FindBy(xpath = "//input[@name='co']")
    public WebElement co;
    @FindBy(xpath = "//select[@name='coType']")
    public List<WebElement> coType;
    @FindBy(xpath = "//select[@name='coType']")
    public WebElement coTypeElement;
    @FindBy(xpath = "//input[@name='street']")
    public WebElement street;
    @FindBy(xpath = "//input[@name='number']")
    public WebElement no;

    @FindBy(xpath = "//input[@name='zip']")
    public WebElement postalCode;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;

    @FindBy(xpath = "//select[@name='countryCode']")
    public WebElement country;

    @FindBy(xpath = "//div[@class='address-form__checkboxes']//div[1]//label")
    public WebElement shippingCheckBox;

    @FindBy(xpath = "//div[@class='address-form__checkboxes']//div[2]//label")
    public WebElement billingCheckBox;

    @FindBy(xpath = "//button[contains(@ui-sref,'newAddress')]")
    public WebElement addNewAddressButton;

    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getElementCOType(String coTypeText) {
        return coTypeElement.findElement(By.xpath("//option[@label='" + coTypeText + "']"));
    }

    public void scrollUntillView() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
    }

    public void scrollUntillView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement getElementCountryCode(String coTypeText) {
        return country.findElement(By.xpath("//option[text()='" + coTypeText + "']"));
    }
}
