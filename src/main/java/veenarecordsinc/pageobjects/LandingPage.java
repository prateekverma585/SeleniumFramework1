package veenarecordsinc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import veenarecordsinc.AbstractComponents1.abstractComponents;

public class LandingPage extends abstractComponents {
		WebDriver driver;
		public LandingPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
	//WebElement userEmail = 	driver.findElement(By.id("userEmail"));
	//driver.findElement(By.id("userPassword")).sendKeys("HareRam@123");
	//driver.findElement(By.id("login")).click();
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue loginApplication(String email,String userPass)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(userPass);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goTO() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		waitWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
