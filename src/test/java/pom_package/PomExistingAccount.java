package pom_package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class PomExistingAccount extends BaseClass {
		//object repository
	
	@FindBy(css = "#nav-link-accountList")WebElement AccountandLists;//driver.findElement(By.
	@FindBy(id="ap_email")WebElement Email;
	@FindBy(id="continue")WebElement Continue;
	@FindBy(id="ap_password")WebElement Password;
	@FindBy(id="signInSubmit")WebElement Continue2;

		//initiate page elements
		public PomExistingAccount() {
		PageFactory.initElements(driver,this);//initElement is a static method in page factory
		//this keyword helps to convert local into global driver
		}
		
		/*
		 * public void HelloSignIn() { AccountandLists.click(); } public void
		 * mobileOrEmail(String email) { Email.sendKeys(email); } public void
		 * password(String password) { Password.sendKeys(password); } public void
		 * Continue() { Continue.click(); } public void SignIn() { Continue2.click(); }
		 */
		
		public PomYourAccount login(String email, String password) throws InterruptedException {

			AccountandLists.click();
			Email.sendKeys(email);
			Continue.click();
			Password.sendKeys(password);
			Continue2.click();
			Thread.sleep(2000);
			return new PomYourAccount();

		}
}
