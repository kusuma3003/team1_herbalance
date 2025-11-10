Feature: Blood Report Upload Modal navigation

  Background:
    Given the user is on the Sign Up page
    And has entered valid registration details

  Scenario: Navigate to Blood Report Upload Modal
    When the user clicks the "Register" button
    Then the page title should be "Upload Your Recent Blood Work"
    And the supporting text for the title should be displayed
    And the onboarding progress bar is visible
    And the progress bar shows "Step 1 of 10"

  Scenario: Verify Upload PDF button
    When the user clicks the "Register" button
    Then the "Upload PDF" button is displayed
    And the "Upload PDF" button is enabled
    And the note "PDF files only (Max 10MB)" is displayed

  Scenario: Verify Skip Option
    When the user clicks the "Register" button
    Then the "Skip for Now" card is visible
    And the explanation text about continuing without lab results is displayed
    And the "Continue Without Report" button is displayed
    And the "Continue Without Report" button is enabled

  Scenario: Verify Data Security Information
    When the user clicks the "Register" button
    Then the note about secure processing and no sharing with third parties is displayed