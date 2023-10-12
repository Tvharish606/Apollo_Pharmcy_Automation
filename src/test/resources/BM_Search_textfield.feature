Feature: 
  BM_Search_textfield

  Scenario Outline: User able login to Apollo pharmacy Application using valid creditional
    Given when User open the browser and enter the url
    When User click on Login funcationality icon
    And Enter the <Phone number> and click on next icon
    And Enter the valid OTP pin and click on next icon
    Then Check wheather user able to see the Login page

    Examples: 
      | Phone number |
      | "8660463204" |

  Scenario Outline: 
    : user able to see the searched results output in main page
    User able login to Apollo pharmacy Application using valid creditional

    Given when User open the browser and enter the url
    When User click on Login funcationality icon
    And Enter the <Phone number> and click on next icon
    And Enter the valid OTP pin and click on next icon
    Given user click on search textfield
    And enter the Medicines and click on X button
    Then check wheather the searched results displayed

    Examples: 
      | Phone number |
      | "8660463204" |
 
 Scenario Outline: User able to add the item to cart 
    Given when User open the browser and enter the url
    When User click on Login funcationality icon
    And Enter the <Phone number> and click on next icon
    And Enter the valid OTP pin and click on next icon
    And user moves to Hansaplast Wound and Pain Management Range
    And Select the 2nd item and add it to view cart
    Then check wheather the added item is displayed in view cart
    Examples: 
      | Phone number |
      | "8660463204" |     
      
 
