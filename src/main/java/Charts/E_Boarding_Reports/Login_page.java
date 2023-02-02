package Charts.E_Boarding_Reports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_page {
	public WebDriver driver;

	By email= By.cssSelector("input[type='text']");
	By password=By.cssSelector("input[type='password']");
	By login =By.xpath("//*[text()='Sign In']");
	
	public Login_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement password()
	{
		 return driver.findElement(password);
	}
	
	public WebElement login()
	{
		return driver.findElement(login);
	}
}
