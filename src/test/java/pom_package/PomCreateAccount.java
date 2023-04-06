package pom_package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class PomCreateAccount extends BaseClass{
	//object repository
	
	
	
	
		@FindBy(css = "#nav-link-accountList")WebElement AccountandLists;//driver.findElement(By.
		@FindBy(xpath = "//a[contains(text(),'Start here.')]")WebElement Starthere;
		@FindBy(id="ap_customer_name")WebElement YourName;
		@FindBy(id="ap_email")WebElement MobileOrEmail;
		@FindBy(id="ap_password") WebElement Password;
		@FindBy(id="ap_password_check") WebElement PasswordAgain;
		@FindBy(id="continue") WebElement Continue;
		
		
		//initiate page elements
		public PomCreateAccount() {
			PageFactory.initElements(driver,this);//initElement is a static method in page factory
			//this keyword helps to convert local into global driver
		}

			public String verify() {
			return driver.getTitle();
		}

		public PomYourAccount LoginAccount(String name, String emailormob, String pass, String passA) throws InterruptedException {
			action = new Actions(driver);
			action.moveToElement(AccountandLists).build().perform();
			Thread.sleep(2000);
			action.moveToElement(Starthere).click().build().perform();
			Thread.sleep(2000);
			YourName.sendKeys(name);
			MobileOrEmail.sendKeys(emailormob);
			Password.sendKeys(pass);
			PasswordAgain.sendKeys(passA);
			Continue.click();
			
			
			Thread.sleep(2000);
			return new PomYourAccount();
		}
}
