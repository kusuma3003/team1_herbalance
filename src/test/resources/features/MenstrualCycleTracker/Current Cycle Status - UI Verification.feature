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

Feature: Current Cycle Status - UI Verification
Background: User clicks Activity Insights button after logged in
 
  Scenario: Section heading text
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then "Current Cycle Status" is displayed
    
  Scenario: Display cycle progress based on onboarding data
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Displays current cycle progress in the format "Day [CurrentCycleDay] of your [CycleLength]-day cycle" as the values entered during onboarding process
  
  Scenario: Progress bar with phase labels
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then "Menstrual", "Follicular", "Ovulation", "Luteal" labels are displayed below the progress bar
  
  Scenario: Progress bar accuracy for current cycle day and phase
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Progress bar should be filled according to the current cycle progress
  
  Scenario: Display all the labels in Current Cycle Status section
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then "Current Phase", "Last period started", "Next period expected" are displayed
  
  Scenario: Display correct Current Phase
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Displays the phase based on the value entered during onboarding process
  
  Scenario: Display correct Last period started
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Displays correct "Last period started" based on the date entered during onboarding process
  
  Scenario: Display correct Next period expected
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Displays correct "Next period expected" based on the values entered during onboarding process
  
  Scenario: Subsection heading text per phase
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Subsection heading reflects the Current Phase in the format "[Current Phase] Details" 
  
  Scenario: Content below the subsection heading per phase
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Display content should match current phase 
  