package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageObjects {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private By tal_logo = By.xpath("//img[@alt='Takealot']");
    private By login_link = By.linkText("Login");
    private By register_link = By.linkText("Register");

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String navigate_to_home_page(String url) {
        System.out.println("Home Page URL: "+url);
        driver.get(url);
        webDriverWait.until(ExpectedConditions.titleIs("Takealot.com: Online Shopping | SA's leading online store"));
                // presenceOfElementLocated(tal_logo));

        return driver.getTitle();
    }
    public String get_tal_logo_text() {
        return driver.findElement(tal_logo).getText();
    }

    public void click_on_login_link() {
        driver.findElement(login_link).click();
    }

    public void click_on_register_link() {
        driver.findElement(register_link).click();
    }

}
