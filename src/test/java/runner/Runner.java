package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin  = {"pretty","html:target/HER.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},  //cucumber reports
		
		monochrome = true,  //console output color and eliminate junk characters
		tags = " ",  //tags from feature file
		features = {"src/test/resources/features"}, //location of feature files, we can give this way-->".//features//"
		glue= {"stepdefinition","Hooks"}) //location of step definition files, gives granural level of info in test result

public class Runner {

}