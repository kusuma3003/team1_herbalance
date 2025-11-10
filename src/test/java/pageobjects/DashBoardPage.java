package pageobjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import driverfactory.DriverFactory;
import utils.LoggerLoad;

public class DashBoardPage {
	
	
	public WebDriver driver;
	Alert alert;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		this.driver = DriverFactory.Driver();
	}
	
	By freeplantitle = By.xpath("//div[@title='FreePlan']");
	By Username = By.xpath("//img[@name='User']");
	By Bellicon = By.xpath("//img[@name='bell']");
	By Searchbar = By.className("Pke_EE");	
	By Menu =By.xpath("//div[@class='_3sdu8W emupdz']");
	By getmenu = By.xpath("//*[text()='headbar']");
	By MenuActivityinsight =By.xpath("//div[@class='_3sdu8W emupdz']/div[1]");
	By MenuDietplan =By.xpath("//div[@class='_3sdu8W emupdz']/div[2]");
	By MenuWorkout =By.xpath("//div[@class='_3sdu8W emupdz']/div[3]");
	By Menuwater =By.xpath("//div[@class='_3sdu8W emupdz']/div[4]");
	By getSection=By.xpath("//*[contains(text(),'Free Plan')]");
	By Subplantitle =By.xpath("//*[text()='Title']");
	By SubplanDes =By.xpath("//*[text()='Descrption']");
	By alignmentinputfield= By.className("mat-card-content");
	By Section= By.className("nvu-card-section");
	By Metricsec= By.className("nvu-card-metsection");
	By GoalSec= By.className("nvu-card-goalsection");
	By Weight =By.xpath("//a[@Id='weight']");
	By Height =By.xpath("//a[@Id='height']");
	By BMI =By.xpath("//div[@class='rightresult']//b");
	By GoalWeight =By.xpath("//a[@Id='weight']");
	By weekWeight =By.xpath("//a[@Id='weight']");
	By Subhead= By.linkText("nvu");
	By Bmihead= By.xpath("//*[contains(text(),'Underweight (18.5)')]");

	By Freeplanbar =By.xpath("//a[@Id='freeplan']");
	By Healthconditon= By.cssSelector(".bqvu-card");
	By Hearticon =By.cssSelector(".card .heart-icon");
	By Conditionname =By.cssSelector(".card .condition-name");
	By infoicon= By.cssSelector(".card .info-icon");
	By infotext = By.cssSelector(".card .info-text");
	
	
	By BloodReport= By.xpath("//*[contains(text(),'Upload Blood Report')]");
	By Subscription=By.xpath("//*[@id='container']/div/footer/div/div[2]/div[1]");
	By upgradebutoon =By.xpath("//*[@id='container']/div/footer/div/div[2]/div[1]/div[1]");
	By MenstrualBar=By.xpath("//div[@class='_8K2S+t row']/div/footer/div/div[2]/div[1]");
	By Menstrual=By.xpath("//div[@class='_8K2S+t row']/div/footer/div/div[2]/div[1]");
	By Hormonal=By.xpath("//div[@class='_8K2S+t row']/div/footer/div/div[2]/div[2]");
	By Symptoms=By.xpath("//div[@class='_8K2S+t row']/div/footer/div/div[2]/div[3]");
	By Cravings=By.xpath("//div[@class='_8K2S+t row']/div/footer/div/div[2]/div[4]");
	By DashLogout=By.id("Logout");
	
	
	public void DashLogout() {
		 driver.findElement(DashLogout).click();
		}
	public boolean DashLogoutdis() {
		return driver.findElement(DashLogout).isDisplayed();
		}
	
	public boolean Hormonal() {
		return driver.findElement(Hormonal).isDisplayed();
		}
	public boolean Symptoms() {
		return driver.findElement(Symptoms).isDisplayed();
		}
	public boolean Cravings() {
		return driver.findElement(Cravings).isDisplayed();
		}
	
	public boolean MenstrualBar() {
		return driver.findElement(MenstrualBar).isDisplayed();
		}
	public boolean Menstrual() {
		return driver.findElement(Menstrual).isDisplayed();
		}
	public void MenstrualClick() {
		 driver.findElement(Menstrual).click();
		}
	
	public boolean Subscription() {
		return driver.findElement(Subscription).isDisplayed();
		}
	public void Subscriptionclick() {
		 driver.findElement(Subscription).click();
		}
	
	public void Upgradebtn() {
		driver.findElement(upgradebutoon).click();
		}
	
	/*public boolean Healthconditon() {
		return driver.findElement(Healthconditon).isDisplayed();
		}*/
	
	public void Healthconditon() {
    // Verify heart icon
    try {
        WebElement heartIcon = driver.findElement(Hearticon); // adjust selector
        if (heartIcon.isDisplayed()) {
            System.out.println("Heart icon is visible");
        }
    } catch (Exception e) {
        System.out.println(" Heart icon not found");
    }

    // Verify condition name
    try {
        WebElement conditionName = driver.findElement(Conditionname); // adjust selector
        if (conditionName.isDisplayed()) {
            System.out.println("Condition name is visible: " + conditionName.getText());
        }
    } catch (Exception e) {
        System.out.println(" Condition name not found");
    }

    // Verify info icon and related text
    try {
        WebElement infoIcon = driver.findElement(infoicon); // adjust selector
        WebElement infoText = driver.findElement(infotext); // adjust selector
        if (infoIcon.isDisplayed() && infoText.isDisplayed()) {
            System.out.println("Info icon and related text are visible");
            System.out.println(" Info text: " + infoText.getText());
        }
    } catch (Exception e) {
        System.out.println(" Info icon or related text not found");
    }

	}


	public boolean HealthWithcond() {
		return driver.findElement(Healthconditon).isSelected();
		}
	/*public boolean BloodReport() {
		return driver.findElement(BloodReport).isDisplayed();
		}*/
	
	public void BloodReport() {
	// Locate the Upload Blood Report button
    try {
        WebElement uploadButton = driver.findElement(BloodReport);
        if (uploadButton.isDisplayed()) {
            System.out.println("'Upload Blood Report' button is visible");
        } else {
            System.out.println(" Button is present but not visible");
        }
    } catch (Exception e) {
        System.out.println("'Upload Blood Report' button not found");
    }}

	public boolean BloodReportSelect() {
		return driver.findElement(Healthconditon).isEnabled();
		}
	public void BloodReportClick() {
		 driver.findElement(Healthconditon).click();
		}
	
	
	public boolean FreePlan() {
		return driver.findElement(freeplantitle).isDisplayed();
		}
	
	public boolean Username () {
		return driver.findElement(Username ).isDisplayed();
		}
	
	public void Usernameclick () {
		 driver.findElement(Username ).click();
		}
	
	public boolean Bellicon  () {
		return driver.findElement(Bellicon  ).isDisplayed();
		}
	
	public boolean Searchbar  () {
		return driver.findElement(Searchbar).isDisplayed();
		}
	
	public boolean Menu() {
		return driver.findElement(Menu).isDisplayed();
	}
	
	public void MenuActivityinsight() {
		driver.findElement(MenuActivityinsight).click();
	}
	public void MenuDietplan() {
		 driver.findElement(MenuDietplan).click();
	}
	public void MenuWorkout() {
		driver.findElement(MenuWorkout).click();
	}
	public void Menuwater() {
		driver.findElement(Menuwater).click();
	}
	
	/*public void getMenu() {
	
	WebElement menuContainer = driver.findElement(By.cssSelector("ul.menu, nav.menu, div.navbar"));

    // Find all menu items inside the container
    List<WebElement> menuItems = menuContainer.findElements(By.tagName("li"));

    // Print each menu item text
    System.out.println("Menu Items:");
    for (WebElement item : menuItems) {
        System.out.println("- " + item.getText());
    }
    }*/
	
	public void getMenu() {
		List<String> expectedLabels = Arrays.asList(
	            "User Name",
	            "Activity Insights",
	            "Diet Plan",
	            "Workout",
	            "Water Tracker",
	            "View Full Cycle Details",
	            "Upload Blood Report",
	            "Upgrade to Premium",
	            "Generate 7-Day Plan",
	            "See Premium Plans"
	        );

	        // Loop through each label and verify visibility
	        for (String label : expectedLabels) {
	            try {
	                // Adjust locator strategy as needed (e.g., xpath, cssSelector)
	                WebElement element = driver.findElement(getmenu);
	                if (element.isDisplayed()) {
	                    System.out.println(" Visible: " + label);
	                } else {
	                    System.out.println(" Not visible: " + label);
	                }
	            } catch (Exception e) {
	                System.out.println(" Not found: " + label);
	            }
	        }
		}

	public void Subtitle() {
	// expected texts
    String planTitle = "Free Plan • Access to Basic Features";
    String planDescription = "Enjoy our free plan with basic features and exclusive workout planning";

    // Verify title visibility
    try {
        WebElement titleElement = driver.findElement(Subplantitle);
        if (titleElement.isDisplayed()) {
            System.out.println(" Title is visible: " + planTitle);
        }
    } catch (Exception e) {
        System.out.println(" Title not found: " + planTitle);
    }

    // Verify description visibility
    try {
        WebElement descElement = driver.findElement(SubplanDes);
        if (descElement.isDisplayed()) {
            System.out.println(" Description is visible: " + planDescription);
        }
    } catch (Exception e) {
        System.out.println(" Description not found: " + planDescription);
    }

	}
	
	
	/*public boolean Subtitle() {
		return driver.findElement(Subtitle).isDisplayed();
	}*/
	
	public void checkAllignmentOfTextFld() {
		String textFldAllign = ((WebElement) alignmentinputfield).getCssValue("text-align");
		Assert.assertEquals("center", textFldAllign);
		
	}
	public boolean Section() {
		return driver.findElement(Section).isDisplayed();
	}
	
	public void  getSection() {
		List<String> expectedLabels = Arrays.asList(
				"Weight & Body Metrics",
				"Health Conditions",
				"Blood Report Insights",
				"Menstrual Cycle Insights",
				"Subscription Information"
	            );

	        // Loop through each label and verify visibility
	        for (String label : expectedLabels) {
	            try {
	                // Adjust locator strategy as needed (e.g., xpath, cssSelector)
	                WebElement element = driver.findElement(getSection);
	                if (element.isDisplayed()) {
	                    System.out.println(" Visible: " + label);
	                } else {
	                    System.out.println(" Not visible: " + label);
	                }
	            } catch (Exception e) {
	                System.out.println(" Not found: " + label);
	            }
	        }
		}

	/*public void getSection() {
		
		WebElement Sectionheading = driver.findElement(By.cssSelector("ul.menu, nav.menu, div.navbar"));

	    // Find all menu items inside the container
	    List<WebElement> SectionItems = Sectionheading.findElements(By.tagName("li"));

	    // Print each menu item text
	    System.out.println("SectionItems:");
	    for (WebElement item : SectionItems) {
	        System.out.println("- " + item.getText());
	    }
	}*/
	
	public void Metricsec() { 
		List<String> expectedLabels = Arrays.asList(
				"Weight" , "Height" , "BMI" , "7-Day Goal","BMI Reference Guide"
				
	            );

	        // Loop through each label and verify visibility
	        for (String label : expectedLabels) {
	            try {
	                // Adjust locator strategy as needed (e.g., xpath, cssSelector)
	                WebElement element = driver.findElement(Metricsec);
	                if (element.isDisplayed()) {
	                    System.out.println(" Visible: " + label);
	                } else {
	                    System.out.println(" Not visible: " + label);
	                }
	            } catch (Exception e) {
	                System.out.println(" Not found: " + label);
	            }
	        }
	}
	
	/*public boolean Metricsec() {
		return driver.findElement(Metricsec).isDisplayed();
	}
	public boolean GoalSec() {
		return driver.findElement(GoalSec).isDisplayed();
	}*/
	
	public void GoalSec() { 
		List<String> expectedLabels = Arrays.asList(
				"Starting weight", "Goal" , "Weekly target", "Daily Weigh-in"
				
	            );

	        // Loop through each label and verify visibility
	        for (String label : expectedLabels) {
	            try {
	                // Adjust locator strategy as needed (e.g., xpath, cssSelector)
	                WebElement element = driver.findElement(GoalSec);
	                if (element.isDisplayed()) {
	                    System.out.println(" Visible: " + label);
	                } else {
	                    System.out.println(" Not visible: " + label);
	                }
	            } catch (Exception e) {
	                System.out.println(" Not found: " + label);
	            }
	        }
	}
	
	public boolean Weight() {
		return driver.findElement(Weight).isDisplayed();
	}
	public boolean Height() {
		return driver.findElement(Height).isDisplayed();
	}
	public void BMI() {
		WebElement BMIElement = driver.findElement(BMI);
        String resultText = BMIElement.getText();
        System.out.println("BMI displayed: " + resultText);
        //verify using the given formula for BMI 
	double weight = 70;
    double height = 1.75;
    double expectedBMI = weight / (height * height);
    String expectedBMIFormatted = String.format("%.1f", expectedBMI);

    // Validate result
    if (resultText.contains(expectedBMIFormatted)) {
        System.out.println(" BMI is correctly calculated: " + expectedBMIFormatted);
    } else {
        System.out.println(" BMI mismatch. Expected: " + expectedBMIFormatted + ", Found: " + resultText);
    }
	}

	/*public boolean BMI() 
	{
		return driver.findElement(BMI).isDisplayed();
	}*/
	
	public boolean GoalWeight() {
		return driver.findElement(GoalWeight).isDisplayed();
	}
	public boolean WeekWeight() {
		return driver.findElement(weekWeight).isDisplayed();
	}
	
	public boolean Subhead() {
		return driver.findElement(Subhead).isDisplayed();
	}
	/*public boolean Bmihead() {
		return driver.findElement(Bmihead).isDisplayed();
	}*/
	
	public void Bmiheading() {
	// Expected labels and their color codes 
    Map<String, String> expectedLabels = new HashMap<>();
    expectedLabels.put("Underweight (18.5)", "#00bfff");  // Light Blue
    expectedLabels.put("Normal (25)", "#28a745");         // Green
    expectedLabels.put("Overweight (30)", "#ffc107");     // Amber
    expectedLabels.put("Obese (40+)", "#dc3545");         // Red

    // Loop through each label and verify visibility and color
    for (Map.Entry<String, String> entry : expectedLabels.entrySet()) {
        String labelText = entry.getKey();
        String expectedColor = entry.getValue();

        try {
            WebElement labelElement = driver.findElement(Bmihead);
            if (labelElement.isDisplayed()) {
                String actualColor = labelElement.getCssValue("color");
                System.out.println("Visible: " + labelText);
                System.out.println(" CSS Color: " + actualColor);

                // Optional: Normalize and compare color values
                if (actualColor.contains(expectedColor) || actualColor.equalsIgnoreCase(expectedColor)) {
                    System.out.println("Color matches expected: " + expectedColor);
                } else {
                    System.out.println("Color mismatch. Expected: " + expectedColor + ", Found: " + actualColor);
                }
            } else {
                System.out.println("Not visible: " + labelText);
            }
        } catch (Exception e) {
            System.out.println("Label not found: " + labelText);
        }
    }
	}
  
	public boolean FreePlanbar() {
		return driver.findElement(Freeplanbar).isDisplayed();
	}
}
