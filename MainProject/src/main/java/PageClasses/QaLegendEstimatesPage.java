package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendEstimatesPage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Estimate List']")
	WebElement estimatelist;
	@FindBy(xpath = "//a[@title='Add estimate']")
	WebElement addestimate;
	@FindBy(id = "estimate_date")
	WebElement estimatedate;
	@FindBy(id = "valid_until")
	WebElement validtilldate;
	@FindBy(xpath = "(//a[@class='select2-choice']//span)[5]")
	WebElement clientfield;
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	WebElement clientsearchfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveestimate; 
	@FindBy(xpath = "//div[@id='page-content']//button")
	WebElement actionsbutton;
	@FindBy(xpath = "(//ul[@class='dropdown-menu']//a)[4]")
	WebElement markassent;
	@FindBy(xpath = "//span[text()='Sent']")
	WebElement sentstatuscheck;
	
	
	public QaLegendEstimatesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void createAnEstimate(String datestimate,String validdate,String clientname,WebDriver driver) {
		PageUtilities.clickOnElement(estimatelist);
		PageUtilities.clickOnElement(addestimate);
		PageUtilities.enterText(estimatedate, datestimate);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.enterText(validtilldate, validdate);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.clickOnElement(clientfield);
		PageUtilities.enterText(clientsearchfield, clientname);
		PageUtilities.enterKeyPress(driver);
		PageUtilities.clickOnElement(saveestimate);
	}
	public void markassent(WebDriver driver){
		WaitUtility.waitForElementToBeClickable(driver, actionsbutton);
		PageUtilities.clickOnElement(actionsbutton);
		PageUtilities.clickOnElement(markassent);
	}
	public String getsentstatus() {
		WaitUtility.waitForElementTextToBe(driver, sentstatuscheck, "Sent");
		String getstatus=PageUtilities.getElementText(sentstatuscheck);
		return getstatus;
	}

}
