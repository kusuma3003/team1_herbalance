package stepdefinition;

import static org.testng.Assert.assertTrue;
import utils.TestContextSetup;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driverfactory.DriverFactory;
import pageobjects.OnboardingStep9Page;
import utils.PropertyFileReader;
import utils.TestContextSetup;

public class OnboardingStep9Steps {

	TestContextSetup context;
    DriverFactory driverFactory;
    public WebDriver driver;

    OnboardingStep9Page step9Page = new OnboardingStep9Page(driver);

    public OnboardingStep9Steps(TestContextSetup context) {

    	this.context = context;
        step9Page = context.getpageobjectmanager().getonboardingstep9page();
    }

    @Given("the user has completed onboarding up to Step 7")
    public void completed_up_to_step7() {
        System.out.println("User completed Step 7 successfully.");
    }

    @Given("the user is on Step 8 of the onboarding process")
    public void user_on_step8() {
        Assert.assertTrue(step9Page.isPageTitleDisplayed());
    }

    @When("the user clicks any dietary option")
    public void user_clicks_any_diet_option() {
        step9Page.selectRandomDietOption();
    }

    @Then("the selected diet should be highlighted")
    public void verify_selected_diet_highlight() {
        Assert.assertTrue(step9Page.isDietOptionHighlighted());
    }

    @Then("the {string} button should be enabled")
    public void verify_continue_enabled(String btnName) {
        Assert.assertTrue(step9Page.isContinueButtonEnabled());
    }

    @When("the user clicks the {string} button in Step 8")
    public void user_clicks_back_button(String btnName) {
        step9Page.clickBackButton();
    }

    @Then("the user should be redirected to Step 7")
    public void redirected_to_step7() {
        Assert.assertTrue(step9Page.isStep7Displayed());
    }

    @When("the user clicks {string} after selecting any dietary option")
    public void click_continue_to_step9(String btn) {
        step9Page.clickContinueButton();
    }

    @Then("the user should be redirected to Step 9")
    public void verify_redirected_to_step9() {
        Assert.assertTrue(step9Page.isStep9Displayed());
    }

    @Then("the onboarding progress bar should show {string}")
    public void verify_progress_bar(String expectedProgress) {
        Assert.assertEquals(expectedProgress, step9Page.getProgressBarText());
    }

    @Then("the title should be {string}")
    public void verify_title(String title) {
        Assert.assertEquals(title, step9Page.getStep9Title());
    }

    @Then("the description should display {string}")
    public void verify_description(String desc) {
        Assert.assertTrue(step9Page.getStep9Description().contains(desc));
    }

    @Then("four sections should be visible")
    public void verify_four_sections() {
        Assert.assertEquals(4, step9Page.getActivitySectionsCount());
    }

    @Then("the section titles {string}, {string}, {string}, {string} should be displayed")
    public void verify_section_titles(String s1, String s2, String s3, String s4) {
        Assert.assertTrue(step9Page.verifyActivityTitles(s1, s2, s3, s4));
    }

    @Then("description text for each section should be visible")
    public void verify_description_texts() {
        Assert.assertTrue(step9Page.areSectionDescriptionsVisible());
    }

    @Then("a radio button should be displayed in all sections")
    public void verify_radio_buttons() {
        Assert.assertTrue(step9Page.areRadioButtonsDisplayed());
    }

    @Then("the informational note {string} should be displayed")
    public void verify_info_note(String expectedNote) {
        Assert.assertTrue(step9Page.getInfoNote().contains(expectedNote));
    }

    @Then("the {string} button should be disabled")
    public void verify_continue_disabled(String btn) {
        Assert.assertFalse(step9Page.isContinueButtonEnabled());
    }
}
