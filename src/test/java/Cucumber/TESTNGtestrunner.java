package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/Cucumber",
    glue = "Udemeyacademy.Stepdefinitions",
    monochrome = true,
    tags= "@Regression",
    //plugin is used to specify the output format of the test execution reports in Cucumber. It allows you to generate reports in 
    //different formats (e.g., HTML, JSON, XML) and to output logs or summaries of the test execution.
    plugin = {"html:target/cucumber.html"}
)
public class TESTNGtestrunner extends AbstractTestNGCucumberTests {
}
