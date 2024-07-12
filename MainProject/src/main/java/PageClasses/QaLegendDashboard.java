package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendDashboard {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement dashboardmenu;
	@FindBy(xpath = "//span[text()='Events']")
	WebElement eventsmenu;
	@FindBy(xpath = "//span[text()='Notes']")
	WebElement notesmenu;
	@FindBy(xpath = "//span[text()='Messages']")
	WebElement messagesmenu;
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement clientsmenu;
	@FindBy(xpath = "//span[text()='Projects']")
	WebElement projectsmenu;
	@FindBy(xpath = "//span[text()='All Projects']")
	WebElement allprojectssubmenu;
	@FindBy(xpath = "//span[text()='Items']")
	WebElement itemsmenu;
	@FindBy(xpath = "//span[text()='Invoices']")
	WebElement invoicemenu;
	@FindBy(xpath = "//span[text()='Tickets']")
	WebElement ticketsmenu;
	@FindBy(xpath = "//span[text()='Team members']")
	WebElement teammembersmenu;
	@FindBy(xpath = "//a[@id='user-dropdown-icon']")
	WebElement profileicon;
	@FindBy(xpath = "//span[text()='Estimates']")
	WebElement estimatesmenu;
	@FindBy(xpath = "//span[text()='Finance']")
	WebElement financemenu;
	@FindBy(xpath = "//span[text()='Payments']")
	WebElement paymentmenu;
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement leavemenu;
	@FindBy(xpath = "//span[text()='Time cards']")
	WebElement timecardsmenu;
	
	public QaLegendDashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickOnNotesMenu() {
		PageUtilities.clickOnElement(notesmenu);
	}
	public void clickOnMessageMenu() {
		PageUtilities.clickOnElement(messagesmenu);
	}
	public void clickOnClientMenu() {
		PageUtilities.clickOnElement(clientsmenu);
	}
	public void clickOnAllProjectsSubMenu() {
		PageUtilities.clickOnElement(projectsmenu);
		PageUtilities.clickOnElement(allprojectssubmenu);
	}
	public void clickOnItemsMenu() {
		PageUtilities.clickOnElement(itemsmenu);
	}
	public void clickOnInvoiceMenu() {
		PageUtilities.clickOnElement(invoicemenu);
	}
	public void clickOnTicketsMenu() {
		PageUtilities.clickOnElement(ticketsmenu);
	}
	public void clickOnTeamMembersMenu() {
		PageUtilities.clickOnElement(teammembersmenu);
	}
	public void clickOnProfileIcon() {
		PageUtilities.clickOnElement(profileicon);
	}
	public void clickOnEstimatesMenu() {
		PageUtilities.clickOnElement(estimatesmenu);
	}
	public void clickOnPaymentMenu() {
		PageUtilities.clickOnElement(financemenu);
		PageUtilities.clickOnElement(paymentmenu);
	}
	public void clickOnEventMenu() {
		PageUtilities.clickOnElement(eventsmenu);
	}
	public void clickOnLeaveMenu() {
		PageUtilities.clickAnElementUsingJavaScriptExe(driver, leavemenu);
		//PageUtilities.clickOnElement(leavemenu);
	}
	public void cLickOnTimecards() {
		PageUtilities.clickAnElementUsingJavaScriptExe(driver, timecardsmenu);
	}
}
