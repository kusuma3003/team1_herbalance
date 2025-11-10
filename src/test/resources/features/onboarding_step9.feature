Feature: Onboarding Step 8 Functionality and Step 9 UI Verification

  Background:
    Given the user has completed onboarding up to Step 7
    And the user is on Step 8 of the onboarding process

  Scenario: Highlight selected diet option
    When the user clicks any dietary option
    Then the selected diet should be highlighted

  Scenario: Continue button enables upon dietary selection
    When the user clicks any dietary option
    Then the "Continue" button should be enabled

  Scenario: Navigate back to Step 7
    When the user clicks the "Back" button in Step 8
    Then the user should be redirected to Step 7

  Scenario: Navigate to Step 9
    When the user clicks "Continue" after selecting any dietary option
    Then the user should be redirected to Step 9
    And the onboarding progress bar should show "9 of 11"
    And the title should be "Physical Activity Level"
    And the description should display "Help us understand your current exercise routine to design an appropriate fitness plan."
    And four sections should be visible
    And the section titles "Sedentary", "Lightly Active", "Moderately Active", "Very Active" should be displayed
    And description text for each section should be visible
    And a radio button should be displayed in all sections
    And the informational note "Your activity level helps us design a fitness plan that’s both effective and manageable." should be displayed
    And the "Continue" button should be disabled
