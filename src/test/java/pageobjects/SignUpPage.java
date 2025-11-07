package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

public class SignUpPage {
	
	WebDriver driver;

	By signUp = By.xpath("//*[contains(text(),'Sign up')]");
	By signUptab = By.xpath("//*[contains(text(), 'signup')]");
	By emailID = By.xpath("//*[contains(text(), 'emailid')]");
	By passwordField = By.xpath("//*[text()='password']");
	By confirmPasswordField=By.xpath("//*[@class='confirmpassword']");
	By loginButton=By.xpath("//*[@class='login']");
	By registerButton=By.xpath("//*[contains(text(),'Register')]"); 
	By showpasswordRadioButton = By.xpath("//*[@href='show password']");
	By termsRadioButton = By.xpath("//*[@href='terms and conditions']");
	By logInLink = By.xpath("//*[@href='logIn']");
	
	public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void LaunchPage() {
		String baseUrl = ConfigReader.get("baseUrl"); 
        driver.get(baseUrl);
        	
	}
	public void clickSignUpButton() {
		driver.findElement(signUp).click();
	}
	public boolean isEmailIdDisplayed() {
        WebElement emailField = driver.findElement(emailID);
        return emailField.isDisplayed();
    }

	 public String getEmailIdPlaceholder_text() {
	        WebElement emailField = driver.findElement(emailID);
	        return emailField.getDomAttribute("placeholder");
	    }
	 public boolean isPasswordDisplayed() {
	        WebElement pwd = driver.findElement(passwordField);
	        return pwd.isDisplayed();
	    }

	    public boolean isPasswordMasked() {
	        WebElement pwd = driver.findElement(passwordField);
	        String fieldType = pwd.getDomAttribute("type"); 
	        return fieldType.equalsIgnoreCase("password");
	    }
	 
		
	    public boolean isConfirmPasswordDisplayed() {
	        WebElement pwd = driver.findElement(confirmPasswordField);
	        return pwd.isDisplayed();
	    }

	    public boolean isConfirmPasswordMasked() {
	        WebElement pwd = driver.findElement(confirmPasswordField);
	        String fieldType = pwd.getDomAttribute("type"); 
	        return fieldType.equalsIgnoreCase("confirm password");
	    }
	    public boolean isLoginButtonEnabled() {
	        WebElement btn = driver.findElement(loginButton);
	        return btn.isEnabled();
	    }
	    public boolean isLoginLinkVisible() {
	        WebElement link = driver.findElement(logInLink);
	        return link.isDisplayed();
	    }
	    public void clickLoginLink() {
	        driver.findElement(logInLink).click();
	    }

	    public boolean isOnLoginPage() {
	        String currentUrl = driver.getTitle();
	        return  driver.getTitle().contains("Login");
	    }
	}
      


