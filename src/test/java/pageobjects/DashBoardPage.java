package pageobjects;

import java.util.List;

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
	By MenuActivityinsight =By.xpath("//div[@class='_3sdu8W emupdz']/div[1]");
	By MenuDietplan =By.xpath("//div[@class='_3sdu8W emupdz']/div[2]");
	By MenuWorkout =By.xpath("//div[@class='_3sdu8W emupdz']/div[3]");
	By Menuwater =By.xpath("//div[@class='_3sdu8W emupdz']/div[4]");
	By Subtitle =By.xpath("//a[@class='_Brand Directory']");
	By alignmentinputfield= By.className("mat-card-content");
	By Section= By.className("nvu-card-section");
	By Metricsec= By.className("nvu-card-metsection");
	By GoalSec= By.className("nvu-card-goalsection");
	By Weight =By.xpath("//a[@Id='weight']");
	By Height =By.xpath("//a[@Id='height']");
	By BMI =By.xpath("//a[@Id='bmi']");
	By GoalWeight =By.xpath("//a[@Id='weight']");
	By weekWeight =By.xpath("//a[@Id='weight']");
	By Subhead= By.linkText("nvu");
	By Bmihead= By.linkText("bqvu-card");
	By Freeplanbar =By.xpath("//a[@Id='freeplan']");
	By Healthconditon= By.cssSelector(".bqvu-card");
	By BloodReport= By.linkText(".bqvu-card-her-app");
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
	
	public boolean Healthconditon() {
		return driver.findElement(Healthconditon).isDisplayed();
		}
	public boolean HealthWithcond() {
		return driver.findElement(Healthconditon).isSelected();
		}
	public boolean BloodReport() {
		return driver.findElement(BloodReport).isDisplayed();
		}
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
	
	public void getMenu() {
	
	WebElement menuContainer = driver.findElement(By.cssSelector("ul.menu, nav.menu, div.navbar"));

    // Find all menu items inside the container
    List<WebElement> menuItems = menuContainer.findElements(By.tagName("li"));

    // Print each menu item text
    System.out.println("Menu Items:");
    for (WebElement item : menuItems) {
        System.out.println("- " + item.getText());
    }
    }
	
	public boolean Subtitle() {
		return driver.findElement(Subtitle).isDisplayed();
	}
	
	public void checkAllignmentOfTextFld() {
		String textFldAllign = ((WebElement) alignmentinputfield).getCssValue("text-align");
		Assert.assertEquals("center", textFldAllign);
		
	}
	public boolean Section() {
		return driver.findElement(Section).isDisplayed();
	}
	
	public void getSection() {
		
		WebElement Sectionheading = driver.findElement(By.cssSelector("ul.menu, nav.menu, div.navbar"));

	    // Find all menu items inside the container
	    List<WebElement> SectionItems = Sectionheading.findElements(By.tagName("li"));

	    // Print each menu item text
	    System.out.println("SectionItems:");
	    for (WebElement item : SectionItems) {
	        System.out.println("- " + item.getText());
	    }
	}
	
	public boolean Metricsec() {
		return driver.findElement(Metricsec).isDisplayed();
	}
	public boolean GoalSec() {
		return driver.findElement(GoalSec).isDisplayed();
	}
	
	public boolean Weight() {
		return driver.findElement(Weight).isDisplayed();
	}
	public boolean Height() {
		return driver.findElement(Height).isDisplayed();
	}
	public boolean BMI() {
		return driver.findElement(BMI).isDisplayed();
	}
	
	public boolean GoalWeight() {
		return driver.findElement(GoalWeight).isDisplayed();
	}
	public boolean WeekWeight() {
		return driver.findElement(weekWeight).isDisplayed();
	}
	
	public boolean Subhead() {
		return driver.findElement(Subhead).isDisplayed();
	}
	public boolean Bmihead() {
		return driver.findElement(Bmihead).isDisplayed();
	}
	
	public boolean FreePlanbar() {
		return driver.findElement(Freeplanbar).isDisplayed();
	}
}
