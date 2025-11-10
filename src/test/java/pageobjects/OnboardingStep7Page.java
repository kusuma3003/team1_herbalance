package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driverfactory.DriverFactory;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OnboardingStep7Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep7Page(WebDriver driver) {
        this.driver = driver;
    }

    private By progressBar = By.cssSelector(".progress-bar");
    private By stepCount = By.xpath("//span[contains(text(),'7 of 11')]");
    private By title = By.xpath("//h1[contains(text(),'Current Weight and Height')]");
    private By description = By.xpath("//p[contains(text(),'This helps us calculate your BMI')]");
    private By weightField = By.xpath("//label[contains(text(),\"What’s your current weight?\")]");
    private By heightField = By.xpath("//label[contains(text(),\"What’s your height?\")]");
    private By textFields = By.cssSelector("input[type='text']");

    public boolean isProgressDisplayed() {
        return driver.findElement(progressBar).isDisplayed();
    }

    public boolean isStepCountCorrect() {
        return driver.findElement(stepCount).isDisplayed();
    }

    public boolean isTitleDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public boolean isDescriptionDisplayed() {
        return driver.findElement(description).isDisplayed();
    }

    public boolean areFieldsDisplayed() {
        return driver.findElements(textFields).size() == 2;
    }

    public boolean areLabelsCorrect() {
        return driver.findElement(weightField).isDisplayed()
                && driver.findElement(heightField).isDisplayed();
    }

}
