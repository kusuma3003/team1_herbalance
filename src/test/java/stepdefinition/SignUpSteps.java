package stepdefinition;

import org.testng.Assert;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SignUpPage;

public class SignUpSteps {
			
    private SignUpPage SignUpPage =new SignUpPage(DriverFactory.getDriver());

	@Given("User is on the HerBalance launch page")
	public void user_is_on_the_her_balance_launch_page() {
	SignUpPage.LaunchPage();
	    
	}

	@When("User clicks sign up button")
	public void user_clicks_sign_up_button() {
	 SignUpPage.clickSignUpButton();
	}

	@Then("Email ID input field with placeholder {string} should be visible")
	public void email_id_input_field_with_placeholder_should_be_visible(String string) {
		Assert.assertTrue(SignUpPage.isEmailIdDisplayed(), "Email field not visible");
		Assert.assertEquals(SignUpPage.getEmailIdPlaceholder_text(), string, "Placeholder mismatch");
	    
	}

	@Then("Password input field with masked entry should be visible")
	public void password_input_field_with_masked_entry_should_be_visible() {
		Assert.assertTrue(SignUpPage.isPasswordDisplayed(), "Password field is not visible");
        Assert.assertTrue(SignUpPage.isPasswordMasked(), "Password field is not masked ");	
	    
	}

	@Then("Confirm password input field with masked entry should be visible")
	public void confirm_password_input_field_with_masked_entry_should_be_visible() {
		Assert.assertTrue(SignUpPage.isConfirmPasswordDisplayed(), "Confirm Password field is not visible");
        Assert.assertTrue(SignUpPage.isConfirmPasswordMasked(), "Confirm Password field is not masked ");
	       
	}
	@Then("“Login” button should be visible, enabled")
	public void login_button_should_be_visible_enabled() {
		 Assert.assertTrue(SignUpPage.isLoginButtonEnabled(), "Login Button not enabled "); 
	}

	@Then("“Login” link should be visible and navigates to the Login page")
	public void sign_up_link_should_be_visible_and_navigates_to_the_sign_up_page() {
		Assert.assertTrue(SignUpPage.isLoginLinkVisible(), "Login link is not visible on the page");
        SignUpPage.clickLoginLink();
        Assert.assertTrue(SignUpPage.isOnLoginPage(), " Navigation failed — user did not reach the Sign Up page");   
	}

	@Then("Email ID , Password , Confirm Password fields should be properly aligned vertically with equal spacing")
	public void email_id_password_confirm_password_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
	   
	}

	@Then("There should be exactly {int} input field")
	public void there_should_be_exactly_input_field(Integer int1) {
	    
	}

	@Then("Radio button for show passwords is present")
	public void radio_button_for_show_passwords_is_present() {
	    
	}

	@Then("Terms and conditions details should be present")
	public void terms_and_conditions_details_should_be_present() {
	    
	}

	@Then("Radio button for Terms and condition is present")
	public void radio_button_for_terms_and_condition_is_present() {
	   
	}

	@Then("The background gradient \\(light purple) and fonts should match HerBalance theme")
	public void the_background_gradient_light_purple_and_fonts_should_match_her_balance_theme() {
	   
	}





}
