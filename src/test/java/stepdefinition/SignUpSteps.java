
package stepdefinition;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driverfactory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SignUpPage;
import utils.ExcelUtils;
import utils.TestContextSetup;

public class SignUpSteps {
	TestContextSetup context;
	DriverFactory driverFactory;
	public WebDriver driver;
	public SignUpPage signuppage;
	private Map<String, String> testData;
	String expectedError;
	String actualError;
	private Scenario scenario;
	WebElement inputField;

	public SignUpSteps(TestContextSetup context) {
		this.context = context;
		signuppage = context.getpageobjectmanager().getsignuppage();
		this.driver = DriverFactory.Driver();
	}

	@Given("User is on the HerBalance launch page")
	public void user_is_on_the_her_balance_launch_page() {
		signuppage.LaunchPage();

	}

	@When("User clicks sign up button")
	public void user_clicks_sign_up_button() {
		signuppage.clickSignUpButton();
		signuppage.clickSignUpTab();
	}

	@Then("Email ID input field with placeholder {string} should be visible")
	public void email_id_input_field_with_placeholder_should_be_visible(String string) {
		Assert.assertTrue(signuppage.isEmailIdDisplayed(), "Email field not visible");
		Assert.assertEquals(signuppage.getEmailIdPlaceholder_text(), string, "Placeholder mismatch");

	}

	@Then("Password input field with masked entry should be visible")
	public void password_input_field_with_masked_entry_should_be_visible() {
		Assert.assertTrue(signuppage.isPasswordDisplayed(), "Password field is not visible");
		Assert.assertTrue(signuppage.isPasswordMasked(), "Password field is not masked ");

	}

	@Then("Confirm password input field with masked entry should be visible")
	public void confirm_password_input_field_with_masked_entry_should_be_visible() {
		Assert.assertTrue(signuppage.isConfirmPasswordDisplayed(), "Confirm Password field is not visible");
		Assert.assertTrue(signuppage.isConfirmPasswordMasked(), "Confirm Password field is not masked ");

	}

	@Then("“Login” button should be visible, enabled")
	public void login_button_should_be_visible_enabled() {
		Assert.assertTrue(signuppage.isLoginButtonEnabled(), "Login Button not enabled ");
	}

	@Then("“Login” link should be visible and navigates to the Login page")
	public void sign_up_link_should_be_visible_and_navigates_to_the_sign_up_page() {
		Assert.assertTrue(signuppage.isLoginLinkVisible(), "Login link is not visible on the page");
		signuppage.clickLoginLink();
		Assert.assertTrue(signuppage.isOnLoginPage(), " Navigation failed — user did not reach the Sign Up page");
	}

	@Then("Email ID , Password , Confirm Password fields should be properly aligned vertically with equal spacing")
	public void email_id_password_confirm_password_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
		Assert.assertTrue(signuppage.isAligned(), "Fields are not aligned");
		Assert.assertTrue(signuppage.isSpaced(), "Not Equally Spaced ");

	}

	@Then("There should be exactly {int} input field")
	public void there_should_be_exactly_input_field(Integer int1) {
		Assert.assertTrue(signuppage.verifyingInputFields(), "No input fields not matching ");

	}

	@Then("Radio button for show passwords is present")
	public void radio_button_for_show_passwords_is_present() {
		Assert.assertTrue(signuppage.verifyShowPasswordRadioButton(), "Show password Radio Button not present ");
	}

	@Then("Terms and conditions details should be present")
	public void terms_and_conditions_details_should_be_present() {
		Assert.assertTrue(signuppage.verifyTermsAndConditionsPresent(), "Terms and condition not present");
	}

	@Then("Radio button for Terms and condition is present")
	public void radio_button_for_terms_and_condition_is_present() {
		Assert.assertTrue(signuppage.verifyTermsandConditionRadioButton(),
				"Terms and Conditions radio button not present");

	}

	@Then("The background gradient \\(light purple) and fonts should match HerBalance theme")
	public void the_background_gradient_light_purple_and_fonts_should_match_her_balance_theme() {
		Assert.assertTrue(signuppage.verifyTheme(), "Background color or theme does not match HerBalance theme");

	}

	@Given("User is on the HerBalance auth page")
	public void user_is_on_the_her_balance_auth_page() {
		signuppage.LaunchPage();
		signuppage.clickSignUpButton();
		signuppage.clickSignUpTab();
	}

	@When("the user enters testdata for each {string}")
	public void the_user_enters_testdata_for_each(String string) {
		testData = ExcelUtils.readExcelRow(string, "sheet1");
		String email = testData.get("email");
		String password = testData.get("password");
		String confirmPassword = testData.get("confirmpassword");
		if (string.toLowerCase().contains("without accepting terms")) {
			signuppage.registerUserwithoutclickingTerms(email, password, confirmPassword);
		} else {
			signuppage.registerUser(email, password, confirmPassword);
		}

	}

	@Then("user should able to see this expected output")
	public void user_should_able_to_see_this_expected_output() {
		expectedError = testData.get("output");
		actualError = signuppage.verifyResult(expectedError);
		Assert.assertEquals(actualError, expectedError, "Mismatch between expected and actual result");
	}

	@When("User enters {string} in {string} field and performs {string}")
	public void user_enters_in_field_and_performs(String password, String field, String action) {
		inputField = signuppage.user_enters_in_field_and_performs(password, field, action);

	}

	@Then("The {string} field should display password as {string}")
	public void the_field_should_display_password_as(String field, String visibility) {
		String type = inputField.getDomAttribute("type");
		if (visibility.equalsIgnoreCase("visible")) {
			Assert.assertEquals(type, "text", field + " should be visible but it's masked");
		} else {
			Assert.assertEquals(type, "password", field + " should be masked but it's visible");
		}
	}

	@When("user clicks on {string}")
	public void user_clicks_on(String string) {
		signuppage.clickLoginLink();

	}

	@Then("User should be redirected to the login tab")
	public void user_should_be_redirected_to_the_login_tab() {
		Assert.assertTrue(signuppage.isOnLoginPage(), "User is not redirected to the login page");
	}

}
