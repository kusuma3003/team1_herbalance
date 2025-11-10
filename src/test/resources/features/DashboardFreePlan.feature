@Dashboard
Feature: FreePlanDashboard-UIverification

  Background: User is in login page
    Given User is on the HerBalance auth page
    When User clicks login in button after entering  a valid credential

  @Dash01
  Scenario: Title of the Dashboard
    Then User should see Free Plan Dashboard title

  @Dash102
  Scenario: Profile Name visibility
    Then User should see user name on the top right side

  @Dash03
  Scenario: Profile icon Visibility
    Then User should see profile icon near user name

  @Dash04
  Scenario: Notification Icon visibility
    Then User should see bell icon for notification

  @Dash05
  Scenario: Search bar visibility
    Then User should see search bar in dashboard

  @Dash06
  Scenario: Button count
    Then User should see 12 menus in dashboard

  @Dash07
  Scenario: Button text
    Then User Name, "Activity Insights"," Diet Plan","Workout","Water Tracker",  "View Full Cycle Details","Upload Blood Report", "Upgrade to Premium","Generate 7-Day Plan",  "See Premium Plans"

  @Dash08
  Scenario: Sub text for title
    Then "User should see  Free Plan Access to Basic Features", "Enjoy our free plan with basic features and exclusive workout planning"

  @Dash09
  Scenario: Sub text location
    Then Sub text should be located at the centre of the page

  @Dash10
  Scenario: 5 Section visibility
    Then 5 section should be visible

  @Dash11
  Scenario: Section heading text
    Then Weight & Body Metrics,Health Conditions,Blood Report Insights,Menstrual Cycle Insights,Subscription Information

  @Dash12
  Scenario: Metrics Section Displays All Relevant Sub-sections
    Then Weight , Height , BMI , 7-Day Goal,BMI Reference Guide

  @Dash13
  Scenario: 7-Day Goal section details
    Then App should have Starting weight, Goal , Weekly target, Daily Weigh-in

  @Dash14
  Scenario: Weight Value Displayed from Onboarding
    Then Should display the users weight as entered during the onboarding process

  @Dash15
  Scenario: Height Value Displayed from Onboarding
    Then Should display the users Height as entered during the onboarding process

  @Dash16
  Scenario: BMI Calculation on Dashboard
    Then BMI should be correctly calculated using the formula

  @Dash17
  Scenario: Starting weight value check
    Then Should display weight entered by user

  @Dash18
  Scenario: Goal weight value check
    Then Goal weight should be displayed as the difference from the weekly target

  @Dash19
  Scenario: Weekly target value check
    Then Weekly target should be .7 kg

  @Dash20
  Scenario: Daily weigh in schedule display
    Then Daily weigh in should be - "Morning before,break food"

  @Dash21
  Scenario: subcription details should be displayed in 7-day goal
    Then Subcription details should be present in 7-day goal section

  @Dash22
  Scenario: Presence of slider in BMI reference guide
    Then Slider should be present in BMI reference guide

  @Dash23
  Scenario: BMI reference guide section is visible
    Then BMI Reference Guide component should be displayed with a gradient slider and labeled ranges

  @Dash24
  Scenario: gradient color representation
    Then slider should display a continuous gradient from blue to yellow to orange to red, representing increasing BMI values

  @Dash25
  Scenario: BMI category labels
    Then Labels "Underweight (18.5)", "Normal (25)", "Overweight (30)", and "Obese (40+)" should be visible and color-coded accordingly

  @Dash26
  Scenario: BMI pointer position based on user’s BMI
    Then Circular pointer should automatically be positioned on the slider corresponding to the users BMI value

  @Dash27
  Scenario: Slider is non-interactive
    Then Slider should not allow manual movement; it should remain fixed based on the users BMI

  @Dash28
  Scenario: Info label visibility
    Then "Info" label should be visible above the slider

  @Dash29
  Scenario: Free plan note
    Then Message Free plan includes 7 days of limited tracking should be displayed clearly below the slider
