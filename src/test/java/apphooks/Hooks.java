package apphooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.LoggerLoad;
import utils.TestContextSetup;

public class Hooks {

	private TestContextSetup context;

	public Hooks() {

	}

	@Before(order = 0)
	public static void setup() {
		LoggerLoad.info("setup browser");
		DriverFactory.setupDriver();
		// TestContextSetup.setupDriver();

	}

	@Before(order = 1)
	public static void getbrowser() {
		LoggerLoad.info("get driver");
		DriverFactory.Driver();
		// TestContextSetup.Driver();
	}

	@After(order = 0)
	public static void screenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) DriverFactory.Driver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());

		}

	}

	@AfterAll
	public static void after() {
		// SetupDriver.TearDown();
		// TestContextSetup.TearDown();

	}

}