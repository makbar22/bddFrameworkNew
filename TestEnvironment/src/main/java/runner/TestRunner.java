package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\murta\\eclipse-workspace\\TestEnvironment\\src\\main\\java\\Features\\Login.feature", //features tells cucumber options where are features located
		glue = {"stepDefinition"}, //glue tells cucumber options where Step Definitions are located
		tags = {"@loginTest"},
		dryRun = false,	//dry run if sets to false checks if all steps in feature files has step definitions
		monochrome = true,	//if set to true, makes the console output readable
		strict = false,	//if set to true will fail and stop executing if there are pending/undefined steps. 
		format = {"pretty",
		        "html:target/cucumber-reports/cucumber-pretty",
		        "json:target/cucumber-reports/CucumberTestReport.json",
		        "rerun:target/cucumber-reports/rerun.txt"
		        },
		
				plugin = "json:target/cucumber-reports/CucumberTestReport.json"
		)



public class TestRunner {

}
