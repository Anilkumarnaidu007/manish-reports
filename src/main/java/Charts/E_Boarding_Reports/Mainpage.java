package Charts.E_Boarding_Reports;

import org.openqa.selenium.WebDriver;

import resources.base;

	public class Mainpage extends base  {

		public WebDriver driver;
		//public String urlname;
		
		  public Mainpage(WebDriver driver) 
		  {
		  
			  this.driver=driver; 
		  }
		 
		
		public String title()
		{
			return  driver.getTitle();

		}
		
		
		public String[] navigate()
		{

			String[] arr =new String[2];
			
			arr[0]=child.urlname;

			 arr[1]=driver.getCurrentUrl();
			
			 return arr;
				
	}
	
}