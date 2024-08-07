
package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendMessagePage {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Compose']")
	WebElement composebutton;
	@FindBy(id = "s2id_to_user_id")
	WebElement tosend;
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	WebElement tosendsearchbox;
	@FindBy(xpath = "//div[@class='select2-result-label']")
	WebElement toperson;
	@FindBy(xpath = "//input[@id='subject']")
	WebElement messagesubject;
	@FindBy(xpath = "//textarea[@id='message']")
	WebElement messagedescription;
	@FindBy(xpath = "//span[@class='fa fa-send']")
	WebElement sendmessage;
	@FindBy(xpath = "//a[text()='Sent items']")
	WebElement senditemsmenu;
	@FindBy(xpath = "//input[@id='search-messages']")
	WebElement searchsendmessage;
	@FindBy(xpath = "//div[@class='media-body']")
	WebElement searchresult;
	@FindBy(xpath = "(//div[@id='message-details-section']//p)[2]")
	WebElement messagesentbody;
	public QaLegendMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterAndSendMessage(String senduser,String subject,String decriptionmessage) {
		PageUtilities.clickOnElement(composebutton);
		PageUtilities.clickOnElement(tosend);
		PageUtilities.enterText(tosendsearchbox, senduser);
		PageUtilities.clickOnElement(toperson);
		PageUtilities.enterText(messagesubject, subject);
		PageUtilities.enterText(messagedescription, decriptionmessage);
		PageUtilities.clickOnElement(sendmessage);
	} 
	
	public void searchForSendMessage(String sub) {
		WaitUtility.waitForElementToBeClickable(driver, senditemsmenu);
		PageUtilities.clickOnElement(senditemsmenu);
		PageUtilities.clickOnElement(searchsendmessage);
		PageUtilities.enterText(searchsendmessage, sub);
		PageUtilities.clickOnElement(searchresult);
		
	}
	public String getSendMessage() {
		String getmessage=PageUtilities.getElementText(messagesentbody);
		return getmessage;
	}
}
