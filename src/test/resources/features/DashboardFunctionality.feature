@DashboardFunctionality
Feature: Dashboard - Functionality

  Background: User logged into the application
    Given User is on the Her Balance Dashboard page

  @Dash54
  Scenario: Sub menu in  profile name
    When User clicks on profile name
    Then User should see "Home", "Edit profile", "Subscription" , "Logout" options

  @Dash55
  Scenario: Sub menu in activity insights
    When User clicks on activity Insight
    Then User should see  Track Weight", Food Intake" , "Menstrual Phase Logs"

  @Dash56
  Scenario: Navigation on diet plan
    When User clicks on Diet plan button
    Then User should redirected to diet-plan page

  @Dash57
  Scenario: Navigation on workout plan
    When User clicks on workout button
    Then User should redirected to workout page

  @Dash57
  Scenario: Navigation on water Tracker plan
    When User clicks on water tracker button
    Then User should redirected to water tracker page

  @Dash58
  Scenario: Navigation on View Full cycle details
    When User clicks on View Full Cycle Details
    Then User should be redirected to Menstrual cycle tracker page

  @Dash59
  Scenario: Navigation on Upload Blood report
    When User clicks on Upload Blood report
    Then User should be redirected to explorer to choose the file

  @Dash60
  Scenario: Navigation on Upgrade premium
    When User clicks on  Upgrade to Premium
    Then User should be redirected to Subcription page

  @Dash61
  Scenario: Navigation on  generate 7-day Plan
    When User clicks on Generate 7-Day Plan
    Then User should be redirected to diet-plan page

  @Dash62
  Scenario: Navigation on see premium plans
    When User clicks on See Premium Plans
    Then User should be redirected to Subcription page
