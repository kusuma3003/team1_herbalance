package stepdefinition;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import driverfactory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SignUpPage;
import utils.ExcelUtils;
import utils.TestContextSetup;

public class SignUpSteps {

	TestContextSetup context;
	DriverFactory driver;
	SignUpPage signuppage;
	private Map<String, String> testData;
	String expectedError;
	String actualError;
	WebElement inputField;
	private Scenario scenario;

	private static final Logger logger = LogManager.getLogger(SignUpSteps.class);

	public SignUpSteps(TestContextSetup context) {
		this.context = context;
		this.driver = context.getdriverFactory();
		this.signuppage = context.getpageobjectmanager().getsignuppage();
	}

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
		logger.info("Starting scenario: {}", scenario.getName());
	}

	@Given("User is on the HerBalance launch page")
	public void user_is_on_the_her_balance_launch_page() {
		logger.info("Navigating to HerBalance launch page...");
		signuppage.LaunchPage();
		logger.info("HerBalance launch page loaded successfully.");
	}

	@When("User clicks sign up button")
	public void user_clicks_sign_up_button() {
		logger.info("Clicking on Sign Up button...");
		signuppage.clickSignUpButton();
		signuppage.clickSignUpTab();
		logger.info("Sign Up tab opened.");
	}

	@Then("Email ID input field with placeholder {string} should be visible")
	public void email_id_input_field_with_placeholder_should_be_visible(String placeholder) {
		logger.info("Verifying Email input field and its placeholder text...");
		Assert.assertTrue(signuppage.isEmailIdDisplayed(), "Email field not visible");
		Assert.assertEquals(signuppage.getEmailIdPlaceholder_text(), placeholder, "Placeholder mismatch");
		logger.info("Email input field is visible with placeholder '{}'.", placeholder);
	}

	@Then("Password input field with masked entry should be visible")
	public void password_input_field_with_masked_entry_should_be_visible() {
		logger.info("Verifying Password input field visibility and masking...");
		Assert.assertTrue(signuppage.isPasswordDisplayed(), "Password field is not visible");
		Assert.assertTrue(signuppage.isPasswordMasked(), "Password field is not masked");
		logger.info("Password field is visible and masked correctly.");
	}

	@Then("Confirm password input field with masked entry should be visible")
	public void confirm_password_input_field_with_masked_entry_should_be_visible() {
		logger.info("Verifying Confirm Password input field visibility and masking...");
		Assert.assertTrue(signuppage.isConfirmPasswordDisplayed(), "Confirm Password field is not visible");
		Assert.assertTrue(signuppage.isConfirmPasswordMasked(), "Confirm Password field is not masked");
		logger.info("Confirm Password field is visible and masked correctly.");
	}

	@Then("\"Login\" button should be visible, enabled")
	public void login_button_should_be_visible_enabled() {
		logger.info("Verifying Login button visibility and enablement...");
		Assert.assertTrue(signuppage.isLoginButtonEnabled(), "Login Button not enabled");
		logger.info("Login button is visible and enabled.");
	}

	@Then("\"Login\" link should be visible and navigates to the Login page")
	public void login_link_should_be_visible_and_navigates_to_the_login_page() {
		logger.info("Checking if Login link is visible...");
		Assert.assertTrue(signuppage.isLoginLinkVisible(), "Login link is not visible on the page");
		logger.info("Clicking on Login link...");
		signuppage.clickLoginLink();
		Assert.assertTrue(signuppage.isOnLoginPage(), "Navigation failed — user did not reach the Login page");
		logger.info("User successfully navigated to the Login page.");
	}

	@Then("Email ID , Password , Confirm Password fields should be properly aligned vertically with equal spacing")
	public void fields_should_be_properly_aligned_and_spaced() {
		logger.info("Verifying alignment and spacing of input fields...");
		Assert.assertTrue(signuppage.isAligned(), "Fields are not aligned vertically.");
		Assert.assertTrue(signuppage.isSpaced(), "Fields are not equally spaced.");
		logger.info("All input fields are properly aligned and spaced.");
	}

	@Then("There should be exactly {int} input field")
	public void there_should_be_exactly_input_field(Integer expectedCount) {
		logger.info("Verifying total number of input fields expected: {}", expectedCount);
		Assert.assertTrue(signuppage.verifyingInputFields(), "Input fields count mismatch.");
		logger.info("Correct number of input fields are displayed.");
	}

	@Then("Radio button for show passwords is present")
	public void radio_button_for_show_passwords_is_present() {
		logger.info("Verifying presence of Show Password radio button...");
		Assert.assertTrue(signuppage.verifyShowPasswordRadioButton(), "Show Password Radio Button not present");
		logger.info("Show Password radio button is present.");
	}

	@Then("Terms and conditions details should be present")
	public void terms_and_conditions_details_should_be_present() {
		logger.info("Verifying presence of Terms and Conditions details...");
		Assert.assertTrue(signuppage.verifyTermsAndConditionsPresent(), "Terms and Conditions not present");
		logger.info("Terms and Conditions details are displayed correctly.");
	}

	@Then("Radio button for Terms and condition is present")
	public void radio_button_for_terms_and_condition_is_present() {
		logger.info("Verifying presence of Terms and Conditions acceptance radio button...");
		Assert.assertTrue(signuppage.verifyTermsAndConditionRadioButton(),
				"Terms and Conditions radio button not present");
		logger.info("Terms and Conditions radio button is present.");
	}

	@Then("The background gradient (light purple) and fonts should match HerBalance theme")
	public void background_and_fonts_should_match_theme() {
		logger.info("Verifying HerBalance theme for background and fonts...");
		Assert.assertTrue(signuppage.verifyTheme(), "Background color or fonts do not match HerBalance theme");
		logger.info("Theme verification successful — background and fonts match the HerBalance style.");
	}

	@Given("User is on the HerBalance auth page")
	public void user_is_on_the_her_balance_auth_page() {
		logger.info("Opening HerBalance auth (Sign Up) page...");
		signuppage.LaunchPage();
		signuppage.clickSignUpButton();
		signuppage.clickSignUpTab();
		logger.info("HerBalance auth page loaded.");
	}

	@When("the user enters testdata for each {string}")
	public void the_user_enters_testdata_for_each(String testCase) {
		logger.info("Fetching test data for: {}", testCase);
		testData = ExcelUtils.readExcelRow(testCase, "Sheet1");
		String email = testData.get("email");
		String password = testData.get("password");
		String confirmPassword = testData.get("confirmpassword");

		if (testCase.toLowerCase().contains("without accepting terms")) {
			logger.info("Registering user without accepting terms...");
			signuppage.registerUserwithoutclickingTerms(email, password, confirmPassword);
		} else {
			logger.info("Registering user with valid data...");
			signuppage.registerUser(email, password, confirmPassword);
		}
	}

	@Then("user should able to see this expected output")
	public void user_should_able_to_see_this_expected_output() {
		logger.info("Verifying expected vs actual result message...");
		expectedError = testData.get("output");
		actualError = signuppage.verifyResult(expectedError);
		Assert.assertEquals(actualError, expectedError, "Mismatch between expected and actual result");
		logger.info("Validation successful. Expected: '{}', Actual: '{}'", expectedError, actualError);
	}

	@When("User enters {string} in {string} field and performs {string}")
	public void user_enters_in_field_and_performs(String password, String field, String action) {
		logger.info("Entering value '{}' in field '{}' and performing action '{}'", password, field, action);
		inputField = signuppage.user_enters_in_field_and_performs(password, field, action);
	}

	@Then("The {string} field should display password as {string}")
	public void the_field_should_display_password_as(String field, String visibility) {
		logger.info("Verifying visibility of {} field; expected state: {}", field, visibility);
		String type = inputField.getDomAttribute("type");
		if (visibility.equalsIgnoreCase("visible")) {
			Assert.assertEquals(type, "text", field + " should be visible but it's masked");
		} else {
			Assert.assertEquals(type, "password", field + " should be masked but it's visible");
		}
		logger.info("{} field visibility verification passed. Current type: {}", field, type);
	}

	@When("user clicks on {string}")
	public void user_clicks_on(String element) {
		logger.info("User clicks on '{}'", element);
		signuppage.clickLoginLink();
	}

	@Then("User should be redirected to the login tab")
	public void user_should_be_redirected_to_the_login_tab() {
		logger.info("Verifying navigation to Login page...");
		Assert.assertTrue(signuppage.isOnLoginPage(), "User is not redirected to the login page");
		logger.info("User successfully redirected to the login tab.");
	}
}
