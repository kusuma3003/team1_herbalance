package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;


public class LaunchPage {
	
	public WebDriver driver;
	Alert alert;
		

	 public  LaunchPage(WebDriver driver) 
		{
			this.driver=driver;
			this.driver=DriverFactory.Driver();
		}
		
		//Launchpage
		By UserName=By.id("username");
		By Password=By.id("password");
		By ClickLogin=By.id("login");
		By NewProgram =By.xpath("//*[text()='A New Program']");
		
		public void NewProgram() {
			driver.findElement(NewProgram).click();
			}
		
		public void Username() {
		driver.findElement(UserName).sendKeys("sdetorganizers@gmail.com");
		   }

}
