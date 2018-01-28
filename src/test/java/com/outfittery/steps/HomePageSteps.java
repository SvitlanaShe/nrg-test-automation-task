package com.outfittery.steps;

import com.outfittery.base.BaseTest;
import com.outfittery.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    private WebDriver driver;
    HomePage home;

    public HomePageSteps(WebDriver driver) {
        this.driver = driver;
        home = new HomePage(driver);
    }

    public boolean onHomePage() {
        return home.onHomePage();
    }
}
