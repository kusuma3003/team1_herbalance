Feature: Onboarding Step 9 Functionality and Step 10 UI verification

  Background:
    Given the user has completed onboarding upto Step 8
    And the user is on Step 9 of onboarding process

  Scenario: Highlight selected activity level
    When the user click any of the activity level
    Then the selected activity level should be highlited

  Scenario: Continue button enables upon activity level selection
    When the user click any of the activity level
    Then the "Continue" button should be enbaled

  Scenario: Radio button selection functionality
    When the user click any of the activity level
    Then the radio button in the selected activity level should be mark as selected

  Scenario: Navigate back to Step 8
    When the user clicks back button in Step 9
    Then the user should be redirect to Step 8

  Scenario: Navigate to Step 10
    When the user clicks continue after selecting any activity level
    Then the user should be redirect to Step 10
    And the onboarding progress bar should show "10 of 11"
    And the title should be "Food Allergies & Sensitivites"
    And the description should display "Do you have any food allergies or intolerances?"
    And four sections should be visble
    And the section titles "Yes, I have food allergies", "Yes, I have food intolerances/sensitivities", "No, I can eat everything", "I'm not sure" should be displayed
    And description text for each section should be visble
    And a radio button should be displayed in all sections
    And the info note "Food sensitivities can impact digestion, inflamamation, and even energy levels. Knowing what works best for your body