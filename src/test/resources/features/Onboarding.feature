Feature: Blood Report Upload Modal  navigation

  Background:
    Given the user is on the Sign Up page
    And has entered valid registration details

  Scenario: Navigate to Blood Report Upload Modal
    When the user clicks the "Register" button
    Then the page title should be "Upload Your Recent Blood Work"
    And the supporting text for the title should be displayed
    And the onboarding progress bar is visible
    And the progress bar shows "Step 1 of 10"

  Scenario: Verify Upload PDF button
    When the user clicks the "Register" button
    Then the "Upload PDF" button is displayed
    And the "Upload PDF" button is enabled
    And the note "PDF files only (Max 10MB)" is displayed

  Scenario: Verify Skip Option
    When the user clicks the "Register" button
    Then the "Skip for Now" card is visible
    And the explanation text about continuing without lab results is displayed
    And the "Continue Without Report" button is displayed
    And the "Continue Without Report" button is enabled

  Scenario: Verify Data Security Information
    When the user clicks the "Register" button
    Then the note about secure processing and no sharing with third parties is displayed

Feature: Upload Functionality

  Background:
    Given the user is on the Sign Up page
    And has entered valid registration details
    And has navigated to the Blood Report Upload page

  Scenario: Navigate to Step 3 without uploading report
    When the user clicks the "Continue Without Report" button
    Then the user should be redirected to Step 3 of the onboarding process

  Scenario: Open file explorer to upload PDF
    When the user clicks the "Upload Blood Report" button
    Then the system should open Windows Explorer to select a file

  Scenario: Upload unsupported file type
    When the user selects an invalid file type and clicks "Upload PDF"
    Then the system should display the error "Only PDF files are supported"

  Scenario: Upload file exceeding size limit
    When the user selects a file larger than 10MB and clicks "Upload PDF"
    Then the system should display the error "File exceeds 10MB"

  Scenario: Upload valid PDF file
    When the user selects a valid PDF file and clicks "Upload PDF"
    Then the system should display a processing percentage bar
    And the system should show the report analysis page

  Scenario: Verify fields on report analysis
    Given the user has uploaded a valid PDF file
    Then the report analysis page should display: 
    Blood Test Results,Complete Blood Count, Medical Conditions ,Abnormal Values, 
    
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
    And the options should include:       
 	
      PCOS
      Pre-diabetes / Diabetes
      Sleep apnea
      Cardiovascular Disease
      Kidney Disease
      Hypothyroidism
      High cholesterol
      Digestive issues (IBS, leaky gut, etc.)
      Liver Disease
      I am perimenopausal or menopausal (age ~45+) should be visible

  Scenario: Verify informational note section
    When the user clicks "Continue Without Report"
    Then the informational note text should be displayed

Feature: Onboarding Step 3 Functionality and Step 4 UI Verification

  Background:
    Given the user has completed onboarding up to Step 2
    And the user is on Step 3 of the onboarding process

  Scenario: Navigate to Step 4 after selecting health conditions
    When the user selects one or more health conditions
    And clicks the "Continue" button
    Then the user should be redirected to Step 4

  Scenario: Display onboarding progress on Step 4
    When the user clicks "Continue" after selecting health conditions
    Then the onboarding progress bar should be displayed
    And the progress bar should show the current step as "4 of 11"

  Scenario: Verify navigation buttons on Step 4
    When the user clicks "Continue" after selecting health conditions
    Then the "Back" button should be visible and enabled
    And the "Continue" button should be visible and enabled

  Scenario: Verify Step 4 title and description
    When the user navigates to Step 4
    Then the title should be "Personal Details"
    And the description text should display "Let’s get to know you better to personalize your experience."

  Scenario: Verify input fields on Step 4
    When the user navigates to Step 4
    Then 2 input boxes should be visible
    And the field labels should be:
       What’s your first name?,
       What’s your age?,
       What best describes your blood pressure status?
    And helper text should be displayed under each field

  Scenario: Verify radio buttons on Step 4
    When the user navigates to Step 4
    Then 4 radio buttons should be visible
    And the options for blood pressure should be displayed

