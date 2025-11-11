@profileprefer
Feature: Edit Your Profile - Preferences & Health - UI verifications

  Background: User clicks Edit Profile submenu from Dashboard Profile page
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Preferences & Health Tab

  @profileprefer01
  Scenario: Header text
    Then "Preferences & Health" should be visible

  @profileprefer02
  Scenario: Sub text for header
    Then "Update your dietary preferences and medications" should be visible

  @profileprefer03
  Scenario: Dietary Preferences RadioButtons options presence and state
    Then The following RadioButtons should be visible and enabled:
      | Pescatarian Diet   |
      | Non-Vegetarian     |
      | Vegetarian Diet    |
      | Vegan Diet         |

  @profileprefer04
  Scenario: Add Medication button presence and state
    Then "Add Medication" button should be visible and enabled

  @profileprefer05
  Scenario: Medication & Supplements section presence
    Then "Medication & Supplements" information text should be visible

  @profileprefer06
  Scenario: Back button presence and state
    Then "Back" button should be visible and enabled

  @profileprefer07
  Scenario: Save Profile button presence and state
    Then "Save Profile" button should be visible and enabled
