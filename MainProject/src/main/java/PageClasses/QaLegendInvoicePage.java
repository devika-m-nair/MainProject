package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendInvoicePage {
	WebDriver driver;
	@FindBy(xpath = "(//div[@class='title-button-group']//a)[2]")
	WebElement addinvoicebutton;
	@FindBy(id = "invoice_due_date")
	WebElement invoiceduedatefield;
	@FindBy(xpath = "(//div[@id='s2id_invoice_client_id']//span)[1]")
	WebElement clientfield;
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	WebElement clientsearch;
	@FindBy(xpath = "//div[@class='select2-result-label']")
	WebElement clientsearchresult;
	@FindBy(xpath = "//span[@class='fa fa-check-circle']")
	WebElement saveinvoice;
	@FindBy(xpath = "//div[@id='page-content']//h1")
	WebElement invoiceid;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	WebElement addpaymentbutton;
	 @FindBy(xpath = "//input[@id='invoice_payment_date']")
	 WebElement invoicepaymentdate;
	 @FindBy(xpath = "//input[@id='invoice_payment_amount']")
	 WebElement invoicepaymentamount;
	 @FindBy(xpath = "(//div[@id='invoice-status-bar']//span)[2]")
	 WebElement invoicestatus;
	 
public QaLegendInvoicePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}





public void createAnInvoice(String duedate,String searchclient) {
	PageUtilities.clickOnElement(addinvoicebutton);
	PageUtilities.enterText(invoiceduedatefield, duedate);
	PageUtilities.enterKeyPress(driver);
	PageUtilities.clickOnElement(clientfield);
	PageUtilities.clickOnElement(clientsearch);
	PageUtilities.enterText(clientsearch, searchclient);
	PageUtilities.clickOnElement(clientsearchresult);
	PageUtilities.clickOnElement(saveinvoice);	
}
public String getInvoiceId() {
	String invoiceidgenerated=PageUtilities.getElementText(invoiceid);
	return invoiceidgenerated;
}
public void addPayment(String invoicepaymentdatedata,String paymentamountofinvoice) {
	PageUtilities.clickOnElement(addpaymentbutton);
	PageUtilities.enterText(invoicepaymentdate, invoicepaymentdatedata);
	PageUtilities.enterKeyPress(driver);
	PageUtilities.enterText(invoicepaymentamount, paymentamountofinvoice);
	PageUtilities.clickOnElement(saveinvoice);
}
public String getInvoiceStatus(WebDriver driver) throws InterruptedException {
	WaitUtility.waitForElementTextToBe(driver, invoicestatus, "Fully paid");
	String invoicestatusgenerated=PageUtilities.getElementText(invoicestatus);
	return invoicestatusgenerated;
}
}