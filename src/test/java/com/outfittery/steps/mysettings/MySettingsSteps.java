package com.outfittery.steps.mysettings;

import com.outfittery.pages.mysettings.MySettingsPage;
import com.outfittery.pages.mysettings.PersonalInfoPage;
import com.sun.deploy.util.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MySettingsSteps {

    private WebDriver driver;
    MySettingsPage mySettingsPage;

    public MySettingsSteps(WebDriver driver) {
        this.driver = driver;
        mySettingsPage = new MySettingsPage(driver);
    }

    public boolean verifyMySettingsTabOnPage() {
        return mySettingsPage.mySettingsTabPresent();
    }

    public boolean onMySettingsPage() {
        return mySettingsPage.onMySettingsPage();
    }

    public void clickMenuAndWaitPageToDownload() {
        mySettingsPage.mySettingsTab.click();
        onMySettingsPage();
    }
}
