@editprofile
Feature: Edit Profile - Navigation & Functionalities

  Background:
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded


  @bodymetric_nav
  Scenario: Navigation of Body Metric tab
    When User clicks on Body Metric tab
    Then User should see Body Metric Section


  @preferences_nav
  Scenario: Navigation of Preferences & Health tab
    When User clicks on Preferences & Health tab
    Then User should see Preferences & Health Section


  @basic_next
  Scenario: Navigation of “Next: Body Metrics” button
    When User clicks on Next Body Metrics Button
    Then User should see "Body Metrics" Section


  @preferences_next
  Scenario: Navigation of “Next: Preferences” button
    When User clicks on Next: Preferences Button
    Then User should see "Preferences & Health" Section


  @body_metric_back
  Scenario: Navigation of “Back” button from Body Metric section
    When User clicks on Back Button on Body Metric section
    Then User should see "Basic Information" section


  @preferences_back
  Scenario: Navigation of “Back” button from Preferences & Health section
    When User clicks on Back Button on Preferences & Health section
    Then User should see "Body Metric" section


  @save_profile_msg
  Scenario: Message after clicking Save Profile button
    When User clicks on Save Profile on Preferences & Health section after editing values in any field
    Then User should see success message "Your Profile is saved"


  @add_medication
  Scenario: Navigation of "Add Medication" button
    When User clicks on Add Medication Button
    Then User should see "Pop Up Enter Medication name"

