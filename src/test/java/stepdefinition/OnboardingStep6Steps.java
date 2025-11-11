package stepdefinition;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.DriverFactory;
import pageobjects.OnboardingStep6Page;
import pageobjects.OnboardingStep5Page;
import utils.PropertyFileReader;
import utils.TestContextSetup;


public class OnboardingStep6Steps {

	TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;

    OnboardingStep6Page step6Page = new OnboardingStep6Page(driver);
    OnboardingStep5Page step5Page = new OnboardingStep5Page(driver);

    public OnboardingStep6Steps(TestContextSetup context) {

        this.context = context;
        step6Page = context.getpageobjectmanager().getonboardingstep6page();
        step5Page = context.getpageobjectmanager().getonboardingstep5page();

    }

    @When("the user clicks the Continue button without selecting menstrual cycle info")
    public void user_clicks_continue_without_selecting_cycle() {
        step5Page.clickContinue();
    }

    @Then("the error message {string} should be displayed")
    public void verify_error_message(String expectedMsg) {
    	 Assert.assertTrue( step5Page.isErrorDisplayed());
    }

    @When("the user clicks the Back button in Step 5")
    public void user_clicks_back_button_in_step5() {
        step5Page.clickBack();
    }

    @Then("the user should be redirected to Step 4")
    public void verify_redirect_to_step4() {
        System.out.println("User redirected to Step 4");
    }

    @When("the user selects their menstrual cycle info in Step 5")
    public void user_selects_menstrual_cycle_info() {
        step5Page.selectCycleOption("Yes, I track my cycle");
    }

    @When("clicks the Continue button")
    public void clicks_continue_button() {
        step5Page.clickContinue();
    }

    @Then("the user should be redirected to Step 6")
    public void verify_redirect_to_step6() {
        Assert.assertTrue(step5Page.isProgressBarDisplayed());
    }

    @Then("the onboarding progress bar should show {string}")
    public void verify_progress_step(String expectedStep) {
        Assert.assertTrue(step5Page.isStepCountDisplayed());
    }

    @Then("the title should be {string}")
    public void verify_step6_title(String expectedTitle) {
        Assert.assertTrue(step5Page.isTitleDisplayed());
    }

    @Then("the description should display {string}")
    public void verify_step6_description(String expectedDesc) {
        Assert.assertTrue(step5Page.isDescriptionDisplayed());
    }

    @Then("the question {string} should be visible")
    public void verify_step6_question(String questionText) {
        Assert.assertTrue(step5Page.isQuestionDisplayed());
    }

    @Then("the calendar icon should be visible inside the date input field")
    public void verify_calendar_icon() {
        Assert.assertTrue(step6Page.isCalendarIconDisplayed());
    }

    @Then("the date input field should have placeholder {string}")
    public void verify_date_placeholder(String expectedPlaceholder) {
        Assert.assertTrue(step6Page.isDatePlaceholderCorrect());
    }

    @Then("the label below the date field should display {string}")
    public void verify_cycle_label(String expectedLabel) {
        Assert.assertTrue(step6Page.isCycleLengthLabelDisplayed());
    }

    @Then("the slider control for cycle length should be displayed")
    public void verify_slider_displayed() {
        Assert.assertTrue(step6Page.isSliderDisplayed());
    }

    @Then("the default cycle length value should be {string}")
    public void verify_default_cycle_value(String expectedValue) {
        Assert.assertTrue(step6Page.isDefaultCycleLengthDisplayed());
    }

    @Then("the information text {string} should be visible")
    public void verify_info_text(String info) {
        Assert.assertTrue(step6Page.isInfoTextDisplayed());
    }
}
