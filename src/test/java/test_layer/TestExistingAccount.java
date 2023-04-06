package test_layer;

import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base_package.BaseClass;
import pom_package.PomExistingAccount;
import pom_package.PomYourAccount;
import utility.TimeUtils;

public class TestExistingAccount extends BaseClass{
	PomExistingAccount Log;
	PomYourAccount YourAccount;

	public TestExistingAccount() {
		super();
	}
	@BeforeMethod 
	public void initialSetup() throws InterruptedException {
		initiation();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUtils.timepage));
		Log= new PomExistingAccount();
	}
	@Test
	public void login() throws InterruptedException {
		YourAccount = Log.login(proper.getProperty("email"), proper.getProperty("password"));
	}
	@AfterMethod
	public void close() throws InterruptedException {	
	driver.close();
	}

}
