package runner;

<<<<<<< Updated upstream
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/HER.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, // cucumber reports

		monochrome = true, // console output color and eliminate junk characters
		dryRun = false, tags = " ", // tags from feature file
		features = { "src/test/resources/features" }, // location of feature files, we can give this
														// way-->".//features//"
		glue = { "stepdefinition", "Hooks" }) // location of step definition files, gives granural level of info in test
												// result

public class Runner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
=======
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinition", "apphooks"},
    tags = "@run" ,  
    plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    monochrome = true,
    dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
>>>>>>> Stashed changes
