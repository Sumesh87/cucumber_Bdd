Feature: As a user login with valid and invalid credentials


  @firefox
  Scenario: To validate login with valid credentials using chrome
    Given User has launched the url "https://www.saucedemo.com/"
    When user logged in with valid credentials as below
      | userName | password|
      | standard_user| secret_sauce|
    And user clicked login
    Then User should be navigated to home page
