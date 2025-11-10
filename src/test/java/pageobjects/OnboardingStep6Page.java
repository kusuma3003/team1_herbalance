package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driverfactory.DriverFactory;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OnboardingStep6Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep6Page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By title = By.xpath("//h1[contains(text(),'Last Period Date')]");
    private By description = By.xpath("//p[contains(text(),'This helps us understand')]");
    private By question = By.xpath("//label[contains(text(),'When did your last menstrual period start?')]");
    private By dateInput = By.id("periodDate"); // example
    private By calendarIcon = By.cssSelector(".calendar-icon");
    private By cycleLengthLabel = By.xpath("//label[contains(text(),'Cycle Length (days)')]");
    private By slider = By.cssSelector(".cycle-slider");
    private By defaultCycleLength = By.xpath("//span[contains(text(),'28')]");
    private By infoText = By.xpath("//p[contains(text(),'Average cycle length is 28 days')]");
    private By continueButton = By.xpath("//button[text()='Continue']");
    private By backButton = By.xpath("//button[text()='Back']");
    private By errorMessage = By.xpath("//div[contains(text(),'Please select your last period start date')]");
    private By currentPhaseMessage = By.xpath("//div[contains(text(),\"you're currently in\")]");
    private By currentPhaseDescription = By.xpath("//p[contains(text(),'phase')]");
    private By cycleTimelineHeader = By.xpath("//h2[contains(text(),'Your Cycle Timeline')]");
    private By upcomingCalendarHeader = By.xpath("//h2[contains(text(),'Your Upcoming Cycle Calendar')]");
    private By nextExpectedPeriodsHeader = By.xpath("//h2[contains(text(),'Your Next Expected Periods')]");
    private By currentPhaseName = By.xpath("//div[contains(text(),'Phase (Day')]");
    private By phaseGuidanceText = By.xpath("//p[contains(text(),'guidance')]");
    private By calendarMonths = By.cssSelector(".calendar-month"); // placeholder
    private By rightArrow = By.cssSelector(".calendar-next");
    private By leftArrow = By.cssSelector(".calendar-prev");
    private By legendItems = By.cssSelector(".phase-legend-item");
    private By expectedPeriodDates = By.cssSelector(".expected-date");

    public boolean isTitleDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public boolean isDescriptionDisplayed() {
        return driver.findElement(description).isDisplayed();
    }

    public boolean isQuestionDisplayed() {
        return driver.findElement(question).isDisplayed();
    }

    public boolean isCalendarIconDisplayed() {
        return driver.findElement(calendarIcon).isDisplayed();
    }

    public boolean isDatePlaceholderCorrect() {
        String placeholder = driver.findElement(dateInput).getAttribute("placeholder");
        return placeholder.equals("mm/dd/yyyy");
    }

    public boolean isCycleLengthLabelDisplayed() {
        return driver.findElement(cycleLengthLabel).isDisplayed();
    }

    public boolean isSliderDisplayed() {
        return driver.findElement(slider).isDisplayed();
    }

    public boolean isDefaultCycleLengthDisplayed() {
        return driver.findElement(defaultCycleLength).isDisplayed();
    }

    public boolean isInfoTextDisplayed() {
        return driver.findElement(infoText).isDisplayed();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickBack() {
        driver.findElement(backButton).click();
    }

    public void enterDate(String date) {
        driver.findElement(dateInput).clear();
        driver.findElement(dateInput).sendKeys(date);
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isCurrentPhaseMessageDisplayed() {
        return driver.findElement(currentPhaseMessage).isDisplayed();
    }

    public boolean isPhaseDescriptionDisplayed() {
        return driver.findElement(currentPhaseDescription).isDisplayed();
    }

    public boolean areHeadersDisplayed() {
        return driver.findElement(cycleTimelineHeader).isDisplayed()
                && driver.findElement(upcomingCalendarHeader).isDisplayed()
                && driver.findElement(nextExpectedPeriodsHeader).isDisplayed();
    }

    public boolean isCurrentPhaseDisplayed() {
        return driver.findElement(currentPhaseName).isDisplayed();
    }

    public boolean isGuidanceDisplayed() {
        return driver.findElement(phaseGuidanceText).isDisplayed();
    }

    public boolean isCalendarDisplayed() {
        return driver.findElements(calendarMonths).size() == 2;
    }

    public void clickRightArrow() {
        driver.findElement(rightArrow).click();
    }

    public void clickLeftArrow() {
        driver.findElement(leftArrow).click();
    }

    public boolean isLegendDisplayed() {
        return driver.findElements(legendItems).size() >= 4;
    }

    public boolean areExpectedPeriodsDisplayed() {
        return driver.findElements(expectedPeriodDates).size() >= 3;
    }

}
