package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OnboardingStep5Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep5Page(WebDriver driver) {
        this.driver = driver;
    }

    // --- Locators ---
    private By progressBar = By.cssSelector(".progress-bar");
    private By progressText = By.xpath("//*[contains(text(),'5 of 11')]");
    private By backButton = By.xpath("//button[contains(text(),'Back')]");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private By title = By.xpath("//h1[contains(text(),'Menstrual Cycle Awareness')]");
    private By description = By.xpath("//*[contains(text(),'Understanding your cycle')]");
    private By question = By.xpath("//*[contains(text(),'Do you currently track your menstrual cycle?')]");
    private By radioButtons = By.xpath("//input[@type='radio']");
    private By radioOptions = By.xpath("//label[contains(text(),'cycle') or preceding-sibling::input[@type='radio']]");
    private By errorMessage = By.xpath("//div[contains(text(),'Please select your menstrual cycle track')]");
    private By menstrualCycleOptions = By.cssSelector(".cycle-option"); // placeholder selector
    private By stepCount = By.xpath("//span[contains(text(),'6 of 11')]");

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

    // --- Question & Radio Options ---
    public boolean isQuestionDisplayed() {
        return driver.findElement(question).isDisplayed();
    }

    public int getRadioButtonCount() {
        return driver.findElements(radioButtons).size();
    }

    public boolean areRadioOptionsDisplayed() {
        List<WebElement> options = driver.findElements(radioOptions);
        return !options.isEmpty();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickBack() {
        driver.findElement(backButton).click();
    }

    public void selectCycleOption(String option) {
        driver.findElement(By.xpath("//label[contains(.,'" + option + "')]")).click();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isStepCountDisplayed() {
        return driver.findElement(stepCount).isDisplayed();
    }

    public boolean isNavigationButtonsVisible() {
        return driver.findElement(backButton).isDisplayed() && driver.findElement(continueButton).isDisplayed();
    }
}
