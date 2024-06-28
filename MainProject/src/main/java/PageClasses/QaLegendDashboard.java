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

}
