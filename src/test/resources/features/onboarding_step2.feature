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