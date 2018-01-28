Feature: My Settings features
  As a user
  In order to check my settings functionality
  I want to test personal info, manage addresses and change password

  Background:
    Given on main page
    When click button "Customer Login"
    And "Login page" is opened
    And enter email "svitlana.shepotilova@test.com"
    And enter password "1234qwer"
    And click button "login"
    Then user is logged in
    And opened url is "dashboard"
    When click menu item "My Settings"
    Then "My Settings" is opened

  @Positives
  @MySettings
  Scenario: Verify My Settings page sections are present
    When "My Settings" is opened
    Then sections "Personal info","Manage address", "Manage password" are present

  @Positive
  @MySettings
  Scenario: Verify user information could be updated: name, last name, phone number, country code
    When click button "EditPersonalInfo"
    And save current information
    And set user name "Updated"
    And set user last name "Updated"
    And set user phone number "44444444444"
    And set user country code "+90"
    And click button "SaveChanges"
    And click button "EditPersonalInfo"
    Then user name is "Updated"
    And user last name is "Updated"
    And user phone number is "44444444444"
    And set saved data to personal info

  @Negative
  @MySettings
  Scenario: Verify error on save when incorrect data entered as personal information
    When click button "EditPersonalInfo"
    And save current information
    And set user name "~~~~~~"
    And set user last name "~~~~~~"
    And set user phone number "~~~~~~"
    And click button "SaveChanges"
  Then Error message appears

  @Negative
  @MySettings
  Scenario: Verify "This is must!" when empty mandatory field name
    When click button "EditPersonalInfo"
    And set user name ""
    Then "This is a must!" Error for "name"

  @Negative
  @MySettings
  Scenario: Verify "This is must!" when empty mandatory field phone number
    When click button "EditPersonalInfo"
    And set user phone number ""
    Then "This is a must!" Error for "phoneNumber"

  @Negative
  @MySettings
  @Jira
  @ShouldFail
  Scenario: Verify "This is must!" when empty mandatory field last name
    When click button "EditPersonalInfo"
    And set user last name ""
    Then "This is a must!" Error for "lastName"

  @Negative
  @MySettings
  Scenario: Verify Too long Error when set too long text to name field (>255)
    When click button "EditPersonalInfo"
    And set user name "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sed varius tellus, tincidunt commodo odio. Donec gravida efficitur metus ac fringilla. Morbi placerat egestas ultricies. Nulla convallis dolor et ullamcorper luctus. Donec nec ante eu eros sed."
    Then "A bit too long, please check again." Error for "name"

  @Negative
  @MySettings
  @Jira
  @ShouldFail
  Scenario: Verify Too long Error when set too long text to last name field (>255)
    When click button "EditPersonalInfo"
    And set user last name "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sed varius tellus, tincidunt commodo odio. Donec gravida efficitur metus ac fringilla. Morbi placerat egestas ultricies. Nulla convallis dolor et ullamcorper luctus. Donec nec ante eu eros sed."
    Then "A bit too long, please check again." Error for "lastName"

  @Negative
  @MySettings
  Scenario: Verify Too long Error when set too long text to name field (>25)
    When click button "EditPersonalInfo"
    And set user phone number "Lorem ipsum dolor sit ame."
    Then "A bit too long, please check again." Error for "phoneNumber"

  @Positive
  @MySettings
  Scenario: Verify no Error when set text to phone field (length==25)
    When click button "EditPersonalInfo"
    And set user phone number "Lorem ipsum dolor sit am."
    Then no Error for "phoneNumber"


  @Positive
  @MySettings
  @ChangePassword
  Scenario: Password could be changed
    When click button "Change Password"
    And enter old password "1234qwer"
    And enter new password "1234asdf"
    And enter confirm new password "1234asdf"
#    And click button "Save Changes" password
##    Then successful message appears
#
  @Negative
  @MySettings
    @ChangePassword
  Scenario: Save Changes button inactive when empty passwords inputs
    When click button "Change Password"
    Then button "Save Changes" is inactive


    @Positive
    @MySettings
    @ManageAddresses
    @AddAddress
    Scenario: Address could be added. entry data: Svitlana Shepotilova, only one default address
      When click button "Manage Addresses"
      And click button "Add new Address"
      And enter First Name "Test"
      And enter Second Name "Second Test"
    And enter c/o "test"
    And select c/o type "Private"
    And enter Street "Test Street"
  And enter No "25"
  And enter Postal Code "435678"
  And enter City "TestCity"
  And select Country "Danmark"
  And click button "Add address"
  Then verify on manage addresses page
      And verify text present on manage address page "Test Second Test"
      And verify text present on manage address page "Test Street 25"
      And verify text present on manage address page "c/o test, private"
      And verify text present on manage address page "435678 TestCity"
      And verify text present on manage address page "Danmark"

#  To Do - implement clean up!

