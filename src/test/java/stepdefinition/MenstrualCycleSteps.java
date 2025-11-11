package stepdefinition;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.MenstrualCyclePage;
import utils.TestContextSetup;

public class MenstrualCycleSteps {

    TestContextSetup context;
    public WebDriver driver;
    public MenstrualCyclePage menstrualpage;
    private static final Logger logger = LoggerFactory.getLogger(MenstrualCycleSteps.class);

    public MenstrualCycleSteps(TestContextSetup context) {
        this.context = context;
        menstrualpage = context.getpageobjectmanager().getmenstrualpage();
        this.driver = DriverFactory.Driver();
    }

    @Given("User is on the Her Balance Dashboard with the Activity Insights submenu expanded")
    public void user_is_on_the_dashboard_with_activity_insights_expanded() {
        logger.info("Clicking Activity Insights on dashboard");
        menstrualpage.ClickActivityInsights();
    }

    @When("User clicks on Menstrual Phase Logs")
    public void user_clicks_on_menstrual_phase_logs() {
        logger.info("Clicking on Menstrual Phase Logs");
        menstrualpage.ClickMensuralPhaseLog();
    }

    @Then("{int} sections should be visible\\(Current Cycle Status, Upcoming Phases, Recommended Activities, Nutrition Tips, Next Period)")
    public void sections_should_be_visible(int expectedCount) {
        logger.info("Verifying {} sections are visible", expectedCount);
        List<WebElement> sections = Arrays.asList(
                menstrualpage.getCurrentCycleStatusSection(),
                menstrualpage.getUpcomingPhasesSection(),
                menstrualpage.getRecommendedActivitiesSection(),
                menstrualpage.getNutritionTipsSection(),
                menstrualpage.getNextPeriodSection()
        );

        int visibleCount = (int) sections.stream().filter(WebElement::isDisplayed).count();
        Assert.assertEquals(visibleCount, expectedCount, "Number of visible sections does not match expected");
    }

    @Then("{string} tab should be visible")
    public void tab_should_be_visible(String tabName) {
        logger.info("Verifying tab '{}' is visible", tabName);
        Assert.assertTrue(menstrualpage.isElementVisible(tabName), tabName + " tab is not visible");
    }

    @Then("{string} heading is displayed")
    public void heading_is_displayed(String expectedHeading) {
        logger.info("Verifying heading: {}", expectedHeading);
        String actualHeading = menstrualpage.isCycleProgressHeading();
        Assert.assertEquals(actualHeading, expectedHeading, "Heading text does not match");
    }

    @Then("Displays current cycle progress in the format {string}")
    public void displays_current_cycle_progress(String expectedValue) {
        logger.info("Verifying current cycle progress contains: {}", expectedValue);
        String actualText = menstrualpage.getProgressText();
        Assert.assertTrue(actualText.contains(expectedValue), "Displayed progress text mismatch");
    }

    @Then("{string}, {string}, {string}, {string} labels are displayed below the progress bar")
    public void progress_labels_are_displayed(String label1, String label2, String label3, String label4) {
        logger.info("Verifying progress labels are displayed: {}, {}, {}, {}", label1, label2, label3, label4);
        Assert.assertTrue(menstrualpage.areLabelsDisplayed(label1, label2, label3, label4),
                "Progress labels are not displayed correctly");
    }

    @Then("Progress bar should be filled according to the current cycle progress")
    public void progress_bar_should_be_filled() {
        logger.info("Verifying progress bar is filled");
        Assert.assertTrue(menstrualpage.isProgressBarFilled(), "Progress bar should be filled");
    }

    @Then("Displays the current phase based on onboarding data")
    public void displays_current_phase_based_on_onboarding() {
        String progressText = menstrualpage.getProgressText();
        String expectedPhase = menstrualpage.getExpectedPhaseFromDay(progressText);
        String actualPhase = menstrualpage.getCurrentPhaseContent();
        logger.info("Expected phase: {}, Actual phase: {}", expectedPhase, actualPhase);
        Assert.assertEquals(actualPhase, expectedPhase, "Phase not matching");
    }

    @Then("Displays correct {string} based on onboarding data")
    public void displays_correct_date(String label) {
        LocalDate actualDate = menstrualpage.getActualDate(label);
        LocalDate expectedDate = menstrualpage.getExpectedDate(label);
        logger.info("Verifying {}: actual={}, expected={}", label, actualDate, expectedDate);
        Assert.assertEquals(actualDate, expectedDate, "Date is incorrect");
    }

    @Then("Subsection heading reflects the Current Phase in the format {string}")
    public void subsection_heading_reflects_current_phase(String format) {
        String currentPhase = menstrualpage.getCurrentPhaseName();
        String actualHeading = menstrualpage.getSubsectionHeading();
        String expectedHeading = currentPhase + " Details";
        logger.info("Verifying subsection heading: expected='{}', actual='{}'", expectedHeading, actualHeading);
        Assert.assertEquals(actualHeading, expectedHeading, "Subsection heading does not match the current phase format");
    }

