
@loginui
Feature: Auth Page UI Verification

  @loginui01
  Scenario: HerBalance logo visibility
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then HerBalance logo should be visible on the top-left corner
    
 @loginui02
  Scenario: Login and Sign Up tabs are displayed
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then "Login" tabs should be visible
    And "Sign Up" tabs should be visible
    
  @loginui03
  Scenario: Default selected tab is “Login”
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Login” tab should be active by default

 @loginui04
  Scenario: Email ID input field presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then Email ID input field with placeholder "you@example.com" should be visible

  @loginui05
  Scenario: Password input field presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then Password input field with masked entry should be visible

  @loginui06
  Scenario: “Show Password”  presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Show password” should be visible 

  @loginui07
  Scenario: “Login” button presence and state
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Login” button should be visible, enabled

    @loginui08
  Scenario: “Forgot password?” link presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Forgot password?” link should be visible
    
    @loginui09
  Scenario: “Sign Up” link visibility
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then “Sign Up” link should be visible and navigates to the Sign-Up page
    
    @loginui10
  Scenario: Right panel content (Transform Your Weight Loss Journey)
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then The right section should display “Cycle-Synced Plans”, “Blood Work Analysis”, and “Personalized Dashboard” content
    
    @loginui11
  Scenario: Testimonial section presence
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then A testimonial with text and name (e.g., “Sarah, 34”) should be displayed
    
    @loginui12
  Scenario: total number of tabs
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then There should be exactly 2 tabs — “Login” and “Sign Up”
    
    @loginui13
  Scenario: input field alignment and spacing
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then Email ID fields should be properly aligned vertically with equal spacing
    And Password fields should be properly aligned vertically with equal spacing
    
    @loginui14
  Scenario: Two input field 
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then There should be exactly 2 input field
    
    @loginui15
  Scenario: Radio button for show password
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then Radio button for show password
    
    @loginui16
  Scenario: background and theme consistency
    Given User is on the HerBalance launch page
    When User clicks log in button
    Then The background gradient (light purple) and fonts should match HerBalance theme
    
    
    