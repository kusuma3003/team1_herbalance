#Author Vinothini
@taglaunchpage
Feature: Launch Page in Her Balance - Non functional

  @launch1
  Scenario: Cycle phases information is displayed
    Given User is on the browser
    When User enters app url
    Then Display cards for 'Menstrual Phase', 'Follicular Phase', 'Ovulation Phase', and 'Luteal Phase'

  @launch2
  Scenario: Cycle tracking app information is visible
    Given User is on the browser
    When User enters app url
    Then Details about the 'Cycle Tracking App' and its features

  @launch3
  Scenario: Login buttons are visible
    Given User is on the browser
    When User enters app url
    Then Login button should be visible

  @launch4
  Scenario: Sign up buttons are visible
    Given User is on the browser
    When User enters app url
    Then Sign button should be visible

  @launch5
  Scenario: Images in Sync your weight loss journey section are displayed
    Given User is on the browser
    When User enters app url
    Then Images in Sync' should be displayed

  @launch6
  Scenario: Informational text under Empower weight loss section
    Given User is on the browser
    When User enters app url
    Then Display information about hormonal shifts and metabolism during the menstrual cycle

  @launch7
  Scenario: Layour and colors are loaded correctly
    Given User is on the browser
    When User enters app url
    Then User should see a light purple background and readable text content

  @launch8
  Scenario: Get started now button are visible
    Given User is on the browser
    When User enters app url
    Then Display a 'Get Started Now' button in the footer section

  @launch9
  Scenario: Start Your Personalized Journey is visible
    Given User is on the browser
    When User enters app url
    Then Start Your Personalized' button should be displayed

  @launch10
  Scenario: Login button is clickable
    Given User is in her balance home
    When User clicks log in button
    Then User should be navigated to auth page login tab

  @launch11
  Scenario: Sign up button is clickable
    Given User is in her balance home
    When User clicks sign up button
    Then User should be navigated to auth page sign up tab

  @launch12
  Scenario: Get started now button are Clickable
    Given User is in her balance home
    When User clicks Get Started button
    Then User should be navigated to auth page login tab

  @launch13
  Scenario: Start Your Personalized Journey is clickable
    Given User is in her balance home
    When User clicks Start your personalized journey button
    Then User should be navigated to auth page login tab
