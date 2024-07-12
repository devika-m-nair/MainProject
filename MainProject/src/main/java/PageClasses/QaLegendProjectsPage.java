package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QaLegendProjectsPage {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='title-button-group']//a")
	WebElement addallprojectbutton;
	@FindBy(xpath = "//input[@id=\"title\"]")
	WebElement projecttitlefield;
	@FindBy(xpath = "//div[@class='form-group']//a")
	WebElement clientfield;
	@FindBy(xpath = "//input[@id='s2id_autogen6_search']")
	WebElement clientsearchoption;
	@FindBy(xpath = "//ul[@class='select2-results']//span")
	WebElement selectclient;
	@FindBy(xpath = "//span[@class='fa fa-check-circle']")
	WebElement saveallproject;
	@FindBy(xpath = "//input[@type='search']")
	WebElement projectsearch;
	@FindBy(xpath = "(//table[@id='project-table']//a)[2]")
	WebElement projectaddedtitle;



public QaLegendProjectsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}



public void addAProject(String titleofproject ,String clientname) {
	PageUtilities.clickOnElement(addallprojectbutton);
	PageUtilities.enterText(projecttitlefield, titleofproject);
	PageUtilities.clickOnElement(clientfield);
	PageUtilities.enterText(clientsearchoption, clientname);	
	PageUtilities.clickOnElement(selectclient);
	PageUtilities.clickOnElement(saveallproject);
}
public void searchProjectCreate(String searchtitle) {
	WaitUtility.waitForElementToBeClickable(driver, projectsearch);
	PageUtilities.clickOnElement(projectsearch);
	PageUtilities.enterText(projectsearch, searchtitle);
	
}
public String getCreatedProject() {
	String getprojecttitle=PageUtilities.getElementText(projectaddedtitle);
	return getprojecttitle;
}
}

