package stepdefinition;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driverfactory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.MenstrualCyclePage;
import utils.TestContextSetup;

public class MenstrualCycleSteps {
	TestContextSetup context;
	DriverFactory driverFactory;
	public WebDriver driver;
	public MenstrualCyclePage menstrualpage;
	
	public MenstrualCycleSteps(TestContextSetup context) {
		this.context = context;
		menstrualpage = context.getpageobjectmanager().getmenstrualpage();
		this.driver = DriverFactory.Driver();
	}
	
	@Given("User is on the Her Balance Dashboard with the Activity Insights submenu expanded")
	public void user_is_on_the_her_balance_dashboard_with_the_activity_insights_submenu_expanded() {
		menstrualpage.ClickActivityInsights();
	}

	@When("User clicks on Menstrual Phase Logs")
	public void user_clicks_on_menstrual_phase_logs() {
		menstrualpage.ClickMensuralPhaseLog();
	}

	@Then("{int} sections should be visible\\(Current Cycle Status, Upcoming Phases, Recommended Activities, Nutrtion Tips, Next Period)")
	public void sections_should_be_visible_current_cycle_status_upcoming_phases_recommended_activities_nutrtion_tips_next_period(Integer int1) {
		List<WebElement> sections = Arrays.asList(
				menstrualpage.getCurrentCycleStatusSection(),
				menstrualpage.getUpcomingPhasesSection(),
				menstrualpage.getRecommendedActivitiesSection(),
				menstrualpage.getNutritionTipsSection(),
				menstrualpage.getNextPeriodSection()
		    );

		    int visibleCount = 0;
		    for (WebElement section : sections) {
		        if (section.isDisplayed()) {
		            visibleCount++;
		        }
		    }
     Assert.assertEquals(visibleCount, int1, "Number of visible sections does not match expected");
		
	}

	@Then("{string} tab should be visible")
	public void tab_should_be_visible(String string) {
		Assert.assertTrue(menstrualpage.isElementVisible(string), string + " is not visible");
	}
	@Then("{string} is displayed")
	public void is_displayed(String expectedHeading) {
		String actualHeading = menstrualpage.isCycleProgressHeading(); // returns text
	    Assert.assertEquals("Heading text does not match!", expectedHeading, actualHeading);
	}

	@Then("Displays current cycle progress in the format {string} as the values entered during onboarding process")
	public void displays_current_cycle_progress_in_the_format_as_the_values_entered_during_onboarding_process(String expectedValue) {
		String actualText = menstrualpage.getProgressText();
        Assert.assertTrue(actualText.contains(expectedValue),"Displayed progress text mismatch");
	}
	@Then("{string}, {string}, {string}, {string} labels are displayed below the progress bar")
	public void labels_are_displayed_below_the_progress_bar(String string, String string2, String string3, String string4) {
		Assert.assertTrue(menstrualpage.areLabelsDisplayed(string, string2, string3, string4),
				"Labels are not displayed correctly");
	}

	@Then("Progress bar should be filled according to the current cycle progress")
	public void progress_bar_should_be_filled_according_to_the_current_cycle_progress() {
		Assert.assertTrue(menstrualpage.isProgressBarFilled(),"Progress bar should be filled");
	}

	@Then("{string}, {string}, {string} are displayed")
	public void are_displayed(String string, String string2, String string3) {
		Assert.assertTrue(menstrualpage.areLabelsDisplayed(string, string2, string3),"All three labels should be visible");
	}

	@Then("Displays the phase based on the value entered during onboarding process")
	public void displays_the_phase_based_on_the_value_entered_during_onboarding_process() {String progressText = menstrualpage.getProgressText();
    String expectedPhase = menstrualpage.getExpectedPhaseFromDay(progressText);
    String actualPhase = menstrualpage.getCurrentPhaseContent();
    Assert.assertEquals(actualPhase, expectedPhase, "Phase not matching");
	
	}

	@Then("Displays correct {string} based on the date entered during onboarding process")
	public void displays_correct_based_on_the_date_entered_during_onboarding_process(String string) {
		LocalDate actualDate = menstrualpage.getActualDate(string);
		LocalDate expectedDate = menstrualpage.getExpectedDate(string);
	    Assert.assertEquals(actualDate, expectedDate,"date is incorrect");;   
	}
	@Then("Displays correct {string} based on the values entered during onboarding process")
	public void displays_correct_based_on_the_values_entered_during_onboarding_process(String string) {
		LocalDate actualDate = menstrualpage.getActualDate(string);
		LocalDate expectedDate = menstrualpage.getExpectedDate(string);
	    Assert.assertEquals(actualDate, expectedDate,"date is incorrect");;  
	}

