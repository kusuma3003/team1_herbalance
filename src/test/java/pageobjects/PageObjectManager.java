package pageobjects;

import org.openqa.selenium.WebDriver;

import stepdefinition.MenstrualCycleSteps;

public class PageObjectManager {

	public WebDriver driver;
	public SignUpPage signupPage;
	public MenstrualCyclePage menstrualpage;
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public SignUpPage getsignuppage() {
		if (signupPage == null) {
			signupPage = new SignUpPage(driver);
		}
		return signupPage;
	}
	public MenstrualCyclePage getmenstrualpage() {
		if (menstrualpage == null) {
			menstrualpage = new MenstrualCyclePage(driver);
		}
		return menstrualpage;
	}

	

	

}
