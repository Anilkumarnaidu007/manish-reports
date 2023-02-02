package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public static WebDriver driver;

	public static Properties prop;
	
	public static class child
	{
		//public static SoftAssert sa = new SoftAssert();
		public static String urlname=prop.getProperty("url");
		public static WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		public static JavascriptExecutor  js= (JavascriptExecutor)driver;
		public static Actions act=new Actions(driver);
		public static int sum=0;
		public static int summation=0;

	}
	
public WebDriver initializeDriver() throws IOException
{
 prop= new Properties();
FileInputStream fis=new FileInputStream("D:\\work_space\\E_Boarding_Reports\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
String urlname=prop.getProperty("url");
System.out.println(browserName);
System.out.println(urlname);


if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
	 ChromeOptions options=new ChromeOptions();
	 //options.addArguments("disable-gpu");
	 //options.addArguments("headless");
	driver= new ChromeDriver();
	driver.get(urlname);
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

return driver;

}


public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}

