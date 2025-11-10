package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public SignUpPage signupPage;
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public SignUpPage getsignuppage() {
		if (signupPage == null) {
			signupPage = new SignUpPage(driver);
		}
		return signupPage;
	}

	

	

}
