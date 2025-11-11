package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.DashBoardPage;
import pageobjects.LaunchPage;
import utils.Excel_Reader;
import utils.LoggerLoad;
import utils.PropertyFileReader;
import utils.TestContextSetup;

public class DashboardSteps {
	
	TestContextSetup context;
	DriverFactory driverFactory;
	public WebDriver driver;
	public DashBoardPage dashboardpage;
	public LaunchPage launchpage;
	Excel_Reader excelreader;
	//Alert alert;

	public DashboardSteps(TestContextSetup context) {

		this.context = context;
		dashboardpage = context.getpageobjectmanager().getdashboardpage();
		launchpage = context.getpageobjectmanager().getlaunchpage();
		this.driver = DriverFactory.Driver();
		excelreader = context.getexcelreader();
	}
	
	@Given("User is on the HerBalance auth page")
	public void user_is_on_the_her_balance_auth_page() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("dashboardurl"));
	}

	@When("User clicks login in button after entering  a valid credential")
	public void user_clicks_login_in_button_after_entering_a_valid_credential() {
		 launchpage.Loginbutton();
	}

	@Then ("User should see Free Plan Dashboard title")
	public void user_should_see_free_plan_dashboard_title() {
		//dashboardpage.FreePlan();
		Assert.assertTrue(dashboardpage.FreePlan());
		String pageTitle = driver.getTitle();
		 System.out.println("Page Title: " + pageTitle);
  }
	
	@Then("User should see user name on the top right side")
	public void user_should_see_user_name_on_the_top_right_side() {
		Assert.assertTrue(dashboardpage.Username());
	}
	
	@Then("User should see bell icon for notification")
	public void user_should_see_bell_icon_for_notification() {
		Assert.assertTrue(dashboardpage.Bellicon());
	}
	
	@Then("User should see profile icon near user name")
	public void user_should_see_profile_icon_near_user_name() {
		//Assert.assertTrue(dashboardpage.Username());
	}
	
	@Then("User should see search bar in dashboard")
	public void user_should_see_search_bar_in_dashboard() {
		Assert.assertTrue(dashboardpage.Searchbar());
	}
	
	@Then("User should see {int} menus in dashboard")
	public void user_should_see_menus_in_dashboard(Integer int1) {
		Assert.assertTrue(dashboardpage.Menu());
		
	}
	
	@Then("User Name, {string},{string},{string},{string},  {string},{string}, {string},{string},  {string}")
	public void user_name(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
		dashboardpage.getMenu();
	}

	@Then("{string}, {string}")
	public void string_string(String string, String string2) {
		dashboardpage.Subtitle();
		String subTitle = driver.getTitle();
		 System.out.println("Page Title: " + subTitle);
	} 
	
	@Then("Sub text should be located at the centre of the page")
	public void sub_text_should_be_located_at_the_centre_of_the_page() {
		dashboardpage.checkAllignmentOfTextFld();
		LoggerLoad.info("Alignment input field is center position");
	}
	
	@Then("{int} section should be visible")
	public void section_should_be_visible(Integer int1) {
		Assert.assertTrue(dashboardpage.Section());
	}
	@Then("Weight & Body Metrics,Health Conditions,Blood Report Insights,Menstrual Cycle Insights,Subscription Information")
	public void weight_body_metrics_health_conditions_blood_report_insights_menstrual_cycle_insights_subscription_information() {
		dashboardpage.getSection();
	}
	@Then("Weight , Height , BMI , {int}-Day Goal,BMI Reference Guide")
	public void weight_height_bmi_day_goal_bmi_reference_guide(Integer int1) {
		dashboardpage.Metricsec();
	}
	
	@Then("App should have Starting weight, Goal , Weekly target, Daily Weigh-in")
	public void app_should_have_starting_weight_goal_weekly_target_daily_weigh_in() {
		dashboardpage.GoalSec();
	}
	
	@Then("Should display the users weight as entered during the onboarding process")
	public void should_display_the_user_s_weight_as_entered_during_the_onboarding_process() {
		
		Assert.assertTrue(dashboardpage.Weight());
	}

	@Then("Should display the users Height as entered during the onboarding process")
	public void should_display_the_user_s_height_as_entered_during_the_onboarding_process() {
		//dashboardpage.Height();
		Assert.assertTrue(dashboardpage.Section());
	} 
	
	@Then("BMI should be correctly calculated using the formula" )
	public void bmi_should_be_correctly_calculated_using_the_formula_weight_in_kg_height_in_m(Integer int1) {
		dashboardpage.BMI();
	}
	
	@Then("Should display weight entered by user")
	public void should_display_weight_entered_by_user() {
		dashboardpage.Weight();
	}

	@Then("Goal weight should be displayed as the difference from the weekly target")
	public void goal_weight_should_be_displayed_as_the_difference_from_the_weekly_target() {
		dashboardpage.GoalWeight();
	}

	@Then("Weekly target should be {double} kg")
	public void weekly_target_should_be_kg(Double double1) {
		dashboardpage.WeekWeight();
	}

	@Then("Daily weigh in should be - {string}")
	public void daily_weigh_in_should_be(String string) {
		dashboardpage.Weight();
	}
	
	@Then("Subcription details should be present in {int}-day goal section")
	public void subcription_details_should_be_present_in_day_goal_section(Integer int1) {
		dashboardpage.Subhead();
	}

	@Then("Slider should be present in BMI reference guide")
	public void slider_should_be_present_in_bmi_reference_guide() {
		dashboardpage.Bmiheading();
	}

	@Then("BMI Reference Guide component should be displayed with a gradient slider and labeled ranges")
	public void bmi_reference_guide_component_should_be_displayed_with_a_gradient_slider_and_labeled_ranges() {
		dashboardpage.Bmiheading();
	}
	
	@Then("slider should display a continuous gradient from blue to yellow to orange to red, representing increasing BMI values")
	public void slider_should_display_a_continuous_gradient_from_blue_to_yellow_to_orange_to_red_representing_increasing_bmi_values() {
		dashboardpage.Bmiheading();
	} 
	
	@Then("Labels {string}, {string}, {string}, and {string} should be visible and color-coded accordingly")
	public void labels_and_should_be_visible_and_color_coded_accordingly(String string, String string2, String string3, String string4) {
		dashboardpage.Bmiheading();
	}

	@Then("Circular pointer should automatically be positioned on the slider corresponding to the users BMI value")
	public void circular_pointer_should_automatically_be_positioned_on_the_slider_corresponding_to_the_user_s_bmi_value() {
		dashboardpage.Bmiheading();
	}

	@Then("Slider should not allow manual movement; it should remain fixed based on the users BMI")
	public void slider_should_not_allow_manual_movement_it_should_remain_fixed_based_on_the_user_s_bmi() {
		dashboardpage.Bmiheading();
	}

	@Then("{string} label should be visible above the slider")
	public void label_should_be_visible_above_the_slider(String string) {
		dashboardpage.Bmiheading();
	}
	
	@Then("Message Free plan includes {int} days of limited tracking should be displayed clearly below the slider")
	public void message_free_plan_includes_days_of_limited_tracking_should_be_displayed_clearly_below_the_slider(Integer int1) {
		dashboardpage.FreePlanbar();
	}
	
	//=========================================Health With Condition=====================================================
	
	@Then("Displayed condition\\(s) match exactly what was selected during onboarding, without requiring user input again")
	public void displayed_condition_s_match_exactly_what_was_selected_during_onboarding_without_requiring_user_input_again() {
		//dashboardpage.Healthconditon();
		dashboardpage.Healthconditon();
	}

	@Then("Message appears below condition card explaining how the plan is adjusted")
	public void message_appears_below_condition_card_explaining_how_the_plan_is_adjusted() {
		dashboardpage.Healthconditon();
	}

	@Then("Card includes heart icon, condition name , and info icon with related text")
	public void card_includes_heart_icon_condition_name_and_info_icon_with_related_text() {
		dashboardpage.Healthconditon();
	}
	
	//====================================Health With Condition===========================================================
	
	@Then("Message like No health conditions selected or an empty state is displayed")
	public void message_like_no_health_conditions_selected_or_an_empty_state_is_displayed() {
		Assert.assertTrue(dashboardpage.HealthWithcond());
	}
	
	//=====================================Blood Report Insights=====================================================
	
	@Then("Blood Report Insights section should display the personalized values and insights")
	public void blood_report_insights_section_should_display_the_personalized_values_and_insights() {
		dashboardpage.BloodReport();
	}

	@Then("User should see the Upload Blood Report button")
	public void user_should_see_the_upload_blood_report_button() {
		dashboardpage.BloodReport();
	}

	@Then("Message prompting them to upload their medical blood test report")
	public void message_prompting_them_to_upload_their_medical_blood_test_report() {
		dashboardpage.BloodReportSelect();
		 Assert.assertEquals("medical blood test report", dashboardpage.BloodReportSelect());
	}

	@Then("Upload Blood Report\" button should be enabled")
	public void upload_blood_report_button_should_be_enabled() {
		Assert.assertTrue(dashboardpage.BloodReportSelect());
	}
	
	//==============================================DashboardSubsription=================================
	
	@Then("Joined date should be displayed")
	public void joined_date_should_be_displayed() {
		Assert.assertTrue(dashboardpage.Subscription());
	}

	@Then("Todays date should be display")
	public void todays_date_should_be_display() {
		Assert.assertTrue(dashboardpage.Subscription());
	}

	@Then("Subcription plan should be displayed")
	public void subcription_plan_should_be_displayed() {
		Assert.assertEquals("Subcription plan displayed", dashboardpage.Subscription());
	}

	@Then("Status of plan should be displayed\\(how many days left out of {int} days free plan)")
	public void status_of_plan_should_be_displayed_how_many_days_left_out_of_days_free_plan(Integer int1) {
		Assert.assertTrue(dashboardpage.Subscription());
	}

	@Then("Upgrade to Premium\" button should be displayed")
	public void upgrade_to_premium_button_should_be_displayed() {
		dashboardpage.Upgradebtn();
	}
	//==============================MenstrualCycle==============================================================
	
	@Then("Should display current menstrual phase in cycle insights section based on onboarding input")
	public void should_display_current_menstrual_phase_in_cycle_insights_section_based_on_onboarding_input() {
		Assert.assertTrue(dashboardpage.MenstrualBar());
	}

	@Then("Should display accurate number of days left in the cycle")
	public void should_display_accurate_number_of_days_left_in_the_cycle() {
		Assert.assertTrue(dashboardpage.MenstrualBar());
	}

	@Then("{string} should be displayed accurately based on onboarding input")
	public void should_be_displayed_accurately_based_on_onboarding_input(String string) {
		Assert.assertTrue(dashboardpage.MenstrualBar());
	}

	@Then("{string} count displayed should match the number of days since the last period start date")
	public void count_displayed_should_match_the_number_of_days_since_the_last_period_start_date(String string) {
		Assert.assertTrue(dashboardpage.MenstrualBar());
	}

	@Then("Filled portion should visually represent the proportion of days completed in the current cycle")
	public void filled_portion_should_visually_represent_the_proportion_of_days_completed_in_the_current_cycle() {
		Assert.assertTrue(dashboardpage.Menstrual());
	}
	 
	@Then("Should display x days as the countdown to the next period")
	public void should_display_x_days_as_the_countdown_to_the_next_period() {
		Assert.assertTrue(dashboardpage.Menstrual());
	}

	@Then("User should be redirected to the full Menstrual cycle log page")
	public void user_should_be_redirected_to_the_full_menstrual_cycle_log_page() {
		Assert.assertTrue(dashboardpage.Menstrual());
	}

	@Then("Message {string} should be displayed")
	public void message_should_be_displayed(String string) {
		Assert.assertEquals("Message displayed", dashboardpage.Menstrual());
	}

	@Then("Hormonal Impact on Weight message should match the expected text for that phase")
	public void hormonal_impact_on_weight_message_should_match_the_expected_text_for_that_phase() {
		Assert.assertTrue(dashboardpage.Hormonal());
	}

	@Then("Symptoms listed should correspond to the expected symptoms for that phase")
	public void symptoms_listed_should_correspond_to_the_expected_symptoms_for_that_phase() {
		Assert.assertTrue(dashboardpage.Symptoms());
	}

	@Then("Cravings displayed should match the expected cravings for that phase")
	public void cravings_displayed_should_match_the_expected_cravings_for_that_phase() {
		Assert.assertTrue(dashboardpage.Cravings());
	}
	
	//================================DashboardFunctionality=====================================
	
	@Given("User is on the Her Balance Dashboard page")
	public void user_is_on_the_her_balance_dashboard_page() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("dashboardurl"));
	}

	@When("User clicks on profile name")
	public void user_clicks_on_profile_name() {
		dashboardpage.Usernameclick();
	}

	@Then("User should see {string}, {string}, {string} , {string} options")
	public void user_should_see_options(String string, String string2, String string3, String string4) {
		Assert.assertTrue(dashboardpage.Username());
	}

	@When("User clicks on activity Insight")
	public void user_clicks_on_activity_insight() {
		dashboardpage.MenuActivityinsight();
	}

	@Then("User should see  Track Weight\", Food Intake\" , {string}")
	public void user_should_see_track_weight_food_intake(String string) {
		dashboardpage.getMenu();
	}

	@When("User clicks on Diet plan button")
	public void user_clicks_on_diet_plan_button() {
		dashboardpage.MenuDietplan();
	}

	@Then("User should redirected to diet-plan page")
	public void user_should_redirected_to_diet_plan_page() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("dietplanurl"));
	}

	@When("User clicks on workout button")
	public void user_clicks_on_workout_button() {
		dashboardpage.MenuWorkout();
	}

	@Then("User should redirected to workout page")
	public void user_should_redirected_to_workout_page() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("Workouturl"));
	}

	@When("User clicks on water tracker button")
	public void user_clicks_on_water_tracker_button() {
		dashboardpage.Menuwater();
	}

	@Then("User should redirected to water tracker page")
	public void user_should_redirected_to_water_tracker_page() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("WaterTrackerurl"));
	}

	@When("User clicks on View Full Cycle Details")
	public void user_clicks_on_view_full_cycle_details() {
		dashboardpage.MenstrualClick();
	}

	@Then("User should be redirected to Menstrual cycle tracker page")
	public void user_should_be_redirected_to_menstrual_cycle_tracker_page() {
		Assert.assertTrue(dashboardpage.Menstrual());
	}

	@When("User clicks on Upload Blood report")
	public void user_clicks_on_upload_blood_report() {
		dashboardpage.BloodReportClick();
	}

	@Then("User should be redirected to explorer to choose the file")
	public void user_should_be_redirected_to_explorer_to_choose_the_file() {
	    
	}

	@When("User clicks on  Upgrade to Premium")
	public void user_clicks_on_upgrade_to_premium() {
		dashboardpage.Upgradebtn();
	}

	@Then("User should be redirected to Subcription page")
	public void user_should_be_redirected_to_subcription_page() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("Subcriptionurl"));
	}

	@When("User clicks on Generate {int}-Day Plan")
	public void user_clicks_on_generate_day_plan(Integer int1) {
		dashboardpage.MenuDietplan();
	}

	@Then("User should be redirected to diet-plan page")
	public void user_should_be_redirected_to_diet_plan_page() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("dietplanurl"));
	}

	@When("User clicks on See Premium Plans")
	public void user_clicks_on_see_premium_plans() {
		dashboardpage.Upgradebtn();
	}
