package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Com8_Autocompletedropdown2 extends Base{
	
		
		@Test
		public void autocompletedropdown2() {
			try {
				
			driver.get("https://www.twoplugs.com/");
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
			
			WebElement ele=driver.findElement(By.id("autocomplete"));
			ele.clear();
			ele.sendKeys("chennai");
			
			String text;
			
			do {
				ele.sendKeys(Keys.ARROW_DOWN);
				text=ele.getAttribute("value");
				if(text.contains("Chennai Shopping Mall")) {
					ele.sendKeys(Keys.ENTER);
					break;
				}
				
			}while(!text.isEmpty());
			logger.log(Status.PASS, new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
		}
		catch(Exception e) {
			logger.log(Status.FAIL,new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
			logger.fail(e.getMessage());
		}
}
}