package TestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClassMain;
import PageClasses.QaLegendDashboard;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagePage;
import PageClasses.QaLegendNotesPage;
import dev.failsafe.internal.util.Assert;

public class QaLegend_TestCases extends  BaseClassMain{
	public WebDriver driver;
	Properties props;
	FileReader reader;
	String path="";
	QaLegendLoginPage loginpage;
	QaLegendForgotPassword forgotpassword;
	QaLegendDashboard dashboard;
	QaLegendNotesPage notes;
	QaLegendMessagePage message;
	Random rand;
	@BeforeMethod  
	public void intialization() throws Exception
	{
		driver = browserIntialization("chrome");
		loginpage = new QaLegendLoginPage(driver);
		forgotpassword = new QaLegendForgotPassword(driver);
		dashboard = new QaLegendDashboard(driver);
		notes = new QaLegendNotesPage(driver);
		message = new QaLegendMessagePage(driver);
		rand = new Random();
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
		forgotpassword.forgotPasswordVerification(props.getProperty("username"));
		String successmessage=props.getProperty("forgotscreensuccessmessage");
		org.testng.Assert.assertEquals(forgotpassword.getSuccessMessage(), successmessage);	
	}

	 @Test 
	 public void addEditNotes() { 
		 System.out.println("Testcase3"); 
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 dashboard.clickOnNotesMenu();
		 String notetitle=props.getProperty("notestitle")+rand.nextInt(10000);
		 notes.addNotes(notetitle, props.getProperty("notesdescription")); 
		 notes.searchNotes(notetitle);
		 org.testng.Assert.assertEquals(notes.getNoteTitle(), notetitle);
	 }
	 @Test
	 public void sendAMessage() {
		 System.out.println("TestCase4");
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 dashboard.clickOnMessageMenu();
		 String messagesub=props.getProperty("messagesubject")+rand.nextInt(10000);
		 String messagedes=props.getProperty("messagedescription")+rand.nextInt(10000);
		 message.enterAndSendMessage(props.getProperty("messageto"),messagesub ,messagedes);
		 message.searchForSendMessage(messagesub);
		 org.testng.Assert.assertEquals(message.getSendMessage(), messagesub);
	 }
	 

}
