Feature: 
  Login_APLM

  Scenario Outline: user able login to Apollo pharmacy application using valid creditional
    Given when user open the browser and enter the url
    When user click on login funcationality icon
    And enter the <phone number> and click on next icon
    And enter the valid OTP pin and click on next icon
    Then check wheather user able to see the login page

    Examples: 
      | phone number |
      | "8660463204" |
