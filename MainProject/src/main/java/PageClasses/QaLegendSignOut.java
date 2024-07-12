package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QaLegendSignOut {
	WebDriver driver;
	@FindBy(xpath = "(//ul[@role='menu']//i)[4]")
	WebElement signout;
	@FindBy(xpath = "//h2[text()='Sign in']")
	WebElement signinpage;
	
	
	
	public QaLegendSignOut(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickOnSignOut() {
		PageUtilities.clickOnElement(signout);
	}
	public String checksigninpage() {
		String getsigninpage=PageUtilities.getElementText(signinpage);
		return getsigninpage;
	}

}
