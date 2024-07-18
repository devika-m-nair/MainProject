package TestCases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import AutomationCore.BaseClassMain;
import PageClasses.QaLegendClientPage;
import PageClasses.QaLegendDashboard;
import PageClasses.QaLegendEstimatesPage;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendInvoicePage;
import PageClasses.QaLegendItemsPage;	
import PageClasses.QaLegendLeavePage1;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagePage;
import PageClasses.QaLegendNotesPage;
import PageClasses.QaLegendProjectsPage;
import PageClasses.QaLegendSignOut;
import PageClasses.QaLegendTeamMembersPage;
import PageClasses.QaLegendTicketsPage;
import PageClasses.QaLegendTimecardPage;
import Utilities.ExcelUtility;
import Utilities.MyRetry;
import Utilities.PageUtilities;
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
	QaLegendTicketsPage ticketspage;
	QaLegendTeamMembersPage teammemberspage;
	QaLegendSignOut signout;
	QaLegendEstimatesPage estimatepage;
	QaLegendLeavePage1 leavepage1;
	QaLegendTimecardPage timecard;
	Random rand;
	private static String downloadpath="C:\\Users\\Shank\\Downloads\\Demo CRM.xlsx";
	@BeforeMethod 
	@Parameters("browser")
	public void intialization(String browser) throws Exception
	{
		driver = browserIntialization(browser);
		loginpage = new QaLegendLoginPage(driver);
		forgotpassword = new QaLegendForgotPassword(driver);
		dashboard = new QaLegendDashboard(driver);
		notes = new QaLegendNotesPage(driver);
		message = new QaLegendMessagePage(driver);
		clientspage = new QaLegendClientPage(driver);
		projectpage = new QaLegendProjectsPage(driver);
		itemspage = new QaLegendItemsPage(driver);
		invoicepage = new QaLegendInvoicePage(driver);
		ticketspage =  new QaLegendTicketsPage(driver);
		teammemberspage = new QaLegendTeamMembersPage(driver);
		signout = new QaLegendSignOut(driver);
		estimatepage = new QaLegendEstimatesPage(driver);
		leavepage1 = new QaLegendLeavePage1(driver);
		timecard = new QaLegendTimecardPage(driver);
		rand = new Random();
		PageUtilities.maximizeTheWindow(driver);
		props=new Properties();
		path=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\TestData.properties";
		reader = new FileReader(path);
		props.load(reader);
		driver.get(props.getProperty("url"));
	}
	
	
	 @AfterMethod 
	 public void quitTheBrowser() { 
		 driver.quit();
	 
    }
	
	 @Test(retryAnalyzer = MyRetry.class,groups = {"Regression Test"})
	 public void loginToQaLegendApp() {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 assertEquals(loginpage.checkIfLoggedIn(), "Dashboard");	 
	 }
	 
	@Test(retryAnalyzer = MyRetry.class,groups = {"Re Test"})
	public void forgotPasswordVerification() {
		forgotpassword.forgotPasswordVerification(props.getProperty("username"));
		String successmessage=props.getProperty("forgotscreensuccessmessage");
		org.testng.Assert.assertEquals(forgotpassword.getForgotPasswordStatus(), true);	
	}

	 @Test(retryAnalyzer = MyRetry.class,groups = {"Regression Test"})
	 public void addEditNotes1() { 
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 dashboard.clickOnNotesMenu();
		 String notetitle=props.getProperty("notestitle")+rand.nextInt(10000);
		 notes.addNotes(notetitle, props.getProperty("notesdescription")); 
		 notes.searchNotes(notetitle);
		 org.testng.Assert.assertEquals(notes.getNoteTitle(), notetitle);
	 }
	 
	 @Test(dataProvider = "NoteData", retryAnalyzer = MyRetry.class, groups = {"Regression Test"})
	 public void addEditNotes(String note,String des) throws InterruptedException { 
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 dashboard.clickOnNotesMenu();
		 notes.addNotes(note, des); 
		 notes.searchNotes(note);
		 org.testng.Assert.assertEquals(notes.getNoteTitle(), note);

}
	@DataProvider(name="NoteData")
		public Object[][] data() throws IOException{
			Object[][] notedata = new Object[2][2];
			notedata[0][0]="Devika Title A1";
			notedata[0][1]="Description";
			notedata[1][0]="Jeena Title A2";
			notedata[1][1]="description2";
			return notedata;
	}
	 
	 @Test(retryAnalyzer = MyRetry.class,groups = {"Re Test"})
	 public void sendAMessage() {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 dashboard.clickOnMessageMenu();
		 String messagesub=props.getProperty("messagesubject")+rand.nextInt(10000);
		 String messagedes=props.getProperty("messagedescription")+rand.nextInt(10000);
		 message.enterAndSendMessage(props.getProperty("messageto"),messagesub ,messagedes);
		 message.searchForSendMessage(messagesub);
		 org.testng.Assert.assertEquals(message.getSendMessage(), messagedes);
	 }
	 
	 @Test(retryAnalyzer = MyRetry.class)
	 public void clientCreation() {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnClientMenu();
		 String nameclientcomapany=props.getProperty("clientcompanyname")+rand.nextInt(10000);
		 clientspage.createAClient(nameclientcomapany);
		 clientspage.searchClient(nameclientcomapany);
		 org.testng.Assert.assertEquals(clientspage.getClientCompany(), nameclientcomapany);
	 }
	 
	 @Test(retryAnalyzer = MyRetry.class)
	 public void addAllProject() {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnAllProjectsSubMenu();
		 String titleofproject=props.getProperty("projecttitle")+rand.nextInt(10000);
		 projectpage.addAProject(titleofproject, props.getProperty("projectclientname"));
		 projectpage.searchProjectCreate(titleofproject);
		 assertEquals(projectpage.getCreatedProject(), titleofproject);
	 }
	 
	 @Test(retryAnalyzer = MyRetry.class)
	 public void addAndDeleteAnItem() {
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
	 
	 @Test(retryAnalyzer = MyRetry.class)
	 public void addInvoiceAndMakefullPayment() throws InterruptedException {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnInvoiceMenu();
		 invoicepage.createAnInvoice(props.getProperty("invoiceduedate"), props.getProperty("invoiceclientname"));
		 String invoideid=invoicepage.getInvoiceId();
		 System.out.println(invoideid);
		 invoicepage.addPayment(props.getProperty("invoicepaymentdate"), props.getProperty("invoicepaymentamount"));
		 String invoicestatus=invoicepage.getInvoiceStatus(driver);
		 System.out.println(invoicestatus);
		 assertEquals(invoicestatus, "Fully paid");
	 }
	 
	 @Test(retryAnalyzer = MyRetry.class)
	 public void addATicketAndUpdateStatus() {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnTicketsMenu();
		 String tickettittle=props.getProperty("tickettitle")+rand.nextInt(10000);
		 ticketspage.addATicket(tickettittle, props.getProperty("ticketclientname"), driver, props.getProperty("ticketdescription"));
		 ticketspage.changeTheStatus(tickettittle);
		 assertEquals(ticketspage.getStatusOfTicket(), "Closed");
	 }
	 
	 @Test(retryAnalyzer = MyRetry.class)
	 public void addATeamMember() throws InterruptedException, IOException {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnTeamMembersMenu();
		 String memberfirstname=ExcelUtility.getString(1, 0,props.getProperty("excelfilepath"), "TeamMemberData")+rand.nextInt(10000);
		 String memberslastname=ExcelUtility.getString(1, 1,props.getProperty("excelfilepath"), "TeamMemberData")+rand.nextInt(10000);
		 String membersjobtitle=ExcelUtility.getString(1, 2,props.getProperty("excelfilepath"), "TeamMemberData")+rand.nextInt(10000);
		 String membersemailid=props.getProperty("memberemaillocal")+rand.nextInt(10000)+props.getProperty("memberemaildomain");
		 System.out.println(membersemailid);
		 String memberspassword=ExcelUtility.getNumeric(1, 3,props.getProperty("excelfilepath"), "TeamMemberData");
		 teammemberspage.createATeamMember(memberfirstname, memberslastname, membersjobtitle, membersemailid, memberspassword);
		 teammemberspage.searchForTeamMember(driver,membersemailid);
		 assertEquals(teammemberspage.getMemberEmailId(), membersemailid); 
	 }
	 
	 @Test(retryAnalyzer = MyRetry.class)
	 public void signOut() {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnProfileIcon();
		 signout.clickOnSignOut();
		 assertEquals(signout.checksigninpage(), "Sign in");
	 }
	 
	 @Test(retryAnalyzer = MyRetry.class)
	 public void addAnEstimate()  {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnEstimatesMenu();
		 estimatepage.createAnEstimate(props.getProperty("estimatedate"), props.getProperty("estimatevaliddate"), props.getProperty("estimateclientname"), driver);
		 estimatepage.markassent(driver);
		 assertEquals(estimatepage.getsentstatus(), "Sent");
	 }
	 
	@Test(retryAnalyzer = MyRetry.class)
	 public void assignLeave() {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnLeaveMenu();
		leavepage1.assigningALeaveForMember(props.getProperty("leaveformember"), driver, props.getProperty("leavetype"), props.getProperty("leavereason"));
		String assignie=leavepage1.verifyMemberAvailableInSummary(props.getProperty("leaveformember"));
		assertEquals(props.getProperty("leaveformember"), assignie);
	}
	
	
	}


