package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
D
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


	    plugin = {
	        "pretty",
	        "html:target/HER.html",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
	    },
	    monochrome = true,
	    dryRun = false,
	    features = "src/test/resources/features",
	    glue = { "stepdefinition", "Hooks" },
	    tags = "@tag1"
	)
	public class Runner extends AbstractTestNGCucumberTests {

	    @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	}

