package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

@Listeners({utils.Listerners.class})
public class Com1_StatusofWebElement extends Base {
	
	
	
	@Test(priority =1)
	public void verifyWebElements() throws MalformedURLException {
		try {
		driver.get("https://demo.nopcommerce.com/login");
		
		
		//get navigate difference navigate mehtod implements url instance also
		
		//URL url = new URL("https://demo.nopcommerce.com/login");
		//driver.navigate().to(url);
		
		//String classname = this.getClass().getSimpleName();
		//System.out.println(classname);
		
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());		
		
		WebElement store = driver.findElement(By.id("small-searchterms"));
		System.out.println(store.isDisplayed());
		logger.log(Status.INFO, "isDisplayed() method passed");
		
		System.out.println(store.isEnabled());
		logger.log(Status.INFO, "isenabled() method passed");
		logger.log(Status.PASS,new Object(){}.getClass().getEnclosingMethod().getName()+" passed");
		}
		catch(Exception e) {
			logger.log(Status.FAIL,new Object(){}.getClass().getEnclosingMethod().getName()+ "failed");
			e.printStackTrace();
		}
		
	}
	
	@Test(priority =2,groups={"sanity"})
	public void verifyselectedfunction() {
		try {
			
		
		driver.findElement(By.linkText("Register")).click();
		
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println(male.isSelected()); //false
		System.out.println(female.isSelected());//false
		male.click();
		System.out.println(male.isSelected());//true
		System.out.println(female.isSelected());//false
		female.click();
		System.out.println(male.isSelected());//false
		System.out.println(female.isSelected());//true
		
		logger.log(Status.PASS, new Object(){}.getClass().getEnclosingMethod().getName()+" passed");
		
		}
		catch(Exception e) {
			logger.log(Status.FAIL, new Object(){}.getClass().getEnclosingMethod().getName()+" failed");
			e.printStackTrace();
		}
	}
	

}
