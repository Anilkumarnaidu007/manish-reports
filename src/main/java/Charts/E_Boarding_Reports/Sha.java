package Charts.E_Boarding_Reports;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import resources.base;

public class Sha extends base {

	public WebDriver driver;
	
	By Dwelltime = By.xpath("//span[text()='Dwell Time']");
	By val=By.xpath("//span[text()='SHA Dwell Time']");
	By calendar=By.xpath("//div/div/i[@class='mx-icon-calendar']");
	By caldate=By.cssSelector("td[title='2023-01-31']");
	By shatable=By.xpath("//a[@href='/shadwelltime']");
	By tablevalues=By.cssSelector("tbody>tr>td:nth-of-type(2)");
	By dwelltimechartvalues=By.xpath("//*[local-name()='text' and @ class='apexcharts-datalabel']");
	
	public Sha(WebDriver driver)
	{	
		this.driver=driver;
	}
	
	public WebElement Dwelltimeurl() throws IOException
	{
		 //driver=initializeDriver();
		 driver.get(child.urlname);
		Login_page l =new Login_page(driver);
		l.email().sendKeys("admin");
		l.password().sendKeys("admin");
		l.login().click();
		 driver.get(child.urlname);
		 return driver.findElement(Dwelltime);
		
	}
	public ArrayList<String> sha_data_database()
	{
		String date = LocalDate.now().minusDays(1).toString();
		System.out.println(date);
		Connection con=Db_Connection.getDBConnection();
		ResultSet rs = null;

		CallableStatement cstmt = null;
		ArrayList<String> dbvalues=new ArrayList<>();
		try {
			cstmt = con.prepareCall("{call usp_Rpt_Get_PreSHA_SHA_DwellTime(?)}");
			cstmt.setString(1,date);
			rs = cstmt.executeQuery();
			
			while (rs.next())
			{
				
				dbvalues.add(rs.getString("AvgDwellTime"));
				//list.add(rs.getString("MaxWaitTime"));
			}
		}
		catch(Exception e)
		{
			{
				System.out.println("error: "+e);
			}
		}
		return dbvalues;
	}
	
	public WebElement shaurl()
	{
		return driver.findElement(val);
	}
	
	public WebElement calendaricon()
	{
		child.wait.until(ExpectedConditions.visibilityOfElementLocated(calendar));
		return driver.findElement(calendar);
	}
	
	public WebElement calendardate()
	{
		child.wait.until(ExpectedConditions.visibilityOfElementLocated(caldate));
		//Thread.sleep(3000);
		return driver.findElement(caldate);		
	}
	
	public WebElement shatable()
	{
		return driver.findElement(shatable);
		
	}

	public ArrayList<String> dwell_table_values() throws InterruptedException
	{
		List<WebElement> DwellTimeValues=driver.findElements(tablevalues);
		ArrayList<String> listvalues=new ArrayList<String>();
		for(WebElement e: DwellTimeValues)
			  
		  {
				/*
				 * listvalues.add(e.getText()); int si=Integer.parseInt(e.getText());
				 * System.out.println(si); child.sum=child.sum+si; Thread.sleep(1000);
				 */
				 
		  
		  //act.moveToElement(e)
		 
			  
			
			
			  if(e.getText()==null||e.getText().isEmpty()||e.getText().trim().isEmpty()) { System.out.println("Dwelltimevalue empty");
			  
			  } else { listvalues.add(e.getText()); int si=Integer.parseInt(e.getText());
			  System.out.println(si); child.sum=child.sum+si; Thread.sleep(1000);
			  
			  }
			 
			 
		  }
		return listvalues;
		
 
	}
	
	public ArrayList<String> chart_values() throws InterruptedException
	{
		driver.navigate().back();
		ArrayList<String> chartlist=new ArrayList<String>();
		List <WebElement> chartvalues=driver.findElements(dwelltimechartvalues);
		
		  for(int i=0;i<chartvalues.size()-24;i++)
			  
		  {
				/*
				 * chartlist.add(chartvalues.get(i).getText()); int
				 * si=Integer.parseInt(chartvalues.get(i).getText()); System.out.println(si);
				 * child.summation=child.summation+si; Thread.sleep(1000);
				 */
				 
				
				
				  if(chartvalues.get(i).getText()==null||chartvalues.get(i).getText().isEmpty()||chartvalues.get(i).getText().trim().isEmpty()) { chartlist.add(null);
				  System.out.println("Chart values are blank"); } else {
				  chartlist.add(chartvalues.get(i).getText()); int
				  si=Integer.parseInt(chartvalues.get(i).getText()); System.out.println(si);
				  child.summation=child.summation+si; Thread.sleep(1000); }
				 
				 
		 
		  }
		
		return chartlist;
		

	}
}



