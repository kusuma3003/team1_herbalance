package stepdefinition;

import org.openqa.selenium.WebDriver;
import driverfactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.OnboardingStep1Page;

public class OnboardingStep1Steps<TestContextSetup> {

    TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;
    

    OnboardingStep1Page uploadPage = new OnboardingStep1Page(driver);

    public OnboardingStep1Steps(TestContextSetup context) {

        this.context = context;
        //step 1 is upload blood work
        uploadPage = context.getpageobjectmanager().OnboardingStep1Page();
    }

    @Given("the user is on the Sign Up page")
    public void user_is_on_sign_up_page() {
        // Navigate to signup page (placeholder)
        driverFactory.openPage(PropertyFileReader.getUrl());
    }

    @And("has entered valid registration details")
    public void user_enters_valid_registration_details() {
        // code to enter registration details
    }

    @When("the user clicks the {string} button")
    public void user_clicks_the_button(String buttonName) {
        // handle click for "Register", "Continue Without Report", etc.
        System.out.println("Clicked button: " + buttonName);
    }

    @Then("the page title should be {string}")
    public void verify_page_title(String expectedTitle) {
        Assert.assertTrue(uploadPage.isPageTitleDisplayed(), "Page title not displayed");
    }

    @Then("the supporting text for the title should be displayed")
    public void verify_supporting_text() {
        Assert.assertTrue(uploadPage.isSupportingTextDisplayed());
    }

    @Then("the onboarding progress bar is visible")
    public void verify_progress_bar_visible() {
        Assert.assertTrue(uploadPage.isProgressBarVisible());
    }

    @Then("the {string} button is displayed")
    public void verify_button_displayed(String buttonName) {
        Assert.assertTrue(uploadPage.isUploadPdfButtonVisible());
    }

    @Then("the {string} button is enabled")
    public void verify_button_enabled(String buttonName) {
        Assert.assertTrue(uploadPage.isUploadPdfButtonEnabled());
    }

    @Then("the note {string} is displayed")
    public void verify_note_displayed(String expectedNote) {
        Assert.assertTrue(uploadPage.isPdfNoteDisplayed());
    }

    @Then("the {string} card is visible")
    public void verify_card_visible(String cardName) {
        Assert.assertTrue(uploadPage.isSkipCardVisible());
    }

    @Then("the explanation text about continuing without lab results is displayed")
    public void verify_explanation_text_displayed() {
        Assert.assertTrue(uploadPage.isSkipExplanationDisplayed());
    }

    @Then("the {string} button is displayed")
    public void verify_continue_button_displayed(String buttonName) {
        Assert.assertTrue(uploadPage.isContinueWithoutReportButtonDisplayed());
    }

    @Then("the {string} button is enabled")
    public void verify_continue_button_enabled(String buttonName) {
        Assert.assertTrue(uploadPage.isContinueWithoutReportButtonEnabled());
    }

    @Then("the note about secure processing and no sharing with third parties is displayed")
    public void verify_data_security_note_displayed() {
        Assert.assertTrue(uploadPage.isDataSecurityNoteDisplayed());
    }
}
