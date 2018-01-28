package com.outfittery.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    By byLogin = By.xpath("//h4[@class=\"mt-md\"]");

    @FindBy(xpath = "//a[@class='login open-login']")
    public WebElement customerLoginButton;

    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement login;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    By passwordBy = By.xpath("//input[@id='password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    public boolean onLoginPage() {
        return driver.findElements(byLogin).size() > 0;
    }

    public void waitForPageAppear() {

        WebDriverWait waiter = new WebDriverWait(driver, 2000);
        waiter.until(ExpectedConditions.presenceOfElementLocated(passwordBy));

    }

    public void scrollUntillView() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
    }
}
