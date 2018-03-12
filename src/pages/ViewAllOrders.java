package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import models.Order;
import utilities.Browser;
import utilities.FileUtil;

public class ViewAllOrders {

	private static WebDriver driver = Browser.getDriver();
	private int index=1;
	
	
	public ViewAllOrders() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@class='SampleTable']//th[@scope='col']")
	public List<WebElement> columns;
	
	@FindBy(xpath="//table[@class='SampleTable']//tr")
	public List<WebElement> rows;
	
	@FindBy(xpath = "//a[@href='Process.aspx']")
	public WebElement ordersLink;
	
	@FindBy(xpath = "//a[@href='Default.aspx']")
	public WebElement viewAllOrdersLink;
	
	
	public String getValueOfCell(Order order, String targetColumn) {
		
		int indOfColumn = getIndex(columns, targetColumn) + 1;
		int indOfRow = getIndex(rows, order.getName()) + 1;
		
		WebElement valueEl = driver.findElement(By.xpath(
				"(//table[@class='SampleTable']//tr["+ indOfRow +"])//td["+ indOfColumn +"]"));
		String valueOfCell = valueEl.getText();
		
		return valueOfCell;
	}
	
	
	/**
	 * Returns index of target String  in the given List of WebElements.
	 * 
	 * @param list
	 * @param target
	 * @return
	 */
	public static int getIndex(List<WebElement> list, String target) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains(target)) {
				index = i;
			}
		}
		return index;
	}
	
	
	public void readValues() {
		index++;
		String text = "";
		
		for( ; index < rows.size(); index++) {
			text += rows.get(index).getText()+"\n";
		}
		
		System.out.println(text);
		FileUtil.writeFile("/Users/almazbekbegaliev/Desktop/Cybertek", text);
	
	}
	
	
	
	
	
}
