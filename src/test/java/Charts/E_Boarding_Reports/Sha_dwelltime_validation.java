package Charts.E_Boarding_Reports;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class Sha_dwelltime_validation extends base {
	public  WebDriver driver;
	
	
	  @BeforeTest
	  
	  public void sha_avgdata_database() throws IOException 
	  {
	  driver=initializeDriver(); 
	  }
	 
	
@Test
public void sha_avg() throws IOException, InterruptedException
{
	Sha s=new Sha(driver);
	ArrayList<String> database_arr=s.sha_data_database();
	System.out.println(database_arr);
	s.Dwelltimeurl().click();
	s.shaurl().click();
	Thread.sleep(5000);
	s.calendaricon().click();
	Thread.sleep(1000);
	s.calendardate().click();
	child.js.executeScript("document.body.style.transform='scale(0.6)'");
	s.shatable().click();
	Thread.sleep(3000);
	ArrayList<String> table_arr=s.dwell_table_values();
	System.out.println(table_arr);
	System.out.println(child.sum+":Total ShaDwellTime Table Count");
	child.act.sendKeys(Keys.PAGE_DOWN).build().perform();
	ArrayList<String>chartvalues_arr=s.chart_values();
	System.out.println(chartvalues_arr);
	System.out.println(child.summation+":Total ShaDwellTime Chart Count");
	
	  Assert.assertEquals(child.sum, child.summation);
	  Assert.assertEquals(chartvalues_arr, table_arr);
	  Assert.assertEquals(database_arr, table_arr);
	  Assert.assertEquals(database_arr,chartvalues_arr);
	/*
	 * child.sa.assertEquals(child.sum, child.summation);
	 * child.sa.assertEquals(chartvalues_arr, table_arr);
	 * child.sa.assertEquals(database_arr, table_arr);
	 * child.sa.assertEquals(database_arr,chartvalues_arr);
	 */
	 
	System.out.println("Test Completed");
	//child.sa.assertAll();
}


  @AfterTest
  
  public void teardown() 
  { 
	  base.driver.close();
  
  }
 
 
}
