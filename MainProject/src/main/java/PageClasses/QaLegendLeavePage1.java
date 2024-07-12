package PageClasses;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.DateUtility;
import Utilities.PageUtilities;

public class QaLegendLeavePage1 {
	WebDriver driver;
	@FindBy(xpath = "(//div[@class='title-button-group']//a)[2]")
	WebElement assignleavebutton;
	@FindBy(xpath = "(//form[@id='leave-form']//span)[1]")
	WebElement teammemberfield;
	@FindBy(xpath = "(//div[@id='select2-drop'])//input")
	WebElement teammembersearch;
	@FindBy(xpath = "(//div[@id='s2id_leave_type_id']//span)[1]")
	WebElement leavetypefield;
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	WebElement leavetype;
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	WebElement leavetypesearch;
	@FindBy(id = "single_date")
	WebElement leavedate;
	@FindBy(xpath = "//textarea[@name='reason']")
	WebElement leavereason;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement leavesubmit;
	
	
	
	public QaLegendLeavePage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void assigningALeaveForMember(String membername,WebDriver driver,String leavetype,String reason) {
		PageUtilities.clickOnElement(assignleavebutton);
		PageUtilities.clickOnElement(teammemberfield);
		PageUtilities.enterText(teammembersearch, membername);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.clickOnElement(leavetypefield);
		PageUtilities.enterText(leavetypesearch, leavetype);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.enterText(leavedate, DateUtility.getCurrentDate());
		PageUtilities.enterText(leavereason, reason);
		PageUtilities.clickOnElement(leavesubmit);
	}

}
