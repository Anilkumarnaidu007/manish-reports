package Charts.E_Boarding_Reports;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
//import org.testng.asserts.SoftAssert;
import dev.failsafe.internal.util.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sha_Dwelltime_raw {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
Connection con=Db_Connection.getDBConnection();
ResultSet rs = null;

CallableStatement cstmt = null;
ArrayList<String> dbvalues=new ArrayList<>();
try {
	cstmt = con.prepareCall("{call usp_Rpt_Get_PreSHA_SHA_DwellTime(?)}");
	cstmt.setString(1, "2023-01-01");
	rs = cstmt.executeQuery();
	
	while (rs.next())
	{
		
		dbvalues.add(rs.getString("AvgDwellTime"));
		//list.add(rs.getString("MaxWaitTime"));
	}
}
catch(Exception e)
{
	System.out.println("error: "+e);
}
	System.out.println(dbvalues);	
		// TODO Auto-generated method stub
			//SoftAssert a= new SoftAssert();
			System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			//options.addArguments("disable-gpu");
			//options.addArguments("headless");
			WebDriver driver= new ChromeDriver();
			//System.setProperty("webdriver.gecko.driver","C://geckodriver.exe");
			//WebDriver driver= new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));			
			String ShaUrl="http://localhost:8080/main";
			driver.get(ShaUrl);
			//a.assertEquals("http://localhost:8080/login",  ShaUrl,"ShaUrl Title Mismatch :" );
			System.out.println(driver.getCurrentUrl());
			driver.manage().window().maximize();	 
			driver.findElement(By.cssSelector("input[type='text']")).sendKeys("admin");
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin");
			driver.findElement(By.xpath("//*[text()='Sign In']")).submit();
			JavascriptExecutor  js= (JavascriptExecutor)driver;
			driver.get(ShaUrl);
			driver.findElement(By.xpath("//span[text()='Dwell Time']")).click();
			Thread.sleep(3000);
			List<WebElement> values=driver.findElements(By.cssSelector("span[class='menuText']"));
			
			for(int i=0;i<values.size();i++)
			{
				String names=values.get(i).getText();
				
				if(names.contains("SHA Dwell Time"))
				{
					values.get(i).click();
				}
			}
			Thread.sleep(3000);
			WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/i[@class='mx-icon-calendar']")));
			driver.findElement(By.xpath("//div/div/i[@class='mx-icon-calendar']")).click();			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[title='2023-01-01']")));
			//Thread.sleep(3000);
			driver.findElement(By.cssSelector("td[title='2023-01-01']")).click();
			js.executeScript("document.body.style.transform='scale(0.6)'");
			driver.findElement(By.xpath("//a[@href='/shadwelltime']")).click();
			Thread.sleep(3000);
			Actions act=new Actions(driver);
			//act.sendKeys(Keys.PAGE_DOWN).build().perform();		
			int sum=0;
			List<WebElement> DwellTimeValues=driver.findElements(By.cssSelector("tbody>tr>td:nth-of-type(2)"));
			ArrayList<String> listvalues=new ArrayList<String>();
			 //System.out.println(DwellTimeValues.stream().map(val->val.getText()).collect(Collectors.toList()).size());
			  for(WebElement e: DwellTimeValues)
			  
			  {
			  
			  //act.moveToElement(e)
			 
				  
				/*
				 * if(e.getText().isBlank()) { System.out.println("Dwelltimevalue empty");
				 * 
				 * } else { listvalues.add(e.getText()); int si=Integer.parseInt(e.getText());
				 * System.out.println(si); sum=sum+si; Thread.sleep(1000);
				 * 
				 * }
				 */
			  
			  }
			 
			System.out.println(listvalues);
			System.out.println(sum+":Total ShaDwellTime Table Count");
			
			driver.navigate().back();	
			Thread.sleep(2000);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();	
			Thread.sleep(2000);
			ArrayList<String> chartlist=new ArrayList<String>();
			int summation=0;
			List <WebElement> chartvalues=driver.findElements(By.xpath("//*[local-name()='text' and @ class='apexcharts-datalabel']"));
			//int chartvalues=driver.findElements(By.xpath("//*[local-name()='text' and @ class='apexcharts-datalabel']")).size();
			//List <WebElement> rse=driver.findElements(By.xpath("//div[@class='apexcharts-tooltip-y-group']"));
			
			  for(int i=0;i<chartvalues.size()-24;i++)
			  
			  {
				if(chartvalues.get(i).getText().isEmpty())
				{
					chartlist.add(null);
			  		System.out.println("Chart values are blank");
				}
				else
				{
					chartlist.add(chartvalues.get(i).getText()); 
			  		int si=Integer.parseInt(chartvalues.get(i).getText());
			  		System.out.println(si);
			  		summation=summation+si; 
			  		Thread.sleep(1000);
				  }
			 
			  }
			
			System.out.println(summation+":Total ShaDwellTime Chart Count");
			//System.out.println(chartlist);
			
			//a.assertEquals(sum, summation);
			//a.assertEquals(chartlist, listvalues);
			//a.assertEquals(dbvalues,listvalues );
			
			//a.assertAll();	

	}
}
	
			/*	if(li.isEnabled()) 
			{
				li.click();
				System.out.println("clicked");
			}
			else {
				System.out.println("error");
			*/
		
			/*
			 * boolean
			 * button_enabled=driver.findElement(By.xpath("//div[text()='15']")).isEnabled()
			 * ; System.out.println(button_enabled);
			 * a.assertFalse(button_enabled,"button is not disabled");
			 * 
			 * 
			 * boolean
			 * button_disabled=driver.findElement(By.xpath("//div[text()='12']")).isEnabled(
			 * ); System.out.println(button_disabled);
			 * a.assertFalse(button_disabled,"button is not disabled");
			 * 
			 * WebElement j=driver.findElement(By.xpath("//div[text()='15']")); j.click();
			 * 
			 * JavascriptExecutor jse = (JavascriptExecutor) driver;
			 * jse.executeScript("arguments[0].style.border='2px solid red'",j );
			 */
				/*
				 * if( //button.isEnabled()) { //button.click();
				 * //a.assertFalse(button.isEnabled(), "Button should be disabled!");
				 * System.out.println("Element is clickable"); } else {
				 * System.out.println("Element isn't clickable");
				 * 
				 * }
				 */

			
			
				
			
	

	
	


