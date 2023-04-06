package test_layer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_package.BaseClass;
import pom_package.PomExistingAccount;
import pom_package.PomYourAccount;
import pom_package.PomYourOrders;

public class TestYourOrders extends BaseClass {

		PomExistingAccount Log;
		PomYourAccount YourAccount;
		PomYourOrders YourOrders;

		public TestYourOrders() {
			super();
		}

		@BeforeMethod
		public void initsetup() throws InterruptedException {
			initiation();
			Thread.sleep(2500);
			Log = new PomExistingAccount();
			YourAccount = Log.login(proper.getProperty("email"), proper.getProperty("password"));
			YourAccount.MouseHover();
			YourOrders = YourAccount.ClickYourOrders();
			// YourOrders.ClickonOrders();
		
		}

		@Test(priority = 1)
		public void Title() {
			String actual = YourOrders.verify();
			System.out.println(actual);
			Assert.assertEquals(actual, "Your Orders", "YourOrderpage title is not matched");
		}
		
		@Test(priority = 2)
		public void testBuyAgainLink() {
			YourOrders.ClickonBuyAgain();
		}

		@Test(priority = 3)
		public void testCancelledorderLink() {
			YourOrders.ClickonCancelledOrders();
		}

		@Test(priority = 4)
		public void testNotyetShipped() {
			YourOrders.ClickonNotYetShipped();
		}
		
		@Test(priority = 5)
		public void testOrdersLink1() {
			// YourOrders.ClickonOrders();
			YourOrders.orderfilter1();
		}

		@Test(priority = 6, enabled = false)
		public void testOrdersLink2() {
			// YourOrders.ClickonOrders();
			YourOrders.orderfilter2();
		}

		@Test(priority = 7, enabled = false)
		public void testOrdersLink3() {
			// YourOrders.ClickonOrders();
			YourOrders.orderfilter3();
		}
		@AfterMethod
		public void close() {
			driver.quit();
		}



}
