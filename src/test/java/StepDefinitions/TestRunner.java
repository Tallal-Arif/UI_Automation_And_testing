package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features", 
		glue= {"StepDefinitions"},
		monochrome = true,
		tags = "@NewTrelloBoard", // Use the tag of the test you want to run
		plugin = {"pretty", "junit:target/JUnitReports/report.xml",
				"json:target/JSONReports/report.json",
				"html:target/HtmlReports"})
public class TestRunner {

}
