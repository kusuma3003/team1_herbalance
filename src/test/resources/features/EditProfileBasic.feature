 @profbasic
Feature:  Edit Your Profile-Basic Information -UI verifications

  Background: User clicks  Edit Profile submenu from Dashboard Profile page
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks Basic Information tab

  @profbasic01
  Scenario: Header text inside the section
    Then "Basic Information" should be visible inside section

  @profbasic02
  Scenario: Sub text for header 
    Then "Update your name and age" sub text should be visible

  @profbasic03
  Scenario: Name input field presence
    Then Should display the user’s Name as entered during the onboarding process.

  @profbasic04
  Scenario: Age input field presence
    Then Should display the user’s Age as entered during the onboarding process.

  @profbasic05
  Scenario: Input field alignment and spacing
    Then Name and Age fields should be properly aligned vertically with equal spacing

  @profbasic06
  Scenario: “Next: Body Metrics” button presence and state
    Then “Next: Body Metrics” button should be visible, enabled