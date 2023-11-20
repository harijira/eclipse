Feature: Testing OrangeHRM #goal
1) Valid Case
2) Invalid Case
Scenario Outline: To login test login fuctionality with valid and invalid data
@PositiveTesting
Scenario: To test the login functionality
Given I should be in the login page of the OrangeHRM
And Enter the user name "<Admin>"
And Enter the Password "<admin123>"
When click on the login button
Then I should see the title as "OrangeHRM"
@NegativeTesting
Scenario: To test the login functionality
Given I should be in the login page of the OrangeHRM
And Enter the user name "<admin>"
And Enter the Password "<admin456>"
When click on the login button
Then I should see the title as "OrangeHRM"