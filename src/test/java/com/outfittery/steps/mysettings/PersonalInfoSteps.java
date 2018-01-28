package com.outfittery.steps.mysettings;

import com.outfittery.pages.mysettings.PersonalInfoPage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PersonalInfoSteps {
    private WebDriver driver;
    PersonalInfoPage personalInfoPage;

    public PersonalInfoSteps(WebDriver driver) {
        this.driver = driver;
        personalInfoPage = new PersonalInfoPage(driver);
    }

    public boolean sectionIsPresentInMySettings() {
        return personalInfoPage.userBlock.isDisplayed();
    }

    public void clickEdit() {
        personalInfoPage.editButton.click();
        //wait for edit menu opened
        personalInfoPage.waitForPageAppear();
    }

    public Map<String, String> saveInfoMap() {
        return personalInfoPage.getInformation();
    }

    public void enterName(String name) {
        personalInfoPage.nameInput.clear();
        personalInfoPage.nameInput.sendKeys(name);
    }

    public void enterLastName(String lastName) {
        personalInfoPage.lastNameInput.clear();
        personalInfoPage.lastNameInput.sendKeys(lastName);
    }

    public void enterPhoneNumber(String phoneNumber) {
        personalInfoPage.phoneNumber.clear();
        personalInfoPage.phoneNumber.sendKeys(phoneNumber);
    }

    public void clickSaveChangesButton() {
        personalInfoPage.saveChangesButton.click();
        personalInfoPage.waitForPageAppear();
    }

    public String getName() {
        return personalInfoPage.getNameInputText();
    }

    public String getLastName() {
        return personalInfoPage.getLastNameInputText();
    }

    public String getPhoneNumber() {
        return personalInfoPage.getPhoneNumberInputText();
    }

    public void setDataToPersonalInfo(Map<String, String> dataSaved) {
        enterName(dataSaved.get("name"));
        enterLastName(dataSaved.get("lastName"));
        enterPhoneNumber(dataSaved.get("phoneNumber"));
        setCountryCode(dataSaved.get("countryCode"));
        clickSaveChangesButton();
    }

    public boolean verifyThisIsMustErrorForFieldExists(String fieldName) {
        return personalInfoPage.errorPresentFor(fieldName);
    }

    public String getErrorTextForField(String fieldName) {
        return personalInfoPage.getErrorTextForField(fieldName);
    }

    public void setCountryCode(String countryCode) {
        personalInfoPage.countryCode.click();
        personalInfoPage.getCountryCodeElement(countryCode).click();
    }
}
