package basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Com9_CheckBox extends Base{

	
		@Test
		public void democheckbox() throws InterruptedException {
			
			try {
	
			driver.get("https://itera-qa.azurewebsites.net/home/automation");
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//1 select one check box 
			
			//driver.findElement(By.id("monday")).click();
			
			//2 selecting all checkboxs
			
			List<WebElement>checkboxlist=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
			
			/*for(WebElement li:checkboxlist) {
				li.click();
			}*/
			//Thread.sleep(3000);
			
			//3 selecting multiple check box by choice
			
			/*for(WebElement li:checkboxlist) {
				
				String choice=li.getAttribute("id");
				if(choice.equals("monday") || choice.equals("thursday")) {
					li.click();
				}
			}
			Thread.sleep(3000);*/
			
			//4 selecting last 2 checkboxes
			int sizeofchbox=checkboxlist.size();
			
			/*for(int i=sizeofchbox-2;i<sizeofchbox;i++) {
					
					checkboxlist.get(i).click();
				
			}
			Thread.sleep(3000);*/
				
		//5 selecting first 2boxes
		
				
		for(int i=0;i<2;i++) {
			
			checkboxlist.get(i).click();
		
			}
		Thread.sleep(3000);
		logger.log(Status.PASS, new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
			}
			catch(Exception e) {
				logger.log(Status.FAIL, new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
				logger.fail(e.getMessage());
			}
	}
}

