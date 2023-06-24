package basics;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class Com7_AutocompleteDropdown extends Base{

	
	@Test
	public void Autocompletedropdown() throws InterruptedException {
		try {
		driver.get("https://www.google.com//");
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		//Thread.sleep(3000);
		//Assert.fail();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		List<WebElement> searchlist = driver.findElements(By.xpath("//div[@class='wM6W7d']/span"));
		
		
		System.out.println("size of autocomplete options: "+searchlist.size());
		String text;
		for(WebElement ele:searchlist) {
			text =ele.getText();
			if(text.equals("selenium tutorial")) {
				ele.click();
				break;
			}
		}
		logger.log(Status.PASS,new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
		}
		catch(Exception e) {
			logger.log(Status.FAIL, new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
			logger.fail(e.getMessage());
		}
	}
}