Feature: Onboarding Step 4 Functionality and Step 5 UI Verification

  Background:
    Given the user has completed onboarding up to Step 3
    And the user is on Step 4 of the onboarding process

  Scenario: Error message for invalid first name
    When the user enters an invalid first name
    And clicks the "Continue" button
    Then the error message "Please enter valid name" should be displayed

  Scenario: Error message for invalid age
    When the user enters an invalid age
    And clicks the "Continue" button
    Then the error message "Please enter a number" should be displayed

  Scenario: Error message for missing blood pressure status
    When the user does not select a blood pressure status
    And clicks the "Continue" button
    Then the error message "Please select your blood pressure status" should be displayed

  Scenario: Navigating back to Step 3
    When the user clicks the "Back" button in Step 4
    Then the user should be redirected to Step 3

  Scenario: Navigate to Step 5 after entering valid details
    When the user enters all required details in Step 4
    And clicks the "Continue" button
    Then the user should be redirected to Step 5
    And the onboarding progress bar should be displayed
    And the progress bar should show "5 of 11"
    And the "Back" button should be visible and enabled
    And the "Continue" button should be visible and enabled

  Scenario: Verify Step 5 title and description
    When the user navigates to Step 5
    Then the title should be "Menstrual Cycle Awareness"
    And the description should display "Understanding your cycle helps us optimize your weight loss journey."

  Scenario: Verify Step 5 question and options
    When the user navigates to Step 5
    Then the question "Do you currently track your menstrual cycle?" should be visible
    And 5 radio buttons should be visible
    And the options for menstrual cycle awareness should be displayed

Feature: Onboarding Step 5 Functionality and Step 6 UI Verification

  Background:
    Given the user has completed onboarding up to Step 4
    And the user is on Step 5 of the onboarding process

  Scenario: Error message for not selecting menstrual cycle tracking
    When the user clicks the "Continue" button without selecting menstrual cycle info
    Then the error message "Please select your menstrual cycle track" should be displayed

  Scenario: Navigating back to Step 4
    When the user clicks the "Back" button in Step 5
    Then the user should be redirected to Step 4

  Scenario: Navigate to Step 6 after selecting menstrual cycle info
    When the user selects their menstrual cycle info in Step 5
    And clicks the "Continue" button
    Then the user should be redirected to Step 6
    And the onboarding progress bar should be displayed
    And the progress bar should show "6 of 11"
    And the "Back" button should be visible and enabled
    And the "Continue" button should be visible and enabled

  Scenario: Verify Step 6 title and description
    When the user navigates to Step 6
    Then the title should be "Last Period Date"
    And the description should display "This helps us understand your current cycle phase and tailor recommendations."

  Scenario: Verify date input and question visibility
    When the user navigates to Step 6
    Then the question "When did your last menstrual period start?" should be visible
    And the calendar icon should be visible inside the date input field
    And the date input field should have placeholder "mm/dd/yyyy"

  Scenario: Verify cycle length slider and label
    When the user navigates to Step 6
    Then the label below the date field should display "Cycle Length (days)"
    And the slider control for cycle length should be displayed
    And the default cycle length value should be "28"
    And the information text "Average cycle length is 28 days, but can vary from 21 to 45 days" should be visible

Feature: Onboarding Step 6 Functionality and Step 7 UI Verification

  Background:
    Given the user has completed onboarding up to Step 5
    And the user is on Step 6 of the onboarding process

  Scenario: Error message for not selecting last menstrual date
    When the user clicks "Continue" without selecting last menstrual date
    Then the error message "Please select your last period start date" should be displayed

  Scenario: Navigating back to Step 5
    When the user clicks the "Back" button in Step 6
    Then the user should be redirected to Step 5

  Scenario: Error message for invalid date input
    When the user enters an invalid date in the last menstrual date field
    And clicks "Continue"
    Then the error message "Please select your last period start date" should be displayed

  Scenario: Display of current phase message
    When the user selects a valid last menstrual date
    Then the message "Based on your last period starting on <date>, you're currently in the [CurrentPhase]." should be visible
    And the description text about the current phase should be displayed

  Scenario: Verify section headers
    When the user selects a valid last menstrual date
    Then the section headers "Your Cycle Timeline", "Your Upcoming Cycle Calendar", and "Your Next Expected Periods" should be visible

  Scenario: Verify current phase details
    When the user selects a valid last menstrual date
    Then the current phase name with day count (e.g., "Menstrual Phase (Day 3)") should be displayed
    And the detailed phase guidance text should be visible

  Scenario: Verify calendar display
    When the user selects a valid last menstrual date
    Then the upcoming cycle calendar should display two months (current month and next month)
    And the calendar should have right and left navigation arrows

  Scenario: Changing last period date updates timeline
    Given the user has selected the last menstrual date
    When the user changes the date using the cycle calendar
    Then the displayed phase in the timeline should update accordingly

  Scenario: Navigation of months using calendar arrows
    Given the user has selected the last period date
    When the user clicks the right arrow in the calendar
    Then the calendar should display the next month
    When the user clicks the left arrow in the calendar
    Then the calendar should display the previous month

  Scenario: Verify cycle phase legend
    When the user selects a valid last menstrual date
    Then the legend should display the following phases with respective colors:
      | Phase             | Color Indicator |
      | Menstrual Phase   | Red / Pink      |
      | Ovulation Phase   | Blue            |
      | Follicular Phase  | Light Purple    |
      | Luteal Phase      | Lavender        |

  Scenario: Display of next expected periods
    When the user selects a valid last menstrual date
    Then at least three future expected period dates should be listed
    And the dates should be displayed in chronological order

  Scenario: Navigate to Step 7
    When the user clicks "Continue" after selecting last menstrual date
    Then the user should be redirected to Step 7
    And the onboarding progress bar should show "7 of 11"
    And the title should be "Current Weight and Height"
    And the description text should display "This helps us calculate your BMI and set appropriate goals"
    And exactly two text fields should be present
    And the text field labels should display "What’s your current weight?" and "What’s your height?"

