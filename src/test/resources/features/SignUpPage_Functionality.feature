#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Sign up Functionality on HerBalance Auth Page

Background: User is clicked Sign up button in home page

  
   Scenario Outline: Run multiple registration tests from Excel
    Given User is on the HerBalance auth page
    When the user enters testdata for each "<scenario>"
    Then user should able to see this expected output
    
    Examples:
      | scenario                                                     |
      | Successful registration with valid credentials               |
      | Registration attempt with invalid details in user name       |
      | Registration attempt with  password length 5                 |
      | Registration attempt with mismatch passwords                 |
      | Registration attempt with empty fields                       |
      | Registration attempt without accepting terms and condition   |
     
     
   Scenario Outline: Verify password visibility toggle behavior
    Given User is on the HerBalance auth page
    When User enters "<password>" in "<field>" field and performs "<action>"
    Then The "<field>" field should display password as "<visibility>"

    Examples:
      | password  | field             | action               | visibility |
      | User@123  | password          | click eye icon       | visible    |
      | User@123  | password          | click eye icon again | masked     |
      | User@123  | confirm password  | click eye icon       | visible    |
      | User@123  | confirm password  | click eye icon again | masked     |

    
    Scenario: Navigate to login page
    Given User is on the HerBalance auth page
    When user clicks on "Login"
    Then User should be redirected to the login tab

 

 