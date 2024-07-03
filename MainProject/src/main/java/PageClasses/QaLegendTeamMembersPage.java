package PageClasses;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendTeamMembersPage {
	WebDriver driver;
	@FindBy(xpath = "(//div[@class='title-button-group']//a)[3]")
	WebElement addteammemberbutton;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement memberfirstname;
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement memberlastname;
	@FindBy(xpath = "//button[@id='form-next']")
	WebElement nextbutton;
	@FindBy(xpath = "//input[@id='job_title']")
	WebElement jobtitle;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailfield;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@id='form-submit']")
	WebElement membersavebutton;
	@FindBy(xpath = "//input[@type='search']")
	WebElement teammembersearch;
	@FindBy(xpath = "(//table[@id='team_member-table']//td)[4]")
	WebElement searchresultemail;
	@FindBy(xpath = "//h1[text()='Team members']")
	WebElement pagetitle;
	
	public QaLegendTeamMembersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void createATeamMember(String firstname,String lastname,String jobtitlefield,String email,String password) {
		PageUtilities.clickOnElement(addteammemberbutton);
		PageUtilities.enterText(memberfirstname, firstname);
		PageUtilities.enterText(memberlastname, lastname);
		PageUtilities.clickOnElement(nextbutton);
		PageUtilities.enterText(jobtitle, jobtitlefield);
		PageUtilities.clickOnElement(nextbutton);
		PageUtilities.enterText(emailfield, email);
		PageUtilities.enterText(passwordfield, password);
		PageUtilities.clickOnElement(membersavebutton);
	}
	public void searchForTeamMember(WebDriver driver,String memberemail) throws InterruptedException {
		//WaitUtility.waitForAnElementToBeVisible(driver, teammembersearch);
		//WaitUtility.waitForElementToBeClickable(driver, teammembersearch);
		Thread.sleep(2000);
		PageUtilities.clickOnElement(teammembersearch);
		PageUtilities.enterText(teammembersearch, memberemail);
	}
	public String getMemberEmailId() {
		String getemail=PageUtilities.getElementText(searchresultemail);
		return getemail;
	}

}
