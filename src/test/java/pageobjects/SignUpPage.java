
package pageobjects;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import driverfactory.DriverFactory;
import utils.ConfigReader;

public class SignUpPage {
	
	WebDriver driver;
	WebElement emailField;
	WebElement passwordField;
	WebElement confirmPasswordField;
	WebElement showPasswordRadio;
	WebElement termsElement;
	WebElement registerbutton;
	int emailY ;
    int passwordY;
    int confirmPasswordY;
	 

	By signUp = By.xpath("//*[contains(text(),'Sign up')]");
	By signUptab = By.xpath("//*[contains(text(), 'signup')]");
	By emailID = By.xpath("//*[contains(text(), 'emailid')]");
	By password = By.xpath("//*[text()='password']");
	By confirmPassword=By.xpath("//*[@class='confirmpassword']");
	By loginButton=By.xpath("//*[@class='login']");
	By registerButton=By.xpath("//*[contains(text(),'Register')]"); 
	By showpasswordRadioButton = By.xpath("//*[@href='show password']");
	By termsRadioButton = By.xpath("//*[@href='terms and conditions']");
	By inputFields=By.cssSelector("contains input");
	By logInLink = By.xpath("//*[@href='logIn']");
	By showPasswordRadioButton =By.id("showPassword");
	By showTermsandConditionRadioButton =By.xpath("//*[contains(text(),'show TermsandCondition')]");
	By TermsandConditions=By.xpath("//*[contains(text(),'Terms and Conditions')]");
	By Body=By.tagName("body");
	By errorMessage =By.cssSelector(".error-message");
	By eyeIconPassword =By.id("IconPassword");
	By eyeIconConfirmPassword =By.id("IconConfirmPassword");
	
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
	public void clickSignUpTab() {
		driver.findElement(signUptab).click();
	}
	public boolean isEmailIdDisplayed() {
        WebElement emailField = driver.findElement(emailID);
        return emailField.isDisplayed();
    }

	 public String getEmailIdPlaceholder_text() {
	        return emailField.getDomAttribute("placeholder");
	    }
	 public boolean isPasswordDisplayed() {
	        WebElement passwordField = driver.findElement(password);
	        return passwordField.isDisplayed();
	    }

	    public boolean isPasswordMasked() {
	        
	        String fieldType = passwordField.getDomAttribute("type"); 
	        return fieldType.equalsIgnoreCase("password");
	    }
	 
		
	    public boolean isConfirmPasswordDisplayed() {
	    	WebElement confirmPasswordField= driver.findElement(confirmPassword);
	        return confirmPasswordField.isDisplayed();
	    }

	    public boolean isConfirmPasswordMasked() {

	        String fieldType = confirmPasswordField.getDomAttribute("type"); 
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
	    public boolean isAligned() {
	    
	    int emailY = emailField.getLocation().getY();
	    int passwordY =passwordField .getLocation().getY();
	    int confirmPasswordY = confirmPasswordField.getLocation().getY();

	    int emailX = emailField.getLocation().getX();
	    int passwordX = passwordField.getLocation().getX();
	    int confirmPasswordX = confirmPasswordField.getLocation().getX();
	    boolean isVerticallyAligned = (emailX == passwordX) && (passwordX == confirmPasswordX);
        return isVerticallyAligned;
	    }
        
        public boolean isSpaced() {
        	int spacing1 = passwordY - emailY;
     	    int spacing2 = confirmPasswordY - passwordY;
     	    boolean isSpacingEqual = (spacing1 == spacing2);
			return isSpacingEqual;
        }
        public boolean verifyingInputFields() {
      
            List<WebElement> inputFieldList = driver.findElements(inputFields);
            
            if (inputFieldList.size() == 3) {
                return true;
            } else {
                return false;
            }
        }
        
        public boolean verifyShowPasswordRadioButton() {
            WebElement showPasswordRadio = driver.findElement(showPasswordRadioButton);
            String type = showPasswordRadio.getDomAttribute("type");
            return showPasswordRadio.isDisplayed() && type.equalsIgnoreCase("radio");
        }
        
        public boolean verifyTermsAndConditionsPresent() {
         
                WebElement termsElement = driver.findElement(TermsandConditions);
                return termsElement.isDisplayed();
            } 
        
        public boolean verifyTermsandConditionRadioButton() {
            WebElement showTermsandCondition = driver.findElement(showTermsandConditionRadioButton );
            String type = showTermsandCondition.getDomAttribute("type");
            return showTermsandCondition.isDisplayed() && type.equalsIgnoreCase("radio");
        }
        
        public boolean verifyTheme() {
            WebElement body = driver.findElement(By.tagName("body"));

            String background = body.getCssValue("background");
            String fontFamily = body.getCssValue("font-family");

            boolean isPurpleTheme = background.contains("rgb(230,230,250)") || background.contains("purple");
            boolean isFontCorrect = fontFamily.contains("Poppins") || fontFamily.contains("Open Sans");

            return isPurpleTheme && isFontCorrect;
        }
        
        public void enterValid_clicks_register() {
           
            emailField.sendKeys(ConfigReader.get("username"));
            passwordField.sendKeys(ConfigReader.get("password"));
            confirmPasswordField.sendKeys(ConfigReader.get("password"));
            WebElement registerbutton=driver.findElement(registerButton);
            registerbutton.click();
        }
        public void registerUser(String email, String password, String confirmpassword) {
            emailField.clear();
            passwordField.clear();
            confirmPasswordField.clear();
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            confirmPasswordField.sendKeys(confirmpassword);
            showPasswordRadio.click();
            termsElement.click();
            registerbutton.click();
        }
        public void registerUserwithoutclickingTerms(String email, String password, String confirmpassword) {
            emailField.clear();
            passwordField.clear();
            confirmPasswordField.clear();
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            confirmPasswordField.sendKeys(confirmpassword);
            showPasswordRadio.click();
            registerbutton.click();
            driver.findElement(registerButton).click();
        }
        public String verifyResult(String expectedOutput) {
            if (expectedOutput.equalsIgnoreCase("onboarding")) {
                String currentUrl = driver.getCurrentUrl();
            
                if (currentUrl.contains("onboarding")) {
                    return "onboarding";
                } else {
                    return "redirect_failed";
                }
            } else {
               
                WebElement errorElement = driver.findElement(errorMessage);
                String actualErrorText = errorElement.getText().trim();
                return actualErrorText;
            }
        }
        public WebElement user_enters_in_field_and_performs(String password, String field, String action) {
            WebElement inputField;
            WebElement eyeIcon;

            if (field.equalsIgnoreCase("password")) {
                inputField = passwordField; // assume passwordField is already initialized
                inputField.clear();
                inputField.sendKeys(password);
                eyeIcon = driver.findElement(eyeIconPassword); // locate the eye icon for password
            } else {
                inputField = confirmPasswordField; // assume confirmPasswordField is initialized
                inputField.clear();
                inputField.sendKeys(password);
                eyeIcon = driver.findElement(eyeIconConfirmPassword); // locate eye icon for confirm password
            }

            // Perform the action if it's a click
            if (action.toLowerCase().contains("click")) {
                eyeIcon.click();
            }
           return inputField;
        }

        }
       

        


      


