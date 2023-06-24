package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Com4_BootstrapsDropDown extends Base {
	
	@Test
	public void demobootstrapsdropdown() throws InterruptedException {
		
		try {
		//bootstraps dropdown cant have select html tag then we can use this mmethod to select option form the bootstaps dropdown
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		
		driver.findElement(By.xpath("//button[@id='menu1']")).click();
		List<WebElement> Alloptions = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
		
		for(WebElement option : Alloptions) {
			
			if(option.getText().equals("JavaScript")) {
				option.click();
			    break;
			}
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
