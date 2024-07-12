package TestCases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClassMain;
import PageClasses.QaLegendClientPage;
import PageClasses.QaLegendDashboard;
import PageClasses.QaLegendEstimatesPage;
import PageClasses.QaLegendEventsPage;
import PageClasses.QaLegendForgotPassword;
import PageClasses.QaLegendInvoicePage;
import PageClasses.QaLegendItemsPage;
import PageClasses.QaLegendLeavePage;
import PageClasses.QaLegendLeavePage1;
import PageClasses.QaLegendLoginPage;
import PageClasses.QaLegendMessagePage;
import PageClasses.QaLegendNotesPage;
import PageClasses.QaLegendPaymentPage;
import PageClasses.QaLegendProjectsPage;
import PageClasses.QaLegendSignOut;
import PageClasses.QaLegendTeamMembersPage;
import PageClasses.QaLegendTicketsPage;
import PageClasses.QaLegendTimecardPage;
import Utilities.MyRetry;
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
	QaLegendPaymentPage paymentpage;
	QaLegendEventsPage eventpage;
	QaLegendLeavePage leavepage;
	QaLegendLeavePage1 leavepage1;
	QaLegendTimecardPage timecard;
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
		ticketspage =  new QaLegendTicketsPage(driver);
		teammemberspage = new QaLegendTeamMembersPage(driver);
		signout = new QaLegendSignOut(driver);
		estimatepage = new QaLegendEstimatesPage(driver);
		paymentpage = new QaLegendPaymentPage(driver);
		eventpage = new QaLegendEventsPage(driver);
		leavepage = new QaLegendLeavePage(driver);
		leavepage1 = new QaLegendLeavePage1(driver);
		timecard = new QaLegendTimecardPage(driver);
		rand = new Random();
		driver.manage().window().maximize();
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
	
	 @Test(retryAnalyzer = MyRetry.class)
	 public void loginToQaLegendApp() {
		 System.out.println("Testcase1");
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 
	 }
	 
	@Test(retryAnalyzer = MyRetry.class)
	public void forgotPasswordVerification() {
		System.out.println("Testcase2");
		forgotpassword.forgotPasswordVerification(props.getProperty("username"));
		String successmessage=props.getProperty("forgotscreensuccessmessage");
		org.testng.Assert.assertEquals(forgotpassword.getForgotPasswordStatus(), true);	
	}

	 @Test(retryAnalyzer = MyRetry.class)
	 public void addEditNotes() { 
		 System.out.println("Testcase3"); 
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password")); 
		 dashboard.clickOnNotesMenu();
		 String notetitle=props.getProperty("notestitle")+rand.nextInt(10000);
		 notes.addNotes(notetitle, props.getProperty("notesdescription")); 
		 notes.searchNotes(notetitle);
		 org.testng.Assert.assertEquals(notes.getNoteTitle(), notetitle);
	 }
	 @Test(retryAnalyzer = MyRetry.class)
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
		 System.out.println("TestCase5");
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnClientMenu();
		 String nameclientcomapany=props.getProperty("clientcompanyname")+rand.nextInt(10000);
		 clientspage.createAClient(nameclientcomapany);
		 clientspage.searchClient(nameclientcomapany);
		 org.testng.Assert.assertEquals(clientspage.getClientCompany(), nameclientcomapany);
	 }
	 @Test(retryAnalyzer = MyRetry.class)
	 public void addAllProject() {
		 System.out.println("TestCase6");
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnAllProjectsSubMenu();
		 String titleofproject=props.getProperty("projecttitle")+rand.nextInt(10000);
		 projectpage.addAProject(titleofproject, props.getProperty("projectclientname"));
		 projectpage.searchProjectCreate(titleofproject);
		 assertEquals(projectpage.getCreatedProject(), titleofproject);
	 }
	 @Test(retryAnalyzer = MyRetry.class)
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
	 public void addATeamMember() throws InterruptedException {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnTeamMembersMenu();
		 String memberfirstname=props.getProperty("membersfirstname")+rand.nextInt(10000);
		 String memberslastname=props.getProperty("memberslastname")+rand.nextInt(10000);
		 String membersjobtitle=props.getProperty("memberjobtitle")+rand.nextInt(10000);
		 String membersemailid=props.getProperty("memberemaillocal")+rand.nextInt(10000)+props.getProperty("memberemaildomain");
		 System.out.println(membersemailid);
		 String memberspassword=props.getProperty("memberpassword");
		 teammemberspage.createATeamMember(memberfirstname, memberslastname, membersjobtitle, membersemailid, memberspassword);
		 teammemberspage.searchForTeamMember(driver,membersemailid);
		 assertEquals(teammemberspage.getMemberEmailId(), membersemailid); 
		 //it worked earlier but the wait is not working now
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
	 public void searchForPaymentAndDownloadInvoice() throws InterruptedException {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnInvoiceMenu();
		 invoicepage.createAnInvoice(props.getProperty("invoiceduedate"), props.getProperty("invoiceclientname"));
		 String invoideid=invoicepage.getInvoiceId();
		 System.out.println(invoideid);
		 invoicepage.addPayment(props.getProperty("invoicepaymentdate"), props.getProperty("invoicepaymentamount"));
		 invoicepage.getInvoiceStatus(driver);
		 dashboard.clickOnPaymentMenu();
		 paymentpage.searchForInvoice(invoideid);
		 paymentpage.downloadTheInvoice();
		 //doubt - how to add assertion to check if the file is downloaded to our system
	 }
	 @Test(retryAnalyzer = MyRetry.class)
	 public void addEvents() throws InterruptedException {
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnEventMenu();
		 String eventtitle=props.getProperty("eventtitle")+rand.nextInt(10000);
		 String eventdescription=props.getProperty("eventdescription");
		 String eventenddate=props.getProperty("eventenddate");
		 eventpage.createAnEvent(eventtitle, eventdescription, driver, eventenddate);
		 //what assertion to give
	 }
	 @Test(retryAnalyzer = MyRetry.class)
	 public void assignLeaveAndApprove() {
		 //Page object model
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnLeaveMenu();
		 leavepage.assignALeave(props.getProperty("leaveformember"), props.getProperty("leavetype"),props.getProperty("leavereason")); 
		// doubt - Instead of selecting the current date a previous date is being selected.
	 }
	@Test(retryAnalyzer = MyRetry.class)
	 public void assignLeave() {
		 //Page factory
		 loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.clickOnLeaveMenu();
		leavepage1.assigningALeaveForMember(props.getProperty("leaveformember"), driver, props.getProperty("leavetype"), props.getProperty("leavereason"));
}
	@Test(retryAnalyzer = MyRetry.class)
	public void addTimeToTimeCard() {
		loginpage.loginToQaLegend(props.getProperty("username"),props.getProperty("password"));
		 dashboard.cLickOnTimecards();
		 timecard.addATimeManully(props.getProperty("timecardmember"), props.getProperty("timecardoutdate"));
		 timecard.downloadTheExcelOfListingScreen();
	}
}

