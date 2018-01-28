package com.outfittery.pages.mysettings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordPage {

    private WebDriver driver;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@class='container change-password']")
    public WebElement changePasswordSection;

    @FindBy(xpath = "//a[@translate='components.changePassword.title']/..")
    public WebElement changePasswordButton;

    @FindBy(xpath = "//input[@placeholder='Current password']")
    public WebElement oldPW;

    @FindBy(xpath = "//input[@name='newPW']")
    public WebElement newPW;

    @FindBy(xpath = "//input[@name='confirmNewPW']")
    public WebElement confirmNewPW;

    @FindBy(xpath = "//div[@ng-messages='pwForm.oldPW.$error']//p")
    public WebElement oldPWError;

    @FindBy(xpath = "//div[@ng-messages='pwForm.newPW.$error']//p")
    public WebElement newPWError;

    @FindBy(xpath = "//*[@ng-show='$ctrl.confirmMismatch()'][@class='ng-scope']/../p")
    public WebElement confirmNewPWError;

    @FindBy(xpath = "//button[@name='submit']")
    public WebElement saveChangesButton;
    By oldPWBy = By.xpath("//input[@name='oldPW']");

    public void scrollUntillView() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
    }

    public void waitForPageAppear() {

        WebDriverWait waiter = new WebDriverWait(driver, 2000);
        waiter.until(ExpectedConditions.presenceOfElementLocated(oldPWBy));

    }

    public void scrollUntillViewChangePasswordButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(changePasswordButton);
        actions.perform();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", changePasswordButton);
    }

    //To DO
    public void deleteAttributeDisabled() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(
                "arguments[0].removeAttribute(\"disabled\")", saveChangesButton);
        executor.executeScript("arguments[0].click();", saveChangesButton);
    }
}
