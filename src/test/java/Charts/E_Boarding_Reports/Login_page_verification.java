package Charts.E_Boarding_Reports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class Login_page_verification extends base{
public  WebDriver driver;


@BeforeTest
	public void initializebrowser() throws IOException 
	{
		 driver=initializeDriver();
	}


@Test
public void  Login_validation()  throws IOException
{
	Login_page l =new Login_page(driver);
	l.email().sendKeys("admin");
	l.password().sendKeys("admin");
	l.login().click();
	System.out.println("Test Finished");
}
	
@AfterTest
public void teardown()
{
	driver.close();
}
}