@DashboardMenstrualCycle
Feature: Menstrual Cycle Insights

  Background: User has completed onboarding and last period start date as input
    Given User is on the HerBalance auth page
    When User clicks login in button after entering  a valid credential

  @Dash43
  Scenario: Current phase details
    Then Should display current menstrual phase in cycle insights section based on onboarding input

  @Dash44
  Scenario: Remaining days are calculated based on onboarding input
    Then Should display accurate number of days left in the cycle

  @Dash45
  Scenario: Cycle length label displays correctly
    Then "Cycle:number days" should be displayed accurately based on onboarding input

  @Dash46
  Scenario: Current day count of the cycle is displayed correctly
    Then "Day" count displayed should match the number of days since the last period start date

  @Dash47
  Scenario: Progress bar represents current phase duration visually
    Then Filled portion should visually represent the proportion of days completed in the current cycle

  @Dash48
  Scenario: Next period prediction countdown
    Then Should display x days as the countdown to the next period

  @Dash49
  Scenario: View Full Cycle Details button navigation
    Then User should be redirected to the full Menstrual cycle log page

  @Dash50
  Scenario: Free plan information message
    Then Message "Free plan includes basic cycle insights" should be displayed

  @Dash51
  Scenario: Hormonal Impact on Weight message changes dynamically based on phase
    Then Hormonal Impact on Weight message should match the expected text for that phase

  @Dash52
  Scenario: Likely Symptoms are displayed dynamically based on phase
    Then Symptoms listed should correspond to the expected symptoms for that phase

  @Dash53
  Scenario: Likely Cravings are displayed dynamically based on phase
    Then Cravings displayed should match the expected cravings for that phase
