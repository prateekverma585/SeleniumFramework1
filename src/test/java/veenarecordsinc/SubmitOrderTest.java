	package veenarecordsinc;
	
	import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	
	import io.github.bonigarcia.wdm.WebDriverManager;
	import veenarecords.TestComponents.BaseTest;
	import veenarecordsinc.pageobjects.CheckoutPage;
	import veenarecordsinc.pageobjects.ConfirmationPage;
	import veenarecordsinc.pageobjects.LandingPage;
	import veenarecordsinc.pageobjects.OrderPage;
	import veenarecordsinc.pageobjects.ProductCatalogue;
	import veenarecordsinc.pageobjects.cartPage;
	
	public class SubmitOrderTest extends BaseTest{
		
		String productName = "ZARA COAT 3";	
	
		@Test(dataProvider= "getData",groups= {"Purchase"})
		public void submitOrder(HashMap<String,String> input) throws IOException {
			// TODO Auto-generated method stub
			
			
			ProductCatalogue productCatalogue =landingPage.loginApplication(input.get("email"), input.get("password"));
			List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(input.get("productName"));
			cartPage CartPage = productCatalogue.goToCartPage();
			Boolean match = CartPage.verifyProductDisplay(input.get("productName"));
			Assert.assertTrue(match);
			CheckoutPage checkoutPage = CartPage.checkOut();
			checkoutPage.selectCountry("india");
			ConfirmationPage confirmationPage = checkoutPage.submitOrder();
			String confirmMessage = confirmationPage.confirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			
				
		}
		
		@Test(dependsOnMethods= {"submitOrder"})
		public void OrderHistoryTest() {
			ProductCatalogue productCatalogue =landingPage.loginApplication("veenarecordsinc@gmail.com", "HareRam@123");
			OrderPage ordersPage = productCatalogue.goToOrderPage();
			Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
		}
		
		
		
		
		//ExtentReports

		@DataProvider
		public Object[][] getData() throws IOException {
			/*HashMap<String,String> map = new HashMap<String,String>();
			map.put("email", "veenarecordsinc@gmail.com");
			map.put("password", "HareRam@123");
			map.put("productName", "ZARA COAT 3");
			
			HashMap<String,String> map1 = new HashMap<String,String>();
			map1.put("email", "prateekverma585@gmail.com");
			map1.put("password", "RadhaRani@123");
			map1.put("productName", "ADIDAS ORIGINAL");
			*/
			List<HashMap<String,String>> data =  getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\veenarecordsinc\\jsondata\\PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}}; 
		}
	}
