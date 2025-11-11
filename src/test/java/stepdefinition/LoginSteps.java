package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import utils.Excel_Reader;
import utils.TestContextSetup;

public class LoginSteps {
	TestContextSetup context;
	DriverFactory driverFactory;
	public WebDriver driver;
	public LoginPage loginpage;
	Excel_Reader excelreader;
	//Alert alert;

	public void Loginsteps(TestContextSetup context) {
		
	this.context = context;
	loginpage = context.getpageobjectmanager().getloginpage();
	this.driver = DriverFactory.Driver();
	excelreader = context.getexcelreader();
}

	//---------------------------  Login-UI  --------------------------
@Given("User is on the HerBalance launch page")
public void user_is_on_the_her_balance_launch_page() {
	driver.get("https://dsportalapp.herokuapp.com/");
}

@When("User clicks log in button")
public void user_clicks_log_in_button() {
   loginpage.clickLoginButton();
}

@Then("HerBalance logo should be visible on the top-left corner")
public void her_balance_logo_should_be_visible_on_the_top_left_corner() {
   Assert.assertTrue(loginpage.isLogoVisible());
}

@Then("{string} tabs should be visible")
public void tabs_should_be_visible(String tabName) {
    Assert.assertTrue(loginpage.isTabVisible(tabName));
}


@Then("“Login” tab should be active by default")
public void login_tab_should_be_active_by_default() {
    Assert.assertTrue(loginpage.isLoginTabActive());
}


@Then("Email ID input field with placeholder {string} should be visible")
public void email_id_input_field_with_placeholder_should_be_visible(String placeholder) {
    Assert.assertTrue(loginpage.isEmailPlaceholderCorrect(placeholder));
}


@Then("Password input field with masked entry should be visible")
public void password_input_field_with_masked_entry_should_be_visible() {
    Assert.assertTrue(loginpage.isPasswordMasked());
}


@Then("“Show password” should be visible")
public void show_password_should_be_visible() {
    Assert.assertTrue(loginpage.isShowPasswordOptionVisible());
}


@Then("“Login” button should be visible, enabled")
public void login_button_should_be_visible_enabled() {
    Assert.assertTrue(loginpage.isLoginButtonVisible());
    Assert.assertTrue(loginpage.isLoginButtonEnabled());
}


@Then("“Forgot password?” link should be visible")
public void forgot_password_link_should_be_visible() {
    Assert.assertTrue(loginpage.isForgotPasswordLinkVisible());
}


@Then("“Sign Up” link should be visible and navigates to the Sign-Up page")
public void sign_up_link_should_be_visible_and_navigates_to_the_sign_up_page() {
    Assert.assertTrue(loginpage.isSignUpLinkVisible());
    loginpage.clickSignUpLink();
}

@Then("The right section should display “Cycle-Synced Plans”, “Blood Work Analysis”, and “Personalized Dashboard” content")
public void the_right_section_should_display_cycle_synced_plans_blood_work_analysis_and_personalized_dashboard_content() {
	Assert.assertTrue(loginpage.isRightPanelContentCorrect());
}

@Then("A testimonial with text and name \\(e.g., “Sarah, {int}”) should be displayed")
public void a_testimonial_with_text_and_name_e_g_sarah_should_be_displayed(Integer int1) {
	Assert.assertTrue(loginpage.isTestimonialDisplayed());
}

@Then("There should be exactly {int} tabs — “Login” and “Sign Up”")
public void there_should_be_exactly_tabs_login_and_sign_up(Integer int1) {
	Assert.assertEquals(loginpage.getTabCount(), int1.intValue());
}

@Then("Email ID fields should be properly aligned vertically with equal spacing")
public void email_id_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
	Assert.assertTrue(loginpage.isEmailFieldAligned());
}

@Then("Password fields should be properly aligned vertically with equal spacing")
public void password_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
	Assert.assertTrue(loginpage.isPasswordFieldAligned());
}

