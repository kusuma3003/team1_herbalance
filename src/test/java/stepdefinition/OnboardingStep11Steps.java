package stepdefinition;

import static org.testng.Assert.assertTrue;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.DriverFactory;
import pageobjects.OnboardingStep11Page;
import utils.TestContextSetup;

import utils.PropertyFileReader;

public class OnboardingStep11Steps {

	TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;

    OnboardingStep11Page step11Page = new OnboardingStep11Page(driver);
    
    public OnboardingStep11Steps(TestContextSetup context) {

        this.context = context;
        step11Page = context.getpageobjectmanager().getonboardingstep11page();
    }

    @Given("the user has completed onboarding upto Step 9")
    public void user_completed_upto_step9() {
        System.out.println("User completed onboarding up to Step 9");
    }

    @Given("the user is on Step 10 of onboarding")
    public void user_is_on_step10() {
        Assert.assertTrue(step11Page.isStep10Loaded());
    }

    @Given("the user has completed onboarding upto Step 10")
    public void user_completed_upto_step10() {
        System.out.println("User completed onboarding up to Step 10");
    }

    @Given("the user is on Step 11 of onboarding")
    public void user_is_on_step11() {
        Assert.assertTrue(step11Page.isStep11Loaded());
    }

    // ----------- Step 10 Scenarios -----------
    @When("the user click any options under Food Allergies & Sensitivities")
    public void user_clicks_food_allergy_option() {
        step11Page.selectOption("Yes, I have food allergies");
    }

    @Then("the selected section should be highlited")
    public void selected_section_should_be_highlighted() {
        Assert.assertTrue(step11Page.isSelectedOptionHighlighted());
    }

    @Then("the radio button in the selected section should be mark as selected")
    public void radio_button_marked_selected() {
        Assert.assertTrue(step11Page.isRadioButtonSelected());
    }

    @When("the user clicks back button in Step 10")
    public void user_clicks_back_button_step10() {
        step11Page.clickBackButton();
    }

    @Then("the user should be redirect to Step 9")
    public void user_redirects_to_step9() {
        Assert.assertTrue(step11Page.isRedirectedToStep9());
    }

    @When("the user clicks continue button without selecting any option")
    public void click_continue_without_selection() {
        step11Page.clickContinueButton();
    }

    @Then("error message {string} should be displayed")
    public void verify_error_message(String expectedMsg) {
        Assert.assertEquals(expectedMsg, step11Page.getErrorMessage());
    }

    @When("the user clicks continue after selecting any options under Food Allergies & Sensitivities")
    public void click_continue_after_selection_step10() {
        step11Page.selectOption("No, I can eat everything");
        step11Page.clickContinueButton();
    }

    @Then("the user should be redirect to Step 11")
    public void redirected_to_step11() {
        Assert.assertTrue(step11Page.isRedirectedToStep11());
    }

    @Then("the progress bar should show {string}")
    public void verify_progress_bar(String expected) {
        Assert.assertEquals(expected, step11Page.getProgressText());
    }

    @Then("the title should be {string}")
    public void verify_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, step11Page.getTitleText());
    }

    @Then("the description should be {string}")
    public void verify_description(String expectedDesc) {
        Assert.assertEquals(expectedDesc, step11Page.getDescriptionText());
    }

    @Then("four sections should be visble")
    public void verify_four_sections_visible() {
        Assert.assertEquals(4, step11Page.getNumberOfSections());
    }

    @Then("the section titles {string}, {string}, {string}, {string} should be displayed")
    public void verify_section_titles(String s1, String s2, String s3, String s4) {
        Assert.assertTrue(step11Page.areSectionTitlesDisplayed(s1, s2, s3, s4));
    }

    @Then("description text for each section should be visble")
    public void verify_section_descriptions_visible() {
        Assert.assertTrue(step11Page.areSectionDescriptionsVisible());
    }

    @Then("examples like")
    public void verify_examples(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertTrue(step11Page.areExamplesDisplayed(dataTable.asList()));
    }

    @Then("a radio button should be displayed in all sections")
    public void verify_radio_buttons_displayed() {
        Assert.assertTrue(step11Page.areAllRadioButtonsVisible());
    }

    @Then("the info note {string} should be displayed")
    public void verify_info_note(String expectedNote) {
        Assert.assertTrue(step11Page.getInfoNoteText().contains(expectedNote.trim()));
    }

    // ----------- Step 11 Scenarios -----------
    @When("the user click any options under Medications & Supplements")
    public void user_clicks_medication_option() {
        step11Page.selectOption("Yes, I take supplements");
    }

    @When("the user clicks back button in Step 11")
    public void user_clicks_back_button_step11() {
        step11Page.clickBackButton();
    }

    @Then("the user should be redirect to Step 10")
    public void redirected_to_step10() {
        Assert.assertTrue(step11Page.isRedirectedToStep10());
    }

    @When("the user clicks complete button after selecting any options under Medications & Supplements")
    public void user_clicks_complete_button() {
        step11Page.selectOption("Yes, I take both");
        step11Page.clickCompleteButton();
    }

    @Then("the user should be navigated to the subscription page")
    public void redirected_to_subscription_page() {
        Assert.assertTrue(step11Page.isRedirectedToSubscription());
    }
}
