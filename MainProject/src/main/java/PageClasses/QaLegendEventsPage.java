package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QaLegendEventsPage {
	WebDriver driver;
	@FindBy(id = "Add event")
	WebElement addeventbutton;
	@FindBy(xpath = "//input[@id='title']")
	WebElement eventtitle;
	@FindBy(id = "description")
	WebElement eventdescription;
	@FindBy(id = "start_date")
	WebElement startdatefield;
	

}
