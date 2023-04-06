package pom_package;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base_package.BaseClass;

public class PomYourOrders extends BaseClass {
	@FindBy(partialLinkText = "Orders")WebElement Orders;//driver.findElement(By.
	@FindBy(id= "time-filter")WebElement OrdersFilter;
	@FindBy(linkText = "Buy Again")WebElement BuyAgain;
	@FindBy(linkText = "Not Yet Shipped")WebElement NotYetShipped;
	@FindBy(linkText= "Cancelled Orders")WebElement CancelledOrders;

	public PomYourOrders() {
		PageFactory.initElements(driver, this);
	}	

	public String verify() {
		return driver.getTitle();
	}
	public void orderfilter1() {
		Select obj = new Select(OrdersFilter);
		obj.selectByVisibleText("past 3 months");
	}

	public void orderfilter2() {
		// Orders.click();
		Select obj = new Select(OrdersFilter);
		obj.selectByVisibleText("past 3 months");
	}

	public void orderfilter3() {
		// Orders.click();
		Select obj = new Select(OrdersFilter);
		obj.selectByValue("year-2022");
	}

	public void ClickonBuyAgain() {
		BuyAgain.click();
	}

	public void ClickonNotYetShipped() {
		NotYetShipped.click();
	}

	public void ClickonCancelledOrders() {
		CancelledOrders.click();
	}

}
