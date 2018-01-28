package com.outfittery.steps.mysettings;

import com.outfittery.pages.mysettings.ChangePasswordPage;
import com.outfittery.pages.mysettings.PersonalInfoPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ChangePasswordSteps {

    private WebDriver driver;
    ChangePasswordPage changePasswordPage;

    public ChangePasswordSteps(WebDriver driver) {
        this.driver = driver;
        changePasswordPage = new ChangePasswordPage(driver);
    }

    public boolean sectionIsPresentInMySettings() {
        changePasswordPage.scrollUntillView();
        return changePasswordPage.changePasswordSection.isDisplayed();
    }

    public void clickChangePasswordButton() {
        changePasswordPage.scrollUntillViewChangePasswordButton();
//        changePasswordPage.changePasswordButton.click();
        changePasswordPage.waitForPageAppear();
    }

    public void setOldPW(String oldPW) {
        changePasswordPage.oldPW.clear();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].setAttribute('value', '" + oldPW +"')", changePasswordPage.oldPW);
    }
    public void setNewPW(String newPW) {
        changePasswordPage.newPW.clear();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].setAttribute('value', '" + newPW +"')", changePasswordPage.newPW);
    }
    public void setConfirmNewPW(String confirmNewPW) {
        changePasswordPage.confirmNewPW.clear();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].setAttribute('value', '" + confirmNewPW +"')", changePasswordPage.confirmNewPW);

    }
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    public boolean saveChangesButtonDisabled() {
        changePasswordPage.scrollUntillView();
        return changePasswordPage.saveChangesButton.getAttribute("disabled").equals("true");
    }

    public void clickSaveChangesButton() {
//        changePasswordPage.scrollUntillView();
        changePasswordPage.deleteAttributeDisabled();
        changePasswordPage.saveChangesButton.click();
    }

}
