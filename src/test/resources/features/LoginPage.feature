
@ui
Feature: Auth Page UI Verification

  @ui01
  Scenario: HerBalance logo visibility
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then HerBalance logo should be visible on the top-left corner
    
  @ui02
  Scenario: Login and Sign Up tabs are displayed
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then "Login" tabs should be visible
    And "Sign Up" tabs should be visible
    
  @ui03
  Scenario: Default selected tab is “Login”
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Login” tab should be active by default

  @ui04
  Scenario: Email ID input field presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then Email ID input field with placeholder "you@example.com" should be visible

  @ui05
  Scenario: Password input field presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then Password input field with masked entry should be visible

  @ui06
  Scenario: “Show Password”  presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Show password” should be visible 

  @ui07
  Scenario: “Login” button presence and state
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Login” button should be visible, enabled

    @ui08
  Scenario: “Forgot password?” link presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Forgot password?” link should be visible
    
    @ui09
  Scenario: “Sign Up” link visibility
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Sign Up” link should be visible and navigates to the Sign-Up page
    
    @ui10
  Scenario: Right panel content (Transform Your Weight Loss Journey)
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then The right section should display “Cycle-Synced Plans”, “Blood Work Analysis”, and “Personalized Dashboard” content
    
    @ui11
  Scenario: Testimonial section presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then A testimonial with text and name (e.g., “Sarah, 34”) should be displayed
    
    @ui12
  Scenario: total number of tabs
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then There should be exactly 2 tabs — “Login” and “Sign Up”
    
    @ui13
  Scenario: input field alignment and spacing
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then Email ID fields should be properly aligned vertically with equal spacing
    And Password fields should be properly aligned vertically with equal spacing
    
    @ui14
  Scenario: Two input field 
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then There should be exactly 2 input field
    
    @ui15
  Scenario: Radio button for show password
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then Radio button for show password
    
    @ui16
  Scenario: background and theme consistency
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then The background gradient (light purple) and fonts should match HerBalance theme
    
    
 @func   
 Feature: Login Functionality on HerBalance Auth Page  
 
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
  
    
    
    
    
    
    
    
    
    
    
   