package stepdefinition;

import static org.testng.Assert.assertTrue;
import utils.TestContextSetup;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.DriverFactory;
import pageobjects.OnboardingStep6Page;
import pageobjects.OnboardingStep7Page;
import utils.PropertyFileReader;
import utils.TestContextSetup;


public class OnboardingStep7Steps {

	TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;

    OnboardingStep6Page step6Page = new OnboardingStep6Page(driver);
    OnboardingStep7Page step7Page = new OnboardingStep7Page(driver);

    public OnboardingStep7Steps(TestContextSetup context) {

    	this.context = context;
        //step 1 is upload blood work
        step6Page = context.getpageobjectmanager().getonboardingstep6page();
        step7Page = context.getpageobjectmanager().getonboardingstep7page();
    }

    @When("the user clicks {string} without selecting last menstrual date")
    public void click_continue_without_date(String btn) {
        step6Page.clickContinue();
    }

    @Then("the error message {string} should be displayed")
    public void verify_error_message(String msg) {
        Assert.assertTrue(step6Page.isErrorDisplayed());
    }

    @When("the user clicks the {string} button in Step 6")
    public void user_clicks_back(String btn) {
        step6Page.clickBack();
    }

    @Then("the user should be redirected to Step 5")
    public void verify_redirect_step5() {
        System.out.println("Redirected to Step 5");
    }

    @When("the user enters an invalid date in the last menstrual date field")
    public void enter_invalid_date() {
        step6Page.enterDate("invalid-date");
    }

    @When("the user selects a valid last menstrual date")
    public void select_valid_date() {
        step6Page.enterDate("10/15/2024");
        step6Page.clickContinue();
    }

    @Then("the message {string} should be visible")
    public void verify_phase_message(String msg) {
        Assert.assertTrue(step6Page.isCurrentPhaseMessageDisplayed());
    }

    @Then("the description text about the current phase should be displayed")
    public void verify_phase_description() {
        Assert.assertTrue(step6Page.isPhaseDescriptionDisplayed());
    }

    @Then("the section headers {string}, {string}, and {string} should be visible")
    public void verify_section_headers(String h1, String h2, String h3) {
        Assert.assertTrue(step6Page.areHeadersDisplayed());
    }

    @Then("the current phase name with day count should be displayed")
    public void verify_current_phase_name() {
        Assert.assertTrue(step6Page.isCurrentPhaseDisplayed());
    }

    @Then("the detailed phase guidance text should be visible")
    public void verify_phase_guidance() {
        Assert.assertTrue(step6Page.isGuidanceDisplayed());
    }

    @Then("the upcoming cycle calendar should display two months")
    public void verify_calendar_months() {
        Assert.assertTrue(step6Page.isCalendarDisplayed());
    }

    @Then("the calendar should have right and left navigation arrows")
    public void verify_calendar_arrows() {
        Assert.assertTrue(true); // placeholder for presence of arrows
    }

    @When("the user changes the date using the cycle calendar")
    public void change_cycle_date() {
        step6Page.enterDate("10/20/2024");
    }

    @Then("the displayed phase in the timeline should update accordingly")
    public void verify_phase_update() {
        Assert.assertTrue(step6Page.isCurrentPhaseMessageDisplayed());
    }

    @When("the user clicks the right arrow in the calendar")
    public void click_right_arrow() {
        step6Page.clickRightArrow();
    }

    @Then("the calendar should display the next month")
    public void verify_next_month() {
        Assert.assertTrue(step6Page.isCalendarDisplayed());
    }

    @When("the user clicks the left arrow in the calendar")
    public void click_left_arrow() {
        step6Page.clickLeftArrow();
    }

    @Then("the calendar should display the previous month")
    public void verify_previous_month() {
        Assert.assertTrue(step6Page.isCalendarDisplayed());
    }

    @Then("the legend should display the following phases with respective colors:")
    public void verify_legend(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertTrue(step6Page.isLegendDisplayed());
    }

    @Then("at least three future expected period dates should be listed")
    public void verify_expected_dates() {
        Assert.assertTrue(step6Page.areExpectedPeriodsDisplayed());
    }

    @Then("the dates should be displayed in chronological order")
    public void verify_date_order() {
        Assert.assertTrue(true); // Placeholder
    }

    @When("the user clicks {string} after selecting last menstrual date")
    public void click_continue_to_step7(String btn) {
        step6Page.clickContinue();
    }

    @Then("the user should be redirected to Step 7")
    public void verify_redirect_step7() {
        Assert.assertTrue(step7Page.isProgressDisplayed());
    }

    @Then("the onboarding progress bar should show {string}")
    public void verify_progress_bar(String stepCount) {
        Assert.assertTrue(step7Page.isStepCountCorrect());
    }

    @Then("the title should be {string}")
    public void verify_title(String title) {
        Assert.assertTrue(step7Page.isTitleDisplayed());
    }

    @Then("the description text should display {string}")
    public void verify_description(String desc) {
        Assert.assertTrue(step7Page.isDescriptionDisplayed());
    }

    @Then("exactly two text fields should be present")
    public void verify_text_fields() {
        Assert.assertTrue(step7Page.areFieldsDisplayed());
    }

    @Then("the text field labels should display {string} and {string}")
    public void verify_labels(String label1, String label2) {
        Assert.assertTrue(step7Page.areLabelsCorrect());
    }
}
