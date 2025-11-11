package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;

public class SignUpPage {

    private static final Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    private WebDriver driver;

    // Locators
    private By signUp = By.xpath("//*[contains(text(),'Sign up')]");
    private By signUpTab = By.xpath("//*[contains(text(),'SignUp')]");
    private By emailID = By.id("email");  // Prefer stable locators like id or name
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By loginButton = By.id("loginButton");
    private By registerButton = By.xpath("//*[contains(text(),'Register')]");
    private By showPasswordRadioButton = By.id("showPassword");
    private By termsRadioButton = By.id("acceptTerms");
    private By inputFields = By.cssSelector("input");
    private By loginLink = By.xpath("//a[contains(text(),'Login')]");
    private By termsAndConditions = By.xpath("//*[contains(text(),'Terms and Conditions')]");
    private By body = By.tagName("body");
    private By errorMessage = By.cssSelector(".error-message");
    private By eyeIconPassword = By.id("IconPassword");
    private By eyeIconConfirmPassword = By.id("IconConfirmPassword");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // ========================= Actions ========================= //

    public void LaunchPage() {
        String baseUrl = ConfigReader.get("baseUrl");
        logger.info("Launching HerBalance URL: {}", baseUrl);
        driver.get(baseUrl);
    }

    public void clickSignUpButton() {
        logger.info("Clicking 'Sign Up' button");
        driver.findElement(signUp).click();
    }

    public void clickSignUpTab() {
        logger.info("Clicking 'Sign Up' tab");
        driver.findElement(signUpTab).click();
    }

    // ========================= Element Checks ========================= //

    public boolean isEmailIdDisplayed() {
        logger.info("Checking if Email field is displayed");
        return driver.findElement(emailID).isDisplayed();
    }

    public String getEmailIdPlaceholder_text() {
        String placeholder = driver.findElement(emailID).getDomAttribute("placeholder");
        logger.debug("Email placeholder text: {}", placeholder);
        return placeholder;
    }

    public boolean isPasswordDisplayed() {
        logger.info("Checking if Password field is displayed");
        return driver.findElement(password).isDisplayed();
    }

    public boolean isPasswordMasked() {
        String type = driver.findElement(password).getDomAttribute("type");
        logger.debug("Password field type: {}", type);
        return type.equalsIgnoreCase("password");
    }

    public boolean isConfirmPasswordDisplayed() {
        logger.info("Checking if Confirm Password field is displayed");
        return driver.findElement(confirmPassword).isDisplayed();
    }

    public boolean isConfirmPasswordMasked() {
        String type = driver.findElement(confirmPassword).getDomAttribute("type");
        logger.debug("Confirm Password field type: {}", type);
        return type.equalsIgnoreCase("password");
    }

