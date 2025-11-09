@DashboardSubmenu
Feature: Dashboard - Profile sub menu functionality

  Background: User clicks profile button labelled as users name after logged in
    Given User is on the Her Balance Dashboard with the Profile submenu expanded

  @Dash62
  Scenario: Navigation of Home button
    When User clicks on Home
    Then User should be redirected to dashboard option

  @Dash63
  Scenario: Navigation of Profile
    When User clicks on Edit Profile
    Then User should be redirected to Edit Your Profile page

  @Dash64
  Scenario: Navigation of Subscription
    When User clicks on Subscription
    Then User should be redirected to Subscription Management page

  @Dash65
  Scenario: Navigation of Logout
    When User clicks on Logout
    Then User should be logged out of the application

  @Dash66
  Scenario: Navigation of Track Weight
    When User clicks on Track Weight
    Then User should be redirected to  track weight page

  @Dash67
  Scenario: Navigation of  Food Intake
    When User clicks on Food Intake
    Then User should be redirected to food intake page

  @Dash68
  Scenario: Navigation of Menstrual Phase Logs
    When User clicks on Menstrual Phase Logs
    Then User should be redirected to menstrual phase log page
