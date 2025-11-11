package stepdefinition;

import static org.testng.Assert.assertTrue;

//import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LaunchPage;
import utils.PropertyFileReader;
import utils.Excel_Reader;
import utils.LoggerLoad;
import utils.TestContextSetup;

public class Launchsteps {

	TestContextSetup context;
	DriverFactory driverFactory;
	public WebDriver driver;
	public LaunchPage launchpage;
	
	Excel_Reader excelreader;
	//Alert alert;

	public Launchsteps(TestContextSetup context) {

		this.context = context;
		launchpage = context.getpageobjectmanager().getlaunchpage();
		this.driver = DriverFactory.Driver();
		excelreader = context.getexcelreader();
	}

	@Given("User is on the browser")
	public void user_is_on_the_browser() {
		
		LoggerLoad.info("User is in the browser");
	 }

	@When("User enters app url")
	public void user_enters_app_url() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getUrl());
	}

	@Then("Display cards for {string}, {string}, {string}, and {string}")
	public void display_cards_for_and(String MP, String FP, String OP, String LP) {
		// launchpage.Displaycards();
		Assert.assertTrue(launchpage.Displaycards());
	}

	@Then("Details about the {string} and its features")
	public void details_about_the_and_its_features(String cycletrack) {
		launchpage.Cycletrack();
	}

	@Then("Login button should be visible")
	public void login_button_should_be_visible() {

		
		Assert.assertTrue(launchpage.Loginbutton());
	}

	@Then("Sign button should be visible")
	public void sign_button_should_be_visible() {
		
		Assert.assertTrue(launchpage.SigninButton());
	}

	@Then("Images in Sync' should be displayed")
	public void images_in_sync_should_be_displayed() {
		Assert.assertTrue(launchpage.Imagesyn());
	}

	@Then("Display information about hormonal shifts and metabolism during the menstrual cycle")
	public void display_information_about_hormonal_shifts_and_metabolism_during_the_menstrual_cycle() {
		Assert.assertTrue(launchpage.Menstrualdetailsinfo());
	}

	@Then("User should see a light purple background and readable text content")
	public void user_should_see_a_light_purple_background_and_readable_text_content() {
		launchpage.checkUserTxtClr();
		 Assert.assertEquals("#800080", "purple"); // Assertion for purple
	}

	@Then("Display a {string} button in the footer section")
	public void display_a_button_in_the_footer_section(String startbutton) {
		
		Assert.assertTrue(launchpage.getstartedbutton());
	}

	@Then("Start Your Personalized' button should be displayed")
	public void start_your_personalized_button_should_be_displayed() {
		
		Assert.assertTrue(launchpage.personalizedbutton());
	}
	
	//------------------------------------------Functional testcases--------------------------
	
	@Given("User is in her balance home")
	public void user_is_in_her_balance_home() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("launchurl"));
	}

	@When("User clicks log in button")
	public void user_clicks_log_in_button() {
		 launchpage.Loginbutton();
	}

	@Then("User should be navigated to auth page login tab")
	public void user_should_be_navigated_to_auth_page_login_tab() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("loginurl"));
	}

	@When("User clicks sign up button")
	public void user_clicks_sign_up_button() {
		 launchpage.SigninButton();
	}

	@Then("User should be navigated to auth page sign up tab")
	public void user_should_be_navigated_to_auth_page_sign_up_tab() throws Throwable {
		driverFactory.openPage(PropertyFileReader.getGlobalValue("loginurl"));
	}

	@When("User clicks Get Started button")
	public void user_clicks_get_started_button() {
		launchpage.getstartedbutton();
	}

	@When("User clicks Start your personalized journey button")
	public void user_clicks_start_your_personalized_journey_button() {
		launchpage.personalizedbutton();
	}

}
