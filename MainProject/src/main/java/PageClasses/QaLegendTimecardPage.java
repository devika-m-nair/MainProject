package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendTimecardPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement addtimemanuallybutton;
	@FindBy(xpath = "(//div[@class='form-group']//span)[1]")
	WebElement teammemberfield;
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	WebElement teammembersearch;
	@FindBy(xpath = "//input[@id='in_date']")
	WebElement indate;
	@FindBy(xpath = "//td[@class='today day']")
	WebElement currentday;
	@FindBy(xpath = "//input[@id='in_time']")
	WebElement intime;
	@FindBy(xpath = "//input[@id='out_date']")
	WebElement outdate;
	@FindBy(xpath = "//input[@id='out_time']")
	WebElement outtime;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement savebutton;
	@FindBy(xpath = "//h4[text()='Add time manually']")
	WebElement clickelement;
	@FindBy(xpath = "//span[text()='Excel']")
	WebElement exceldownload;
	
	
	
	
	public QaLegendTimecardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	public void addATimeManully(String teammember,String dateout) {
		PageUtilities.clickOnElement(addtimemanuallybutton);
		PageUtilities.clickOnElement(teammemberfield);
		PageUtilities.enterText(teammembersearch, teammember);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.clickOnElement(indate);
		PageUtilities.clickOnElement(currentday);
		PageUtilities.clickOnElement(intime);
		PageUtilities.clickOnElement(clickelement);
		PageUtilities.enterText(outdate, dateout);
		PageUtilities.clickOnElement(outtime);
		PageUtilities.clickOnElement(clickelement);
		PageUtilities.clickOnElement(savebutton);
	}
	public void downloadTheExcelOfListingScreen() {
		WaitUtility.waitForElementToBeClickable(driver, exceldownload);
		PageUtilities.clickOnElement(exceldownload);
		
	}
	

}
