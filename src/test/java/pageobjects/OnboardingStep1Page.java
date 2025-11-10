package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driverfactory.DriverFactory;

public class OnboardingStep1Page {

    public WebDriver driver;

    // ✅ Constructor
    public OnboardingStep1Page(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Locators (replace with actual locators later)
    private By pageTitle = By.xpath("//h1[contains(text(), 'Upload Your Recent Blood Work')]");
    private By supportingText = By.xpath("//p[contains(text(), 'Upload your blood work to continue')]");
    private By progressBar = By.cssSelector(".progress-bar");
    private By stepText = By.xpath("//*[contains(text(), 'Step 1 of 10')]");
    private By uploadPdfButton = By.id("uploadPdfBtn");
    private By pdfNote = By.xpath("//*[contains(text(),'PDF files only (Max 10MB)')]");
    private By skipCard = By.id("skipCard");
    private By skipExplanation = By.xpath("//*[contains(text(),'continue without lab results')]");
    private By continueWithoutReportButton = By.id("continueWithoutReport");
    private By dataSecurityNote = By.xpath("//*[contains(text(),'securely processed') or contains(text(),'third parties')]");

    // ✅ Methods for actions & verifications
    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public boolean isSupportingTextDisplayed() {
        return driver.findElement(supportingText).isDisplayed();
    }

    public boolean isProgressBarVisible() {
        return driver.findElement(progressBar).isDisplayed();
    }

    public boolean isUploadPdfButtonVisible() {
        return driver.findElement(uploadPdfButton).isDisplayed();
    }

    public boolean isUploadPdfButtonEnabled() {
        return driver.findElement(uploadPdfButton).isEnabled();
    }

    public boolean isPdfNoteDisplayed() {
        return driver.findElement(pdfNote).isDisplayed();
    }

    public boolean isSkipCardVisible() {
        return driver.findElement(skipCard).isDisplayed();
    }

    public boolean isSkipExplanationDisplayed() {
        return driver.findElement(skipExplanation).isDisplayed();
    }

    public boolean isContinueWithoutReportButtonDisplayed() {
        return driver.findElement(continueWithoutReportButton).isDisplayed();
    }

    public boolean isContinueWithoutReportButtonEnabled() {
        return driver.findElement(continueWithoutReportButton).isEnabled();
    }

    public boolean isDataSecurityNoteDisplayed() {
        return driver.findElement(dataSecurityNote).isDisplayed();
    }

}
