package test_layer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_package.BaseClass;
import pom_package.PomExistingAccount;
import pom_package.PomLoginAndSecurity;
import pom_package.PomYourAccount;
import pom_package.PomYourAddress;

public class TestLoginAndSecurity extends BaseClass{
	PomExistingAccount Log;
	PomYourAccount YourAccount;
	PomYourAddress YourAddress;
	PomLoginAndSecurity LoginAndSecurity;

	public TestLoginAndSecurity() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		Thread.sleep(500);
		Log = new PomExistingAccount();
		// SignIn.act();
		YourAccount = Log.login(proper.getProperty("email"), proper.getProperty("password"));
		YourAccount.MouseHover();
		LoginAndSecurity = YourAccount.ClickLoginAndSecurity();
		// YourOrders.ClickonOrders();
		//screenshots("Login And Security");
	}

	@Test
	public void Title() {
		String actual = LoginAndSecurity.verify();
		System.out.println(actual);
		Assert.assertEquals(actual,"Amazon");
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
