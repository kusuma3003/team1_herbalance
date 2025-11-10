Feature: Onboarding Step 7 Functionality and Step 8 UI Verification 

  Background:
    Given the user has completed onboarding up to Step 6
    And the user is on Step 7 of the onboarding process

  Scenario: Weight unit dropdown visibility
    When the user clicks the weight unit dropdown
    Then the options "kg" and "lbs" should be displayed

  Scenario: Height unit dropdown visibility
    When the user clicks the height unit dropdown
    Then the options "cm" and "ft/in" should be displayed

  Scenario: Error message for missing weight
    When the user clicks "Continue" without entering weight
    Then the error message "Weight is required" should be displayed

  Scenario: Error message for invalid weight
    When the user enters an invalid weight
    And clicks "Continue"
    Then the error message "Enter a valid weight" should be displayed

  Scenario: Error message for missing height
    When the user clicks "Continue" without entering height
    Then the error message "Height is required" should be displayed

  Scenario: Error message for invalid height
    When the user enters an invalid height
    And clicks "Continue"
    Then the error message "Enter a valid height" should be displayed

  Scenario: Navigate back to Step 6
    When the user clicks the "Back" button in Step 7
    Then the user should be redirected to Step 6

  Scenario: BMI calculation and display
    When the user enters valid weight and height
    Then the label "BMI Calculation" should be displayed
    And BMI should be calculated and displayed as "Your BMI is [calculated value]"
    And a BMI bar should be visible
    And the BMI bar labels "Underweight", "Normal", "Overweight", "Obese" should be displayed in order
    And the color codes for the BMI bar should align with the categories:
      | Category       | Color   |
      | Underweight    | Blue    |
      | Normal         | Yellow  |
      | Overweight     | Orange  |
      | Obese          | Red     |
    And the BMI indicator should fall in the correct category based on calculated BMI

  Scenario: Display sections and headings
    When the user enters valid weight and height
    Then two sections should be visible
    And the section headings "[Current Phase] note" and "BMI Feedback" should be displayed
    And the current phase note should reflect the user’s menstrual phase and BMI
    And the BMI feedback messages should correspond to the calculated BMI range

  Scenario: Navigate to Step 8
    When the user clicks "Continue" after entering valid weight and height
    Then the user should be redirected to Step 8
    And the onboarding progress bar should show "8 of 11"
    And the title should be "Dietary Preferences"
    And the description should display "Let us know about your eating habits to provide suitable meal recommendations"
    And four sections should be visible
    And the section titles "Pescatarian Diet", "Non-Vegetarian", "Vegetarian Diet", "Vegan Diet" should be displayed
    And description text for each diet should be visible
    And the informational note "Understanding your dietary preferences ensures our meal recommendations align with your lifestyle." should be displayed
    And the "Continue" button should be 