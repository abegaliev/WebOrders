package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

	private static WebDriver driver;
	
	/**
	 * Sets up the driver and returns it
	 * 
	 * @return driver;
	 */
	public static final WebDriver getDriver() {
		
		if(driver == null || ((RemoteWebDriver)driver).getSessionId() == null) {
		
		String browser = Config.getProperty("browser");

		switch(browser) {
		case "chrome":
			String chromePath = Config.getProperty("chromePath");
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			break;
		case "firefox":
			String ffPath = Config.getProperty("ffPath");
			System.setProperty("webdriver.gecko.driver", ffPath);
			driver = new FirefoxDriver();
			break;
			
		default:
			System.out.println("=============Default browser is Chrome==============");
			chromePath = Config.getProperty("chromePath");
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return driver;
	
		}else {
			return driver;
		}
	
		
	}
	
}
