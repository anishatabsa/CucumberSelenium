package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestUtilities;

import java.time.Duration;

public class LoginPageObjects {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private TestUtilities testUtils;
    private By login_text = By.name("login-form");
    private By login_form_close_button = By.xpath("//button[@data-ref='modal-close-button']");
    private By email_address_textbox = By.name("email");
    private By password_textbox = By.name("password");
    private By login_button = By.className("button.submit-action");

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.testUtils = new TestUtilities(driver);
    }
    public String get_login_form_header(){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(login_text));// visibilityOf(driver.findElement(login_text)));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String loginFormHeader = driver.findElement(login_text).getText();
        System.out.println("Login Form Header: "+loginFormHeader);
        return loginFormHeader;
    }

    public void click_login_form_close_button() {
        driver.findElement(login_form_close_button).click();
    }

    public void enter_email_address(String email) {
        driver.findElement(email_address_textbox).sendKeys(email);
    }

    public void enter_password(String password) {
        driver.findElement(password_textbox).sendKeys(password);
    }

    public void click_login_button() {
        driver.findElement(login_button).click();
    }

}
