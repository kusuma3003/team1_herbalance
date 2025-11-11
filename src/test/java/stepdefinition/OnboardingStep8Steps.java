package stepdefinition;

import static org.testng.Assert.assertTrue;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.DriverFactory;
import pageobjects.OnboardingStep6Page;
import pageobjects.OnboardingStep8Page;
import utils.PropertyFileReader;
import utils.TestContextSetup;


public class OnboardingStep8Steps {

	TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;

    OnboardingStep8Page step8Page = new OnboardingStep8Page(driver);

    public OnboardingStep8Steps(TestContextSetup context) {

    	this.context = context;
        step8Page = context.getpageobjectmanager().getonboardingstep8page();
    }

    @Given("the user has completed onboarding up to Step 6")
    public void completed_up_to_step6() {
        System.out.println("User completed Step 6");
    }

    @Given("the user is on Step 7 of the onboarding process")
    public void user_on_step7() {
        Assert.assertTrue(step8Page.isPageTitleDisplayed());
    }

    @When("the user clicks the weight unit dropdown")
    public void user_clicks_weight_dropdown() {
        step8Page.clickWeightDropdown();
    }

    @Then("the options {string} and {string} should be displayed")
    public void verify_weight_unit_options(String opt1, String opt2) {
        Assert.assertTrue(step8Page.verifyDropdownOptions(opt1, opt2));
    }

    @When("the user clicks the height unit dropdown")
    public void user_clicks_height_dropdown() {
        step8Page.clickHeightDropdown();
    }

    @When("the user clicks {string} without entering weight")
    public void click_continue_without_weight(String btn) {
        step8Page.clickContinue();
    }

    @Then("the error message {string} should be displayed")
    public void verify_error_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, step8Page.getErrorMessage());
    }

    @When("the user enters an invalid weight")
    public void enter_invalid_weight() {
        step8Page.enterWeight("abc");
    }

    @When("the user enters an invalid height")
    public void enter_invalid_height() {
        step8Page.enterHeight("xyz");
    }

    @When("the user clicks the {string} button in Step 7")
    public void user_clicks_back_in_step7(String btn) {
        step8Page.clickBackButton();
    }

    @Then("the user should be redirected to Step 6")
    public void redirected_to_step6() {
        Assert.assertTrue(step8Page.isStep6Displayed());
    }

    @When("the user enters valid weight and height")
    public void enter_valid_weight_height() {
        step8Page.enterWeight("60");
        step8Page.enterHeight("165");
    }

    @Then("BMI should be calculated and displayed as {string}")
    public void verify_bmi_display(String bmiText) {
        Assert.assertTrue(step8Page.isBMICalculated());
    }

    @Then("a BMI bar should be visible")
    public void verify_bmi_bar() {
        Assert.assertTrue(step8Page.isBMIBarDisplayed());
    }

    @Then("the BMI bar labels {string}, {string}, {string}, {string} should be displayed in order")
    public void verify_bmi_labels(String a, String b, String c, String d) {
        Assert.assertTrue(step8Page.verifyBMILabels(a, b, c, d));
    }

    @When("the user clicks {string} after entering valid weight and height")
    public void click_continue_step8(String btn) {
        step8Page.clickContinue();
    }

    @Then("the user should be redirected to Step 8")
    public void redirected_to_step8() {
        Assert.assertTrue(step8Page.isStep8Displayed());
    }

    @Then("the onboarding progress bar should show {string}")
    public void verify_progress_bar(String progress) {
        Assert.assertEquals(progress, step8Page.getProgressValue());
    }

    @Then("the title should be {string}")
    public void verify_title(String title) {
        Assert.assertEquals(title, step8Page.getStepTitle());
    }

    @Then("the description should display {string}")
    public void verify_description(String desc) {
        Assert.assertTrue(step8Page.getStepDescription().contains(desc));
    }
}
