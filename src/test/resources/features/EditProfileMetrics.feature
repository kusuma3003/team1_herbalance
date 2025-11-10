
    
 @profmetrics
Feature: Edit Your Profile-Body Metrics -UI verifications

  Background: User clicks  Edit Profile submenu from Dashboard Profile page
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab

  @profmetrics01
  Scenario: Header text inside the section
     Then "Body Metric" should be visible inside section
    
  @profmetrics02
  Scenario: Sub text for header 
     Then "Update your weight and height information " should be visible
    
  @profmetrics03
  Scenario: Weight input field presence
     Then Should display the user’s Weight as entered during the onboarding process.

  @profmetrics04
  Scenario: Height input field presence
    Then Should display the user’s Height as entered during the onboarding process.

  @profmetrics05
  Scenario: Instruction for entering Weight and Height 
     Then Please enter your height in decimal format (e.g., 5'.9"=5.9) should be visible
    
  @profmetrics06
  Scenario: Dropdown for weight measurment presence and state
     Then "kg"or "lb" unit values in dropdown should be visible ,enabled
    
  @profmetrics07
  Scenario: Dropdown for Height measurment presence and state
    Then "ft/in" or "cm" unit values in dropdown should be visible, enabled
    
  @profmetrics08
  Scenario: input field alignment and spacing
    Then Weight and Height fields should be properly aligned vertically with equal spacing
    
  @profmetrics09
  Scenario: BMI Calculation section is visible
   Then BMI Calculation Number should be displayed with a gradient slider and labels
    
  @profmetrics010
  Scenario: BMI Catogary section is visible
    Then BMI Category section should present with BMI Category

  @profmetrics11
  Scenario: BMI Catogary note is visible
    Then BMI Catogary note should be visible
    
    @profmetrics12
  Scenario: gradient color representation
    Then slider should display a continuous gradient from blue → yellow → orange → red, representing increasing BMI values
    
     @profmetrics13
  Scenario: "Back" Button presence and state
    Then "Back" Button should be visible ,enabled
    
    @profmetrics14
  Scenario: “Next: Body Metrics” button presence and state
    Then “Next: Body Metrics” button should be visible, enabled
    
    
    