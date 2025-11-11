package stepdefinition;

import static org.testng.Assert.assertTrue;
import utils.TestContextSetup;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.DriverFactory;
import pageobjects.OnboardingStep5Page;
import pageobjects.OnboardingStep4Page;
import utils.PropertyFileReader;
import utils.TestContextSetup;


public class OnboardingStep5Steps {

	TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;

    OnboardingStep5Page step5Page = new OnboardingStep5Page(driver);
    OnboardingStep4Page step4Page = new OnboardingStep4Page(driver);

    public OnboardingStep5Steps(TestContextSetup context) {

    	this.context = context;
        //step 1 is upload blood work
        step5Page = context.getpageobjectmanager().getonboardingstep5page();
    }

    // --- Background ---
    @Given("the user has completed onboarding up to Step 3")
    public void user_completed_step3() {
        System.out.println("User completed Step 3 successfully.");
    }

    @And("the user is on Step 4 of the onboarding process")
    public void user_on_step4() {
        System.out.println("User is currently on Step 4 (Personal Details).");
    }

    // --- Step 4 Error Validations ---
    @When("the user enters an invalid first name")
    public void user_enters_invalid_first_name() {
        step4Page.enterFirstName("12345");
    }

    @When("the user enters an invalid age")
    public void user_enters_invalid_age() {
        step4Page.enterAge("abc");
    }

    @When("the user does not select a blood pressure status")
    public void user_skips_blood_pressure() {
        System.out.println("User did not select any blood pressure status.");
    }

    @And("clicks the {string} button")
    public void user_clicks_button(String button) {
        System.out.println("Clicked button: " + button);
    }

    @Then("the error message {string} should be displayed")
    public void error_message_displayed(String expectedMessage) {
    	 Assert.assertTrue(
                 step4Page.isErrorDisplayed(expectedMessage));
    }

    // --- Navigation between Steps ---
    @When("the user clicks the {string} button in Step 4")
    public void user_clicks_back_in_step4(String buttonName) {
        System.out.println("Clicked " + buttonName + " in Step 4.");
    }

    @Then("the user should be redirected to Step 3")
    public void user_redirected_to_step3() {
        System.out.println("User redirected to Step 3.");
    }

    @When("the user enters all required details in Step 4")
    public void user_enters_valid_details() {
        step4Page.enterFirstName("Emma");
        step4Page.enterAge("28");
        step4Page.selectBloodPressureOption("Normal");
    }

    @Then("the user should be redirected to Step 5")
    public void redirected_to_step5() {
        System.out.println("Redirected to Step 5 (Menstrual Cycle Awareness).");
    }

    @And("the onboarding progress bar should be displayed")
    public void progress_bar_displayed() {
        Assert.assertTrue(step5Page.isProgressBarDisplayed());
    }

    @And("the progress bar should show {string}")
    public void progress_bar_shows_text(String stepText) {
    	Assert.assertTrue( step5Page.isProgressTextDisplayed());
    }

    @And("the {string} button should be visible and enabled")
    public void verify_buttons(String buttonName) {
        if (buttonName.equals("Back")) {
            Assert.assertTrue(step5Page.isBackButtonVisible());
            Assert.assertTrue(step5Page.isBackButtonEnabled());
        } else if (buttonName.equals("Continue")) {
            Assert.assertTrue(step5Page.isContinueButtonVisible());
            Assert.assertTrue(step5Page.isContinueButtonEnabled());
        }
    }

    // --- Step 5 UI Verification ---
    @When("the user navigates to Step 5")
    public void user_navigates_to_step5() {
        System.out.println("User is now on Step 5 page.");
    }

    @Then("the title should be {string}")
    public void verify_title(String expectedTitle) {
    	 Assert.assertTrue( step5Page.isTitleDisplayed());
        Assert.assertEquals(expectedTitle, step5Page.getTitleText());
    }

    @And("the description should display {string}")
    public void verify_description(String expectedDescription) {
    	 Assert.assertTrue(step5Page.isDescriptionDisplayed());
        Assert.assertEquals(expectedDescription, step5Page.getDescriptionText());
    }

    @Then("the question {string} should be visible")
    public void verify_question(String expectedQuestion) {
    	Assert.assertTrue( step5Page.isQuestionDisplayed());
    }

    @And("{int} radio buttons should be visible")
    public void verify_radio_buttons_count(int expectedCount) {
    	Assert.assertEquals( expectedCount, step5Page.getRadioButtonCount());
    }

    @And("the options for menstrual cycle awareness should be displayed")
    public void verify_radio_options() {
    	 Assert.assertTrue( step5Page.areRadioOptionsDisplayed());
    }
}
