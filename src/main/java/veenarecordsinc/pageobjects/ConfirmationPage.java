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

public class ConfirmationPage extends abstractComponents{
		
	
		WebDriver driver;
		
		public ConfirmationPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		//act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		@FindBy(css=".hero-primary")
		WebElement confirmMessage;
		
		public String confirmationMessage() {
			 return confirmMessage.getText();
		}
		
	
}
