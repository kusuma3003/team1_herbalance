package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import org.openqa.selenium.*;
import java.time.Duration;

import java.util.Random;

public class OnboardingStep9Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep9Page(WebDriver driver) {
        this.driver = driver;
    }

    private By title = By.xpath("//h1[contains(text(),'Dietary Preferences')]");
    private By dietOptions = By.cssSelector(".diet-option");
    private By selectedDietOption = By.cssSelector(".diet-option.selected, .diet-option.active");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private By backButton = By.xpath("//button[contains(text(),'Back')]");
    private By progressBarText = By.cssSelector(".progress-text");
    private By step9Title = By.xpath("//h1[contains(text(),'Physical Activity Level')]");
    private By step9Description = By.cssSelector(".step-description");
    private By sectionTitles = By.cssSelector(".activity-section h3");
    private By sectionDescriptions = By.cssSelector(".activity-section p");
    private By radioButtons = By.cssSelector(".activity-section input[type='radio']");
    private By infoNote = By.cssSelector(".info-note");
    


    public boolean isPageTitleDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public void selectRandomDietOption() {
        List<WebElement> options = driver.findElements(dietOptions);
        if (options.isEmpty()) {
            throw new RuntimeException("No diet options found!");
        }
        options.get(new Random().nextInt(options.size())).click();
    }

    public boolean isDietOptionHighlighted() {
        return !driver.findElements(selectedDietOption).isEmpty();
    }

    public boolean isContinueButtonEnabled() {
        return driver.findElement(continueButton).isEnabled();
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public boolean isStep7Displayed() {
        return driver.getPageSource().contains("Current Weight and Height");
    }

    public void clickContinueButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public boolean isStep9Displayed() {
        try {
            return driver.findElement(step9Title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getProgressBarText() {
        return driver.findElement(progressBarText).getText();
    }

    public String getStep9Title() {
        return driver.findElement(step9Title).getText();
    }

    public String getStep9Description() {
        return driver.findElement(step9Description).getText();
    }

    public int getActivitySectionsCount() {
        return driver.findElements(sectionTitles).size();
    }

    public boolean verifyActivityTitles(String... titles) {
        String pageText = driver.getPageSource();
        for (String title : titles) {
            if (!pageText.contains(title)) {
                return false;
            }
        }
        return true;
    }

    public boolean areSectionDescriptionsVisible() {
        List<WebElement> descriptions = driver.findElements(sectionDescriptions);
        return descriptions.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean areRadioButtonsDisplayed() {
        List<WebElement> radios = driver.findElements(radioButtons);
        return radios.size() >= 4 && radios.stream().allMatch(WebElement::isDisplayed);
    }

    public String getInfoNote() {
        return driver.findElement(infoNote).getText();
    }
}
