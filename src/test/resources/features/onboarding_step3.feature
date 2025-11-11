Feature: Onboarding Scenarios  Step 3  UI verifcation 

  Background:
    Given the user is on the Blood Report Upload page
    And has completed Step 2 of onboarding

  Scenario: Display onboarding progress when skipping blood report
    When the user clicks "Continue Without Report"
    Then the onboarding progress bar should be displayed
    And the progress bar should show the current step as "3 of 11"

  Scenario: Verify navigation buttons on Step 3
    When the user clicks "Continue Without Report"
    Then the "Back" button should be visible and enabled
    And the "Continue" button should be visible and enabled

  Scenario: Verify Step 3 header and subtitle
    When the user clicks "Continue Without Report"
    Then the header should display "Health condition"
    And the subtitle should display "Want to manually enter any key conditions or comorbidities?"

  Scenario: Verify health condition options
    When the user clicks "Continue Without Report"
    Then 9 radio buttons should be visible
    And the options should include:  PCOS Pre-diabetes / Diabetes Sleep apnea Cardiovascular Disease Kidney Disease Hypothyroidism High cholesterol Digestive issues (IBS, leaky gut, etc.) Liver Disease I am perimenopausal or menopausal (age ~45+) should be visible

  Scenario: Verify informational note section
    When the user clicks "Continue Without Report"
    Then the informational note text should be displayed