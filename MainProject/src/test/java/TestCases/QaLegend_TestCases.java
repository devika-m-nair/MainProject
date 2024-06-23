package TestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClassMain;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendLoginPage;

public class QaLegend_TestCases extends  BaseClassMain{
	public WebDriver driver;
	Properties props;
	FileReader reader;
	QaLegendLoginPage loginpage;
	QaLegendForgotPassword forgotpassword;
	@BeforeMethod  
	public void intialization() throws Exception
	{
		driver = browserIntialization("chrome");
		loginpage = new QaLegendLoginPage(driver);
		forgotpassword = new QaLegendForgotPassword(driver);
		driver.manage().window().maximize();
		props=new Properties();
		reader = new FileReader("C:\\Users\\Shank\\git\\repository4\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
		props.load(reader);
		driver.get(props.getProperty("url"));
	}
	
	 @Test 
	 public void loginToQaLegendApp() {
		 System.out.println("Testcase1");
	 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
	 }
	 
	@Test
	public void forgotPasswordVerification() {
		System.out.println("Testcase2");
		forgotpassword.forgotPasswordSuccessVerification(props.getProperty("username"));
	}
	
	
	/*
	 * @Test public void addEditNotes() { System.out.println("Testcase1"); }
	 */

}
