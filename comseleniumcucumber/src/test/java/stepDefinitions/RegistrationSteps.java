package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class RegistrationSteps {

    @Given("User is on the registration page")
    public void user_is_on_the_registration_page() {
        System.out.println("User clicks on the Registration link");
    }

    @Then("The Registration page should be displayed")
    public void the_registration_page_should_be_displayed() {
        System.out.println("Registration page displayed");
    }

    @When("User fills the registration form with valid details")
    public void user_fills_the_registration_form_with_valid_details(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        System.out.println("Name: "+ dataTable.cell(0,0));
        System.out.println("Surname: "+ dataTable.cell(0,1));
        System.out.println("Email: "+ dataTable.cell(0,2));
        System.out.println("Age: "+ dataTable.cell(0,3));
        System.out.println("Gender: "+ dataTable.cell(0,4));
        System.out.println("Nationality: "+ dataTable.cell(0,5));
        System.out.println("Country: "+ dataTable.cell(0,6));
    }

    @When("User clicks on the Register button")
    public void user_clicks_on_the_register_button() {
        System.out.println("Register button clicked");
    }

    @Then("User registration should be completed successfully")
    public void user_registration_should_be_completed_successfully() {
        System.out.println("Registration successful");
    }

}
