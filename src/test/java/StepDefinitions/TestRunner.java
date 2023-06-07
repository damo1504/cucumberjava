package StepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/logindemo.feature",
    glue = {"StepDefinitions"}, monochrome = true,
    plugin = {"pretty",
        "html:target/reports/htmlreport.html",
        "json:target/reports/cucumber.json",
        "json:target/reports/cucumber.xml",
        "junit:target/JUnitReports/report.xml"},
    tags = "")
public class TestRunner {

}
