package PageClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.PageUtilities;

public class QaLegendLeavePage {
	WebDriver driver;
	//By assignleavebutton=By.xpath("//a[@title='Assign leave']");
	By assignleavebutton=By.xpath("(//div[@class='title-button-group']//a)[2]");
	By teammemberfield=By.xpath("(//form[@id='leave-form']//span)[1]");
	By teammembersearch=By.xpath("(//div[@id='select2-drop'])//input");
	By leavetypefield=By.xpath("(//div[@id='s2id_leave_type_id']//span)[1]");
	By leavetypesearch=By.xpath("//div[@id='select2-drop']//input");
	By leavedate=By.id("single_date");
	By leavereason=By.xpath("//textarea[@name='reason']");
	By leavesubmit=By.xpath("//button[@type='submit']");
	
	public QaLegendLeavePage(WebDriver driver) {
		this.driver=driver;
	}

	public void assignALeave(String membername, String leavetype,String reason) {
		driver.findElement(assignleavebutton).click();
		driver.findElement(teammemberfield).click();
		driver.findElement(teammembersearch).sendKeys(membername);
		driver.findElement(teammembersearch).sendKeys(Keys.ENTER);
		driver.findElement(leavetypefield).click();
		driver.findElement(leavetypesearch).sendKeys(leavetype);
		driver.findElement(teammembersearch).sendKeys(Keys.ENTER);
		Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        String formattedDate = sdf.format(date);
        WebElement dateField = driver.findElement(leavedate);
        dateField.sendKeys(formattedDate);
        dateField.sendKeys(Keys.ENTER);
        driver.findElement(leavereason).sendKeys(reason);
        driver.findElement(leavesubmit).click();	
	}

}
