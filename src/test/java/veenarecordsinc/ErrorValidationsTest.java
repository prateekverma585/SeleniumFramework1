package veenarecordsinc;
import veenarecords.TestComponents.Retry;
import java.io.IOException;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import veenarecords.TestComponents.BaseTest;
import veenarecordsinc.pageobjects.CheckoutPage;
import veenarecordsinc.pageobjects.ConfirmationPage;
import veenarecordsinc.pageobjects.LandingPage;
import veenarecordsinc.pageobjects.ProductCatalogue;
import veenarecordsinc.pageobjects.cartPage;


public class ErrorValidationsTest extends BaseTest{

	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";		
		ProductCatalogue productCatalogue =landingPage.loginApplication("veenarecorddnc@gmail.com", "Hareasdam@123");
		
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
			
	}
	
	@Test
	public void productErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";		
		ProductCatalogue productCatalogue =landingPage.loginApplication("prateekverma585@gmail.com", "RadhaRani@123");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		cartPage CartPage = productCatalogue.goToCartPage();
		Boolean match = CartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
		/*
		CheckoutPage checkoutPage = CartPage.checkOut();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.confirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		*/
			
	}

}
