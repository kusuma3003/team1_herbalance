@DashboardBloodReportInsights
Feature: Blood Report Insights - report uploaded

  Background: User has completed onboarding and uploaded report
    Given User is on the HerBalance auth page
    When User clicks login in button after entering  a valid credential

  @Dash34
  Scenario: Display Blood Report Insights based on report uploaded
    Then Blood Report Insights section should display the personalized values and insights

  @Dash35
  Scenario: Display Blood Report Insights based on report not uploaded
    Then User should see the Upload Blood Report button

  @Dash36
  Scenario: Message for Blood report
    Then Message prompting them to upload their medical blood test report

  @Dash37
  Scenario: Upload report button
    Then Upload Blood Report" button should be enabled
