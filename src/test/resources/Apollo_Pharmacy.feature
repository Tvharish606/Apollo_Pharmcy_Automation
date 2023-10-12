Feature: Apollo_Pharmacy_options

  Scenario: user able to check all the Apollo_Pharmacy options
    Given Open the browser and enter the url
    When user entered valid user name and click on next button
    And user entered the valid OTP and click on Sign_up button
    When user click on Drinks options juices Apollo_Prdoucts_module
    Then check wheather Drinks page is displayed

 Scenario: user able to check all the Apollo_Pharmacy options   
 
 Given Open the browser and enter the url
    When user entered valid user name and click on next button
    And user entered the valid OTP and click on Sign_up button
    When user click on ORS drinks options under Apollo_Prdoucts_module
    Then check wheather ORS_Drinks page is displayed
 