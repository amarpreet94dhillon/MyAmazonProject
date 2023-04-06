package base_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import utility.TimeUtils;

public class BaseClass {
	//Browser info
	//URL info
	public static WebDriver driver;
	public static Actions action;
	public static Properties proper = new Properties();
	//Step1
		public BaseClass() {
			try {
				FileInputStream file = new FileInputStream("C:\\Users\\amarp\\eclipse-workspace\\Amazon_Ecommerce_Framework\\src\\test\\java\\environment_variable\\Config.properties");
				proper.load(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException a) {
				a.printStackTrace();
			}
		}
		//Step 2
		public static void initiation() {
			String browserName=proper.getProperty("browser");
			if(browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
				driver= new ChromeDriver();
			}
			else if(browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
				driver= new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUtils.timepage));
			driver.get(proper.getProperty("url"));
			driver.navigate().refresh();
		}


}
