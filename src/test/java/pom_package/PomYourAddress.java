package pom_package;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base_package.BaseClass;

public class PomYourAddress extends BaseClass {
	@FindBy(partialLinkText ="Your Addresses")WebElement YourAddress;
	@FindBy(id = "ya-myab-plus-address-icon") WebElement AddAddress;//driver.findElement(By.
	@FindBy(id = "ya-myab-default-shipping-address-icon") WebElement DefaultAddress;
	@FindBy(id = "address-ui-widgets-enterAddressFullName") WebElement FullName;
	@FindBy(id = "address-ui-widgets-enterAddressPhoneNumber") WebElement phoneno;
	@FindBy(id = "address-ui-widgets-enterAddressLine1") WebElement Addressline1;
	@FindBy(id = "address-ui-widgets-enterAddressLine2") WebElement Addressline2;
	@FindBy(id = "address-ui-widgets-enterAddressCity") WebElement City;
	@FindBy(id = "address-ui-widgets-enterAddressPostalCode") WebElement Postalcode;
	@FindBy(css = "#address-ui-widgets-enterAddressStateOrRegion > span > span") WebElement Province;
	@FindBy(id = "address-ui-widgets-use-as-my-default") WebElement MakeDefaultAddress;
	@FindBy(id = "address-ui-widgets-form-submit-button-announce") WebElement AddressSubmit;

	public PomYourAddress() {
		PageFactory.initElements(driver, this);
	}
	public void AddingAddress(String name, String email, String addresslineA,
	String addresslineB, String city, String postal) throws InterruptedException 
	{
		AddAddress.click();
		FullName.sendKeys(name);
		phoneno.sendKeys(email);
		Addressline1.sendKeys(addresslineA);
		Addressline2.sendKeys(addresslineB);
		City.sendKeys(city);
		Select obj = new Select(Province);
		obj.selectByVisibleText("Ontario");
		Postalcode.sendKeys(postal);
		MakeDefaultAddress.click();
		AddressSubmit.click();
		Thread.sleep(2000);
	}

	public String verify() {
		return driver.getTitle();
	}

	public boolean verifyDefaultAddress() {
		return DefaultAddress.isDisplayed();
	}

	public boolean verifyAddAddress() {
		return AddAddress.isDisplayed();
	}
}
