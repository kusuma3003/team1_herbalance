package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public LaunchPage launchpage;
	public LoginPage loginpage;

	


	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public LaunchPage getlaunchpage() {
		if (launchpage == null) {
			launchpage = new LaunchPage(driver);
		}
		return launchpage;
	}

	public LoginPage getloginpage() {
		if (launchpage == null) {
			launchpage = new LaunchPage(driver);
		}
		return loginpage;
	}

	

}