	@Then("Subsection heading reflects the Current Phase in the format {string}")
	public void subsection_heading_reflects_the_current_phase_in_the_format(String string) {
		String currentPhase = menstrualpage.getCurrentPhaseName();
	    String actualHeading = menstrualpage.getSubsectionHeading();
	    String expectedHeading = currentPhase + " Details";

	    Assert.assertEquals(actualHeading, expectedHeading, "Subsection heading does not match the current phase format");
	    
	}

	@Then("Display content should match current phase")
	public void display_content_should_match_current_phase() {
		String currentPhase = menstrualpage.getCurrentPhaseName();
	    String actualContent = menstrualpage.getPhaseGuidanceText();
	    String expectedContent = menstrualpage.getExpectedPhaseGuidance(currentPhase);
        Assert.assertTrue(actualContent.contains(expectedContent.substring(0, 30)), "Phase guidance content does not match ");
	          
	}
	@Then("Then the section heading {string} should be visible")
	public void then_the_section_heading_should_be_visible(String string) {
		String actualHeading = menstrualpage.getSectionHeading(string);
	    Assert.assertEquals(actualHeading,string,"Section heading text is incorrect");
	}

	@Then("the subtext {string} should be visible")
	public void the_subtext_should_be_visible(String string) {
		Assert.assertTrue(menstrualpage.getSubtext(string), "Subtext is incorrect ");
	}
	@Then("{int} subsections should be visible")
	public void subsections_should_be_visible(Integer expectedCount) {
		int actualCount = menstrualpage.getVisibleSubsectionCount();
	    Assert.assertEquals(actualCount, expectedCount,
	        "Number of visible subsections is incorrect " );
	   
	}

	@Then("{string}, {string}, {string}, {string} are displayed")
	public void are_displayed(String string, String string2, String string3, String string4) {
		List<String> actualHeadings = menstrualpage.getAllPhaseHeadings();
	    List<String> expectedHeadings = Arrays.asList(string, string2, string3, string4);

	  Assert.assertEquals(actualHeadings, expectedHeadings, "Phase headings do not match expected values.");
	}  
	

	@Then("Start date should be diaplayed correctly as per the cycle data entered during onboarding process")
	public void start_date_should_be_diaplayed_correctly_as_per_the_cycle_data_entered_during_onboarding_process() {
	
		Assert.assertTrue(menstrualpage.areStartDatesDisplayed(), "Do not have a start date displayed");
		}

	@Then("All phase start dates should be displayed in {string} format")
	public void all_phase_start_dates_should_be_displayed_in_format(String string) {
		Assert.assertTrue(menstrualpage.areStartDatesDisplayed(), "One or more phases do not have a start date displayed");
	   
	}

	@Then("Current phase date should be displayed in {string} format")
	public void current_phase_date_should_be_displayed_in_format(String string) {
		Assert.assertTrue(menstrualpage.isCurrentPhaseStartDateFormatValid(string), "format doesnt match");
	}

	@Then("{string} subsection is highlighted based on cycle data entered during onboarding process")
	public void subsection_is_highlighted_based_on_cycle_data_entered_during_onboarding_process(String string) {
		boolean match = menstrualpage.verifyCycleDataWithHighlighted();
	    Assert.assertTrue(match, "Highlighted phase does not match the current cycle phase");
	    
	}
	@Then("the section heading {string} should be displayed")
	public void the_section_heading_should_be_displayed(String string) {
		boolean displayed = menstrualpage.isSectionHeadingDisplayed(string);
	    Assert.assertTrue(displayed, "Section heading is not displayed");
       
}
	@Then("Recommended Activities content should be displayed according to the {string}")
	public void recommended_activities_content_should_be_displayed_according_to_the(String string) {
		boolean correctContent = menstrualpage.isRecommendedActivitiesContentCorrect(string);
	    Assert.assertTrue(correctContent,
	        "Recommended Activities content does not match the expected content for phase: " + string);
	}


	@Then("Nutrition Tips content should be displayed according to the {string}")
	public void nutrition_tips_content_should_be_displayed_according_to_the(String string) {
		boolean correctContent = menstrualpage.isNutritionTipsContentCorrect(string);
	    Assert.assertTrue(correctContent,
	        "Nutrition Tips content does not match the expected content for phase: " + string);
	}

	@Then("the {string} should be displayed in the format {string} based on the cycle data entered during onboarding")
	public void the_should_be_displayed_in_the_format_based_on_the_cycle_data_entered_during_onboarding(String string, String string2) {
		boolean valid = menstrualpage.isNextPeriodDateFormatValid();
	    Assert.assertTrue(valid, "Next period date format is incorrect!");
	}

	@Then("the {string} should be displayed correctly as per the next period date")
	public void the_should_be_displayed_correctly_as_per_the_next_period_date(String string) {
		Assert.assertTrue(menstrualpage.isDaysRemainingValid(), "Displayed Invalid");
	}







}
