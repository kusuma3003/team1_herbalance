Feature: Onboarding Step 10 Functionality and Step 11 UI verification

  Background:
    Given the user has completed onboarding upto Step 9
    And the user is on Step 10 of onboarding

  Scenario: Highlight selected section
    When the user click any options under Food Allergies & Sensitivities
    Then the selected section should be highlited

  Scenario: Radio button selection functionality
    When the user click any options under Food Allergies & Sensitivities
    Then the radio button in the selected section should be mark as selected

  Scenario: Navigate back to Step 9
    When the user clicks back button in Step 10
    Then the user should be redirect to Step 9

  Scenario: Error message for not selecting any options
    When the user clicks continue button without selecting any option
    Then error message "Please select an option" should be displayed

  Scenario: Navigate to Step 11
    When the user clicks continue after selecting any options under Food Allergies & Sensitivities
    Then the user should be redirect to Step 11
    And the progress bar should show "11 of 11"
    And the title should be "Medications & Supplements"
    And the description should be "Do you currently take any medications or supplements?"
    And four sections should be visble
    And the section titles "Yes, I take prescription medications", "Yes, I take supplements", "Yes, I take both", "No, I don’t take any medications or supplements" should be displayed
    And description text for each section should be visble
    And examples like  "eg:Yes, I take prescription medications Doctor-prescribed medications Yes, I take supplements Vitamins, minerals, or other supplements  Yes, I take both Both medications and supplements No, I don’t take any medications or supplements Not currently taking anything should be displayed"
        
    And a radio button should be displayed in all sections
    And the info note "Boost Your Wellness Game: Why Knowing Your Meds & Supplements Matters Tailoring your nutrition and fitness to match what you’re taking helps prevent unwanted side effects and keeps your results on track"
      
  Scenario: Section highlighted on selection
    Given the user is on Step 11 of onboarding
    When the user clicks any option under "Medications & Supplements"
    Then the selected section should be highlighted

  Scenario: Radio button selection functionality
    Given the user is on Step 11 of onboarding
    When the user clicks any option under "Medications & Supplements"
    Then the corresponding radio button should be marked as selected

  Scenario: Navigating back to Step 10
    Given the user is on Step 11 of onboarding
    When the user clicks the back button
    Then the user should be redirected to Step 10 of onboarding

  Scenario: Error message displayed when continuing without selection
    Given the user is on Step 11 of onboarding
    When the user clicks the Continue button without selecting any option
    Then an error message "Please select an option" should be displayed

  Scenario: Complete button functionality
    Given the user is on Step 11 of onboarding
    When the user enters any option under "Medications & Supplements"
    And clicks the Complete button
    Then the user should be navigated to the Subscription page