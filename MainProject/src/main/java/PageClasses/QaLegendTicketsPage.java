package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendTicketsPage {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='title-button-group']//a")
	WebElement addticketbutton;
	@FindBy(xpath = "//input[@id='title']")
	WebElement tickettitle;
	@FindBy(xpath = "//div[@id='s2id_client_id']")
	WebElement ticketclient;
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	WebElement ticketclientsearch;
	@FindBy(xpath = "//span[@class='select2-match']")
	WebElement ticketclientsearchresult;
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement ticketdescription;
	@FindBy(xpath = "//span[@class='fa fa-check-circle']")
	WebElement ticketsavebutton;
	@FindBy(xpath = "//input[@type='search']")
	WebElement ticketlistingsearch;
	@FindBy(xpath = "//span[@class='dropdown inline-block']//button")
	WebElement statusupdatedropdown;
	@FindBy(xpath = "(//ul[@class='dropdown-menu pull-right']//a)[2]")
	WebElement markascomplete;
	@FindBy(xpath = "//span[text()='Closed']")
	WebElement ticketstatuscheck;
	
	
	
	
	public QaLegendTicketsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	public void addATicket(String title,String clientname,WebDriver driver,String description) {
		PageUtilities.clickOnElement(addticketbutton);
		PageUtilities.enterText(tickettitle, title);
		PageUtilities.clickOnElement(ticketclient);
		PageUtilities.enterText(ticketclientsearch, clientname);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.enterText(ticketdescription, description);
		PageUtilities.clickOnElement(ticketsavebutton);
	}
	public void changeTheStatus(String titleticket) {
		PageUtilities.clickOnElement(ticketlistingsearch);
		PageUtilities.enterText(ticketlistingsearch, titleticket);
		PageUtilities.clickOnElement(statusupdatedropdown);
		PageUtilities.clickOnElement(markascomplete);
	}
	public String getStatusOfTicket() {
		String getstatus=PageUtilities.getElementText(ticketstatuscheck);
		return getstatus;
	}

}
