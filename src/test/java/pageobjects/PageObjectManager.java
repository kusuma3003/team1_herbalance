package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public LaunchPage launchpage;
	public DashBoardPage dashboardpage;
	public LoginPage loginpage;
	EditProfilePage editProfilePage;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public LaunchPage getlaunchpage() {
		if (launchpage == null) {
			launchpage = new LaunchPage(driver);
		}
		return launchpage;
	}
	
	public DashBoardPage getdashboardpage() {
		if (dashboardpage == null) {
			dashboardpage = new DashBoardPage(driver);
		}
		return dashboardpage;
	}

	
	public LoginPage getloginpage() {
		if (launchpage == null) {
			launchpage = new LaunchPage(driver);
		}
		return loginpage;
	}
	

	public EditProfilePage getEditProfilePage() {
	    if (editProfilePage == null) {
	        editProfilePage = new EditProfilePage(driver);
	    }
	    return editProfilePage;
	}


}
