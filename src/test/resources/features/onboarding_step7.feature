Feature: Onboarding Step 6 Functionality and Step 7 UI Verification

  Background:
    Given the user has completed onboarding up to Step 5
    And the user is on Step 6 of the onboarding process

  Scenario: Error message for not selecting last menstrual date
    When the user clicks "Continue" without selecting last menstrual date
    Then the error message "Please select your last period start date" should be displayed

  Scenario: Navigating back to Step 5
    When the user clicks the "Back" button in Step 6
    Then the user should be redirected to Step 5

  Scenario: Error message for invalid date input
    When the user enters an invalid date in the last menstrual date field
    And clicks "Continue"
    Then the error message "Please select your last period start date" should be displayed

  Scenario: Display of current phase message
    When the user selects a valid last menstrual date
    Then the message "Based on your last period starting on <date>, you're currently in the [CurrentPhase]." should be visible
    And the description text about the current phase should be displayed

  Scenario: Verify section headers
    When the user selects a valid last menstrual date
    Then the section headers "Your Cycle Timeline", "Your Upcoming Cycle Calendar", and "Your Next Expected Periods" should be visible

  Scenario: Verify current phase details
    When the user selects a valid last menstrual date
    Then the current phase name with day count (e.g., "Menstrual Phase (Day 3)") should be displayed
    And the detailed phase guidance text should be visible

  Scenario: Verify calendar display
    When the user selects a valid last menstrual date
    Then the upcoming cycle calendar should display two months (current month and next month)
    And the calendar should have right and left navigation arrows

  Scenario: Changing last period date updates timeline
    Given the user has selected the last menstrual date
    When the user changes the date using the cycle calendar
    Then the displayed phase in the timeline should update accordingly

  Scenario: Navigation of months using calendar arrows
    Given the user has selected the last period date
    When the user clicks the right arrow in the calendar
    Then the calendar should display the next month
    When the user clicks the left arrow in the calendar
    Then the calendar should display the previous month

  Scenario: Verify cycle phase legend
    When the user selects a valid last menstrual date
    Then the legend should display the following phases with respective colors:
      | Phase             | Color Indicator |
      | Menstrual Phase   | Red / Pink      |
      | Ovulation Phase   | Blue            |
      | Follicular Phase  | Light Purple    |
      | Luteal Phase      | Lavender        |

  Scenario: Display of next expected periods
    When the user selects a valid last menstrual date
    Then at least three future expected period dates should be listed
    And the dates should be displayed in chronological order

  Scenario: Navigate to Step 7
    When the user clicks "Continue" after selecting last menstrual date
    Then the user should be redirected to Step 7
    And the onboarding progress bar should show "7 of 11"
    And the title should be "Current Weight and Height"
    And the description text should display "This helps us calculate your BMI and set appropriate goals"
    And exactly two text fields should be present
    And the text field labels should display "What’s your current weight?" and "What’s your height?"