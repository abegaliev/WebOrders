package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Browser;

public class LogIn {

	private static WebDriver driver = Browser.getDriver();
	
	public LogIn() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="ctl00$MainContent$username")
	public WebElement emailField;
	
	@FindBy(id="ctl00_MainContent_password")
	public WebElement passwordField;
	
	@FindBy(id="ctl00_MainContent_login_button")
	public WebElement logInButton;
	
	public String title;
	
	public void login() {
		emailField.sendKeys("Tester");
		passwordField.sendKeys("test");
		logInButton.click();
		title = driver.getTitle();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
