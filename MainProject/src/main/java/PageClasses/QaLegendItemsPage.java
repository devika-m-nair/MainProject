package PageClasses;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendItemsPage {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='title-button-group']//a")
	WebElement additemsbutton;
	@FindBy(xpath = "//input[@id='title']")
	WebElement itemstitle;
	@FindBy(xpath = "//input[@id='item_rate']")
	WebElement itemsrate;
	@FindBy(xpath = "//span[@class='fa fa-check-circle']")
	WebElement itemsavebutton;
	@FindBy(xpath = "(//div[@id='item-table_wrapper']//input)[3]")
	WebElement itemsearchbox;
	@FindBy(xpath = "(//table[@id='item-table']//td)[1]")
	WebElement searchtitleresult;
	@FindBy(xpath = "//a[@class='delete']")
	WebElement deleteitem;
	@FindBy(xpath = "//td[text()='No record found.']")
	WebElement noitemfound;
	
	public QaLegendItemsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void createAnItem(String itemtitle,String itemrate) {
		PageUtilities.clickOnElement(additemsbutton);
		PageUtilities.enterText(itemstitle, itemtitle);
		PageUtilities.enterText(itemsrate, itemrate);
		PageUtilities.clickOnElement(itemsavebutton);
	}
	public void searchForItemAdded(String itemsearchtitle) {
		PageUtilities.clickOnElement(itemsearchbox);
		PageUtilities.enterText(itemsearchbox, itemsearchtitle);	
	}
	public String getItemCreated() {
		String getitemtitle=PageUtilities.getElementText(searchtitleresult);
		return getitemtitle;
	}
	public void deleteItem() {
		PageUtilities.clickOnElement(deleteitem);
	}
	public String searchForDeletedItem() {
		String noitemfoundmessage=PageUtilities.getElementText(noitemfound);
		return noitemfoundmessage;
		
	}
}
