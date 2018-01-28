package com.outfittery.steps;

import com.outfittery.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void clickCustomerLogin() {
        loginPage.customerLoginButton.click();
    }

    public boolean onLoginPage() {
        loginPage.waitForPageAppear();
        return  loginPage.onLoginPage();
    }

    public void clickLogin() {
        loginPage.scrollUntillView();
        loginPage.loginButton.click();
    }

    public void enterPassword(String password) {
        loginPage.password.clear();
        loginPage.password.sendKeys(password);
    }

    public void enterLogin(String login) {
        loginPage.login.clear();
        loginPage.login.sendKeys(login);
    }
}
