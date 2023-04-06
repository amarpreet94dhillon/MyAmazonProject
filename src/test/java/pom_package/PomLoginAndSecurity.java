package pom_package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class PomLoginAndSecurity extends BaseClass {
	@FindBy(partialLinkText ="Login & security")WebElement LoginAndSecurity;
	@FindBy(id = "ap_password")WebElement Password;
	@FindBy(id = "signInSubmit")WebElement signinSumbit;
	@FindBy(css = ".a-expander-container") WebElement Securitycheck;

	public String verify() {
		return driver.getTitle();
	}

	public PomLoginAndSecurity() {
		PageFactory.initElements(driver, this);

	}

	public void SecurityCheck(String password) {
		Password.sendKeys(password);
		signinSumbit.click();
		Securitycheck.isDisplayed();
	}


}
