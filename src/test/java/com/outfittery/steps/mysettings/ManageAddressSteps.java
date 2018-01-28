package com.outfittery.steps.mysettings;

import com.outfittery.pages.mysettings.ManageAddressPage;
import com.outfittery.pages.mysettings.PersonalInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageAddressSteps {

    private WebDriver driver;
    ManageAddressPage manageAddressPage;

    public ManageAddressSteps(WebDriver driver) {
        this.driver = driver;
        manageAddressPage = new ManageAddressPage(driver);
    }

    public boolean sectionIsPresentInMySettings() {
        return manageAddressPage.manageAddressSection.isDisplayed();
    }

    public void clickAddNewAddressButton() {
        manageAddressPage.scrollUntillView();
        manageAddressPage.addNewAddressButtons.click();
    }

    public boolean onManageAddressesPage() {
        return manageAddressPage.editOrDeleteAddressButtons.size()>0;
    }

    public void clickManageAddressesButton() {
        manageAddressPage.scrollUntillView();
        manageAddressPage.manageAddressesButton.click();
        manageAddressPage.waitForPageAppear();
    }

    public boolean textPresentOnManageAddress(String text) {
        manageAddressPage.scrollUntillView();
        return manageAddressPage.getAllTextItemsFromAllAdresses().contains(text);
    }

    public void clickEditOrDeleteForUser(String userFirstLastName) {
        WebElement element = manageAddressPage.getEditOrDeleteButtonForUser(userFirstLastName);
        manageAddressPage.scrollUntillView(element);
        manageAddressPage.scrollUntillView();
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();
    }
}
