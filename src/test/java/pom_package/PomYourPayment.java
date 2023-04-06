package pom_package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base_package.BaseClass;

public class PomYourPayment extends BaseClass{
	@FindBy(partialLinkText = "Your Payments")WebElement YourPayment; 
	@FindBy(linkText = "Wallet")WebElement wallet;
	@FindBy(css = ".a-button-input")WebElement AddAPayment;
	@FindBy(css = ".a-button-input")WebElement AddACreditOrDebitCard;
	@FindBy(name = "addCreditCardNumber")WebElement CardNumber;
	@FindBy(id = "pp-zsZvT7-18")WebElement NameOnCard;
	@FindBy(xpath = "//*[@id=\"pp-CJsKUh-22\"]/span/span")WebElement ExpiryMM1;
	@FindBy(xpath = "//*[@id=\"pp-CJsKUh-23\"]/span/span")WebElement ExpiryYY1;
	@FindBy(name = "addCreditCardVerificationNumber")WebElement CVV;
	@FindBy(xpath = "//*[@id=\"pp-zTom2R-31\"]/span/input")WebElement AddYourCard;

	public PomYourPayment() {
		PageFactory.initElements(driver, this);
	}
	public String verify() {
		return driver.getTitle();
	}

	public void AddCard(String cardnumber, String nameoncard, String CSV) throws InterruptedException {
		YourPayment.click();
		wallet.click();
		AddAPayment.click();
		AddACreditOrDebitCard.click();
		CardNumber.sendKeys(cardnumber);
		NameOnCard.sendKeys(nameoncard); 
		Select obj = new Select(ExpiryMM1); 
		obj.selectByIndex(4);
		Select obj2 = new Select(ExpiryYY1);
		obj2.selectByIndex(4);
		CVV.sendKeys(CSV);
		Thread.sleep(1000);
		AddYourCard.click();

	}

}
