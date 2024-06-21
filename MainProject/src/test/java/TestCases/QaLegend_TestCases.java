package TestCases;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationCore.BaseClassMain;

public class QaLegend_TestCases extends  BaseClassMain{
	public WebDriver driver;
	Properties props;
	FileReader reader;
	@BeforeMethod  
	public void intialization() throws Exception
	{
		driver = browserIntialization("chrome");
		driver.manage().window().maximize();
		props=new Properties();
		reader = new FileReader("C:\\Users\\Shank\\eclipse-workspace\\MainProject\\src\\main\\resources\\TestData\\TestData.properties");
		props.load(reader);
		driver.get(props.getProperty("url"));
	}
	@Test
	public void addEditNotes() {
		System.out.println("Testcase1");
	}

}
