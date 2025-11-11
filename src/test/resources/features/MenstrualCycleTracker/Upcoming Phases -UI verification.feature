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

Feature: Upcoming Phases,Recommended Activities - UI Verification
Background: User clicks Activity Insights button after logged in
 
  Scenario: Upcoming Phases Section heading text
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then  the section heading "Upcoming Phases" should be visible
    
    Scenario: Subtext is displayed
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then the subtext "Plan ahead with your cycle phases" should be visible
    
    Scenario: 4 subsections are visible
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then 4 subsections should be visible
    
    Scenario: Subsection heading text
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then "Menstrual Phase", "Follicular Phase", "Ovulation Phase", "Luteal Phase" are displayed
    
    Scenario: Correct start date for each phase 
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Start date should be diaplayed correctly as per the cycle data entered during onboarding process
    
    Scenario: Start date format
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then All phase start dates should be displayed in "Starts MMM dd" format
    
    Scenario: Current Phase Start date format
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Current phase date should be displayed in "Started MMM dd" format 
    
    Scenario: Current Phase subsection is highlighted
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then "Current Phase" subsection is highlighted based on cycle data entered during onboarding process 
    
    