Feature: Onboarding Step 7 Functionality and Step 8 UI Verification 

  Background:
    Given the user has completed onboarding up to Step 6
    And the user is on Step 7 of the onboarding process

  Scenario: Weight unit dropdown visibility
    When the user clicks the weight unit dropdown
    Then the options "kg" and "lbs" should be displayed

  Scenario: Height unit dropdown visibility
    When the user clicks the height unit dropdown
    Then the options "cm" and "ft/in" should be displayed

  Scenario: Error message for missing weight
    When the user clicks "Continue" without entering weight
    Then the error message "Weight is required" should be displayed

  Scenario: Error message for invalid weight
    When the user enters an invalid weight
    And clicks "Continue"
    Then the error message "Enter a valid weight" should be displayed

  Scenario: Error message for missing height
    When the user clicks "Continue" without entering height
    Then the error message "Height is required" should be displayed

  Scenario: Error message for invalid height
    When the user enters an invalid height
    And clicks "Continue"
    Then the error message "Enter a valid height" should be displayed

  Scenario: Navigate back to Step 6
    When the user clicks the "Back" button in Step 7
    Then the user should be redirected to Step 6

  Scenario: BMI calculation and display
    When the user enters valid weight and height
    Then the label "BMI Calculation" should be displayed
    And BMI should be calculated and displayed as "Your BMI is [calculated value]"
    And a BMI bar should be visible
    And the BMI bar labels "Underweight", "Normal", "Overweight", "Obese" should be displayed in order
    And the color codes for the BMI bar should align with the categories:
      | Category       | Color   |
      | Underweight    | Blue    |
      | Normal         | Yellow  |
      | Overweight     | Orange  |
      | Obese          | Red     |
    And the BMI indicator should fall in the correct category based on calculated BMI

  Scenario: Display sections and headings
    When the user enters valid weight and height
    Then two sections should be visible
    And the section headings "[Current Phase] note" and "BMI Feedback" should be displayed
    And the current phase note should reflect the user’s menstrual phase and BMI
    And the BMI feedback messages should correspond to the calculated BMI range

  Scenario: Navigate to Step 8
    When the user clicks "Continue" after entering valid weight and height
    Then the user should be redirected to Step 8
    And the onboarding progress bar should show "8 of 11"
    And the title should be "Dietary Preferences"
    And the description should display "Let us know about your eating habits to provide suitable meal recommendations"
    And four sections should be visible
    And the section titles "Pescatarian Diet", "Non-Vegetarian", "Vegetarian Diet", "Vegan Diet" should be displayed
    And description text for each diet should be visible
    And the informational note "Understanding your dietary preferences ensures our meal recommendations align with your lifestyle." should be displayed
    And the "Continue" button should be 
    

Feature: Onboarding Step 8 Functionality and Step 9 UI Verification

  Background:
    Given the user has completed onboarding up to Step 7
    And the user is on Step 8 of the onboarding process

  Scenario: Highlight selected diet option
    When the user clicks any dietary option
    Then the selected diet should be highlighted

  Scenario: Continue button enables upon dietary selection
    When the user clicks any dietary option
    Then the "Continue" button should be enabled

  Scenario: Navigate back to Step 7
    When the user clicks the "Back" button in Step 8
    Then the user should be redirected to Step 7

  Scenario: Navigate to Step 9
    When the user clicks "Continue" after selecting any dietary option
    Then the user should be redirected to Step 9
    And the onboarding progress bar should show "9 of 11"
    And the title should be "Physical Activity Level"
    And the description should display "Help us understand your current exercise routine to design an appropriate fitness plan."
    And four sections should be visible
    And the section titles "Sedentary", "Lightly Active", "Moderately Active", "Very Active" should be displayed
    And description text for each section should be visible
    And a radio button should be displayed in all sections
    And the informational note "Your activity level helps us design a fitness plan that’s both effective and manageable." should be displayed
    And the "Continue" button should be disabled

