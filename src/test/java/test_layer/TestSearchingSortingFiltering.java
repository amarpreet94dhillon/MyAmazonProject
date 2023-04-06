package test_layer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_package.BaseClass;
import pom_package.PomExistingAccount;
import pom_package.PomSearchingSortingFiltering;
import pom_package.PomYourAccount;

public class TestSearchingSortingFiltering extends BaseClass {
	PomSearchingSortingFiltering SearchingSortingFiltering;
	PomExistingAccount Log;
	PomYourAccount YourAccount;

	public TestSearchingSortingFiltering() {
		super();
	}

	@BeforeMethod
	public void initseup() throws InterruptedException {
		initiation();
		Thread.sleep(500);
		// SearchingSortingFiltering.search(prop.getProperty("product"));
		Log = new PomExistingAccount();
		// SignIn.act();
		YourAccount = Log.login(proper.getProperty("email"), proper.getProperty("password"));
		Thread.sleep(500);
	}

	@Test(priority = 1)
	public void Title() {
		String actual = SearchingSortingFiltering.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, proper.getProperty("productPageTitle"), "Product Page Title is not matched");
	}

	@Test(priority = 2)
	public void search() throws InterruptedException {
		// SearchingSortingFiltering.invokeBrowser();

		SearchingSortingFiltering = YourAccount.VerifySearch(proper.getProperty("product"));
		SearchingSortingFiltering.searchproduct();
		Thread.sleep(1000);
		SearchingSortingFiltering.getNthproduct(proper.getProperty("productno"));
//SearchingSortingFiltering.getAllproducts();
	}

	@Test(priority = 3)
	public void GetAllProduct() throws InterruptedException {
		SearchingSortingFiltering = YourAccount.VerifySearch(proper.getProperty("product"));
		SearchingSortingFiltering.searchproduct();
		Thread.sleep(4000);
		SearchingSortingFiltering.getAllproducts();
	}

	@Test(priority = 4)
	public void verifysortingFunctionality() throws InterruptedException {
		PomSearchingSortingFiltering SearchingSortingFiltering = new PomSearchingSortingFiltering();
		SearchingSortingFiltering = YourAccount.VerifySearch(proper.getProperty("product"));
		SearchingSortingFiltering.searchproduct();
		Thread.sleep(4000);
		SearchingSortingFiltering.verifysort();
	}

	@Test(priority = 5)
	public void verifyFilterfunctionality() throws InterruptedException {
		PomSearchingSortingFiltering SearchingSortingFiltering = new PomSearchingSortingFiltering();
		SearchingSortingFiltering = YourAccount.VerifySearch(proper.getProperty("product"));
		SearchingSortingFiltering.searchproduct();
		Thread.sleep(4000);
		SearchingSortingFiltering.verifyfilter();
	}

	@Test(priority = 6)
	public void verifyPaginationfunctionality() throws InterruptedException {
		PomSearchingSortingFiltering SearchingSortingFiltering = new PomSearchingSortingFiltering();
		SearchingSortingFiltering = YourAccount.VerifySearch(proper.getProperty("product1"));

		SearchingSortingFiltering.verifypagination();
	}

	@Test(priority = 7)
	public void verifyfindDuplicatesinPages() throws InterruptedException {
		PomSearchingSortingFiltering SearchingSortingFiltering = new PomSearchingSortingFiltering();
		SearchingSortingFiltering = YourAccount.VerifySearch(proper.getProperty("product1"));

		SearchingSortingFiltering.findDuplicatesinPages();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	

}
