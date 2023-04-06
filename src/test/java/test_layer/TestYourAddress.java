package test_layer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_package.BaseClass;
import pom_package.PomExistingAccount;
import pom_package.PomYourAccount;
import pom_package.PomYourAddress;

public class TestYourAddress extends BaseClass{
	PomExistingAccount Log;
	PomYourAccount YourAccount;
	PomYourAddress YourAddress;

	public TestYourAddress() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		Thread.sleep(500);
		Log = new PomExistingAccount();
		YourAccount = Log.login(proper.getProperty("email"), proper.getProperty("password"));
		YourAccount.MouseHover();
		YourAddress = YourAccount.ClickYourAddress();
		//YourOrders.ClickonOrders();
	}

	@Test(priority = 1)
	public void Title() {
		String actual = YourAddress.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Your Addresses");
	}

	@Test(priority = 2)
	public void AddAddress() {
		Assert.assertTrue(YourAddress.verifyAddAddress());
	}

	@Test(priority = 3)
	public void DefaultAddress() {
		Assert.assertTrue(YourAddress.verifyDefaultAddress());
	}

	@Test(priority = 4, enabled=false)
	public void AddNewAddress() throws InterruptedException {

		YourAddress.AddingAddress(proper.getProperty("name"), proper.getProperty("email"),
				proper.getProperty("addresslineA"), proper.getProperty("addresslineB"), proper.getProperty("city"),
				proper.getProperty("postal"));
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}


}
