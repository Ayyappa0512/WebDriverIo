package advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestClass;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basics.Base;

public class Com12_Dynamic_webtable extends Base {
		
		@Test
		public void dynamicwebtable() {
		try {
			driver.get("https://demo.opencart.com/admin");
			
			WebElement username=driver.findElement(By.id("input-username"));
			username.clear();
			username.sendKeys("demo");
			
			WebElement pass=driver.findElement(By.id("input-username"));
			pass.clear();
			pass.sendKeys("demo");
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			driver.findElement(By.id("menu-sale")).click();
			
			driver.findElement(By.xpath("//ul[@id='collapse6']/li[1]")).click();
		}catch(AssertionError e) {
			
			//Base obj = new Base();
			Com12_Dynamic_webtable o = new Com12_Dynamic_webtable();
			o.capturescreen(driver, "dynamicwebtable");
			Assert.assertTrue(false);
			logger.log(Status.PASS, new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
		}
		catch(Exception e) {
			logger.log(Status.FAIL, new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
			logger.fail(e.getMessage());
		}
		}
}
