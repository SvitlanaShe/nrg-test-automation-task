package com.outfittery.pages.mysettings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ManageAddressPage {
    private WebDriver driver;

    @FindBy(className = "address-defaults")
    public WebElement manageAddressSection;

    @FindBy(xpath = "//div[@class='modify-address']")
    public List<WebElement> editOrDeleteAddressButtons;

    @FindBy(xpath = "//div[@class='address-list__item ng-scope']//p")
    List<WebElement> allAddressesItemsList;

    By editOrUpdateBUttonBy = By.xpath("//div[@class='modify-address']");

    @FindBy(xpath = "//button[contains(@ui-sref,'newAddress')]")
    public WebElement addNewAddressButtons;
    @FindBy(className = "manage-addresses")
    public WebElement manageAddressesButton;

    public ManageAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    public void scrollUntillView() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,750)");
    }

    public void scrollUntillView(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void waitForPageAppear() {
        WebDriverWait waiter = new WebDriverWait(driver, 2000);
        waiter.until(ExpectedConditions.presenceOfElementLocated(editOrUpdateBUttonBy));
    }

    public List<String> getAllTextItemsFromAllAdresses() {
        List<String> result = new ArrayList<>();
        allAddressesItemsList.forEach(item -> {
            result.add(item.getText());
        });
        return result;
    }

    public WebElement getEditOrDeleteButtonForUser(String userFirstLastName) {
        WebElement element = driver.findElements(
                By.xpath("//p[text()='" + userFirstLastName + "']/ancestor::div[contains(@class,'item')]//div[@class='modify-address']")
        ).get(0);
        return element;
    }
}
