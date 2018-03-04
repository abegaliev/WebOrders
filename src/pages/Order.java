package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Browser;

public class Order {

	private static WebDriver driver = Browser.getDriver();
	
	public Order() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantityField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtName")
	public WebElement customerName;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement streetField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement cityField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement stateField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zipCodeField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNumber;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox1a")
	public WebElement expDate;
	
	@FindBy(id="//table[@id='ctl00_MainContent_fmwOrder_cardList']//input")
	public List<WebElement> cardTypes;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement productDropDown;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement processBtn;
	
	@FindBy(xpath = "//input[@type='reset']")
	public WebElement resetBtn;
	
	public void placeOrder(models.Order order) {
		
		
		
	}
	
	public void selectProduct(String targetProd) {
		Select select = new Select(productDropDown);
		select.selectByVisibleText(targetProd);
	}
	
//	public void chooseCardType(String tardet) {
//		for(WebElement elem : )
//	}
	
	
	
	
}
