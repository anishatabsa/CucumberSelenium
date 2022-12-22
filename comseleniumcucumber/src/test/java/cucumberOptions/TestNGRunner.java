package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features", // To specify where the feature files are located
        glue = "stepDefinitions", // To specify where the step definitions are located
        tags = "@Regression", // To run specific tags for e.g. @Sanity, @Smoke, @Negative, @Regression etc.
        plugin = { // To generate cucumber reports
                "pretty", // This would prettify the console test output with green and red colors.
                "html:target/reports/TestReport.html", // To generate html report in specified location
                "json:target/reports/JsonReport.json", // To generate json report in specified location
                "junit:target/reports/XmlReport.xml", // To generate XML Junit report in specified location
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //To generate Extent reports
                "rerun:target/failed_tests.txt"
        },
        dryRun = false, // If set to true it will verify if all the steps in feature files have step definitions
        monochrome = false // To print the output in console without any special characters
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true) //Annotation to run tests in parallel
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
