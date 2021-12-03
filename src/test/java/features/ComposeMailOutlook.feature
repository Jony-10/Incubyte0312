Feature: Compose a mail in outlook
  Scenario Outline: Login to outlook and send a mail
    Given I am at outlook homepage
    When I click on the Sign In button
    Then Outlook sign in page is displayed
    When I enter a valid "<email>" and click on the Submit button
    And I enter a valid "<password>" and click on the Submit button
    And I select Yes for remember me
    Then Outlook inbox page should be displayed
    When I click on the Compose Button
    Then New mail page should be displayed in screen
    When I enter "<to>", "<subject>", "<body>" into respective fields
    Then I verify "<to>", "<subject>", "<body>" fields value based on my last input

    Examples:
      |email                     |password          |  to               |   subject     |         body                  |
      |testitforme01@outlook.com |Password@Random99 | test123@gmail.com|   Incubyte    |Automation QA test for Incubyte|