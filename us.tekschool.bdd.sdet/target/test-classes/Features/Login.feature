@loginAndLogout
Feature: Login to Test Environment

Background:

Given User is on TEST Environment page

@loginTest
Scenario: Login to MyAccount
When User click on MyAccount
And User click on Login
And User enters username 'sdet@tekschool.us' and password 'sdet'
And User click on Login button
Then User should be logged in to user dashboard

@multipleUsers
 Scenario Outline: Login to MyAccount with multiple users
 When User click on MyAccount
And User click on Login
And User enters username '<userName>' and password '<password>'
And User click on Login button
Then User should be logged in to user dashboard

     Examples:
    |userName			  |password|
    |sdet@tekschool.us    |sdet	   |
    |student@tekschool.us |TEST	   |
    |teacher@tekSchool.us |teacher |
    |consumer@tekschool.us|JBond   |
    
@LogoutTest
Scenario: Logout to MyAccount
When User click on MyAccount
And User click on Login
And User enters username 'sdet@tekschool.us' and password 'sdet'
And User click on Login button
Then User should be logged in to user dashboard
Then User click on LogOut Button
Then User should be logged out





