package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverfactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.OnboardingStep3Page;
import utils.PropertyFileReader;
import utils.TestContextSetup;

public class OnboardingStep3Steps {

	TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;
    

    OnboardingStep3Page step3page1 = new OnboardingStep3Page(driver);

    public OnboardingStep3Steps(TestContextSetup context) {

    	this.context = context;
        step3page1 = context.getpageobjectmanager().getonboardingstep3page();
    }

    @Given("the user is on the Blood Report Upload page")
    public void user_is_on_blood_report_upload_page() {
        System.out.println("Navigated to Blood Report Upload page");
    }

    @And("has completed Step 2 of onboarding")
    public void completed_step2_onboarding() {
        System.out.println("Completed Step 2");
    }

    @When("the user clicks {string}")
    public void user_clicks_button(String buttonName) {
        if (!buttonName.equalsIgnoreCase("Continue Without Report")) {
        	throw new IllegalArgumentException("Unknown button: " + buttonName);
        }
    }

    // --- Scenario: Display onboarding progress ---
    @Then("the onboarding progress bar should be displayed")
    public void onboarding_progress_bar_displayed() {
        Assert.assertTrue(step3page1.isProgressBarDisplayed());
    }

    @Then("the progress bar should show the current step as {string}")
    public void progress_bar_shows_current_step(String expectedStep) {
        Assert.assertTrue(step3page1.isProgressTextDisplayed());
    }

    // --- Scenario: Verify navigation buttons ---
    @Then("the {string} button should be visible and enabled")
    public void button_visible_and_enabled(String buttonName) {
        switch (buttonName) {
            case "Back":
                Assert.assertTrue(step3page1.isBackButtonVisible());
                Assert.assertTrue(step3page1.isBackButtonEnabled());
                break;
            case "Continue":
                Assert.assertTrue(step3page1.isContinueButtonVisible());
                Assert.assertTrue(step3page1.isContinueButtonEnabled());
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + buttonName);
        }
    }

    // --- Scenario: Verify header and subtitle ---
    @Then("the header should display {string}")
    public void verify_header(String expectedHeader) {
        Assert.assertTrue(step3page1.isHeaderDisplayed());
        Assert.assertEquals(expectedHeader, step3page1.getHeaderText());
    }

    @Then("the subtitle should display {string}")
    public void verify_subtitle(String expectedSubtitle) {
        Assert.assertTrue(step3page1.isSubtitleDisplayed());
        Assert.assertEquals(expectedSubtitle, step3page1.getSubtitleText());
    }

    // --- Scenario: Verify health condition options ---
    @Then("{int} radio buttons should be visible")
    public void verify_radio_buttons_count(int expectedCount) {
        Assert.assertEquals(expectedCount, step3page1.getRadioButtonCount());
    }

    @Then("the options should include:")
    public void verify_condition_options(io.cucumber.datatable.DataTable dataTable) {
        for (String option : dataTable.asList()) {
            Assert.assertTrue(step3page1.areConditionOptionsDisplayed(option));
        }
    }

    // --- Scenario: Verify informational note ---
    @Then("the informational note text should be displayed")
    public void verify_informational_note() {
        Assert.assertTrue(step3page1.isInformationalNoteDisplayed());
    }

}
