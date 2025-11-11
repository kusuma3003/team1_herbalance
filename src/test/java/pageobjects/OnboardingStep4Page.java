package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driverfactory.DriverFactory;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OnboardingStep4Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep4Page(WebDriver driver) {
        this.driver = driver;
    }

    // --- Locators ---
    private By progressBar = By.cssSelector(".progress-bar");
    private By progressText = By.xpath("//*[contains(text(),'4 of 11')]");
    private By backButton = By.xpath("//button[contains(text(),'Back')]");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private By title = By.xpath("//h1[contains(text(),'Personal Details')]");
    private By description = By.xpath("//*[contains(text(),'get to know you better')]");
    private By inputBoxes = By.xpath("//input");
    private By fieldLabels = By.xpath("//label");
    private By helperText = By.xpath("//small | //p[contains(@class,'helper')]");
    private By radioButtons = By.xpath("//input[@type='radio']");
    private By radioOptions = By.xpath("//label[contains(text(),'blood pressure') or preceding-sibling::input[@type='radio']]");
    private By firstNameInput = By.id("firstName");
    private By ageInput = By.id("age");
    private By bloodPressureOptions = By.xpath("//input[@type='radio' and @name='bloodPressure']");
    private By errorMessage = By.xpath("//*[contains(@class,'error') or contains(text(),'Please')]");

    // --- Progress Bar ---
    public boolean isProgressBarDisplayed() {
        return driver.findElement(progressBar).isDisplayed();
    }

    public boolean isProgressTextDisplayed() {
        return driver.findElement(progressText).isDisplayed();
    }

    // --- Navigation Buttons ---
    public boolean isBackButtonVisible() {
        return driver.findElement(backButton).isDisplayed();
    }

    public boolean isBackButtonEnabled() {
        return driver.findElement(backButton).isEnabled();
    }

    public boolean isContinueButtonVisible() {
        return driver.findElement(continueButton).isDisplayed();
    }

    public boolean isContinueButtonEnabled() {
        return driver.findElement(continueButton).isEnabled();
    }

    // --- Title & Description ---
    public boolean isTitleDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public boolean isDescriptionDisplayed() {
        return driver.findElement(description).isDisplayed();
    }

    public String getDescriptionText() {
        return driver.findElement(description).getText();
    }

    // --- Input Fields ---
    public int getInputBoxCount() {
        return driver.findElements(inputBoxes).size();
    }

    public boolean areFieldLabelsDisplayed(String labelText) {
        List<WebElement> labels = driver.findElements(fieldLabels);
        for (WebElement label : labels) {
            if (label.getText().trim().equalsIgnoreCase(labelText.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean isHelperTextDisplayed() {
        List<WebElement> helpers = driver.findElements(helperText);
        return !helpers.isEmpty();
    }

    // --- Radio Buttons ---
    public int getRadioButtonCount() {
        return driver.findElements(radioButtons).size();
    }

    public boolean areRadioOptionsDisplayed() {
        return !driver.findElements(radioOptions).isEmpty();
    }

    // --- Form Entry Methods ---
    public void enterFirstName(String name) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(name);
    }

    public void enterAge(String age) {
        driver.findElement(ageInput).clear();
        driver.findElement(ageInput).sendKeys(age);
    }

    public void selectBloodPressureOption(String optionText) {
        List<WebElement> options = driver.findElements(By.xpath("//label[contains(text(),'" + optionText + "')]"));
        if (!options.isEmpty()) {
            options.get(0).click();
        }
    }

// --- Error Messages ---
    public boolean isErrorDisplayed(String expectedMessage) {
        List<WebElement> errors = driver.findElements(errorMessage);
        for (WebElement e : errors) {
            if (e.getText().contains(expectedMessage)) {
                return true;
            }
        }
        return false;
    }

}
