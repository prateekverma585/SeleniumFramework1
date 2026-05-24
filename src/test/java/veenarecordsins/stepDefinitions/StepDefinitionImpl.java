package veenarecordsins.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import veenarecords.TestComponents.BaseTest;
import veenarecordsinc.pageobjects.CheckoutPage;
import veenarecordsinc.pageobjects.ConfirmationPage;
import veenarecordsinc.pageobjects.LandingPage;
import veenarecordsinc.pageobjects.ProductCatalogue;
import veenarecordsinc.pageobjects.cartPage;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		landingPage = LaunchApplication();
	    System.out.println("I landed on Ecommerce Page");
	}
	
	@Given("^Logged in with (.+) and (.+)$")
	public void logged_in_with_name_and_password(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		productCatalogue = landingPage.loginApplication(username, password);
	    System.out.println("Logged in with username and password");
	}
	
	@When("^I checked for the (.+) to cart$")
	public void i_add_product_to_cart(String productName) {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		System.out.println("I add product to Cart");
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
	    // Write code here that turns the phrase above into concrete actions
		cartPage CartPage = productCatalogue.goToCartPage();
		Boolean match = CartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = CartPage.checkOut();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
		System.out.println("Checkout and submit the order");
	}
	@Then("{string} message is displayed on confiramtion page")
	public void message_is_displayed_on_confiramtion_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
		String confirmMessage = confirmationPage.confirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		System.out.println("Verify the order in order history page");
		driver.close();
	}
	
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		String errorMessage = landingPage.getErrorMessage();
		Assert.assertEquals(string, errorMessage);
		System.out.println("Error message is displayed");
		driver.close();
	}

}
