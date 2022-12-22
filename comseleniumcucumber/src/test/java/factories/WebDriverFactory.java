package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public WebDriver driver;

    public WebDriver get_chrome_driver() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }
}
