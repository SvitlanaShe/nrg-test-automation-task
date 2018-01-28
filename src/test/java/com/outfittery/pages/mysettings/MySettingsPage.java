package com.outfittery.pages.mysettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySettingsPage {

    private WebDriver driver;

    By mySettingsTabBy = By.xpath("//*[@ui-sref='app.customerAccount.mySettings']");
    By userAvatarBy = By.xpath("//div[@class='user-block']//div[@class='ng-binding ng-scope']");

    @FindBy(xpath = "//*[@ui-sref='app.customerAccount.mySettings']")
    public WebElement mySettingsTab;

    public MySettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean mySettingsTabPresent() {

        return driver.findElements(mySettingsTabBy).size() > 0;
    }

    public boolean onMySettingsPage() {

        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.presenceOfElementLocated(userAvatarBy));

        return driver.findElements(userAvatarBy).size() == 1;
    }
}
