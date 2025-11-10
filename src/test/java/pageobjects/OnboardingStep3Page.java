package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OnboardingStep3Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep3Page(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Locators (replace with actual locators later)
    private By backButton = By.xpath("//button[contains(text(),'Back')]");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private By header = By.xpath("//h1[contains(text(),'Health condition')]");
    private By subtitle = By.xpath("//p[contains(text(),'manually enter any key conditions')]");
    private By progressBar = By.cssSelector(".progress-bar");
    private By progressText = By.xpath("//*[contains(text(),'3 of 11')]");
    private By radioButtons = By.xpath("//input[@type='radio']");
    private By optionLabels = By.xpath("//label[contains(@for,'condition')]");
    private By informationalNote = By.xpath("//*[contains(text(),'note') or contains(text(),'information') or contains(text(),'This information')]");

    // --- Button Visibility ---
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

    // --- Header/Subtitles ---
    public boolean isHeaderDisplayed() {
        return driver.findElement(header).isDisplayed();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public boolean isSubtitleDisplayed() {
        return driver.findElement(subtitle).isDisplayed();
    }

    public String getSubtitleText() {
        return driver.findElement(subtitle).getText();
    }

    // --- Progress Bar ---
    public boolean isProgressBarDisplayed() {
        return driver.findElement(progressBar).isDisplayed();
    }

    public boolean isProgressTextDisplayed() {
        return driver.findElement(progressText).isDisplayed();
    }

    // --- Health Condition Options ---
    public int getRadioButtonCount() {
        List<WebElement> radios = driver.findElements(radioButtons);
        return radios.size();
    }

    public boolean areConditionOptionsDisplayed(String optionText) {
        List<WebElement> options = driver.findElements(optionLabels);
        for (WebElement opt : options) {
            if (opt.getText().trim().equalsIgnoreCase(optionText.trim())) {
                return true;
            }
        }
        return false;
    }

    // --- Informational Note ---
    public boolean isInformationalNoteDisplayed() {
        return driver.findElement(informationalNote).isDisplayed();
    }
}
