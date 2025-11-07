package driverfactory;

<<<<<<< Updated upstream
import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.PropertyFileReader;

//import utilities.PropertyFileReader;
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
>>>>>>> Stashed changes

public class DriverFactory {
	public static WebDriver driver;
	static ResourceBundle rb; // for reading properties file
	static String br; // for storing browser name

	private static WebDriver getDriver() {
		// rb = ResourceBundle.getBundle("config");
		// br = rb.getString("browser");

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(false);
		// options.addArguments("--headless");
		try {
			br = PropertyFileReader.getbrowser();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (br.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver(options);
		} else if (br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (br.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}

		// driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		return driver;

	}

	public static WebDriver Driver() {

		return driver;

	}

	public void openPage(String url) {
		driver.get(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static WebDriver setupDriver() {
		if (driver == null) {
			getDriver();
		}
		return driver;

	}

	public static void TearDown() {
		if (driver != null) {

			driver.quit();
		}

	}

	public static String url() {
		return driver.getCurrentUrl();

	}

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Initializes the driver for the current thread based on browser type
    public static WebDriver initDriver(String browser) {

        if (tlDriver.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    tlDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    tlDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    tlDriver.set(new EdgeDriver());
                    break;
                default:
                    System.out.println("Browser not supported. Launching Chrome by default.");
                    tlDriver.set(new ChromeDriver());
                    break;
            }
        }

        return getDriver();
    }

    // Returns the driver for current thread
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // Quits the driver for current thread
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}