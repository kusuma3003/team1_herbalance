@DashboardHealthwithcondtion
Feature: Health Conditions -with condition

  Background: User has completed onboarding and selected one or more health conditions
    Given User is on the HerBalance auth page
    When User clicks login in button after entering  a valid credential

  @Dash30
  Scenario: Automatic data mapping from onboarding
    Then Displayed condition(s) match exactly what was selected during onboarding, without requiring user input again

  @Dash31
  Scenario: Condition description message
    Then Message appears below condition card explaining how the plan is adjusted

  @Dash32
  Scenario: Styling and icon display
    Then Card includes heart icon, condition name , and info icon with related text

  @Dash33
  Scenario: No condition scenario
    Then Message like No health conditions selected or an empty state is displayed
