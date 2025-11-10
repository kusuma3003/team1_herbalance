Feature: Onboarding Step 4 Functionality and Step 5 UI Verification

  Background:
    Given the user has completed onboarding up to Step 3
    And the user is on Step 4 of the onboarding process

  Scenario: Error message for invalid first name
    When the user enters an invalid first name
    And clicks the "Continue" button
    Then the error message "Please enter valid name" should be displayed

  Scenario: Error message for invalid age
    When the user enters an invalid age
    And clicks the "Continue" button
    Then the error message "Please enter a number" should be displayed

  Scenario: Error message for missing blood pressure status
    When the user does not select a blood pressure status
    And clicks the "Continue" button
    Then the error message "Please select your blood pressure status" should be displayed

  Scenario: Navigating back to Step 3
    When the user clicks the "Back" button in Step 4
    Then the user should be redirected to Step 3

  Scenario: Navigate to Step 5 after entering valid details
    When the user enters all required details in Step 4
    And clicks the "Continue" button
    Then the user should be redirected to Step 5
    And the onboarding progress bar should be displayed
    And the progress bar should show "5 of 11"
    And the "Back" button should be visible and enabled
    And the "Continue" button should be visible and enabled

  Scenario: Verify Step 5 title and description
    When the user navigates to Step 5
    Then the title should be "Menstrual Cycle Awareness"
    And the description should display "Understanding your cycle helps us optimize your weight loss journey."

  Scenario: Verify Step 5 question and options
    When the user navigates to Step 5
    Then the question "Do you currently track your menstrual cycle?" should be visible
    And 5 radio buttons should be visible
    And the options for menstrual cycle awareness should be displayed