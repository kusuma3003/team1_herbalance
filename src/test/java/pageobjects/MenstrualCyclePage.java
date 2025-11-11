package pageobjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenstrualCyclePage {

    WebDriver driver;
    public SignUpPage signuppage;

    // Onboarding data
    private int cycleLengthDays = 28;
    private LocalDate onboardingLastPeriodDate = LocalDate.of(2025, 10, 7);//need to change

    // Locators
    By activityInsight = By.xpath("//*[contains(text(),'activityInsight')]");
    By mensuralPhasedropdown = By.xpath("//*[contains(text(), 'mensuralPhase')]");
    By currentCycleStatusSection = By.id("currentCycleStatus");
    By upcomingPhasesSection = By.id("upcomingPhases");
    By recommendedActivitiesSection = By.id("recommendedActivities");
    By nutritionTipsSection = By.id("nutritionTips");
    By nextPeriodSection = By.id("nextPeriod");

    By updateCycleButton = By.id("updateCycleButton");
    By backToDashboardButton = By.id("backToDashboardButton");
    By addPeriodLogButton = By.id("addPeriodLogButton");
    By cycleOverviewTab = By.id("cycleOverviewTab");
    By menstrualCalendarTab = By.id("menstrualCalendarTab");
    By periodHistoryTab = By.id("periodHistoryTab");

    private By heading_CycleProgress = By.xpath("//[contains(text(),'Current Cycle Status')]");
    private By progressText = By.xpath("//[contains(@class,'progress-text')]");
    private By progressBar = By.xpath("//[contains(@class,'cycle-progress-bar')]");
    private By progressLabels = By.xpath("//div[contains(@class,'progress-labels')]/span");

    private By currentPhaseHeading = By.xpath("//div[contains(@class,'current-phase')]//h2");
    private By currentPhaseContent = By.xpath("//div[contains(@class,'current-phase')]//p[contains(@class,'content')]");
    private By currentPhaseLabel = By.xpath("//div[contains(@class,'current-phase-name')]");
    private By subsectionHeading = By.xpath("//h2[contains(@class,'phase-subsection-heading')]");
    private By phaseGuidanceText = By.xpath("//div[contains(@class,'phase-guidance-content')]");

    private By nextPeriodExpectedDate = By.xpath("//div[contains(@class,'phase-start-date')]");
    private By lastPeriodStartDate = By.xpath("//span[@id='last-period-start']");
    private By nextPeriodDateLabel = By.cssSelector(".next-period .date");
    private By daysRemainingLabel = By.cssSelector(".next-period .days-remaining");

    private By upcomingPhaseHeading = By.xpath("//h2[contains(text(),'Upcoming Phases')]");
    private By upcomingPhasesubText = By.xpath("//p[contains(text(),'Plan ahead with your cycle phases')]");
    private By upcomingPhasesubsections = By.xpath("//div[contains(@class,'phase-subsection')]");
    private By upcomingPhaseStartDate = By.xpath("//div[contains(@class,'date')]");
    private By upcomingPhaseDates = By.xpath("//div[contains(@class,'Dates')]");

    private By recommendedActivitiesHeading = By.xpath("//h2[text()='Recommended Activities']");
    private By nutritionTipsHeading = By.xpath("//h2[text()='Nutrition Tips']");
    private By nextPeriodHeading = By.xpath("//h2[text()='Next Period']");
    private By recommendedActivitiesContent = By.cssSelector(".recommended-activities .content");
    private By nutritionTipsContent = By.cssSelector(".nutrition-tips .content");
    
    private By updateCycleInfoButton = By.xpath("//button[contains(text(),'Update Cycle Information')]");
    private By sectionHeaders = By.cssSelector(".cycle-section");
    private By messageText = By.id("cycle-status-msg");


    // Phase guidance data
    private static final Map<String, String> phaseGuidance = new HashMap<>();
    static {
        phaseGuidance.put("Menstrual Phase",
                "Energy dips, so focus on rest, hydration, and iron-rich foods (spinach, lentils). Gentle movement like yoga and walking can ease cramps.");
        phaseGuidance.put("Follicular Phase",
                "Your energy is rising, metabolism is in high gear, and carbs are processed efficiently—perfect for strength training and intense workouts.");
        phaseGuidance.put("Ovulation Phase",
                "Your strength and confidence peak—go for your heaviest lifts or fastest runs! Post-ovulation, your body may store carbs more easily.");
        phaseGuidance.put("Luteal Phase",
                "Your metabolism is burning extra calories, but cravings spike! Balance mood and hunger with magnesium-rich foods (dark chocolate, nuts).");
    }

    // Recommended activities data
    private static final Map<String, String> recommendedActivitiesMap = new HashMap<>();
    static {
        recommendedActivitiesMap.put("Menstrual Phase",
                "1.Gentle yoga or stretching\n2.Walking in nature\n3.Light swimming or aqua therapy");
        recommendedActivitiesMap.put("Follicular Phase",
                "1.Strength training or HIIT for building stamina\n2.Cycling or jogging to boost energy\n3.Creative hobbies or learning new skills to take advantage of mental clarity");
        recommendedActivitiesMap.put("Ovulation Phase",
                "1.Running, cycling, or HIIT to use peak energy\n2.Group activities or social events to boost confidence\n3.Challenging projects or creative work for mental clarity");
        recommendedActivitiesMap.put("Luteal Phase",
                "1.Moderate intensity workouts like Pilates\n2.Steady-state cardio instead of HIIT\n3.Mind-body exercises to reduce stress");
    }

    // Nutrition tips data
    private static final Map<String, String> nutritionTipsMap = new HashMap<>();
    static {
        nutritionTipsMap.put("Menstrual Phase",
                "1.Focus on iron-rich foods to replenish\n2.Stay hydrated with warm beverages\n3.Eat anti-inflammatory foods");
        nutritionTipsMap.put("Follicular Phase",
                "1.Focus on protein and fiber-rich foods for steady energy\n2.Stay hydrated to support hormone balance\n3.Try new workouts or creative projects to boost motivation");
        nutritionTipsMap.put("Ovulation Phase",
                "1.Eat lean proteins and healthy fats (chicken, fish, avocado)\n2.Include zinc-rich foods (eggs, pumpkin seeds, chickpeas)\n3.Stay hydrated with water or herbal teas");
        nutritionTipsMap.put("Luteal Phase",
                "1.Higher calorie burn but increased cravings\n2.Focus on magnesium-rich foods for mood stability\n3.Prioritize fiber and complex carbs for satiety");
    }

    // Constructor
    public MenstrualCyclePage(WebDriver driver) {
        this.driver = driver;
        this.signuppage = new SignUpPage(driver);
    }

    // ---------------------- Navigation / Click Actions ----------------------
    public void ClickActivityInsights() {
        signuppage.LaunchPage();
        //add login details
        driver.findElement(activityInsight).click();
    }

    public void ClickMensuralPhaseLog() {
        driver.findElement(mensuralPhasedropdown).click();
    }

    // ---------------------- Sections / Elements Getters ----------------------
    public WebElement getCurrentCycleStatusSection() { return driver.findElement(currentCycleStatusSection); }
    public WebElement getUpcomingPhasesSection() { return driver.findElement(upcomingPhasesSection); }
    public WebElement getRecommendedActivitiesSection() { return driver.findElement(recommendedActivitiesSection); }
    public WebElement getNutritionTipsSection() { return driver.findElement(nutritionTipsSection); }
    public WebElement getNextPeriodSection() { return driver.findElement(nextPeriodSection); }

    public boolean isElementVisible(String elementName) {
        By locator;
        switch (elementName) {
            case "Update Cycle Information button": locator = updateCycleButton; break;
            case "Back to Dashboard button": locator = backToDashboardButton; break;
            case "Add Period Log button": locator = addPeriodLogButton; break;
            case "Cycle Overview tab": locator = cycleOverviewTab; break;
            case "Menstrual Calendar tab": locator = menstrualCalendarTab; break;
            case "Period History tab": locator = periodHistoryTab; break;
            default: throw new IllegalArgumentException("Unknown element: " + elementName);
        }
        return driver.findElement(locator).isDisplayed();
    }

    // ---------------------- Progress / Labels ----------------------
    public String isCycleProgressHeading() { return driver.findElement(heading_CycleProgress).getText(); }
    public String getProgressText() { return driver.findElement(progressText).getText().trim(); }

    public boolean areLabelsDisplayed(String... expectedLabels) {
        List<WebElement> labels = driver.findElements(progressLabels);
        for (String label : expectedLabels) {
            boolean found = labels.stream().anyMatch(el -> el.getText().equalsIgnoreCase(label));
            if (!found) return false;
        }
        return true;
    }

    public boolean isProgressBarFilled() {
        String width = driver.findElement(progressBar).getDomAttribute("style");
        return width.contains("%") && !width.contains("0%");
    }

    // ---------------------- Phase Info / Guidance ----------------------
    public String getCurrentPhaseHeading() { return driver.findElement(currentPhaseHeading).getText().trim(); }
    public String getCurrentPhaseContent() { return driver.findElement(currentPhaseContent).getText().trim(); }
    public String getCurrentPhaseName() { return driver.findElement(currentPhaseLabel).getText().trim(); }
    public String getSubsectionHeading() { return driver.findElement(subsectionHeading).getText().trim(); }
    public String getPhaseGuidanceText() { return driver.findElement(phaseGuidanceText).getText().trim(); }
    public String getExpectedPhaseGuidance(String phaseName) { return phaseGuidance.getOrDefault(phaseName, ""); }

    public String getExpectedPhaseFromDay(String progressText) {
        String[] parts = progressText.replaceAll("[^0-9 ]", "").trim().split(" ");
        int currentDay = Integer.parseInt(parts[0]);
        int totalDays = Integer.parseInt(parts[1]);

        if (currentDay >= 1 && currentDay <= 5) return "Menstrual Phase";
        else if (currentDay >= 6 && currentDay <= 13) return "Follicular Phase";
        else if (currentDay >= 14 && currentDay <= 16) return "Ovulatory Phase";
        else if (currentDay >= 17 && currentDay <= totalDays) return "Luteal Phase";
        else return "Unknown Phase";
    }

    // ---------------------- Dates ----------------------
    public LocalDate getActualDate(String label) {
        By locator;
        if (label.equalsIgnoreCase("Last period started")) locator = lastPeriodStartDate;
        else if (label.equalsIgnoreCase("Next period expected")) locator = nextPeriodExpectedDate;
        else throw new IllegalArgumentException("Unknown label: " + label);

        String dateText = driver.findElement(locator).getText().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        return LocalDate.parse(dateText, formatter);
    }

    public LocalDate getExpectedDate(String label) {
        if (label.equalsIgnoreCase("Last period started")) return onboardingLastPeriodDate;
        else if (label.equalsIgnoreCase("Next period expected")) return onboardingLastPeriodDate.plusDays(cycleLengthDays);
        else throw new IllegalArgumentException("Unknown label: " + label);
    }

    public String getNextPeriodDateText() { return driver.findElement(nextPeriodDateLabel).getText().trim(); }
    public boolean isNextPeriodDateFormatValid() {
        try { LocalDate.parse(getNextPeriodDateText(), DateTimeFormatter.ofPattern("MMMM d, yyyy")); return true; }
        catch(Exception e) { return false; }
    }

    public String getDaysRemainingText() { return driver.findElement(daysRemainingLabel).getText().trim(); }
    public boolean isDaysRemainingValid() {
        try { LocalDate.parse(getDaysRemainingText(), DateTimeFormatter.ofPattern("MMMM d, yyyy")); return true; }
        catch(Exception e) { return false; }
    }

    // ---------------------- Subsections ----------------------
    public String getHighlightedPhaseText() {
        List<WebElement> sections = driver.findElements(upcomingPhasesubsections);
        for (WebElement section : sections) {
            if (section.getDomAttribute("class").contains("highlighted")) {
                return section.getText().trim();
            }
        }
        return null;
    }

    public boolean verifyCycleDataWithHighlighted() {
        String expected = getCurrentPhaseName();
        String actual = getHighlightedPhaseText();
        return expected.equalsIgnoreCase(actual);
    }

    public int getVisibleSubsectionCount() {
        return (int) driver.findElements(upcomingPhasesubsections)
                .stream().filter(WebElement::isDisplayed).count();
    }

    public List<String> getAllPhaseHeadings() {
        return driver.findElements(upcomingPhasesubsections).stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean getSubtext(String expectedText) {
        return driver.findElement(upcomingPhasesubText).getText().trim().equals(expectedText);
    }

    public boolean areStartDatesDisplayed() {
        List<WebElement> dates = driver.findElements(upcomingPhaseStartDate);
        for (WebElement date : dates) {
            if (date.getText().trim().isEmpty()) return false;
        }
        return true;
    }

    public boolean isCurrentPhaseStartDateFormatValid(String format) {
        String dateText = driver.findElement(upcomingPhaseDates).getText().replace("Started", "").trim();
        try { LocalDate.parse(dateText, DateTimeFormatter.ofPattern(format)); return true; }
        catch(Exception e) { return false; }
    }

    // ---------------------- Section Headings ----------------------
    public boolean isSectionHeadingDisplayed(String heading) {
        By locator;
        switch (heading) {
            case "Recommended Activities": locator = recommendedActivitiesHeading; break;
            case "Nutrition Tips": locator = nutritionTipsHeading; break;
            case "Next Period": locator = nextPeriodHeading; break;
            default: throw new IllegalArgumentException("Unknown section heading: " + heading);
        }
        return driver.findElement(locator).isDisplayed();
    }

    // ---------------------- Recommended Activities ----------------------
    public String getRecommendedActivitiesContent() { return driver.findElement(recommendedActivitiesContent).getText().trim(); }
    public boolean isRecommendedActivitiesContentCorrect(String phase) {
        return getRecommendedActivitiesContent().contains(recommendedActivitiesMap.get(phase));
    }

    // ---------------------- Nutrition Tips ----------------------
    public String getNutritionTipsContent() { return driver.findElement(nutritionTipsContent).getText().trim(); }
    public boolean isNutritionTipsContentCorrect(String phase) {
        return getNutritionTipsContent().contains(nutritionTipsMap.get(phase));
    }
    //----------------Update Cycle--------------------------
    
    public void clickUpdateCycleInfoButton() {
        driver.findElement(updateCycleInfoButton).click();
    }

    public String getDisplayedMessage() {
        return driver.findElement(messageText).getText();
    }

    public int getVisibleSectionsCount() {
        List<?> sections = driver.findElements(sectionHeaders);
        return sections.size();
    }

    public boolean isHeaderDisplayed(String headerText) {
        return driver.findElement(By.xpath("//*[text()='" + headerText + "']")).isDisplayed();
    }

    public boolean isButtonVisible(String buttonText) {
        return driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).isDisplayed();
    }


}
