package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "target/failed_tests.txt", // To specify where the feature files are located
        glue = "stepDefinitions", // To specify where the step definitions are located
        plugin = { // To generate cucumber reports
                "pretty", // This would prettify the console test output with green and red colors.
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" //To generate Extent reports
        },
        dryRun = false, // If set to true it will verify if all the steps in feature files have step definitions
        monochrome = false // To print the output in console without any special characters
)
public class FailedTestsRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true) //Annotation to run tests in parallel
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