//====================================Sub Menu===========================================================================
	
	@Given("User is on the Her Balance Dashboard with the Profile submenu expanded")
	public void user_is_on_the_her_balance_dashboard_with_the_profile_submenu_expanded() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("dashboardurl"));
	}

	@When("User clicks on Home")
	public void user_clicks_on_home() {
		dashboardpage.Menu();
	}

	@Then("User should be redirected to dashboard option")
	public void user_should_be_redirected_to_dashboard_option() {
	    
	}

	@When("User clicks on Edit Profile")
	public void user_clicks_on_edit_profile() {
		dashboardpage.Usernameclick();
	}

	@Then("User should be redirected to Edit Your Profile page")
	public void user_should_be_redirected_to_edit_your_profile_page() {
		Assert.assertTrue(dashboardpage.Username());
	}

	@When("User clicks on Subscription")
	public void user_clicks_on_subscription() {
		dashboardpage.Subscriptionclick();
	}

	@Then("User should be redirected to Subscription Management page")
	public void user_should_be_redirected_to_subscription_management_page() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("Subcriptionurl"));
	}

	@When("User clicks on Logout")
	public void user_clicks_on_logout() {
		dashboardpage.DashLogout();
	}

	@Then("User should be logged out of the application")
	public void user_should_be_logged_out_of_the_application() {
		Assert.assertEquals("Logout Successful", dashboardpage.DashLogoutdis());
	}

	@When("User clicks on Track Weight")
	public void user_clicks_on_track_weight() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("WaterTrackerurl"));
	}

	@Then("User should be redirected to  track weight page")
	public void user_should_be_redirected_to_track_weight_page() {
	   
	}

	@When("User clicks on Food Intake")
	public void user_clicks_on_food_intake() {
		dashboardpage.MenuDietplan();
	}

	@Then("User should be redirected to food intake page")
	public void user_should_be_redirected_to_food_intake_page() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("dietplanurl"));
	}

	@When("User clicks on Menstrual Phase Logs")
	public void user_clicks_on_menstrual_phase_logs() {
		dashboardpage.MenstrualClick();
	}
	
	@Then("User should be redirected to menstrual phase log page")
	public void user_should_be_redirected_to_menstrual_phase_log_page() {
	    
	}




	
	
	

	

	

	

	

	

	

	

	
	

	

	

	

	

	

	

	

	

	

	
	
	



}
