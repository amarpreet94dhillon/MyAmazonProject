package pom_package;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base_package.BaseClass;

public class PomSearchingSortingFiltering extends BaseClass{
	@FindBy(id = "twotabsearchtextbox")WebElement SearchButton;
	@FindBy(xpath = "//select[@id='searchDropdownBox']")
	WebElement category;
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchsumbitbutton;
	@FindBy(xpath = "//*[@id=\"acrPopover\"]")
	WebElement review;
	@FindBy(xpath = "//span[contains(text(),'Mens Force Relaxed Fit Midweight Short Sleeve Pock')]")
	WebElement productresult;
	@FindBy(xpath = "//span[contains(text(),'results for')]")
	WebElement searchresult;
	@FindBy(xpath = "//div[@class='sg-col-inner']//div[@data-index='%d']")
	WebElement Nthproduct;
	@FindBy(xpath = "//div[@data-component-type='s-search-result']")
	List<WebElement> allproducts;
	//60 element in the page
	@FindBy(xpath = "//span[contains(text(),\"Women's Clothing\")]")
	WebElement department;
	@FindBy(xpath = "//ul//li[@id='p_72/11192170011']")
	WebElement customerReview;
	@FindBy(xpath = "//*[@id=\"p_89/addidas\"]/span/a/span")
	WebElement Addidas;
	@FindBy(xpath = "//span[contains(text(),\"Today's Deals\")]")
	WebElement TodaySDeals;
	@FindBy(xpath = "//span[@class='s-pagination-strip']//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
	WebElement NextPage;
	@FindBy(xpath = "//*[@id=\\\"search\\\"]/div[1]/div[1]/div/span[3]/div[2]/div[35]/div/div/span/span[2]")
	WebElement LastPage;
	@FindBy(xpath = "//span//span[@class='s-pagination-item s-pagination-next s-pagination-disabled ']")
	WebElement DisabledNextPage;
	@FindBy(xpath = "//div//span[@class='s-pagination-strip']//span[@class='s-pagination-item s-pagination-selected']")
	List<WebElement> CurrentPage;
	@FindBy(xpath = "//div//span//div[@data-component-type='s-search-result']")
	List<WebElement> productspage1;
	@FindBy(xpath = "//div//span//div[@data-component-type='s-search-result']")
	List<WebElement> consecutivePage;

	
	public PomSearchingSortingFiltering() {
		PageFactory.initElements(driver, this);
	}
	public String verify() {
		return driver.getTitle();
	}

	public void searchproduct() throws InterruptedException {

		Select categoryDropdown = new Select(category);
		Thread.sleep(1000);
		categoryDropdown.selectByIndex(11);
		searchsumbitbutton.click();
		String result = searchresult.getText();
		System.out.println("search result is:" + result);
	}

	public void getNthproduct(String productno) {
		
		// dynamic element id for products
		String xpathExpression = String.format("//div//span//div[@data-component-type=\"s-search-result\"][@data-cel-widget='%s']", productno);
		String nthproduct = driver.findElement(By.xpath(xpathExpression)).getText();

		// String nthproduct=Nthproduct.getText();
		System.out.println("product detail is-->" + nthproduct);
		System.out.println("	");
	}

	public void getAllproducts() throws InterruptedException {
		List<WebElement> allproducts = driver
				.findElements(By.xpath("//div//span//div[@data-component-type='s-search-result']"));


		// using Iterating method(2nd method)
		Iterator<WebElement> iterateallproduct = allproducts.iterator();
		while (iterateallproduct.hasNext()) {
			WebElement product = iterateallproduct.next();
			System.out.println(product.getText() + "product url is->" + product.getAttribute("href"));
			System.out.println("	");
		}

		// display product count
		System.out.println("Count of Featured product in the page is:" + allproducts.size());
	}
	public void verifysort() throws NumberFormatException {
		Select s = new Select(driver.findElement(By.xpath("//select[@id='s-result-sort-select']")));
		s.selectByValue("price-asc-rank");
		try {
			List<WebElement> priceofallproduct = driver
					.findElements(By.xpath("//div[@class='a-row a-size-base a-color-base']//span[@class='a-price']"));
			List<String> webSortedPrices = priceofallproduct.stream().map(R -> R.getText())
					.collect(Collectors.toList());
			List<String> mySortedPrices = priceofallproduct.stream().map(R -> R.getText())
					.sorted(Comparator.comparingInt(Integer::valueOf)).collect(Collectors.toList());
			Assert.assertEquals(webSortedPrices, mySortedPrices, "Should be sorted from lower to highest price");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("NumberFormatException is handled");
		}
	}

	public void verifyfilter() throws InterruptedException {
		department.click();
		Thread.sleep(2000);
		customerReview.click();
		Thread.sleep(2000);
		Addidas.click();
		Thread.sleep(2000);

		List<String> originalprodList1 = allproducts.stream().map(R -> R.getText()).collect(Collectors.toList());
		System.out.println("	");
		System.out.println(originalprodList1);
		System.out.println("	");
		System.out.println("Count of Filtrered product in the page is:" + originalprodList1.size());
		System.out.println("	");
	}

	
	public void verifypagination() throws InterruptedException {
		searchsumbitbutton.click();
		// null or empty string
		String last_page = "";
		try {
			last_page = LastPage.getText();
		} catch (NoSuchElementException ex) {
			System.out.println("last page number not found");
		}
		System.out.println("Last page number : " + last_page);
		int last = Integer.parseInt(last_page);
		System.out.println("last page number in integer:" + last);
		int count = 1, totalproductcount = 0;
		// locating next button
		// this for loop will run 1 to last page,number of times and it will increase
		// by1
		for (int i = 1; i <= last; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,4000)");// this will scroll window by 1000 pixel in vertical
			Thread.sleep(5000);
			List<WebElement> allproducts1 = driver
					.findElements(By.xpath("//div//span//div[@data-component-type='s-search-result']"));
			// display product count
			int result1 = allproducts1.size();
			// product count of page [1] is: 60
			System.out.println("product count of page [" + count + "] is :" + result1);
			totalproductcount = totalproductcount + result1;// 0+60=60,60+60=120,....
			System.out.println("total product count of  [" + count + "] is :" + totalproductcount);
			System.out.println("	");

			try {
				Thread.sleep(1000); // nextpage.click();
				driver.findElement(By.xpath(
						"//span[@class='s-pagination-strip']//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"))
						.click();
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				System.out.println("next page not found");
			} catch (Exception a) {
				a.printStackTrace();
				System.out.println("next page not found");
			}
			count++;
		}
	}

	
	public void findDuplicatesinPages() throws InterruptedException {
		searchsumbitbutton.click();
	
		int consecutive_page = 2;
		int count = 1;
		int totalproductcount = 0;
		// locating next button
		// this for loop will run 1 to last page,number of times and it will increase by1
		for (int i = 1; i <= consecutive_page; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,4000)");// this will scroll window by 1000 pixel in vertical
			Thread.sleep(5000);
			List<WebElement> allproducts = driver.findElements(By.xpath("//div//span//div[@data-component-type='s-search-result']"));
			List<String> originalprodList = allproducts.stream().map(R -> R.getText()).collect(Collectors.toList());
			Set<String> uniqueproduct = new HashSet<>();
			Set<String> duplicateproduct = originalprodList.stream().filter(product -> !uniqueproduct.add(product))
					.collect(Collectors.toSet());
			System.out.println("product count of page [" + count + "] is :" + allproducts.size());
			System.out.println("unique product is:" + uniqueproduct.size());
			System.out.println("duplicate product is:" + duplicateproduct.size());
			totalproductcount = totalproductcount + allproducts.size();
			System.out.println("total product count of  [" + count + "] is :" + totalproductcount);
			System.out.println("	");
			
			try {
				Thread.sleep(1000); // nextpage.click();
				driver.findElement(By.xpath(
						"//span[@class='s-pagination-strip']//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']"))
						.click();

			} catch (NoSuchElementException e) {
				e.printStackTrace();
				System.out.println("next page not found");
			} catch (Exception a) {
				a.printStackTrace();
				System.out.println("next page not found");
			}
			count++;

		}

	}

}
