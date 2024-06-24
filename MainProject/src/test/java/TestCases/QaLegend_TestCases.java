package TestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClassMain;
import PageClasses.QaLegendDashboard;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendNotesPage;

public class QaLegend_TestCases extends  BaseClassMain{
	public WebDriver driver;
	Properties props;
	FileReader reader;
	String path="";
	QaLegendLoginPage loginpage;
	QaLegendForgotPassword forgotpassword;
	QaLegendDashboard dashboard;
	QaLegendNotesPage notes;
	@BeforeMethod  
	public void intialization() throws Exception
	{
		driver = browserIntialization("chrome");
		loginpage = new QaLegendLoginPage(driver);
		forgotpassword = new QaLegendForgotPassword(driver);
		dashboard = new QaLegendDashboard(driver);
		notes = new QaLegendNotesPage(driver);
		driver.manage().window().maximize();
		props=new Properties();
		path=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\TestData.properties";
		reader = new FileReader(path);
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
	
	 @Test 
	 public void addEditNotes() { 
		 System.out.println("Testcase3"); 
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 dashboard.clickOnNotesMenu();
		 notes.addNotes(props.getProperty("notestitle"), props.getProperty("notesdescription")); 
	 }
	 

}
