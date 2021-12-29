package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.pages.BasePage;
import swaglabs.pages.CheckoutPage;
import swaglabs.pages.ItemsPage;
import swaglabs.pages.LoginPage;

public class BuyProduct extends BasePage  {
	
	
	LoginPage loginPage;
	ItemsPage itemsPage;
	CheckoutPage checkoutPage;
	@Given("User launchedd SwagLabs application")
	public void user_launchedd_swag_labs_application() {
		try {
			
			loginPage = new LoginPage(page);
			itemsPage = new ItemsPage(page);
			checkoutPage=new CheckoutPage(page);
		    
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("User logged in the app using correct username {string} and password {string}")
	public void user_logged_in_the_app_using_correct_username_and_password(String username, String password) {
		loginPage.login(username, password);
	}
	@When("User adds {string} product to the cart")
	public void user_adds_product_to_the_cart(String product) {
		itemsPage.orderProduct(product);
	   
	}
	@When("User enters Checkout details with {string}, {string}, {string}")
	public void user_enters_checkout_details_with(String firstname, String lastname, String postalcode) {
	    
		checkoutPage.fillCheckoutDetails(firstname, lastname, postalcode);
	}
	@When("User completes Checkout process")
	public void user_completes_checkout_process() {
	   checkoutPage.completeCheckout();
	}
	@Then("User should get the Confirmation of Order")
	public void user_should_get_the_confirmation_of_order() {
	    checkoutPage.checkoutSuccessful();
	}


}
