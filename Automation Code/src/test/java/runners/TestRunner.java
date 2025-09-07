package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",   // path to my feature files
    glue = {"stepDefinitions"},                 // package for my step definitions
    plugin = {
        "pretty", 
        "html:target/cucumber-reports/htmlreport.html", 
        "json:target/cucumber-reports/jsonreport.json", 
        "junit:target/cucumber-reports/junitreport.xml"
    },
    monochrome = true,   // makes console output readable
    dryRun = false       // true = checks mapping without running tests
)
public class TestRunner {
}
