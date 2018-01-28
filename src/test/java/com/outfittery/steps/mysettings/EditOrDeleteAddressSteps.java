package com.outfittery.steps.mysettings;

import com.outfittery.pages.mysettings.EditOrDeleteAddressPage;
import org.openqa.selenium.WebDriver;

public class EditOrDeleteAddressSteps {
    private WebDriver driver;
    EditOrDeleteAddressPage addressPage;

    public EditOrDeleteAddressSteps(WebDriver driver) {
        this.driver = driver;
        addressPage = new EditOrDeleteAddressPage(driver);
    }

    public void clickAddAddressButton() {
        addressPage.addAddressButton.click();
    }

    public void clickDeleteButton() {
        addressPage.deleteAddressButton.click();
    }
}
