package stepdefinition;

import static org.testng.Assert.assertTrue;
import utils.TestContextSetup;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.DriverFactory;
import pageobjects.OnboardingStep10Page;

public class OnboardingStep10Steps {

	TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;

    OnboardingStep10Page step10Page = new OnboardingStep10Page(driver);
    
    public OnboardingStep10Steps(TestContextSetup context) {

    	this.context = context;
    	step10Page = context.getpageobjectmanager().getonboardingstep10page();
    }

    @Given("the user has completed onboarding upto Step 8")
    public void user_completed_onboarding_upto_step8() {
        System.out.println("User completed onboarding up to Step 8");
    }

    @Given("the user is on Step 9 of onboarding process")
    public void user_on_step9() {
        System.out.println("User is now on Step 9");
        Assert.assertTrue(step10Page.isStep9Loaded());
    }

    @When("the user click any of the activity level")
    public void user_clicks_activity_level() {
        step10Page.selectActivityLevel("Moderately Active");
    }

    @Then("the selected activity level should be highlited")
    public void selected_activity_level_should_be_highlighted() {
        Assert.assertTrue(step10Page.isSelectedActivityHighlighted());
    }

    @Then("the {string} button should be enbaled")
    public void continue_button_should_be_enabled(String buttonName) {
        Assert.assertTrue(step10Page.isButtonEnabled(buttonName));
    }

    @Then("the radio button in the selected activity level should be mark as selected")
    public void radio_button_should_be_selected() {
        Assert.assertTrue(step10Page.isRadioButtonSelected());
    }

    @When("the user clicks back button in Step 9")
    public void user_clicks_back_button() {
        step10Page.clickBackButton();
    }

    @Then("the user should be redirect to Step 8")
    public void user_redirects_to_step8() {
        Assert.assertTrue(step10Page.isRedirectedToStep8());
    }

    @When("the user clicks continue after selecting any activity level")
    public void user_clicks_continue_button() {
        step10Page.clickContinueButton();
    }

    @Then("the user should be redirect to Step 10")
    public void user_redirects_to_step10() {
        Assert.assertTrue(step10Page.isRedirectedToStep10());
    }

    @Then("the onboarding progress bar should show {string}")
    public void progress_bar_should_show(String progressText) {
        Assert.assertEquals(progressText, step10Page.getProgressBarText());
    }

    @Then("the title should be {string}")
    public void verify_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, step10Page.getTitleText());
    }

    @Then("the description should display {string}")
    public void verify_description(String expectedDescription) {
        Assert.assertEquals(expectedDescription, step10Page.getDescriptionText());
    }

    @Then("four sections should be visble")
    public void four_sections_visible() {
        Assert.assertEquals(4, step10Page.getNumberOfSections());
    }

    @Then("the section titles {string}, {string}, {string}, {string} should be displayed")
    public void verify_section_titles(String title1, String title2, String title3, String title4) {
        Assert.assertTrue(step10Page.areSectionTitlesDisplayed(title1, title2, title3, title4));
    }

    @Then("description text for each section should be visble")
    public void section_descriptions_visible() {
        Assert.assertTrue(step10Page.areSectionDescriptionsVisible());
    }

    @Then("a radio button should be displayed in all sections")
    public void radio_buttons_displayed_in_all_sections() {
        Assert.assertTrue(step10Page.areAllRadioButtonsVisible());
    }

    @Then("the info note {string} should be displayed")
    public void verify_info_note(String expectedNote) {
        Assert.assertEquals(expectedNote, step10Page.getInfoNoteText());
    }
}
