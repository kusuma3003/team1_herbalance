package pageobjects;

import org.openqa.selenium.WebDriver;

import stepdefinition.MenstrualCycleSteps;

public class PageObjectManager {

	public WebDriver driver;

	public SignUpPage signupPage;
	public MenstrualCyclePage menstrualpage;

	public LaunchPage launchpage;
	public DashBoardPage dashboardpage;
	public LoginPage loginpage;
	
	public OnboardingStep1Page onboardingstep1page;
	public OnboardingStep3Page onboardingstep3page;
	public OnboardingStep4Page onboardingstep4page;
	public OnboardingStep5Page onboardingstep5page;
	public OnboardingStep6Page onboardingstep6page;
	public OnboardingStep7Page onboardingstep7page;
	public OnboardingStep8Page onboardingstep8page;
	public OnboardingStep9Page onboardingstep9page;
	public OnboardingStep10Page onboardingstep10page;
	public OnboardingStep11Page onboardingstep11page;
	


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
	
	public OnboardingStep1Page getonboardingstep1page() {
		if (onboardingstep1page == null) {
			onboardingstep1page = new OnboardingStep1Page(driver);
		}
		return onboardingstep1page;
	}
	
	public OnboardingStep3Page getonboardingstep3page() {
		if (onboardingstep3page == null) {
			onboardingstep3page = new OnboardingStep3Page(driver);
		}
		return onboardingstep3page;
	}
	
	public OnboardingStep4Page getonboardingstep4page() {
		if (onboardingstep4page == null) {
			onboardingstep4page = new OnboardingStep4Page(driver);
		}
		return onboardingstep4page;

	}

	
	public OnboardingStep5Page getonboardingstep5page() {
		if (onboardingstep5page == null) {
			onboardingstep5page = new OnboardingStep5Page(driver);
		}
		return onboardingstep5page;
	}

	
	public OnboardingStep6Page getonboardingstep6page() {
		if (onboardingstep6page == null) {
			onboardingstep6page = new OnboardingStep6Page(driver);
		}
		return onboardingstep6page;
	}

	
	public OnboardingStep7Page getonboardingstep7page() {
		if (onboardingstep7page == null) {
			onboardingstep7page = new OnboardingStep7Page(driver);
		}
		return onboardingstep7page;
	}

	
	public OnboardingStep8Page getonboardingstep8page() {
		if (onboardingstep8page == null) {
			onboardingstep8page = new OnboardingStep8Page(driver);
		}
		return onboardingstep8page;
	}

	
	public OnboardingStep9Page getonboardingstep9page() {
		if (onboardingstep9page == null) {
			onboardingstep9page = new OnboardingStep9Page(driver);
		}
		return onboardingstep9page;
	}

	
	public OnboardingStep10Page getonboardingstep10page() {
		if (onboardingstep10page == null) {
			onboardingstep10page = new OnboardingStep10Page(driver);
		}
		return onboardingstep10page;
	}

	
	
	public OnboardingStep11Page getonboardingstep11page() {
		if (onboardingstep11page == null) {
			onboardingstep11page = new OnboardingStep11Page(driver);
		}
		return onboardingstep11page;
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
