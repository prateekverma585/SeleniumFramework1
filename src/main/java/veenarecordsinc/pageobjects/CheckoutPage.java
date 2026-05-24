package veenarecordsinc.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import veenarecordsinc.AbstractComponents1.abstractComponents;

public class CheckoutPage extends abstractComponents{
		
	
		WebDriver driver;
		
		public CheckoutPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		//act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		@FindBy(css="[placeholder='Select Country']")
		WebElement country;
		
		//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
		WebElement selectIndia;
		
		//driver.findElement(By.cssSelector(".action__submit")).click();
		@FindBy(css=".action__submit")
		WebElement submit;
		
		By allCountry = By.xpath("//section");
		
		public void selectCountry(String countryName) {
			
			Actions act = new Actions(driver);
			act.sendKeys(country,countryName).build().perform();
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section")));
			waitElementToAppear(allCountry);
			
			selectIndia.click();
			
		}
		
		public ConfirmationPage submitOrder() {
			submit.click();
			ConfirmationPage confirmationPage = new ConfirmationPage(driver);
			return confirmationPage;
		}
		
	
}