    @Then("Display content should match current phase")
    public void display_content_matches_current_phase() {
        String currentPhase = menstrualpage.getCurrentPhaseName();
        String actualContent = menstrualpage.getPhaseGuidanceText();
        String expectedContent = menstrualpage.getExpectedPhaseGuidance(currentPhase);
        logger.info("Verifying guidance content for phase: {}", currentPhase);
        Assert.assertTrue(actualContent.contains(expectedContent), "Phase guidance content does not match");
    }

    @Then("Then the section heading {string} should be visible")
    public void section_heading_should_be_visible(String heading) {
        logger.info("Verifying section heading is visible: {}", heading);
        boolean actualHeading = menstrualpage.isSectionHeadingDisplayed(heading);
        Assert.assertEquals(actualHeading, heading, "Section heading text is incorrect");
    }

    @Then("the subtext {string} should be visible")
    public void subtext_should_be_visible(String expectedText) {
        logger.info("Verifying subtext: {}", expectedText);
        Assert.assertTrue(menstrualpage.getSubtext(expectedText), "Subtext is incorrect");
    }

    @Then("{int} subsections should be visible")
    public void subsections_should_be_visible(int expectedCount) {
        int actualCount = menstrualpage.getVisibleSubsectionCount();
        logger.info("Verifying visible subsections: expected={}, actual={}", expectedCount, actualCount);
        Assert.assertEquals(actualCount, expectedCount, "Number of visible subsections is incorrect");
    }

    @Then("{string}, {string}, {string}, {string} phase headings are displayed")
    public void phase_headings_are_displayed(String h1, String h2, String h3, String h4) {
        List<String> actualHeadings = menstrualpage.getAllPhaseHeadings();
        List<String> expectedHeadings = Arrays.asList(h1, h2, h3, h4);
        logger.info("Verifying phase headings: {}", expectedHeadings);
        Assert.assertEquals(actualHeadings, expectedHeadings, "Phase headings do not match expected values");
    }

    @Then("All phase start dates should be displayed in {string} format")
    public void all_phase_start_dates_should_be_displayed(String format) {
        logger.info("Verifying all phase start dates in format: {}", format);
        Assert.assertTrue(menstrualpage.areStartDatesDisplayed(), "One or more phases do not have a start date displayed");
    }

    @Then("{string} subsection is highlighted based on cycle data")
    public void subsection_is_highlighted(String phase) {
        logger.info("Verifying highlighted subsection matches current phase");
        Assert.assertTrue(menstrualpage.verifyCycleDataWithHighlighted(), "Highlighted phase does not match the current cycle phase");
    }

    @Then("Recommended Activities content should be displayed according to the {string}")
    public void recommended_activities_displayed(String phase) {
        logger.info("Verifying recommended activities content for phase: {}", phase);
        Assert.assertTrue(menstrualpage.isRecommendedActivitiesContentCorrect(phase),
                "Recommended Activities content does not match expected for phase: " + phase);
    }

    @Then("Nutrition Tips content should be displayed according to the {string}")
    public void nutrition_tips_displayed(String phase) {
        logger.info("Verifying nutrition tips content for phase: {}", phase);
        Assert.assertTrue(menstrualpage.isNutritionTipsContentCorrect(phase),
                "Nutrition Tips content does not match expected for phase: " + phase);
    }

    @Then("the {string} should be displayed in the format {string} based on the cycle data entered during onboarding")
    public void next_period_date_displayed(String label, String format) {
        logger.info("Verifying next period date format for label: {}", label);
        Assert.assertTrue(menstrualpage.isNextPeriodDateFormatValid(), "Next period date format is incorrect");
    }

    @Then("the {string} should be displayed correctly as per the next period date")
    public void days_remaining_displayed(String label) {
        logger.info("Verifying days remaining display for label: {}", label);
        Assert.assertTrue(menstrualpage.isDaysRemainingValid(), "Displayed days remaining is invalid");
    }
    
    @Given("User is on Menstrual Cycle Tracker page")
    public void user_is_on_menstrual_cycle_tracker_page() {
    	menstrualpage.ClickActivityInsights();
    	menstrualpage.ClickMensuralPhaseLog();
    	
    }

    @When("User clicks on Update Cycle Information button")
    public void user_clicks_on_update_cycle_information_button() {
    	 menstrualpage.clickUpdateCycleInfoButton();
    }

    @Then("{string} is displayed")
    public void is_displayed(String expectedText) {
    	String actualText = menstrualpage.getDisplayedMessage();
        Assert.assertEquals(actualText, expectedText, "Displayed text does not match!");
    }

    @Then("{int} sections should be visible")
    public void sections_should_be_visible(Integer expectedSections) {
    	int actualSections = menstrualpage.getVisibleSectionsCount();
        Assert.assertEquals(actualSections, expectedSections.intValue(), "Section count mismatch!");
    }
    @Then("{string}, {string} should be displayed")
    public void should_be_displayed(String header1, String header2) {
    	Assert.assertTrue(menstrualpage.isHeaderDisplayed(header1), header1 + " is not displayed");
        Assert.assertTrue(menstrualpage.isHeaderDisplayed(header2), header2 + " is not displayed");
    }

    @Then("{string} button should be visible")
    public void button_should_be_visible(String buttonText) {
    	Assert.assertTrue(menstrualpage.isButtonVisible(buttonText), buttonText + " button not visible");
    }

}
