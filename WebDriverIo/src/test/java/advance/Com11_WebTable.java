package advance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basics.Base;

public class Com11_WebTable extends Base {
		
		
		@Test
		public void webtable() {
			try {
			driver.get("https://www.w3schools.com/html/html_tables.asp");
			
			List<WebElement> wt=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
			
			System.out.println(wt.size());
			
			int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[1]")).size();
			int coloumn = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();
			System.out.println(row);
			System.out.println(coloumn);
			logger.log(Status.PASS, new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
			}
			catch(Exception e) {
				logger.log(Status.FAIL, new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
				logger.fail(e.getMessage());
			}
		}
}
