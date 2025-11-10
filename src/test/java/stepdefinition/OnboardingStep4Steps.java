package stepdefinition;

import static org.testng.Assert.assertTrue;
import utils.TestContextSetup;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.DriverFactory;
import pageobjects.OnboardingStep4Page;

public class OnboardingStep4Steps {

    TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;

    OnboardingStep4Page step4Page = new OnboardingStep4Page(driver);

    public OnboardingStep4Steps(TestContextSetup context) {

        this.context = context;
        //step 1 is upload blood work
        step4Page = context.getpageobjectmanager().OnboardingStep4Page();
    }

    @Given("the user has completed onboarding up to Step 2")
    public void user_completed_step2() {
        System.out.println("User has completed Step 2.");
    }

    @And("the user is on Step 3 of the onboarding process")
    public void user_on_step3() {
        System.out.println("User is currently on Step 3 (Health Condition).");
    }

    @When("the user selects one or more health conditions")
    public void user_selects_health_conditions() {
        System.out.println("User selects one or more health conditions.");
        // Example: driver.findElement(By.xpath("//label[contains(text(),'Diabetes')]")).click();
    }

    @And("clicks the {string} button")
    public void user_clicks_button(String buttonName) {
        System.out.println("Clicked button: " + buttonName);
        // Add logic when actual button elements available
    }

    @Then("the user should be redirected to Step 4")
    public void user_redirected_to_step4() {
        System.out.println("User redirected to Step 4 (Personal Details).");
        // Assert or URL check when available
    }

    // --- Step 4 Progress Verification ---
    @Then("the onboarding progress bar should be displayed")
    public void progress_bar_displayed() {
        Assert.assertTrue("Progress bar not visible", step4Page.isProgressBarDisplayed());
    }

    @And("the progress bar should show the current step as {string}")
    public void progress_bar_text(String expectedStep) {
        Assert.assertTrue("Progress text not visible", step4Page.isProgressTextDisplayed());
    }

    // --- Step 4 Buttons ---
    @Then("the {string} button should be visible and enabled")
    public void verify_button(String buttonName) {
        switch (buttonName) {
            case "Back":
                Assert.assertTrue(step4Page.isBackButtonVisible());
                Assert.assertTrue(step4Page.isBackButtonEnabled());
                break;
            case "Continue":
                Assert.assertTrue(step4Page.isContinueButtonVisible());
                Assert.assertTrue(step4Page.isContinueButtonEnabled());
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + buttonName);
        }
    }

    // --- Title and Description ---
    @Then("the title should be {string}")
    public void verify_title(String expectedTitle) {
        Assert.assertTrue("Title not displayed", step4Page.isTitleDisplayed());
        Assert.assertEquals(expectedTitle, step4Page.getTitleText());
    }

    @And("the description text should display {string}")
    public void verify_description(String expectedDesc) {
        Assert.assertTrue("Description not displayed", step4Page.isDescriptionDisplayed());
        Assert.assertEquals(expectedDesc, step4Page.getDescriptionText());
    }

    // --- Input Fields ---
    @Then("{int} input boxes should be visible")
    public void verify_input_box_count(int expectedCount) {
        Assert.assertEquals("Input box count mismatch", expectedCount, step4Page.getInputBoxCount());
    }

    @And("the field labels should be:")
    public void verify_field_labels(io.cucumber.datatable.DataTable dataTable) {
        for (String label : dataTable.asList()) {
            Assert.assertTrue("Label missing: " + label, step4Page.areFieldLabelsDisplayed(label));
        }
    }

    @And("helper text should be displayed under each field")
    public void verify_helper_text() {
        Assert.assertTrue("Helper text missing", step4Page.isHelperTextDisplayed());
    }

    // --- Radio Buttons ---
    @Then("{int} radio buttons should be visible")
    public void verify_radio_buttons(int expectedCount) {
        Assert.assertEquals("Radio button count mismatch", expectedCount, step4Page.getRadioButtonCount());
    }

    @And("the options for blood pressure should be displayed")
    public void verify_radio_options() {
        Assert.assertTrue("Blood pressure options missing", step4Page.areRadioOptionsDisplayed());
    }
}
