package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LogIn;
import pages.ViewAllOrders;
import utilities.Browser;

public class Tests {

	private WebDriver driver;
	pages.Order orderPage ;
	ViewAllOrders view;
	pages.LogIn login;
	
	
	@BeforeClass
	public void setup() {
		driver = Browser.getDriver();
		orderPage = new pages.Order();
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
	
	@Test(priority = 4)
	public void verifyOrder() {
		models.Order order = new models.Order("FamilyAlbum", "5", "John Smith", "California", "Huston", "TX", "50577", "Visa", "79867344", "12/22");
		view.ordersLink.click();
		orderPage.placeOrder(order);
		view.viewAllOrdersLink.click();
		
		String actualName = view.getValueOfCell(order, "Name");
		String actualProd = view.getValueOfCell(order, "Product");
		String actualNumOfOrders = view.getValueOfCell(order, "#");
		String actualDate = view.getValueOfCell(order, "Date");
		String actualStreet = view.getValueOfCell(order, "Street");
		String actualCity = view.getValueOfCell(order, "City");
		String actualState = view.getValueOfCell(order, "State");
		String actualZip = view.getValueOfCell(order, "Zip");
		String actualCardType = view.getValueOfCell(order, "Card");
		String actualCardNum = view.getValueOfCell(order, "Card Number");
		String actualExp = view.getValueOfCell(order, "Exp");
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(actualName, order.getName());
		soft.assertEquals(actualProd, order.getProduct());
		soft.assertEquals(actualNumOfOrders, order.getQuantity());
		soft.assertEquals(actualDate, order.getData());
		soft.assertEquals(actualStreet, order.getStreet());
		soft.assertEquals(actualCity, order.getCity());
		soft.assertEquals(actualState, order.getState());
		soft.assertEquals(actualZip, order.getZip());
		soft.assertEquals(actualCardType, order.getCardType());
		soft.assertEquals(actualCardNum, order.getCardNumber());
		soft.assertEquals(actualExp, order.getExpDate());
	
		
	}
	
	
	
	
	
	
	
	
	
}
