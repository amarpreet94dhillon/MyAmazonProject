package test_layer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_package.BaseClass;
import pom_package.PomExistingAccount;
import pom_package.PomLoginAndSecurity;
import pom_package.PomYourAccount;
import pom_package.PomYourAddress;
import pom_package.PomYourOrders;
import pom_package.PomYourPayment;
import utility.TimeUtils;

public class TestYourAccount extends BaseClass{
	PomExistingAccount Log;
	PomYourAccount YourAccount;
	PomYourOrders YourOrders;
	PomYourAddress YourAddress;
	PomLoginAndSecurity LoginandSecurity;
	PomYourPayment YourPayment;
	
	public TestYourAccount() {
	super();
	}

	@BeforeMethod
	public void initialSetup() throws InterruptedException {
		initiation();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUtils.timepage));
		Log= new PomExistingAccount();
		YourAccount = Log.login(proper.getProperty("email"), proper.getProperty("password"));
		YourAccount.MouseHover();
	}
	@Test(priority = 1)

	public void testGetName() {

		System.out.println(YourAccount.getNameLabel());
	}

	@Test(priority = 2)
	public void testVerifyName() {
		Assert.assertTrue(YourAccount.verifyNameLabel());
	}
	@Test(priority = 3)
	public void testYourOrders() throws InterruptedException {
		YourOrders = YourAccount.ClickYourOrders();
	}
	@Test(priority = 4)
	public void testYourAddress() {
		YourAddress = YourAccount.ClickYourAddress();
	}

	@Test(priority = 5)
	public void testLoginandSecurity() {
		LoginandSecurity = YourAccount.ClickLoginAndSecurity();
	}

	@Test(priority = 6)
	public void testYourPaymentPage() {
		YourPayment = YourAccount.ClickYourPayments();
	}

		@AfterMethod
	public void close() throws InterruptedException {	
	driver.close();
	}


}
