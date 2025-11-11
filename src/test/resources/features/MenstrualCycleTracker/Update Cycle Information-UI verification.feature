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


Feature: Update Cycle- UI Verification

Background: User clicks "Menstrual Phase Logs" from "Activity Insights" menu

Scenario: Navigation of Update Cycle Information button
    Given User is on Menstrual Cycle Tracker page
    When User clicks on Update Cycle Information button
    Then "Update Cycle Information" calendar popup should be displayed

  Scenario: Heading text
    Given User is on Menstrual Cycle Tracker page
    When User clicks on Update Cycle Information button
    Then "Update Cycle Information" is displayed
    
    Scenario: Subtext
    Given User is on Menstrual Cycle Tracker page
    When User clicks on Update Cycle Information button
    Then "Update your last period start date and typical cycle length" is displayed
    
    Scenario: 2 sections are visible
    Given User is on Menstrual Cycle Tracker page
    When User clicks on Update Cycle Information button
    Then 2 sections should be visible 
    
    Scenario: Sections heading text
    Given User is on Menstrual Cycle Tracker page
    When User clicks on Update Cycle Information button
    Then "Last Period Start Date", "Cycle Length (days)" should be displayed  
    
    Scenario: Cancel button is visible
    Given User is on Menstrual Cycle Tracker page
    When User clicks on Update Cycle Information button
    Then "Cancel" button should be visible
    
    Scenario: Save Changes button is visible
    Given User is on Menstrual Cycle Tracker page
    When User clicks on Update Cycle Information button
    Then "Save Changes" button should be visible
    
    
    
    
    
    
   