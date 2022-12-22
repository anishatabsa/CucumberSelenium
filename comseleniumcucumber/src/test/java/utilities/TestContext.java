package utilities;

import factories.PageObjectFactory;
import factories.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestContext {
    public PageObjectFactory pageObjectFactory;
    public WebDriverFactory webDriverFactory;
    public TestUtilities testUtilities;
    public Properties testProperties;

    public TestContext() throws IOException {
        this.webDriverFactory = new WebDriverFactory();
        WebDriver driver = webDriverFactory.get_chrome_driver();
        this.pageObjectFactory = new PageObjectFactory(driver);
        this.testUtilities = new TestUtilities(driver);
        System.out.println("Setting up properties file");
        this.testProperties = new Properties();
        testProperties.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/test.properties"));
        System.out.println("URL from Properties file: "+ testProperties.getProperty("url"));

    }
}
