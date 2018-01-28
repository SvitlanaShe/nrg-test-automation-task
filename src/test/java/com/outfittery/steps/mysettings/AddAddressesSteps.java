package com.outfittery.steps.mysettings;

import com.outfittery.pages.mysettings.AddAddressPage;
import com.outfittery.pages.mysettings.ChangePasswordPage;
import org.openqa.selenium.WebDriver;

public class AddAddressesSteps {
    private WebDriver driver;
    AddAddressPage addAddressPage;

    public AddAddressesSteps(WebDriver driver) {
        this.driver = driver;
        addAddressPage = new AddAddressPage(driver);
    }

    public void enterFirstName(String firstName) {
        addAddressPage.firstName.clear();
        addAddressPage.firstName.sendKeys(firstName);
    }

    public void enterSecondName(String secondName) {
        addAddressPage.secondName.clear();
        addAddressPage.secondName.sendKeys(secondName);
    }

    public void enterCO(String co) {
        addAddressPage.co.click();
        addAddressPage.co.clear();
        addAddressPage.co.sendKeys(co);
    }

    public void selectCOType(String coType) {
        addAddressPage.coTypeElement.click();
        addAddressPage.getElementCOType(coType).click();
    }

    public void enterStreet(String street) {
        addAddressPage.street.clear();
        addAddressPage.street.sendKeys(street);
    }

    public void enterNo(String no) {
        addAddressPage.no.clear();
        addAddressPage.no.sendKeys(no);
    }

    public void enterZip(String zip) {
        addAddressPage.postalCode.clear();
        addAddressPage.postalCode.sendKeys(zip);
    }

    public void enterCity(String city) {
        addAddressPage.city.clear();
        addAddressPage.city.sendKeys(city);
    }

    public void selectCountry(String country) {
        addAddressPage.scrollUntillView();
        addAddressPage.country.click();
        addAddressPage.getElementCountryCode(country).click();
    }

    public void clickAddNewAddressButton() {
        addAddressPage.scrollUntillView(addAddressPage.addNewAddressButton);
        addAddressPage.addNewAddressButton.click();
    }
}
