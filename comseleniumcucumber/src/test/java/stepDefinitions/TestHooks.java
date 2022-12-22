package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestContext;

import java.io.File;
import java.io.IOException;

public class TestHooks {

    public TestContext context;
    public TestHooks(TestContext context) {
        this.context = context;
    }

//    @Before
//    public void beforeTest() {
//        context.webDriverFactory.driver.get(
//                System.getProperty(context.testProperties.getProperty("url"))
//        );
//    }

    @After
    public void afterTest() {
        context.webDriverFactory.driver.quit();
    }

    @AfterStep
    public void GenerateScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            File screenshot = ((TakesScreenshot)context.webDriverFactory.driver).getScreenshotAs(OutputType.FILE);
            byte[] byteScreenshot = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(byteScreenshot, "image/jpg", "screen");
        }
    }

//    @BeforeAll
//    public void beforeAll() {
//        context.webDriverFactory.driver.get(
//                System.getProperty(context.testProperties.getProperty("url"))
//        );
//    }
//
//    @AfterAll
//    public void afterAll() {
//
//    }
}
