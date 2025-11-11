@profileui
Feature: Edit Profile UI Verification

  Background: User clicks  Edit Profile submenu from Dashboard Profile page
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile

  @profileui01
  Scenario: Title is displayed
    Then "Edit your Profile" title should be visible

 @profileui02
  Scenario: Subtitle is displayed
    Then "Update your personal information and preferences" subtitle should be visible

 @profileui03
  Scenario: Total number of tabs
    Then There should be exactly 3 tabs

 @profileui04
  Scenario: Tabs header are displayed
    Then "Basic Information" tab should be visible
    And "Body Metrics" tab should be visible
    And "Preferences & Health" tab should be visible

@profileui05
  Scenario: Default tab
    Then "Basic Information" tab should be active by default

@profileui06
  Scenario: Back button presence
    Then Back button should be visible