
@profui
Feature: Profile - Edit Your Profile UI verification

  @profui01
  Scenario: Title is displayed 
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile 
    Then Edit your Profile should be visible
    
  @profui02
  Scenario: Sub text for title is dispalyed
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile 
    Then Update your personal inforamtion and preferences should be visible
    
  @profui03
  Scenario: Total number of tabs
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile 
    Then There should be exactly 3 tabs 

  @profui04
  Scenario: Tabs header are displayed
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile 
    Then “Basic Information” ,“Body Metrics”,“Preferences & Health” tabs should be visible

  @profui05
  Scenario: Default tab 
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile 
    Then Basic Information should be visible by default
    
    @profui06
  Scenario: Back Button Presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile 
    Then Back Button should be visible
    
 # -------------------------------------------------------------------------------------------------  
      
 @profbasic
Feature: Profile - Edit Your Profile UI verification

  @profbasic01
  Scenario: Header text inside the section
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Basic Information tab
    Then "Basic Information" should be visible inside section
    
  @profbasic02
  Scenario: Sub text for header 
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Basic Information tab
    Then "Update your name and age" sub text should be visible
    
  @profbasic03
  Scenario: Name input field presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Basic Information tab
    Then Should display the user’s Name as entered during the onboarding process.

  @profbasic04
  Scenario: Age input field presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Basic Information tab
    Then Should display the user’s Age as entered during the onboarding process.

  @profbasic05
  Scenario: Input field alignment and spacing
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Basic Information tab
    Then Name and Age fields should be properly aligned vertically with equal spacing
    
    @profbasic06
  Scenario: “Next: Body Metrics” button presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Basic Information tab
    Then “Next: Body Metrics” button should be visible, enabled
    
 # -------------------------------------------------------------------------------------------------  
 
 @profmetrics
Feature: Profile - Edit Your Profile UI verification

  @profmetrics01
  Scenario: Header text inside the section
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then "Body Metric" should be visible inside section
    
  @profmetrics02
  Scenario: Sub text for header 
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then "Update your weight and height information " should be visible
    
  @profmetrics03
  Scenario: Weight input field presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then Should display the user’s Weight as entered during the onboarding process.

  @profmetrics04
  Scenario: Height input field presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then Should display the user’s Height as entered during the onboarding process.

  @profmetrics05
  Scenario: Instruction for entering Weight and Height 
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then Please enter your height in decimal format (e.g., 5'.9"=5.9) should be visible
    
  @profmetrics06
  Scenario: Dropdown for weight measurment presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then "kg"or "lb" unit values in dropdown should be visible ,enabled
    
  @profmetrics07
  Scenario: Dropdown for Height measurment presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then "ft/in" or "cm" unit values in dropdown should be visible, enabled
    
  @profmetrics08
  Scenario: input field alignment and spacing
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then Weight and Height fields should be properly aligned vertically with equal spacing
    
  @profmetrics09
  Scenario: BMI Calculation section is visible
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then BMI Calculation Number should be displayed with a gradient slider and labels
    
  @profmetrics010
  Scenario: BMI Catogary section is visible
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then BMI Category section should present with BMI Category

  @profmetrics11
  Scenario: BMI Catogary note is visible
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then BMI Catogary note should be visible
    
    @profmetrics12
  Scenario: gradient color representation
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then slider should display a continuous gradient from blue → yellow → orange → red, representing increasing BMI values
    
     @profmetrics13
  Scenario: "Back" Button presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then "Back" Button should be visible ,enabled
    
    @profmetrics14
  Scenario: “Next: Body Metrics” button presence and state
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Body Metrics Tab
    Then “Next: Body Metrics” button should be visible, enabled
    
  # -------------------------------------------------------------------------------------------------  
    
    
    