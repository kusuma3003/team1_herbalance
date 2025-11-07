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
	Alert alert;

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

		// launchpage.Loginbutton();
		Assert.assertTrue(launchpage.Loginbutton());
	}

	@Then("Sign button should be visible")
	public void sign_button_should_be_visible() {
		// launchpage.SigninButton();
		Assert.assertTrue(launchpage.SigninButton());
	}

	@Then("Images in Sync' should be displayed")
	public void images_in_sync_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Display information about hormonal shifts and metabolism during the menstrual cycle")
	public void display_information_about_hormonal_shifts_and_metabolism_during_the_menstrual_cycle() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User should see a light purple background and readable text content")
	public void user_should_see_a_light_purple_background_and_readable_text_content() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Display a {string} button in the footer section")
	public void display_a_button_in_the_footer_section(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Start Your Personalized' button should be displayed")
	public void start_your_personalized_button_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
