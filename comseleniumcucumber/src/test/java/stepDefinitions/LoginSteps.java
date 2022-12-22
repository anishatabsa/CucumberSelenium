package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import utilities.TestContext;

import java.util.Objects;

public class LoginSteps {

    private TestContext context;
    public LoginPageObjects loginPage;
    public HomePageObjects homePage;

    public LoginSteps(TestContext context) {
        this.context = context;
        this.loginPage = context.pageObjectFactory.get_login_page();
        System.out.println("Invoking home page object");
        this.homePage = context.pageObjectFactory.get_home_page();
        System.out.println("Invoked home page object");
    }

    @Given("User is on Takealot home page")
    public void user_is_on_takealot_home_page() {
        String homePageTitle = homePage.navigate_to_home_page(context.testProperties.getProperty("url"));
        System.out.println("Home Page Title: "+ homePageTitle);
        assert homePageTitle.equalsIgnoreCase("Takealot.com: Online Shopping | SA's leading online store");
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        String formName = loginPage.get_login_form_header();
//        assert Objects.equals(formName, "Login");
        Assert.assertEquals(formName, "Login", "User could not reach login page");

    }

    @When("User enters login credentials as username {string} and password {string}")
    public void user_enters_login_credentials_as_username_and_password(String username, String password) {
        loginPage.enter_email_address(username);
        loginPage.enter_password(password);
    }

    @When("User clicks on the Login button")
    public void user_clicks_on_the_login_button() {
        loginPage.click_login_button();
    }

    @Then("Takealot Home Page is displayed")
    public void takealot_home_page_is_displayed() {

        String logo_title = homePage.get_tal_logo_text();
        assert Objects.equals(logo_title, "Takealot");
    }

    @Then("Error is displayed as {string}")
    public void error_is_displayed_as(String error_message) {
        System.out.println("Displays error message "+ error_message);
    }

    @When("User enters login details as username {string} and password {string}")
    public void user_enters_login_details_as_username_and_password(String username, String password) {
        System.out.println("Logged in with username: "+ username + " and password: "+ password);
    }

    @Given("The {string} browser is opened")
    public void the_browser_is_opened(String browser) {
        System.out.println("The "+ browser +" browser has been opened");
    }

    @When("User enters the Takealot URL")
    public void user_enters_the_takealot_url() {
        homePage.navigate_to_home_page(context.testProperties.getProperty("url"));
    }

    @When("User clicks on the login link")
    public void user_clicks_on_the_login_link() {
        homePage.click_on_login_link();
    }

    @Then("User should be navigated to the login page")
    public void user_should_be_navigated_to_the_login_page() {
        String formName = loginPage.get_login_form_header();
        System.out.println("Login form header: "+ formName);
        Assert.assertEquals(formName, "Login", "User could not reach login page");
    }

}
