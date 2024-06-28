package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendClientPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement addclientbutton;
	@FindBy(xpath = "//input[@id='company_name']")
	WebElement companynamefield;
	@FindBy(xpath = "//span[@class='fa fa-check-circle']")
	WebElement clientsavebutton;
	@FindBy(xpath = "//div[@id='client-table_filter']//input")
	WebElement clientsearch;
	@FindBy(xpath = "//table[@id='client-table']//a")
	WebElement clientsearchresult;
	
	
	
	public QaLegendClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void createAClient(String companyname) {
		PageUtilities.clickOnElement(addclientbutton);
		PageUtilities.enterText(companynamefield, companyname);
		PageUtilities.clickOnElement(clientsavebutton);
	}
	public void searchClient(String searchname) {
		PageUtilities.clickOnElement(clientsearch);
		PageUtilities.enterText(clientsearch, searchname);
	}
	public String getClientCompany() {
		String getcompanyname=PageUtilities.getElementText(clientsearchresult);
		return getcompanyname;
	}
}
