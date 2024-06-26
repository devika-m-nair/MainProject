package PageClasses;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendForgotPassword {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Forgot password?']")
	WebElement forgotpasswordlink;
	@FindBy(id = "email")
	WebElement forgotemail;
	@FindBy(xpath = "//button[text()='Send']")
	WebElement sendforgotmail;
	@FindBy(xpath = "//div[text()='Email sent!']")
	WebElement forgotsuccessalert;
	
	
	
	public QaLegendForgotPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public void forgotPasswordVerification(String emailforg) {
		PageUtilities.clickOnElement(forgotpasswordlink);
		PageUtilities.enterText(forgotemail, emailforg);
		PageUtilities.clickOnElement(sendforgotmail);
	}
	
	public String getSuccessMessage() {
		String forgotpasssuccessmessage = PageUtilities.getElementText(forgotsuccessalert);
		return forgotpasssuccessmessage;
	}
	

}
