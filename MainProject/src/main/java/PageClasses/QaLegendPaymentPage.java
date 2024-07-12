package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendPaymentPage {
	WebDriver driver;
	@FindBy(xpath = "//input[@type='search']")
	WebElement paymentsearch;
	@FindBy(xpath = "//table[@id='monthly-invoice-payment-table']//a")
	WebElement searchedinvoice;
	@FindBy(xpath = "(//div[@id='page-content']//button)[1]")
	WebElement actionsbutton;
	@FindBy(xpath = "(//div[@id='page-content']//a)[2]")
	WebElement downloadpdf;
	
	
	
	
	
	

	public QaLegendPaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	


public void searchForInvoice(String invoiceid) {
	PageUtilities.clickOnElement(paymentsearch);
	PageUtilities.enterText(paymentsearch, invoiceid);
}
public void downloadTheInvoice() {
	PageUtilities.clickOnElement(searchedinvoice);
	PageUtilities.clickOnElement(actionsbutton);
	PageUtilities.clickOnElement(downloadpdf);
	
	
	
}
}