Feature: Onboarding Step 9 Functionality and Step 10 UI verification

  Background:
    Given the user has completed onboarding upto Step 8
    And the user is on Step 9 of onboarding process

  Scenario: Highlight selected activity level
    When the user click any of the activity level
    Then the selected activity level should be highlited

  Scenario: Continue button enables upon activity level selection
    When the user click any of the activity level
    Then the "Continue" button should be enbaled

  Scenario: Radio button selection functionality
    When the user click any of the activity level
    Then the radio button in the selected activity level should be mark as selected

  Scenario: Navigate back to Step 8
    When the user clicks back button in Step 9
    Then the user should be redirect to Step 8

  Scenario: Navigate to Step 10
    When the user clicks continue after selecting any activity level
    Then the user should be redirect to Step 10
    And the onboarding progress bar should show "10 of 11"
    And the title should be "Food Allergies & Sensitivites"
    And the description should display "Do you have any food allergies or intolerances?"
    And four sections should be visble
    And the section titles "Yes, I have food allergies", "Yes, I have food intolerances/sensitivities", "No, I can eat everything", "I'm not sure" should be displayed
    And description text for each section should be visble
    And a radio button should be displayed in all sections
    And the info note "Food sensitivities can impact digestion, inflamamation, and even energy levels. Knowing what works best for your body helps us create meal plans that keep you feeling your best!" should be displayed

Feature: Onboarding Step 10 Functionality and Step 11 UI verification

  Background:
    Given the user has completed onboarding upto Step 9
    And the user is on Step 10 of onboarding

  Scenario: Highlight selected section
    When the user click any options under Food Allergies & Sensitivities
    Then the selected section should be highlited

  Scenario: Radio button selection functionality
    When the user click any options under Food Allergies & Sensitivities
    Then the radio button in the selected section should be mark as selected

  Scenario: Navigate back to Step 9
    When the user clicks back button in Step 10
    Then the user should be redirect to Step 9

  Scenario: Error message for not selecting any options
    When the user clicks continue button without selecting any option
    Then error message "Please select an option" should be displayed

  Scenario: Navigate to Step 11
    When the user clicks continue after selecting any options under Food Allergies & Sensitivities
    Then the user should be redirect to Step 11
    And the progress bar should show "11 of 11"
    And the title should be "Medications & Supplements"
    And the description should be "Do you currently take any medications or supplements?"
    And four sections should be visble
    And the section titles "Yes, I take prescription medications", "Yes, I take supplements", "Yes, I take both", "No, I don’t take any medications or supplements" should be displayed
    And description text for each section should be visble
    And examples like  
        eg:Yes, I take prescription medications
        Doctor-prescribed medications
        Yes, I take supplements
        Vitamins, minerals, or other supplements
        Yes, I take both
        Both medications and supplements
        No, I don’t take any medications or supplements
        Not currently taking anything
      should be displayed
    And a radio button should be displayed in all sections
    And the info note "Boost Your Wellness Game: Why Knowing Your Meds & Supplements Matters
        Tailoring your nutrition and fitness to match what you’re taking helps prevent unwanted side effects and keeps your results on track" should be displayed

Feature: Onboarding Step 11 Functionality

  Background:
    Given the user has completed onboarding upto Step 10
    And the user is on Step 11 of onboarding

  Scenario: Highlight selected section
    When the user click any options under Medications & Supplements
    Then the selected section should be highlited

  Scenario: Radio button selection functionality
    When the user click any options under Medications & Supplements
    Then the radio button in the selected section should be mark as selected

  Scenario: Navigate back to Step 10
    When the user clicks back button in Step 11
    Then the user should be redirect to Step 10

  Scenario: Error message for not selecting any options
    When the user clicks continue button without selecting any option
    Then error message "Please select an option" should be displayed

  Scenario: Complete button functionality
    When the user clicks complete button after selecting any options under Medications & Supplements
    Then the user should be navigated to the subscription page