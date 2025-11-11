Feature: Onboarding Step 3 Functionality and Step 4 UI Verification

  Background:
    Given the user has completed onboarding up to Step 2
    And the user is on Step 3 of the onboarding process

  Scenario: Navigate to Step 4 after selecting health conditions
    When the user selects one or more health conditions
    And clicks the "Continue" button
    Then the user should be redirected to Step 4

  Scenario: Display onboarding progress on Step 4
    When the user clicks "Continue" after selecting health conditions
    Then the onboarding progress bar should be displayed
    And the progress bar should show the current step as "4 of 11"

  Scenario: Verify navigation buttons on Step 4
    When the user clicks "Continue" after selecting health conditions
    Then the "Back" button should be visible and enabled
    And the "Continue" button should be visible and enabled

  Scenario: Verify Step 4 title and description
    When the user navigates to Step 4
    Then the title should be "Personal Details"
    And the description text should display "Let’s get to know you better to personalize your experience."

  Scenario: Verify input fields on Step 4
    When the user navigates to Step 4
    Then 2 input boxes should be visible
    And the field labels should be: What’s your first name?, What’s your age?, What best describes your blood pressure status?
    And helper text should be displayed under each field

  Scenario: Verify radio buttons on Step 4
    When the user navigates to Step 4
    Then 4 radio buttons should be visible
    And the options for blood pressure should be displayed