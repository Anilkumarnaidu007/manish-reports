package Charts.E_Boarding_Reports;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class Validate_titlebar extends base {

	public WebDriver driver;
	
	@BeforeTest
	
	public void initilize_browser () throws IOException
	{
		driver =initializeDriver();
		//driver.get(prop.getProperty("url"));

	}

	@Test
	
	public void titlebar()
	{
		Mainpage m = new Mainpage(driver);
		
		Assert.assertEquals(m.title(), "EB Reports");
		System.out.println("Test completed");

		
	}
	
	@AfterTest
	public void teardown() 
	{
		driver.close();
	}
}
