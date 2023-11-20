Feature:Testing Guru99 mercury tours with TestNG #goal
1)Valid Case
2)Invalid Case
Scenario Outline: To test signon fuctionality with valid and invalid data
@PositiveTesting
Scenario: To test the signon functionality with valid data
Given User should be in the signon page of guru99 mercurytours
And Enter the user name "user"
And Enter the Password "user"
When click on the submit button
When User should be in the "Login: Mercury Tours"
And Click on the register
And Enter the first name "abcd"
And Enter the last name "wxyz"
And Enter the phone number "1234567890"
And Enter the email id "abcd@example.com"
And Enter the address "qwerty"
And Enter the city "chennai"
And Enter the state or province "TN"
And Enter the postal code "654852"
And Select the country from drop down list
And Enter the username "user"
And Enter the password for this user "user"
And Enter the password again to confirm "user"
When Click on the submit button to register
Then User should be in "Register: Mercury Tours"
@NegativeTesting
Scenario: To test the signon functionality with invalid data
Given User should be in the signon page of guru99 mercurytours
And Enter the user name "user"
And Enter the Password "user123"
When click on the submit button
When User should be in the "Login: Mercury Tours"
And Click on the register
And Enter the first name "abcd"
And Enter the last name "wxyz"
And Enter the phone number "1234567890"
And Enter the email id "abcd@example.com"
And Enter the address "qwerty"
And Enter the city "chennai"
And Enter the state or province "TN"
And Enter the postal code "654852"
And Select the country from drop down list
And Enter the username "user"
And Enter the password for this user "user"
And Enter the password again to confirm "user123"
When Click on the submit button to register
Then User should be in "Register: Mercury Tours"