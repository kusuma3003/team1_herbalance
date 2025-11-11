
package pageobjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenstrualCyclePage {
 
	 WebDriver driver;
	 public SignUpPage signuppage;
	 private LocalDate onboardingLastPeriodDate = LocalDate.of(2025, 10, 7); 
	 private int cycleLengthDays = 28;

	 
	    By activityInsight = By.xpath("//*[contains(text(),'activityInsight')]");
		By mensuralPhasedropdown = By.xpath("//*[contains(text(), 'mensuralPhase')]");
	    By currentCycleStatusSection = By.id("currentCycleStatus"); // example locator
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
        private By nextPeriodExpectedDate = By.xpath("//div[contains(@class,'phase-start-date')]");
        private By lastPeriodStartDate = By.xpath("//span[@id='last-period-start']");
        private By currentPhaseLabel = By.xpath("//div[contains(@class,'current-phase-name')]");
        private By subsectionHeading = By.xpath("//h2[contains(@class,'phase-subsection-heading')]");
        private By phaseGuidanceText = By.xpath("//div[contains(@class,'phase-guidance-content')]");
        private By upcomingPhaseHeading = By.xpath("//h2[contains(text(),'Upcoming Phases')]");
        private By upcomingPhasesubText = By.xpath("//p[contains(text(),'Plan ahead with your cycle phases')]");
        private By upcomingPhasesubsections = By.xpath("//div[contains(@class,'phase-subsection')]"); 
        private By upcomingPhaseStartDate = By.xpath("//div[contains(@class,'date')]"); 
        private By upcomingPhaseDates=By.xpath("//div[contains(@class,'Dates')]");
        

	public MenstrualCyclePage(WebDriver driver) {
		this.driver = driver;
		this.signuppage = new SignUpPage(driver);
    }
	
	public void ClickActivityInsights() {
		signuppage.LaunchPage();
		//add login page
		driver.findElement(activityInsight).click();
		
	}
	public void ClickMensuralPhaseLog() {
		driver.findElement(mensuralPhasedropdown ).click();
		
	}
	public WebElement getCurrentCycleStatusSection() {
        return driver.findElement(currentCycleStatusSection);
    }

    public WebElement getUpcomingPhasesSection() {
        return driver.findElement(upcomingPhasesSection);
    }

    public WebElement getRecommendedActivitiesSection() {
        return driver.findElement(recommendedActivitiesSection);
    }

    public WebElement getNutritionTipsSection() {
        return driver.findElement(nutritionTipsSection);
    }

    public WebElement getNextPeriodSection() {
        return driver.findElement(nextPeriodSection);
    }
    public boolean isElementVisible(String elementName) {
    	By locator;
         switch (elementName) {
            case "Update Cycle Information button":
                locator = updateCycleButton;
                break;
            case "Back to Dashboard button":
                locator = backToDashboardButton;
                break;
            case "Add Period Log button":
                locator = addPeriodLogButton;
                break;
            case "Cycle Overview tab":
                locator = cycleOverviewTab;
                break;
            case "Menstrual Calendar tab":
                locator = menstrualCalendarTab;
                break;
            case "Period History tab":
                locator = periodHistoryTab;
                break;
            default:
                throw new IllegalArgumentException("Unknown element: " + elementName);
        }
        return driver.findElement(locator).isDisplayed();
    }
    
    public String isCycleProgressHeading() {
        return driver.findElement(heading_CycleProgress).getText();
    }
    
    public String getProgressText() {
        return driver.findElement(progressText).getText().trim();
    }
    public boolean areLabelsDisplayed(String... expectedLabels) {
        List<WebElement> labels = driver.findElements(progressLabels);
        for (String label : expectedLabels) {
            boolean found = labels.stream()
                    .anyMatch(el -> el.getText().equalsIgnoreCase(label));
            if (!found) return false;
        }
        return true;
    }
    public boolean isProgressBarFilled() {
        String width = driver.findElement(progressBar).getDomAttribute("style");
        return width.contains("%") && !width.contains("0%");
    }
    public String getCurrentPhaseHeading() {
        return driver.findElement(currentPhaseHeading).getText().trim();
    }

    public String getCurrentPhaseContent() {
        return driver.findElement(currentPhaseContent).getText().trim();
    }
    public String getExpectedPhaseFromDay(String progressText) {
        String[] parts = progressText.replaceAll("[^0-9 ]", "").trim().split(" ");
        int currentDay = Integer.parseInt(parts[0]);
        int totalDays = Integer.parseInt(parts[1]);

        if (currentDay >= 1 && currentDay <= 5) {
            return "Menstrual Phase";
        } else if (currentDay >= 6 && currentDay <= 13) {
            return "Follicular Phase";
        } else if (currentDay >= 14 && currentDay <= 16) {
            return "Ovulatory Phase";
        } else if (currentDay >= 17 && currentDay <= totalDays) {
            return "Luteal Phase";
        } else {
            return "Unknown Phase";
        }
    }  
        public LocalDate getActualDate(String label) {
            By locator;

            if (label.equalsIgnoreCase("Last period started")) {
                locator = lastPeriodStartDate;
            } else if (label.equalsIgnoreCase("Next period expected")) {
                locator = nextPeriodExpectedDate;
            } else {
                throw new IllegalArgumentException("Unknown label: " + label);
            }

            String dateText = driver.findElement(locator).getText().trim();  // e.g. "November 4, 2025"
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
            return LocalDate.parse(dateText, formatter);
        }
        public LocalDate getExpectedDate(String label) {
            if (label.equalsIgnoreCase("Last period started")) {
                return onboardingLastPeriodDate; // e.g., October 7, 2025
            } else if (label.equalsIgnoreCase("Next period expected")) {
                return onboardingLastPeriodDate.plusDays(cycleLengthDays); // +28 days → November 4, 2025
            } else {
                throw new IllegalArgumentException("Unknown label: " + label);
            }
        }
       
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
        public String getCurrentPhaseName() {
            return driver.findElement(currentPhaseLabel).getText().trim();
        }

        public String getSubsectionHeading() {
            return driver.findElement(subsectionHeading).getText().trim();
        }

        public String getPhaseGuidanceText() {
            return driver.findElement(phaseGuidanceText).getText().trim();
        }

        public String getExpectedPhaseGuidance(String phaseName) {
            return phaseGuidance.getOrDefault(phaseName, "");
        }
        public String getSectionHeading(String expectedHeading) {
            if (expectedHeading.equalsIgnoreCase("Upcoming Phases")) {
                return driver.findElement(upcomingPhaseHeading).getText().trim();
            } else {
                throw new IllegalArgumentException("Locator not defined for heading: " + expectedHeading);
            }
        }
            
            public boolean getSubtext(String expectedText) {
                String actualText = driver.findElement(upcomingPhasesubText).getText().trim();
                return actualText.equals(expectedText); 
            }
            	
            public int getVisibleSubsectionCount() {
                List<WebElement> subsections = driver.findElements(upcomingPhasesubsections); 
                long visibleCount = subsections.stream()
                        .filter(WebElement::isDisplayed)
                        .count();
				return (int)visibleCount;
            }
            public List<String> getAllPhaseHeadings() {
                return driver.findElements(upcomingPhasesubsections)
                             .stream()
                             .map(WebElement::getText)
                             .collect(Collectors.toList());
            }
            public boolean areStartDatesDisplayed() {
                List<WebElement> phaseSections = driver.findElements(upcomingPhaseStartDate);

                for (WebElement section : phaseSections) {
                    String dateText = section.findElement(upcomingPhaseStartDate).getText().trim();
                    if (dateText.isEmpty()) {
                        return false; 
                    }
                }
             return true;
            }
            public String getCurrentPhaseStartDateText() {
                String dateText = driver.findElement(upcomingPhaseDates).getText().replace("Started", "").trim();
                return dateText;
            }
            public boolean isCurrentPhaseStartDateFormatValid(String format) {
                String dateText = getCurrentPhaseStartDateText();
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                    LocalDate.parse(dateText, formatter);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            public String getHighlightedPhaseText() {
                List<WebElement> sections = driver.findElements(upcomingPhasesubsections);

                for (WebElement section : sections) {
                    String classes = section.getDomAttribute("class");
                    if (classes.contains("highlighted")) { 
                        return section.findElement(upcomingPhasesubsections).getText().trim();
                    }
                }
                return null; 
            }
            public boolean verifyCycleDataWithHighlighted() {
               
                String expected = driver.findElement(currentPhaseLabel).getText().trim();
                String actual = getHighlightedPhaseText();
                return expected.equalsIgnoreCase(actual);
            }

        }
        
       