package com.outfittery.pages.mysettings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class PersonalInfoPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='editProfileLink ng-scope']")
    public WebElement editButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameInput;
    @FindBy(xpath = "//input[@name='surname']")
    public WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//select[@name='phoneCountryCode']")
    public WebElement countryCode;

    @FindBy(xpath = "//button[@name='submit']")
    public WebElement saveChangesButton;

    By nameErrorBy = By.xpath("//div[@class='user-info__firstname']//div[@class='errors ng-active']/p");

    By phoneNumberBy = By.xpath("//div[@class='user-info__phone']//div[@class='errors ng-active']/p");
    By lastNameBy = By.xpath("//div[@class='user-info__lastname']//div[@class='errors ng-active']/p");

    public PersonalInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(className = "user-block")
    public WebElement userBlock;

    public void waitForPageAppear() {

        WebDriverWait waiter = new WebDriverWait(driver, 2000);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='user-block__container']//form")));

    }

    public Map<String, String> getInformation() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("name", nameInput.getAttribute("value"));
        dataMap.put("lastName", lastNameInput.getAttribute("value"));
        dataMap.put("phoneNumber", phoneNumber.getAttribute("value"));
        dataMap.put("countryCode", getSelectedCountryCode());
        return dataMap;
    }

    private String getSelectedCountryCode() {
        scrollUntillView();
        countryCode.click();
        return countryCode.getAttribute("value");

    }

    public void scrollUntillView() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
    }

    public String getNameInputText() {
        return nameInput.getAttribute("value");
    }

    public String getLastNameInputText() {
        return lastNameInput.getAttribute("value");
    }

    public String getPhoneNumberInputText() {
        return phoneNumber.getAttribute("value");
    }


    public boolean errorPresentFor(String fieldName) {
        try {
            if (fieldName.equals("name")) {
                driver.findElement(nameErrorBy);
            } else if (fieldName.equals("phoneNumber")) {
                driver.findElement(phoneNumberBy);
            } else if (fieldName.equals("lastName")) {
                driver.findElement(lastNameBy);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public String getErrorTextForField(String fieldName) {
        String errorStr = "";
        try {
            if (fieldName.equals("name")) {
                errorStr = driver.findElement(nameErrorBy).getText();
            } else if (fieldName.equals("phoneNumber")) {
                errorStr = driver.findElement(phoneNumberBy).getText();
            } else if (fieldName.equals("lastName")) {
                errorStr = driver.findElement(lastNameBy).getText();
            }
            return errorStr;
        } catch (Exception e) {
            return "No error field/attribute found. Please check locator/element existing";
        }
    }

    public WebElement getCountryCodeElement(String countryCodeStr) {
        return countryCode.findElement(By.xpath("//option[@value='" + countryCodeStr + "']"));
    }
}
