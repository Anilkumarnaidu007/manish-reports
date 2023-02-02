package Charts.E_Boarding_Reports;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class Validate_navigation_url extends base 
{
	
public WebDriver driver;
	
	@BeforeTest
	
	public void initilize_browser () throws IOException
	{
		driver =initializeDriver();
		//driver.get(prop.getProperty("url"));

	}

	@Test
	
	public  void Validate_url()
	{
		//child c=new child();
		System.out.println(child.urlname);
		Mainpage m = new Mainpage(driver);
		Assert.assertEquals(m.navigate()[0],m.navigate()[1]);
		System.out.println("Test completed");

		
	}
	
	@AfterTest
	public void teardown() 
	{
		driver.close();
	}
	
}
