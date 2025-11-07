package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;

public class LaunchPage {

	public WebDriver driver;
	Alert alert;

	public LaunchPage(WebDriver driver) {
		this.driver = driver;
		this.driver = DriverFactory.Driver();
	}

	By MenstrualPhase = By.id("menstrualphase");
	By FollicularPhase = By.id("follicularphase");
	By OvulationPhase = By.id("ovulationphase");
	By LutealPhase = By.id("putealphase");
	By CycleTrack = By.name("Cycle_Tracking_ App");
	By loginbutton = By.xpath("//div[@class='login']");
	By Signinbutton = By.xpath("//div[@class='signin']");

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
}
