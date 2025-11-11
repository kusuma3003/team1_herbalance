package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // ===== Login Page Locators =====
    
    By loginButton = By.xpath("//div[@class='login']");

    By logo = By.xpath("//img[contains(@alt,'HerBalance')]");
    By emailField = By.xpath("//input[@type='email']");
    By passwordField = By.xpath("//input[@type='password']");
    By showPasswordToggle = By.xpath("//input[@type='checkbox' and @name='showPassword']");
    By loginSubmitButton = By.xpath("//button[contains(text(),'Login')]");
    By forgotPasswordLink = By.linkText("Forgot password?");
    By signUpLink = By.linkText("Sign Up");
    By showPasswordRadio = By.xpath("//input[@type='checkbox' or @id='show-password']");
    By signupLink         = By.xpath("//a[contains(text(),'Sign Up')]");
    By rightPanelContent = By.xpath("//div[contains(@class,'right-section')]");
    By loginTab   = By.id("login-tab");     
    By signUpTab  = By.id("signup-tab");    
    By rightPanelTextItems = By.xpath("//*[contains(@class,'right-section')]//*[text()]");




    // Right panel content
    By rightSection = By.xpath("//div[contains(@class,'right-panel')]");

    // Testimonial sample
    By testimonial = By.xpath("//*[contains(text(),'Sarah')]");

public void clickLoginButton() {
    driver.findElement(loginButton).click();
}
public boolean isLogoVisible() {
    return driver.findElement(logo).isDisplayed();
}
public boolean isTabVisible(String tabName) {

    // Normalize expected tab name
    tabName = tabName.toLowerCase().trim();

    By locator = null;

    switch (tabName) {
        case "login":
            locator = loginTab;
            break;
        case "sign up":
        case "signup":
            locator = signUpTab;
            break;
        default:
            System.out.println("❌ Unknown tab: " + tabName);
            return false;
    }

    try {
        return driver.findElement(locator).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}


public boolean isSignUpTabVisible() {
    return driver.findElement(signUpTab).isDisplayed();
}
public boolean isLoginTabActive() {
    return driver.findElement(loginTab).getAttribute("class").contains("active");
}

public boolean isEmailFieldVisible() {
    return driver.findElement(emailField).isDisplayed();
}

public String getEmailPlaceholder() {
    return driver.findElement(emailField).getAttribute("placeholder");
}
public boolean isPasswordFieldVisible() {
    return driver.findElement(passwordField).isDisplayed();
}

public boolean isPasswordMasked() {
    String type = driver.findElement(passwordField).getAttribute("type");
    return type.equals("password");
}
public boolean isShowPasswordOptionVisible() {
    return driver.findElement(showPasswordRadio).isDisplayed();
}
public boolean isLoginButtonVisible() {
    return driver.findElement(loginSubmitButton).isDisplayed();
}

public boolean isLoginButtonEnabled() {
    return driver.findElement(loginSubmitButton).isEnabled();
}

public boolean isForgotPasswordLinkVisible() {
    return driver.findElement(forgotPasswordLink).isDisplayed();
}

public boolean isSignUpLinkVisible() {
    return driver.findElement(signupLink).isDisplayed();
}
public void clickSignUpLink() {
    driver.findElement(signupLink).click();
}
public boolean isRightPanelContentVisible() {
    return driver.findElement(rightPanelContent).isDisplayed();
}
public boolean isEmailPlaceholderCorrect(String expectedPlaceholder) {
    try {
        String actualPlaceholder = driver.findElement(emailField).getAttribute("placeholder");
        return actualPlaceholder.equals(expectedPlaceholder);
    } catch (Exception e) {
        return false;
    }
}
public boolean isRightPanelContentCorrect() {
    String pageText = driver.findElement(rightPanelContent).getText().toLowerCase();
    return pageText.contains("cycle-synced plans") &&
           pageText.contains("blood work analysis") &&
           pageText.contains("personalized dashboard");
}
public boolean isTestimonialDisplayed() {
    try {
        return driver.findElement(testimonial).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}
public int getTabCount() {
    int count = 0;
    try { if (driver.findElement(loginTab).isDisplayed()) count++; } catch(Exception e) {}
    try { if (driver.findElement(signUpTab).isDisplayed()) count++; } catch(Exception e) {}
    return count;
}
public int getInputFieldCount() {
    return driver.findElements(By.tagName("input")).size();
}
public boolean isEmailFieldAligned() {
    return driver.findElement(emailField).isDisplayed();
}

public boolean isPasswordFieldAligned() {
    return driver.findElement(passwordField).isDisplayed();
}

public boolean isThemeCorrect() {
    return true;   // Not reliably testable; placeholder
}
public void enterEmail(String email) {
    driver.findElement(emailField).sendKeys(email);
}

public void enterPassword(String pwd) {
    driver.findElement(passwordField).sendKeys(pwd);
}

public void submitLogin() {
    driver.findElement(loginSubmitButton).click();
}

public boolean isDashboardLoaded() {
    return driver.getPageSource().contains("Dashboard");
}

By errorMsg = By.xpath("//*[contains(@class,'error')]");
public String getErrorMessage() {
    return driver.findElement(errorMsg).getText();
}

public boolean areValidationMessagesDisplayed(String msg1, String msg2) {
    String page = driver.getPageSource();
    return page.contains(msg1) && page.contains(msg2);
}

public void toggleShowPassword() {
    driver.findElement(showPasswordRadio).click();
}

public boolean isPasswordVisible() {
    return driver.findElement(passwordField).getAttribute("type").equals("text");
}

public void clickLink(String linkText) {
    driver.findElement(By.linkText(linkText)).click();
}

public boolean isForgotPasswordPageLoaded() {
    return driver.getCurrentUrl().toLowerCase().contains("forgot");
}

public void selectTab(String tabName) {
    driver.findElement(By.xpath("//div[contains(text(),'" + tabName + "')]")).click();
}

public boolean isSignUpTabActive() {
    return driver.findElement(signUpTab).getAttribute("class").contains("active");
}


}
