
@func   
 Feature: Login Functionality on HerBalance Auth Page  
 
    Background: User clicked login button in home page
    Given User is on the HerBalance launch page
    When User clicks log in button
    
     @func01
  Scenario: Successful login with valid credentials
    Given User is on the HerBalance auth page
    When user clicks login button after entering a valid credential
    Then User should be redirected to the dashboard
    
    @func02
  Scenario: Login attempt with invalid credentials
    Given User is on the HerBalance auth page
    When user clicks login button after entering a invalid credential
    Then An error message "Invalid email or password" should be displayed
  
    @func03
  Scenario: Login attempt with empty fields
    Given User is on the HerBalance auth page
    When user clicks login button after leaving credential blank
    Then Validation messages "Email ID is required" and "Password is required" should be displayed
  
    @func04
  Scenario: Check show password behaviour
    Given User clicked login button in home page
    And User is on the HerBalance auth page
    When User clicks show password after entering password
    Then Password should be visible in plain text
  
    @func05
  Scenario: Hide Password after unchecking
    Given User clicked login button in home page
    And User is on the HerBalance auth page
    When User unchecks the "Show Password" option after entering password
   Then Password should again be masked
  
    @func06
  Scenario: Password visible when clicking eye icon
    Given User is on the HerBalance auth page
    When User enters a password and clicks the eye icon
    Then Password should become visible and shown in plain text
  
    @func07
  Scenario: Password hides when eye icon clicked again
    Given User is on the HerBalance auth page
    When User clicks the eye icon again
    Then Password should again be masked
  
    @func08
  Scenario: Navigate to Forget Password page
    Given User is on the HerBalance auth page
    When User clicks on "Forgot password?"
    Then User should be redirected to the Forget Password page
  
    @func09
  Scenario: Navigate to Sign Up page
    Given User is on the HerBalance auth page
    When user clicks on "Sign up" tab
    Then User should be redirected to the sign up tab
 