package advance;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import basics.Base;

public class Com14_SoftAsserstions extends Base{

	
	@Test
	public void softassert() {
		try {
		WebDriver driver =new FirefoxDriver();
		SoftAssert softasset = new SoftAssert();
		
		int a=10;
		int b=12;
		
		softasset.assertEquals(10,a);
		
		
		System.out.println("after soft assert failed");
		
		int c=12;
		softasset.assertEquals(b,c);
		
		System.out.println("After soft assert passed");
		//Assert.fail();
		softasset.assertAll();
		Actions a1 =new Actions(driver);
		//press ctr a
//		a1.keyDown(Keys.CONTROL);
//		a1.sendKeys("a");
//		a1.keyUp(Keys.CONTROL);
//		a1.perform();
		logger.log(Status.PASS,new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
		}
		catch(Exception e) {
			logger.log(Status.FAIL, new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
			logger.fail(e.getMessage());
		}
		
	}
}
