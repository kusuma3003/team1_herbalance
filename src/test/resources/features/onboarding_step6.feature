Feature: Onboarding Step 5 Functionality and Step 6 UI Verification

  Background:
    Given the user has completed onboarding up to Step 4
    And the user is on Step 5 of the onboarding process

  Scenario: Error message for not selecting menstrual cycle tracking
    When the user clicks the "Continue" button without selecting menstrual cycle info
    Then the error message "Please select your menstrual cycle track" should be displayed

  Scenario: Navigating back to Step 4
    When the user clicks the "Back" button in Step 5
    Then the user should be redirected to Step 4

  Scenario: Navigate to Step 6 after selecting menstrual cycle info
    When the user selects their menstrual cycle info in Step 5
    And clicks the "Continue" button
    Then the user should be redirected to Step 6
    And the onboarding progress bar should be displayed
    And the progress bar should show "6 of 11"
    And the "Back" button should be visible and enabled
    And the "Continue" button should be visible and enabled

  Scenario: Verify Step 6 title and description
    When the user navigates to Step 6
    Then the title should be "Last Period Date"
    And the description should display "This helps us understand your current cycle phase and tailor recommendations."

  Scenario: Verify date input and question visibility
    When the user navigates to Step 6
    Then the question "When did your last menstrual period start?" should be visible
    And the calendar icon should be visible inside the date input field
    And the date input field should have placeholder "mm/dd/yyyy"

  Scenario: Verify cycle length slider and label
    When the user navigates to Step 6
    Then the label below the date field should display "Cycle Length (days)"
    And the slider control for cycle length should be displayed
    And the default cycle length value should be "28"
    And the information text "Average cycle length is 28 days, but can vary from 21 to 45 days" should be visible