    public boolean isLoginButtonEnabled() {
        logger.info("Checking if Login button is enabled");
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isLoginLinkVisible() {
        logger.info("Checking if Login link is visible");
        return driver.findElement(loginLink).isDisplayed();
    }

    public void clickLoginLink() {
        logger.info("Clicking Login link");
        driver.findElement(loginLink).click();
    }

    public boolean isOnLoginPage() {
        String title = driver.getTitle();
        logger.info("Current page title: {}", title);
        return title != null && title.toLowerCase().contains("login");
    }

    // ========================= Layout Checks ========================= //

    public boolean isAligned() {
        WebElement email = driver.findElement(emailID);
        WebElement pwd = driver.findElement(password);
        WebElement confirm = driver.findElement(confirmPassword);

        int emailX = email.getLocation().getX();
        int pwdX = pwd.getLocation().getX();
        int confirmX = confirm.getLocation().getX();

        boolean aligned = (emailX == pwdX) && (pwdX == confirmX);
        logger.debug("Alignment check result: {}", aligned);
        return aligned;
    }

    public boolean isSpaced() {
        WebElement email = driver.findElement(emailID);
        WebElement pwd = driver.findElement(password);
        WebElement confirm = driver.findElement(confirmPassword);

        int spacing1 = pwd.getLocation().getY() - email.getLocation().getY();
        int spacing2 = confirm.getLocation().getY() - pwd.getLocation().getY();

        boolean equallySpaced = spacing1 == spacing2;
        logger.debug("Spacing check result: {}", equallySpaced);
        return equallySpaced;
    }

    public boolean verifyingInputFields() {
        List<WebElement> fields = driver.findElements(inputFields);
        logger.info("Found {} input fields on page", fields.size());
        return fields.size() == 3;
    }

    public boolean verifyShowPasswordRadioButton() {
        WebElement showPwd = driver.findElement(showPasswordRadioButton);
        String type = showPwd.getDomAttribute("type");
        boolean result = showPwd.isDisplayed() && type.equalsIgnoreCase("radio");
        logger.info("Show Password radio visible: {}", result);
        return result;
    }

    public boolean verifyTermsAndConditionsPresent() {
        boolean visible = driver.findElement(termsAndConditions).isDisplayed();
        logger.info("Terms and Conditions visible: {}", visible);
        return visible;
    }

    public boolean verifyTermsandConditionRadioButton() {
        WebElement termsRadio = driver.findElement(termsRadioButton);
        String type = termsRadio.getDomAttribute("type");
        boolean result = termsRadio.isDisplayed() && type.equalsIgnoreCase("radio");
        logger.info("Terms and Conditions radio visible: {}", result);
        return result;
    }

    public boolean verifyTheme() {
        WebElement pageBody = driver.findElement(body);
        String bg = pageBody.getCssValue("background");
        String font = pageBody.getCssValue("font-family");

        boolean isPurpleTheme = bg.contains("rgb(230,230,250)") || bg.toLowerCase().contains("purple");
        boolean isFontCorrect = font.contains("Poppins") || font.contains("Open Sans");

        logger.info("Theme validation -> Background: {}, Font: {}", bg, font);
        return isPurpleTheme && isFontCorrect;
    }

    // ========================= Actions for SignUp ========================= //

    public void registerUser(String email, String pwd, String confirmPwd) {
        logger.info("Registering user with email: {}", email);
        driver.findElement(emailID).clear();
        driver.findElement(password).clear();
        driver.findElement(confirmPassword).clear();

        driver.findElement(emailID).sendKeys(email);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
        driver.findElement(showPasswordRadioButton).click();
        driver.findElement(termsRadioButton).click();
        driver.findElement(registerButton).click();
    }

    public void registerUserwithoutclickingTerms(String email, String pwd, String confirmPwd) {
        logger.info("Registering user without accepting Terms: {}", email);
        driver.findElement(emailID).clear();
        driver.findElement(password).clear();
        driver.findElement(confirmPassword).clear();

        driver.findElement(emailID).sendKeys(email);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
        driver.findElement(showPasswordRadioButton).click();
        driver.findElement(registerButton).click();
    }

    public String verifyResult(String expectedOutput) {
        logger.info("Verifying result against expected output: {}", expectedOutput);
        if (expectedOutput.equalsIgnoreCase("onboarding")) {
            String url = driver.getCurrentUrl();
            logger.debug("Current URL: {}", url);
            return url.contains("onboarding") ? "onboarding" : "redirect_failed";
        } else {
            WebElement error = driver.findElement(errorMessage);
            String actual = error.getText().trim();
            logger.debug("Error message displayed: {}", actual);
            return actual;
        }
    }

    public WebElement user_enters_in_field_and_performs(String passwordValue, String field, String action) {
        WebElement inputField;
        WebElement eyeIcon;

        if (field.equalsIgnoreCase("password")) {
            inputField = driver.findElement(password);
            eyeIcon = driver.findElement(eyeIconPassword);
        } else {
            inputField = driver.findElement(confirmPassword);
            eyeIcon = driver.findElement(eyeIconConfirmPassword);
        }

        inputField.clear();
        inputField.sendKeys(passwordValue);
        if (action.toLowerCase().contains("click")) {
            logger.info("Clicking eye icon for field: {}", field);
            eyeIcon.click();
        }

        return inputField;
    }
}
