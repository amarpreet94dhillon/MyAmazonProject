package test_layer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_package.BaseClass;
import pom_package.PomExistingAccount;
import pom_package.PomYourAccount;
import pom_package.PomYourPayment;

public class TestYourPayment extends BaseClass {
	PomExistingAccount Log;
	PomYourAccount YourAccount;
	PomYourPayment YourPayment;

	public TestYourPayment() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		Thread.sleep(500);
		Log = new PomExistingAccount();
		YourAccount = Log.login(proper.getProperty("email"), proper.getProperty("password"));
		YourAccount.MouseHover();
		YourPayment = YourAccount.ClickYourPayments();
		}

	@Test(priority = 1)
	public void Title() {
		String actual = YourPayment.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Your Payments");
	}

	@Test(priority = 2)
	public void AddPayment() throws InterruptedException {
		YourPayment.AddCard(proper.getProperty("cardnumber"), proper.getProperty("nameoncard"), proper.getProperty("CSV"));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
