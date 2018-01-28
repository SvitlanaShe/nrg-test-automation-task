package com.outfittery.tests;

import com.outfittery.base.BaseTest;
import com.outfittery.steps.ErrorPageSteps;
import com.outfittery.steps.HomePageSteps;
import com.outfittery.steps.LoginSteps;
import com.outfittery.steps.mysettings.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class MySettingsTests extends BaseTest{
    private static final Logger LOGGER = Logger.getLogger(LoginSteps.class.getName());

    private HomePageSteps homePage;
    private LoginSteps login;
    private ChangePasswordSteps changePassword;
    private ManageAddressSteps manageAddress;
    private MySettingsSteps mySettings;
    private PersonalInfoSteps personalInfo;

    @Given("^on main page$")
    public void on_main_page() throws Throwable {
        homePage = new HomePageSteps(driver);
        assertTrue(homePage.onHomePage());
        login = new LoginSteps(driver);
        LOGGER.info("Main Page is opened ");
    }

    @Before
    public void startup(){
        setUp();
    }

    @After
    public void shutdown() throws Throwable {
        driver_quite();
    }

    @Given("^driver quite$")
    public void driver_quite() throws Throwable {
        tearDown();
        LOGGER.info("WebDriver quite");
    }

    @When("^click button \"([^\"]*)\"$")
    public void click_button(String buttonName) throws Throwable {
        LOGGER.info("Button " + buttonName + " to click");
        switch (buttonName)
        {
            case "Customer Login":
            case "customer login":
                login.clickCustomerLogin();
                break;
            case "Login":
            case "login":
                login = new LoginSteps(driver);
                login.clickLogin();

                break;
            case "EditPersonalInfo":
                personalInfo = new PersonalInfoSteps(driver);
                personalInfo.clickEdit();
                break;
            case "SaveChanges":
                personalInfo = new PersonalInfoSteps(driver);
                personalInfo.clickSaveChangesButton();
                break;
            case "Change Password":
                ChangePasswordSteps changePasswordSteps = new ChangePasswordSteps(driver);
                changePasswordSteps.clickChangePasswordButton();
                break;
            case "Save Changes":
                changePassword = new ChangePasswordSteps(driver);
                changePassword.clickSaveChangesButton();
                break;
            case "Add new Address":
                addAddressesSteps = new AddAddressesSteps(driver);
                addAddressesSteps.clickAddNewAddressButton();
                break;
            case "Add address":
                EditOrDeleteAddressSteps editOrDeleteAddressSteps = new EditOrDeleteAddressSteps(driver);
                editOrDeleteAddressSteps = new EditOrDeleteAddressSteps(driver);
                editOrDeleteAddressSteps.clickAddAddressButton();
                break;
            case "Manage Addresses":
                manageAddress = new ManageAddressSteps(driver);
                manageAddress.clickManageAddressesButton();
                break;
//            case "Edit or delete address":
//                editOrDeleteAddressSteps = new EditOrDeleteAddressSteps(driver);
//                editOrDeleteAddressSteps.clickEditOrDeleteButton();
//                break;
            case "Delete Address":
                editOrDeleteAddressSteps = new EditOrDeleteAddressSteps(driver);
                editOrDeleteAddressSteps.clickDeleteButton();
                break;
            default:
                break;
        }

    }

    @When("^opened url is \"([^\"]*)\"$")
    public void opened_url_is(String urlToCheck) throws Throwable {
        LOGGER.info("Verify opened url by partial text ");
        assertTrue(driver.getCurrentUrl().contains(urlToCheck));
    }

    @When("^enter email \"([^\"]*)\"$")
    public void enter(String email) throws Throwable {
        LOGGER.info("Enter login ");
        login.enterLogin(email);

    }

    @When("^enter password \"([^\"]*)\"$")
    public void enter_user(String password) throws Throwable {
        LOGGER.info("Enter password ");
        login.enterPassword(password);
    }

    @When("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        LOGGER.info("Check My Settings present on page, so user is logged in ");
        mySettings = new MySettingsSteps(driver);
        assert mySettings.verifyMySettingsTabOnPage();
    }

    @When("^click menu item \"([^\"]*)\"$")
    public void click_menu_item(String menu) throws Throwable {
        LOGGER.info("Click on tab " + menu);
        switch (menu){
            case "My Settings":
                mySettings.clickMenuAndWaitPageToDownload();
                break;
            default:
                break;
        }
    }

    @Then("^\"([^\"]*)\" is opened$")
    public void is_opened(String pageName) throws Throwable {
        LOGGER.info("Verify page opened: " + pageName);
        switch (pageName){
            case "Login page":
                assertTrue(login.onLoginPage());
                break;
            case "My Settings":
                assertTrue(mySettings.onMySettingsPage());
                break;
            default:
                assertTrue("Incorrect opened page in test. Please check it out.", false);
                break;
        }
}
//    ManageAddressSteps manageAddressSteps;
    ChangePasswordSteps passwordSteps;

    @Then("^sections \"(.*)\" are present$")
    public void sections_are_present(List<String> items) throws Throwable {
        LOGGER.info("Check items on page present: " + items);
       items.forEach(item -> {
           if(item.contains("info"))
           {
               personalInfo = new PersonalInfoSteps(driver);
               assertTrue("Section Personal Info is missing on MySettings page! ",
                       personalInfo.sectionIsPresentInMySettings());
           }
           else if(item.contains("address"))
           {
               manageAddress = new ManageAddressSteps(driver);
               assertTrue("Section Manage Address is missing on MySettings page! ",
                       manageAddress.sectionIsPresentInMySettings());
           }
           else if(item.contains("password"))
           {
               passwordSteps = new ChangePasswordSteps(driver);
               assertTrue("Section Change Password is missing on MySettings page! ",
                       passwordSteps.sectionIsPresentInMySettings());

           }
       });
    }

    Map<String,String> dataSaved;
    @When("^save current information$")
    public void save_current_information() throws Throwable {
        dataSaved = new HashMap<>();
        dataSaved = personalInfo.saveInfoMap();
        LOGGER.info("data saved: " + dataSaved);
    }

    @Then("^set saved data to personal info$")
    public void set_saved_data_to_personal_info() throws Throwable {
        personalInfo.setDataToPersonalInfo(dataSaved);
    }
    @When("^set user name \"([^\"]*)\"$")
    public void set_user_name(String name) throws Throwable {
        personalInfo = new PersonalInfoSteps(driver);
        personalInfo.enterName(name);
    }

    @When("^set user last name \"([^\"]*)\"$")
    public void set_user_last_name(String lastName) throws Throwable {
        personalInfo = new PersonalInfoSteps(driver);
        personalInfo.enterLastName(lastName);
    }

    @When("^set user phone number \"([^\"]*)\"$")
    public void set_user_phone_number(String phoneNumbefr) throws Throwable {
        personalInfo = new PersonalInfoSteps(driver);
        personalInfo.enterPhoneNumber(phoneNumbefr);
    }

    @When("^set user country code \"([^\"]*)\"$")
    public void set_another_user_country_code(String countryCode) throws Throwable {
        personalInfo.setCountryCode(countryCode);
    }

    @Then("^user name is \"([^\"]*)\"$")
    public void user_name_is(String name) throws Throwable {
        Assert.assertEquals("Names mismatched !",
                personalInfo.getName(),name);
    }

    @Then("^user last name is \"([^\"]*)\"$")
    public void user_last_name_is(String lastName) throws Throwable {
        Assert.assertEquals("Last names mismatched !",
                personalInfo.getLastName(),lastName);
    }

    @Then("^user phone number is \"([^\"]*)\"$")
    public void user_phone_number_is(String phoneNumber) throws Throwable {
        Assert.assertEquals("Phone numbers mismatched !",
                personalInfo.getPhoneNumber(),phoneNumber);
    }

    @Then ("^Error message appears$")
    public void error_message_appears() {
        ErrorPageSteps errorPage = new ErrorPageSteps(driver);
        Assert.assertTrue("No errors on the page!, error should be present",
                errorPage.getErrorsFromPage() > 0);

    }

    @Then ("^\"([^\"]*)\" Error for \"([^\"]*)\"$")
    public void this_is_must_error_for(String errorStr, String fieldName)
    {
        Assert.assertEquals(errorStr,personalInfo.getErrorTextForField(fieldName));
    }

ChangePasswordSteps changePasswordSteps;
    @When("^enter old password \"([^\"]*)\"$")
    public void enter_old_password(String oldPW) throws Throwable {
        changePasswordSteps = new ChangePasswordSteps(driver);
        changePasswordSteps.setOldPW(oldPW);
    }

    @When("^enter new password \"([^\"]*)\"$")
    public void enter_new_password(String newPW) throws Throwable {
        changePasswordSteps = new ChangePasswordSteps(driver);
        changePasswordSteps.setNewPW(newPW);
    }

    @When("^enter confirm new password \"([^\"]*)\"$")
    public void enter_confirm_new_password(String confirmNewPW) throws Throwable {
        changePasswordSteps = new ChangePasswordSteps(driver);
        changePasswordSteps.setConfirmNewPW(confirmNewPW);
        Thread.sleep(15000l);
    }

    @Then("^button \"([^\"]*)\" is inactive$")
    public void button_is_inactive(String buttonName) throws Throwable {
        changePasswordSteps = new ChangePasswordSteps(driver);
        switch (buttonName){
            case "Save Changes":
                Assert.assertTrue(changePasswordSteps.saveChangesButtonDisabled());
                break;
            default:
                LOGGER.error("Please enter correct button name");
                Assert.fail("Please check button name");
                break;

        }
    }
    @When("^click button \"([^\"]*)\" password$")
    public void click_button_password(String buttonName) throws Throwable {
        changePasswordSteps.clickSaveChangesButton();
    }

    @Then("^no Error for \"([^\"]*)\"$")
    public void no_Error_for(String fieldName) throws Throwable {
        switch (fieldName)
        {
            case "phoneNumber":
                personalInfo = new PersonalInfoSteps(driver);
                Assert.assertEquals(personalInfo.getErrorTextForField(fieldName),
                        "No error field/attribute found. Please check locator/element existing");
                break;
            default:
                Assert.fail("Please add correct field name! ");
                break;
        }
    }
//-------section manage addresses

    EditOrDeleteAddressSteps editOrDeleteAddressSteps;
    AddAddressesSteps addAddressesSteps;
    @When("^enter First Name \"([^\"]*)\"$")
    public void enter_First_Name(String firstName) throws Throwable {
        addAddressesSteps.enterFirstName(firstName);
    }

    @When("^enter Second Name \"([^\"]*)\"$")
    public void enter_Second_Name(String secondName) throws Throwable {
        addAddressesSteps.enterSecondName(secondName);
    }

    @When("^enter c/o \"([^\"]*)\"$")
    public void enter_co(String co) throws Throwable {
        addAddressesSteps.enterCO(co);
    }

    @When("^select c/o type \"([^\"]*)\"$")
    public void select_co_type( String coType) throws Throwable {
        addAddressesSteps.selectCOType(coType);
    }


    @When("^enter Street \"([^\"]*)\"$")
    public void enter_Street(String street) throws Throwable {
        addAddressesSteps.enterStreet(street);
    }

    @When("^enter No \"([^\"]*)\"$")
    public void enter_No(String no) throws Throwable {
        addAddressesSteps.enterNo(no);
    }

    @When("^enter Postal Code \"([^\"]*)\"$")
    public void enter_Postal_Code(String zip) throws Throwable {
        addAddressesSteps.enterZip(zip);
    }

    @When("^enter City \"([^\"]*)\"$")
    public void enter_City(String city) throws Throwable {
        addAddressesSteps.enterCity(city);
    }

    @When("^select Country \"([^\"]*)\"$")
    public void select_Country(String country) throws Throwable {
        addAddressesSteps.selectCountry(country);
    }

    @Then("^verify on manage addresses page$")
    public void verify_on_manage_addresses_page() throws Throwable {
        manageAddress = new ManageAddressSteps(driver);
        assertTrue(manageAddress.onManageAddressesPage());
    }

    @Then("^verify text present on manage address page \"([^\"]*)\"$")
    public void verify_text_present(String text) throws Throwable {
        assertTrue(manageAddress.textPresentOnManageAddress(text));
    }

    @Then("^click button Edit or Delete for user \"([^\"]*)\"$")
    public void click_button_for_user( String userFirstLastName) throws Throwable {
        manageAddress.clickEditOrDeleteForUser(userFirstLastName);
    }

}
