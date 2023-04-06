package pom_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import base_package.BaseClass;

public class SingletonWebdriver extends BaseClass {
	   public static WebDriver driver;

	   public static WebDriver getInstance() {
	     if (driver == null) {
	       driver = new FirefoxDriver();
	     }
	     return driver;
	   }

}
