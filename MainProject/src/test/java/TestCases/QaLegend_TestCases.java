package TestCases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClassMain;
import PageClasses.QaLegendClientPage;
import PageClasses.QaLegendDashboard;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendInvoicePage;
import PageClasses.QaLegendItemsPage;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagePage;
import PageClasses.QaLegendNotesPage;
import PageClasses.QaLegendProjectsPage;
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
	QaLegendClientPage clientspage;
	QaLegendProjectsPage projectpage;
	QaLegendItemsPage itemspage;
	QaLegendInvoicePage invoicepage;
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
		clientspage = new QaLegendClientPage(driver);
		projectpage = new QaLegendProjectsPage(driver);
		itemspage = new QaLegendItemsPage(driver);
		invoicepage = new QaLegendInvoicePage(driver);
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
		org.testng.Assert.assertEquals(forgotpassword.getForgotPasswordStatus(), true);	
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
	 @Test
	 public void clientCreation() {
		 System.out.println("TestCase5");
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnClientMenu();
		 String nameclientcomapany=props.getProperty("clientcompanyname")+rand.nextInt(10000);
		 clientspage.createAClient(nameclientcomapany);
		 clientspage.searchClient(nameclientcomapany);
		 org.testng.Assert.assertEquals(clientspage.getClientCompany(), nameclientcomapany);
	 }
	 @Test
	 public void addAllProject() {
		 System.out.println("TestCase6");
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnAllProjectsSubMenu();
		 String titleofproject=props.getProperty("projecttitle")+rand.nextInt(10000);
		 projectpage.addAProject(titleofproject, props.getProperty("projectclientname"));
		 projectpage.searchProjectCreate(titleofproject);
		 assertEquals(projectpage.getCreatedProject(), titleofproject);
	 }
	 @Test
	 public void addAndDeleteAnItem() {
		 System.out.println("TestCase7");
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnItemsMenu();
		 String itemtitle = props.getProperty("titleofitem")+rand.nextInt(10000);
		 itemspage.createAnItem(itemtitle, props.getProperty("rateofitem"));
		 itemspage.searchForItemAdded(itemtitle);
		 assertEquals(itemspage.getItemCreated(), itemtitle);
		 itemspage.deleteItem();
		 String nofoundmessage=props.getProperty("searchnonexistingitem");
		 assertEquals(itemspage.searchForDeletedItem(), nofoundmessage);
	 }
	 @Test
	 public void addInvoice() throws InterruptedException {
		 System.out.println("TestCase8");
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnInvoiceMenu();
		 invoicepage.createAnInvoice(props.getProperty("invoiceduedate"), props.getProperty("invoiceclientname"));
		 String invoideid=invoicepage.getInvoiceId();
		 System.out.println(invoideid);
		 invoicepage.addPayment(props.getProperty("invoicepaymentdate"), props.getProperty("invoicepaymentamount"));
		 String invoicestatus=invoicepage.getInvoiceStatus(driver);
		 System.out.println(invoicestatus);
		 //doubt 
	 }
	 

}

