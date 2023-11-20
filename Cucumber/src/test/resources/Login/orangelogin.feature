Feature: Testing OrangeHRM #goal
Scenario: To test the login functionality
Given I should be in the login page of the OrangeHRM
And Enter the user name
And Enter the Password
When click on the login button
Then I should see the title as "OrangeHRM"