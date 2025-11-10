@DashboardSubscription
Feature: Subscription Information

  Background: User is in login page
    Given User is on the HerBalance auth page
    When User clicks login in button after entering  a valid credential

  @Dash38
  Scenario: Presence of start / joined date of subscription
    Then Joined date should be displayed

  @Dash39
  Scenario: Presence of todays date section
    Then Todays date should be display

  @Dash40
  Scenario: Plan details is displayed
    Then Subcription plan should be displayed

  @Dash41
  Scenario: Status of the plan
    Then Status of plan should be displayed(how many days left out of 7 days free plan)

  @Dash42
  Scenario: Presence of Upgrade to Premium button
    Then Upgrade to Premium" button should be displayed
