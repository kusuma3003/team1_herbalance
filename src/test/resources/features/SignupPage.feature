#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
 @run
Feature: Auth Page UI Verification - sign up tab

    Scenario: Email ID input field presence
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then Email ID input field with placeholder "you@example.com" should be visible
   

    Scenario: Password input field presence
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then Password input field with masked entry should be visible
   
    Scenario: Confirm password input field presence
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then Confirm password input field with masked entry should be visible
    
    Scenario: “Show Passwords”  presence
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then Password input field with masked entry should be visible
    
    Scenario: “Register” button presence and state
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then “Login” button should be visible, enabled
   
    Scenario: “Login" link visibility
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then “Login” link should be visible and navigates to the Login page
   
   Scenario: Input field alignment and spacing
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then Email ID , Password , Confirm Password fields should be properly aligned vertically with equal spacing
   
    Scenario: Three input field 
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then There should be exactly 3 input field
   
    Scenario: Radio button for show passwords
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then Radio button for show passwords is present
   
    Scenario: Terms and condition presence
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then Terms and conditions details should be present
   
    Scenario: Radio button for Terms and condition
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then Radio button for Terms and condition is present
    
    Scenario: Background and theme consistency
    Given User is on the HerBalance launch page
    When User clicks sign up button
    Then The background gradient (light purple) and fonts should match HerBalance theme
    
   
   
   
    
    
   
    