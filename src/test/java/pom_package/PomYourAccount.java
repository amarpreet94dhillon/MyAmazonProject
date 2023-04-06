package pom_package;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_package.BaseClass;

public class PomYourAccount extends BaseClass{
	//object repository
	@FindBy(css ="#nav-link-accountList")WebElement AccountandLists;//driver.findElement(By.
	@FindBy(linkText ="Your Account")WebElement YourAccount;
	@FindBy(id ="nav-link-accountList-nav-line-1")WebElement userNameLabel; 
	@FindBy(partialLinkText ="Your Orders")WebElement YourOrders;
	@FindBy(xpath ="//h2[contains(text(),'Login & security')]")WebElement LoginAndSecurity;
	@FindBy(partialLinkText ="Your Addresses")WebElement YourAddress;
	@FindBy(partialLinkText ="Your Payments")WebElement YourPayments;
	@FindBy(id ="twotabsearchtextbox")WebElement SearchBox;
	@FindBy(id ="//span[@id='nav-cart-count']")WebElement CartButton;
			  			
		//initiate page elements
		public PomYourAccount() {
		PageFactory.initElements(driver,this);//initElement is a static method in page factory
		//this keyword helps to convert local into global driver
		}
		
			public void MouseHover() throws InterruptedException {
			action=new Actions(driver);
			action.moveToElement(AccountandLists).build().perform();//to implement actions required
			Thread.sleep(2000);
			action.moveToElement(YourAccount).click().build().perform();
			//YourAccount.click();
			Thread.sleep(2000);
			}
			public String getNameLabel() {
				return userNameLabel.getText();
			}
			public boolean verifyNameLabel() {
				return userNameLabel.isDisplayed();
			}
			public PomYourOrders ClickYourOrders() throws InterruptedException {
				YourOrders.click();
				return new PomYourOrders();
			}

			public PomYourAddress ClickYourAddress() {
				YourAddress.click();
				return ClickYourAddress();
			}
			public PomYourPayment ClickYourPayments() {
				YourPayments.click();
				return new PomYourPayment();

			}

			public PomLoginAndSecurity ClickLoginAndSecurity() {
				LoginAndSecurity.click();
				return ClickLoginAndSecurity();
			}

			public PomSearchingSortingFiltering VerifySearch(String product) {
				SearchBox.click();
				SearchBox.sendKeys(product);
				return new PomSearchingSortingFiltering();
		
			}
			public PomShoppingCart ClickOnCart() {
				CartButton.click();
				return new PomShoppingCart();
				
			}

		}
			
			

