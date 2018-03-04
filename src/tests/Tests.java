package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import models.Order;
import pages.LogIn;
import pages.ViewAllOrders;
import utilities.Browser;

public class Tests {

	private WebDriver driver;
	Order order ;
	ViewAllOrders view;
	LogIn login;
	
	
	@BeforeClass
	public void setup() {
		driver = Browser.getDriver();
		order = new Order();
		view = new ViewAllOrders();
		login = new LogIn();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
	}
	
	@Test(priority = 1)
	public void loginTest() {
		login.login();
		Assert.assertTrue("Web Orders".equals(login.title));
	}
	
	@Test(priority = 3)
	public void valueOfCells() {
		view.readValues();
	}
	
	
	
	
	
	
	
	
}
