package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OnboardingStep8Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep8Page(WebDriver driver) {
        this.driver = driver;
    }

    private By title = By.xpath("//h1[contains(text(),'Current Weight and Height')]");
    private By weightInput = By.id("weight");
    private By heightInput = By.id("height");
    private By weightDropdown = By.id("weight-unit");
    private By heightDropdown = By.id("height-unit");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private By backButton = By.xpath("//button[contains(text(),'Back')]");
    private By errorMessage = By.cssSelector(".error-message");
    private By bmiLabel = By.xpath("//h2[contains(text(),'BMI Calculation')]");
    private By bmiValue = By.id("bmi-value");
    private By bmiBar = By.id("bmi-bar");
    private By step8Title = By.xpath("//h1[contains(text(),'Dietary Preferences')]");
    private By progressBar = By.cssSelector(".progress-text");

    public boolean isPageTitleDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public void clickWeightDropdown() {
        driver.findElement(weightDropdown).click();
    }

    public void clickHeightDropdown() {
        driver.findElement(heightDropdown).click();
    }

    public boolean verifyDropdownOptions(String opt1, String opt2) {
        return driver.getPageSource().contains(opt1) && driver.getPageSource().contains(opt2);
    }

    public void enterWeight(String value) {
        driver.findElement(weightInput).clear();
        driver.findElement(weightInput).sendKeys(value);
    }

    public void enterHeight(String value) {
        driver.findElement(heightInput).clear();
        driver.findElement(heightInput).sendKeys(value);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public String getErrorMessage() {
        WebElement el = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			el =  wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return el.getText();
    }

    public boolean isStep6Displayed() {
        return driver.getPageSource().contains("Last Period Date");
    }

    public boolean isBMICalculated() {
        return driver.findElement(bmiValue).isDisplayed();
    }

    public boolean isBMIBarDisplayed() {
        return driver.findElement(bmiBar).isDisplayed();
    }

    public boolean verifyBMILabels(String... labels) {
        String page = driver.getPageSource();
        for (String label : labels) {
            if (!page.contains(label)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStep8Displayed() {
        return driver.findElement(step8Title).isDisplayed();
    }

    public String getProgressValue() {
        return driver.findElement(progressBar).getText();
    }

    public String getStepTitle() {
        return driver.findElement(step8Title).getText();
    }

    public String getStepDescription() {
        return driver.findElement(By.cssSelector(".step-description")).getText();
    }
}
