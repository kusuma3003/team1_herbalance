package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import org.openqa.selenium.*;
import java.util.stream.Collectors;

import java.util.Random;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OnboardingStep11Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep11Page(WebDriver driver) {
        this.driver = driver;
    }

    private By step10Header = By.xpath("//h1[text()='Food Allergies & Sensitivities']");
    private By step11Header = By.xpath("//h1[text()='Medications & Supplements']");
    private By options = By.cssSelector(".option");
    private By selectedOption = By.cssSelector(".option.selected");
    private By radioButtons = By.cssSelector(".option input[type='radio']");
    private By continueButton = By.xpath("//button[text()='Continue']");
    private By completeButton = By.xpath("//button[text()='Complete']");
    private By backButton = By.xpath("//button[text()='Back']");
    private By progressBar = By.cssSelector(".progress-bar span");
    private By title = By.cssSelector(".step-title");
    private By description = By.cssSelector(".step-description");
    private By sectionTitles = By.cssSelector(".section-title");
    private By sectionDescriptions = By.cssSelector(".section-desc");
    private By infoNote = By.cssSelector(".info-note");
    private By errorMessage = By.cssSelector(".error-message");
    private By examples = By.cssSelector(".examples li");

    public boolean isStep10Loaded() {
        return driver.findElement(step10Header).isDisplayed();
    }

    public boolean isStep11Loaded() {
        return driver.findElement(step11Header).isDisplayed();
    }

    public void selectOption(String optionText) {
        for (WebElement opt : driver.findElements(options)) {
            if (opt.getText().contains(optionText)) {
                opt.click();
                break;
            }
        }
    }

    public boolean isSelectedOptionHighlighted() {
        return driver.findElement(selectedOption).isDisplayed();
    }

    public boolean isRadioButtonSelected() {
        WebElement selected = driver.findElement(selectedOption);
        return selected.findElement(By.cssSelector("input[type='radio']")).isSelected();
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickCompleteButton() {
        driver.findElement(completeButton).click();
    }

    public boolean isRedirectedToStep9() {
        return driver.getCurrentUrl().contains("step-9");
    }

    public boolean isRedirectedToStep10() {
        return driver.getCurrentUrl().contains("step-10");
    }

    public boolean isRedirectedToStep11() {
        return driver.getCurrentUrl().contains("step-11");
    }

    public boolean isRedirectedToSubscription() {
        return driver.getCurrentUrl().contains("subscription");
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText().trim();
    }

    public String getProgressText() {
        return driver.findElement(progressBar).getText().trim();
    }

    public String getTitleText() {
        return driver.findElement(title).getText().trim();
    }

    public String getDescriptionText() {
        return driver.findElement(description).getText().trim();
    }

    public int getNumberOfSections() {
        return driver.findElements(sectionTitles).size();
    }

    public boolean areSectionTitlesDisplayed(String... titles) {
        List<String> actualTitles = driver.findElements(sectionTitles)
                .stream().map(WebElement::getText).collect(Collectors.toList());
        for (String title : titles) {
            if (!actualTitles.contains(title)) {
                return false;
            }
        }
        return true;
    }

    public boolean areSectionDescriptionsVisible() {
        return driver.findElements(sectionDescriptions).stream().allMatch(WebElement::isDisplayed);
    }

    public boolean areAllRadioButtonsVisible() {
        return driver.findElements(radioButtons).stream().allMatch(WebElement::isDisplayed);
    }

    public boolean areExamplesDisplayed(List<String> expectedExamples) {
        List<String> actualExamples = driver.findElements(examples)
                .stream().map(WebElement::getText).collect(Collectors.toList());
        return actualExamples.containsAll(expectedExamples);
    }

    public String getInfoNoteText() {
        return driver.findElement(infoNote).getText();
    }
}
