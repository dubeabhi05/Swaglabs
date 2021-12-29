package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pages.BasePage;
import swaglabs.pages.ItemsPage;
import swaglabs.pages.LoginPage;

public class LoginSteps extends BasePage{
	
	LoginPage loginPage;
	ItemsPage itemsPage;
	
	@Given("User launched SwagLabs application")
	public void user_launched_swag_labs_application() {
		try {
			
			loginPage = new LoginPage(page);
			itemsPage = new ItemsPage(page);
			
		    
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User logged in the app using username {string} and password {string}")
	public void user_logged_in_the_app_using_username_and_password(String username, String password) {
		loginPage.login(username, password);
	}

	@Then("user should be able to log in")
	public void user_should_be_able_to_log_in() {
		itemsPage.loginSuccessful();
	}

	@Then("User should not get logged in")
	public void user_should_not_get_logged_in() {
		loginPage.loginFailed();
	}

}
