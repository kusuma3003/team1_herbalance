package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import org.openqa.selenium.*;

import java.util.Random;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OnboardingStep10Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep10Page(WebDriver driver) {
        this.driver = driver;
    }

    private By step9Header = By.xpath("//h1[text()='Physical Activity Level']");
    private By activityOptions = By.cssSelector(".activity-option");
    private By selectedOption = By.cssSelector(".activity-option.selected");
    private By radioButtons = By.cssSelector(".activity-option input[type='radio']");
    private By continueButton = By.xpath("//button[text()='Continue']");
    private By backButton = By.xpath("//button[text()='Back']");
    private By progressBar = By.cssSelector(".progress-bar span");
    private By title = By.cssSelector(".step-title");
    private By description = By.cssSelector(".step-description");
    private By sections = By.cssSelector(".section");
    private By sectionTitles = By.cssSelector(".section-title");
    private By sectionDescriptions = By.cssSelector(".section-desc");
    private By infoNote = By.cssSelector(".info-note");

    public boolean isStep9Loaded() {
        return driver.findElement(step9Header).isDisplayed();
    }

    public void selectActivityLevel(String activity) {
        List<WebElement> options = driver.findElements(activityOptions);
        for (WebElement option : options) {
            if (option.getText().contains(activity)) {
                option.click();
                break;
            }
        }
    }

    public boolean isSelectedActivityHighlighted() {
        return driver.findElement(selectedOption).isDisplayed();
    }

    public boolean isButtonEnabled(String buttonName) {
        return driver.findElement(By.xpath("//button[text()='" + buttonName + "']")).isEnabled();
    }

    public boolean isRadioButtonSelected() {
        return driver.findElement(selectedOption).findElement(By.cssSelector("input[type='radio']")).isSelected();
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public boolean isRedirectedToStep8() {
        return driver.getCurrentUrl().contains("step-8");
    }

    public boolean isRedirectedToStep10() {
        return driver.getCurrentUrl().contains("step-10");
    }

    public String getProgressBarText() {
        return driver.findElement(progressBar).getText();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public String getDescriptionText() {
        return driver.findElement(description).getText();
    }

    public int getNumberOfSections() {
        return driver.findElements(sections).size();
    }

    public boolean areSectionTitlesDisplayed(String... titles) {
        List<WebElement> titleElements = driver.findElements(sectionTitles);
        for (String t : titles) {
            boolean found = titleElements.stream().anyMatch(e -> e.getText().equals(t));
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public boolean areSectionDescriptionsVisible() {
        List<WebElement> descs = driver.findElements(sectionDescriptions);
        return descs.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean areAllRadioButtonsVisible() {
        List<WebElement> radios = driver.findElements(radioButtons);
        return radios.stream().allMatch(WebElement::isDisplayed);
    }

    public String getInfoNoteText() {
        return driver.findElement(infoNote).getText();
    }

}
