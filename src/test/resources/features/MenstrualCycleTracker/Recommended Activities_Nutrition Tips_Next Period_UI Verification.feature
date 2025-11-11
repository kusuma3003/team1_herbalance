
Feature: Recommended Activities, Nutrition, and Next Period UI Verification

Background: User clicks the Activity Insights button after logging in

# Recommended Activities Section
Scenario: Recommended Activities Section heading
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then the section heading "Recommended Activities" should be displayed

Scenario: Recommended Activities content per phase
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Recommended Activities content should be displayed according to the "Current Phase"

# Nutrition Tips Section
Scenario: Nutrition Tips Section heading
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then the section heading "Nutrition Tips" should be displayed

Scenario: Nutrition Tips content per phase
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then Nutrition Tips content should be displayed according to the "Current Phase"

# Next Period Section
Scenario: Next Period Section heading
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then the section heading "Next Period" should be displayed

Scenario: Next period date display
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then the "Next period date" should be displayed in the format "Month Day, Year" based on the cycle data entered during onboarding

Scenario: Number of days remaining for the next period
    Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
    When User clicks on Menstrual Phase Logs
    Then the "Number of days remaining" should be displayed correctly as per the next period date
