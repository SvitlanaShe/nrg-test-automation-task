package com.outfittery.pages.mysettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditOrDeleteAddressPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@name='submitBtn']")
    public WebElement addAddressButton;

    @FindBy(xpath = "//div[contains(@class,'address-form__delete')]")
    public WebElement deleteAddressButton;

    public EditOrDeleteAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

}
