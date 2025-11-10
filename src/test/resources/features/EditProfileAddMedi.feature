
  @addMedicationUI
Feature: Preferences & Health - Add Medication UI verification

  Background:
    Given User is on the Preferences & Health section


  @addMed01
  Scenario: Header text is displayed
    When User clicks on Add Medication Button
    Then Enter Medication name header should be visible


  @addMed02
  Scenario: Enter Medication name input field presence
    When User clicks on Add Medication Button
    Then Medication name input field should be visible


  @addMed03
  Scenario: Button text verification
    When User clicks on Add Medication Button
    Then "Ok" and "Cancel" buttons should be visible


  @addMed04
  Scenario: Total number of buttons
    When User clicks on Add Medication Button
    Then There should be exactly 2 buttons


  @addMed05
  Scenario: Adding Medication to the profile
    When User clicks on Add Medication Button
    And User enters medication name
    And User clicks on Ok button
    Then User should see success message "Your Medication name is saved"


  @addMed06
  Scenario: Cancel the Medication pop-up window
    When User clicks on Add Medication Button
    And User clicks on Cancel Button without adding medication details
    Then User should navigate back to Preferences & Health Section page
      