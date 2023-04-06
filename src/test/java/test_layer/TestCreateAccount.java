package test_layer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_package.BaseClass;
import pom_package.PomCreateAccount;
import pom_package.PomYourAccount;
import utility.TimeUtils;

public class TestCreateAccount extends BaseClass {
	PomCreateAccount Log;
	PomYourAccount YourAccount;
	public TestCreateAccount() {
		super();
	}
	@BeforeMethod
	public void initialSetup() throws InterruptedException {
		initiation();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUtils.timepage));
		Log= new PomCreateAccount();
	}
	@Test(priority=1)
	public void Title() {
		String actual = Log.verify();
		System.out.println(actual);
		Assert.assertEquals( actual,"Amazon Registration"); //checkpoint
	}
	@Test (priority=2)
	public void LoginAccount() throws InterruptedException {
		Thread.sleep(3000);
		YourAccount=Log.LoginAccount(proper.getProperty("name"),
				proper.getProperty("emailormob"),
				proper.getProperty("pass"),
				proper.getProperty("passA"));
		}
	@AfterMethod
	public void close() throws InterruptedException {
		
	driver.close();
	}
}
