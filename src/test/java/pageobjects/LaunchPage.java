package pageobjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverfactory.DriverFactory;
import utils.LoggerLoad;

import org.openqa.selenium.support.Color;
import org.testng.Assert;


public class LaunchPage {

	public WebDriver driver;
	Alert alert;

	public LaunchPage(WebDriver driver) {
		this.driver = driver;
		this.driver = DriverFactory.Driver();
	}

	By Menstrualdetailsinfo=By.className("Menstrualdetails");
	By MenstrualPhase = By.id("menstrualphase");
	By FollicularPhase = By.id("follicularphase");
	By OvulationPhase = By.id("ovulationphase");
	By LutealPhase = By.id("putealphase");
	By CycleTrack = By.name("Cycle_Tracking_ App");
	By loginbutton = By.xpath("//div[@class='login']");
	By Signinbutton = By.xpath("//div[@class='signin']");
	By personalizedbutton = By.xpath("//div[@class='personalizedbutton']");
	By getstartedbutton = By.xpath("//div[@class='getstartedbutton']");
    By userText=By.xpath ( "//span[text()='User']");
    By imagesyn=By.xpath("//*[@id='product-1']/div/div/div/a/div/picture/img");
    
    
	public boolean Displaycards() {
		try {
			return driver.findElement(MenstrualPhase).isDisplayed() && driver.findElement(FollicularPhase).isDisplayed()
					&& driver.findElement(OvulationPhase).isDisplayed()
					&& driver.findElement(LutealPhase).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean Cycletrack() {
		return driver.findElement(CycleTrack).isDisplayed();

	}

	public boolean Loginbutton() {
		return driver.findElement(CycleTrack).isDisplayed();

	}

	public boolean SigninButton() {
		return driver.findElement(CycleTrack).isDisplayed();

	}
	public boolean getstartedbutton() {
		return driver.findElement(getstartedbutton).isDisplayed();

	}
	
	public boolean personalizedbutton() {
		return driver.findElement(personalizedbutton).isDisplayed();

	}
	
	public void checkUserTxtClr() {
	    String textColor = ((WebElement) userText).getCssValue("color");

	    System.out.println(textColor);
	    // convert rgba to hex
	    String color = Color.fromString(textColor).asHex();

	    if (color.equals("#800080")) { // Hex code for purple
	        LoggerLoad.info("User text color is" + "--->" + "purple");
	    } else {
	        LoggerLoad.info("User text color is" + "--->" + "Not purple");
	    }

	    Assert.assertEquals("#800080", color); // Assertion for purple
	}

	public boolean Menstrualdetailsinfo() {
		return driver.findElement(Menstrualdetailsinfo).isDisplayed();

	}
	
	public boolean Imagesyn() {
		return driver.findElement(imagesyn).isDisplayed();

	}

	//*[@id="product-1"]/div/div/div/a/div/picture/img
	
}
