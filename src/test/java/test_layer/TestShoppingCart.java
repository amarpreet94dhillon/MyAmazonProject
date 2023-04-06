package test_layer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_package.BaseClass;
import pom_package.PomExistingAccount;
import pom_package.PomSearchingSortingFiltering;
import pom_package.PomShoppingCart;
import pom_package.PomYourAccount;
import pom_package.SingletonWebdriver;

public class TestShoppingCart extends BaseClass {
	PomSearchingSortingFiltering SearchingSortingFiltering;
	PomShoppingCart ShoppingCart;
	PomExistingAccount Log;
	PomYourAccount YourAccount;
	SingletonWebdriver SameItemMultipleTimes;

	public TestShoppingCart() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		Thread.sleep(500);
		// SearchingSortingFiltering.search(prop.getProperty("product"));
		Log = new PomExistingAccount();
		YourAccount = Log.login(proper.getProperty("email"), proper.getProperty("password"));
		Thread.sleep(500);
		//screenshots("Shopping cart");
	}

	@Test(priority = 4)
	public void Title() {
		ShoppingCart = new PomShoppingCart();
		YourAccount.ClickOnCart();
		String actual = ShoppingCart.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon.ca Shopping Cart", "YourAccountpage title is not matched");
	}

	@Test(priority = 1)
	public void verifyAddToCart() throws InterruptedException {
		// SearchingSortingFiltering.invokeBrowser();

		YourAccount.VerifySearch(proper.getProperty("product"));
		Thread.sleep(1000);
		ShoppingCart = new PomShoppingCart();
		ShoppingCart.AddToCart();
		Assert.assertEquals(ShoppingCart.AddedToCart(), "Added to Cart");

	}

	@Test(priority = 2)
	public void verifyAddQuantity() throws InterruptedException {
		// SearchingSortingFiltering.invokeBrowser();
		ShoppingCart = new PomShoppingCart();
		ShoppingCart.addquantity();
		Assert.assertEquals(ShoppingCart.AddedQuantity(), "Qty:3");
	}

	@Test(priority = 3)
	public void verifyAddSameItemMultipleTimes() throws InterruptedException {

		ShoppingCart = new PomShoppingCart();

		ShoppingCart.AddSameItemMultipleTimes(proper.getProperty("product1"));

	}
	@Test(priority = 5, dataProvider = "prod")
	public void verifyAddMultipleItem(String product) throws InterruptedException {

		ShoppingCart = new PomShoppingCart();
		ShoppingCart.AddMultipleItemtocart(product);
	}

	@Test(priority = 6)
	public void verifyRemoveSomeIteminCart() {

		ShoppingCart = new PomShoppingCart();
		ShoppingCart.RemoveSomeIteminCart();
	}

	@Test(priority = 7)
	public void verifyRemoveAllIteminCart() throws InterruptedException {

		ShoppingCart = new PomShoppingCart();
		ShoppingCart.RemoveAllIteminCart();
	}

	@Test(priority = 8)
	public void verifyClickOnTheItemIntheCart() throws InterruptedException {

		ShoppingCart = new PomShoppingCart();
		ShoppingCart.ClickOnTheItemIntheCart();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