@Then("There should be exactly {int} input field")
public void there_should_be_exactly_input_field(Integer int1) {
	Assert.assertEquals(loginpage.getInputFieldCount(), int1.intValue());
}

@Then("Radio button for show password")
public void radio_button_for_show_password() {
    Assert.assertTrue(loginpage.isShowPasswordOptionVisible());
}


@Then("The background gradient \\(light purple) and fonts should match HerBalance theme")
public void the_background_gradient_light_purple_and_fonts_should_match_her_balance_theme() {
	Assert.assertTrue(loginpage.isThemeCorrect());
}

//---------------------------  Login-func  --------------------------

@Given("User is on the HerBalance auth page")
public void user_is_on_the_her_balance_auth_page() {
    driver.get("https://dsportalapp.herokuapp.com/");
    loginpage.clickLoginButton();
}

@When("user clicks login button after entering a valid credential")
public void user_clicks_login_button_after_entering_a_valid_credential() {
    loginpage.enterEmail("valid@test.com");
    loginpage.enterPassword("Valid123");
    loginpage.submitLogin();
}

@Then("User should be redirected to the dashboard")
public void user_should_be_redirected_to_the_dashboard() {
    Assert.assertTrue(loginpage.isDashboardLoaded());
}


@When("user clicks login button after entering a invalid credential")
public void user_clicks_login_button_after_entering_a_invalid_credential() {
    loginpage.enterEmail("wrong@test.com");
    loginpage.enterPassword("WrongPass");
    loginpage.submitLogin();
}

@Then("An error message {string} should be displayed")
public void an_error_message_should_be_displayed(String expectedMsg) {
    Assert.assertEquals(loginpage.getErrorMessage(), expectedMsg);
}


@When("user clicks login button after leaving credential blank")
public void user_clicks_login_button_after_leaving_credential_blank() {
    loginpage.submitLogin();
}

@Then("Validation messages {string} and {string} should be displayed")
public void validation_messages_and_should_be_displayed(String msg1, String msg2) {
    Assert.assertTrue(loginpage.areValidationMessagesDisplayed(msg1, msg2));
}


@Given("User clicked login button in home page")
public void user_clicked_login_button_in_home_page() {
    driver.get("https://dsportalapp.herokuapp.com/");
    loginpage.clickLoginButton();
}

@When("User clicks show password after entering password")
public void user_clicks_show_password_after_entering_password() {
    loginpage.enterPassword("abcd123");
    loginpage.toggleShowPassword();
}

@Then("Password should be visible in plain text")
public void password_should_be_visible_in_plain_text() {
    Assert.assertTrue(loginpage.isPasswordVisible());
}


@When("User unchecks the {string} option after entering password")
public void user_unchecks_the_option_after_entering_password(String option) {
    loginpage.toggleShowPassword(); // uncheck again
}

@Then("Password should again be masked")
public void password_should_again_be_masked() {
    Assert.assertTrue(loginpage.isPasswordMasked());
}


@When("User enters a password and clicks the eye icon")
public void user_enters_a_password_and_clicks_the_eye_icon() {
    loginpage.enterPassword("Test123");
    loginpage.toggleShowPassword();
}

@Then("Password should become visible and shown in plain text")
public void password_should_become_visible_and_shown_in_plain_text() {
    Assert.assertTrue(loginpage.isPasswordVisible());
}

@When("User clicks the eye icon again")
public void user_clicks_the_eye_icon_again() {
    loginpage.toggleShowPassword();
}


@When("User clicks on {string}")
public void user_clicks_on(String link) {
    loginpage.clickLink(link);
}

@Then("User should be redirected to the Forget Password page")
public void user_should_be_redirected_to_the_forget_password_page() {
    Assert.assertTrue(loginpage.isForgotPasswordPageLoaded());
}


@When("user clicks on {string} tab")
public void user_clicks_on_tab(String tabName) {
    loginpage.selectTab(tabName);
}

@Then("User should be redirected to the sign up tab")
public void user_should_be_redirected_to_the_sign_up_tab() {
    Assert.assertTrue(loginpage.isSignUpTabActive());
}

}