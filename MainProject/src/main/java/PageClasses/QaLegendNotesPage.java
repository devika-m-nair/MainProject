package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendNotesPage {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='title-button-group']//a")
	WebElement addnotebutton;
	@FindBy(id = "title")
	WebElement titlefield;
	@FindBy(id = "description")
	WebElement descriptionfield;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement savenotesbutton;
	@FindBy(xpath = "//div[@id='note-table_filter']//input")
	WebElement notessearchbox;
	@FindBy(xpath = "(//a[@class='edit'])[1]")
	WebElement searchtitle;
	

	
	
	
	public QaLegendNotesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	public void addNotes(String notestitle,String notesdescription) {
		PageUtilities.clickOnElement(addnotebutton);
		PageUtilities.enterText(titlefield, notestitle);
		PageUtilities.enterText(descriptionfield, notesdescription);
		PageUtilities.clickOnElement(savenotesbutton);
	}
	
	public void searchNotes(String title) {
		PageUtilities.clickOnElement(notessearchbox);
		PageUtilities.enterText(notessearchbox, title);
	}
	
	public String getNoteTitle() {
		String gettitle=PageUtilities.getElementText(searchtitle);
		return gettitle;
		
	}

}
