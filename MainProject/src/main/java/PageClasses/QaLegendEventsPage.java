package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendEventsPage {
	WebDriver driver;
	//@FindBy(xpath = "(//a[@title='Add event'])[2]")
	@FindBy(xpath = "(//div[@class='title-button-group']//a)[1]")
	WebElement addevent;
	@FindBy(id = "title")
	WebElement eventtitle;
	@FindBy(id = "description")
	WebElement eventdescription;
	@FindBy(id = "start_date")
	WebElement eventstartdatefield;
	@FindBy(xpath = "//td[@class='today day']")
	WebElement eventstarttoday;
	@FindBy(id = "start_time")
	WebElement eventstarttime;
	@FindBy(id = "end_date")
	WebElement eventenddate;
	@FindBy(xpath = "//input[@id='end_time']")
	WebElement eventendtime;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement eventsave;
	@FindBy(xpath = "//label[text()='End date']")
	WebElement clickanywhere;
	
	
	
	
	public QaLegendEventsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	public void createAnEvent(String title,String description,WebDriver driver,String enddate) {
		PageUtilities.clickOnElement(addevent);
		PageUtilities.enterText(eventtitle, title);
		PageUtilities.enterText(eventdescription, description);
		PageUtilities.clickOnElement(eventstartdatefield);
		PageUtilities.clickOnElement(eventstarttoday);
		PageUtilities.clickOnElement(eventstarttime);
		PageUtilities.clickOnElement(clickanywhere);
		PageUtilities.enterText(eventenddate, enddate);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.clickOnElement(eventendtime);
		PageUtilities.clickOnElement(clickanywhere);
		PageUtilities.clickOnElement(eventsave);
	}
	

}
