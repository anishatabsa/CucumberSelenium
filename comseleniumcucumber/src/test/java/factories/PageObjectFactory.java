package factories;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

public class PageObjectFactory {
    private WebDriver driver;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObjects get_login_page() {
        return new LoginPageObjects(driver);
    }

    public HomePageObjects get_home_page() {
        return new HomePageObjects(driver);
    }

}
