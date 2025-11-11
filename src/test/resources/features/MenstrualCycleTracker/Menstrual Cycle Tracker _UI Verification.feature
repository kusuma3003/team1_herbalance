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

Feature: Menstrual Cycle Tracker_UI Verification
Background: User clicks Activity Insights button after logged in
 
  Scenario: 5 sections are visible 
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then 5 sections should be visible(Current Cycle Status, Upcoming Phases, Recommended Activities, Nutrtion Tips, Next Period)
  
  Scenario Outline: Verify visibility of elements in Menstrual Phase Logs
  Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
  When User clicks on Menstrual Phase Logs
  Then "<element>" should be visible

Examples:
  | element                          |
  | Update Cycle Information         |
  | Back to Dashboard                |
  | Add Period Log                   |
  | Cycle Overview                   |
  | Menstrual Calendar               |
  | Period History                   |
   
   