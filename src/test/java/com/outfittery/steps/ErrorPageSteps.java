package com.outfittery.steps;

import com.outfittery.pages.ErrorPage;
import com.outfittery.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ErrorPageSteps {
    private WebDriver driver;
    ErrorPage errorPage;

    public ErrorPageSteps(WebDriver driver) {
        this.driver = driver;
        errorPage = new ErrorPage(driver);
    }

    public int getErrorsFromPage() {
        return errorPage.error.size();
    }
}
