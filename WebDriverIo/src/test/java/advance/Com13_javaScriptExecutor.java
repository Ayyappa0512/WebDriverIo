package advance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basics.Base;

public class Com13_javaScriptExecutor extends Base {
		
	
	@Test
	public void jse_interface() throws InterruptedException {
		try {
		//create js object for interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://demoqa.com/");
		
		//click element using js
		//js.executeScript("document.getElementById('live-scores-link').click();");
		WebElement ele = driver.findElement(By.xpath("//h5[text()='Elements']"));
		js.executeScript("arguments[0].click();",ele);
		System.out.println("---Element click sucessful---");
		//extentlog.log(Status.PASS, "Element click sucessful");
				
		Thread.sleep(3000);
		//enter text using js
		//js.executejs.executeScript("document.getElementByID('search_bar_menu').click();");Script("document.getElementByID('search_bar_menu').click();");
		WebElement ele_text = driver.findElement(By.xpath("//span[text()='Text Box']"));
		js.executeScript("arguments[0].click();",ele_text);
		js.executeScript("document.getElementById('userName').value='Ayyappa';");
		Thread.sleep(3000);
		System.out.println("---Text entered sucessful---");
		
		//handle radio button  using js
		WebElement ele4 = driver.findElement(By.xpath("//span[text()='Check Box']"));
		js.executeScript("arguments[0].click();",ele4);
		WebElement ele3 = driver.findElement(By.xpath("//span[contains(text(),'Home')]"));
		js.executeScript("arguments[0].checked=true;",ele3);
		System.out.println("---Check Box checked sucessfully---");
		Thread.sleep(3000);
				
		//handle radio button  using js
		WebElement ele2 = driver.findElement(By.xpath("//span[text()='Radio Button']"));
		js.executeScript("arguments[0].click();",ele2);
		
		//WebElement ele3 = driver.findElement(By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']//*[@class='rct-icon rct-icon-uncheck']"));
		js.executeScript("document.getElementById('yesRadio').checked=true;");
		Thread.sleep(3000);
		System.out.println("---Radio butten selected sucessfully---");
		

		js.executeScript("alert('Welcome To Selenium Testing');");
		
		driver.switchTo().alert().accept();

		Thread.sleep(3000);
		
		js.executeScript("history.go(0)");
		Thread.sleep(3000);
		
		String innerText = js.executeScript(" return document.documentElement.innerText;").toString();
		System.out.println(innerText);
		
		String titleText =  js.executeScript("return document.title;").toString();
		System.out.println(titleText);
		
		String domainName=  js.executeScript("return document.domain;").toString();
		System.out.println(domainName);
		
		String url=  js.executeScript("return document.URL;").toString();
		System.out.println(url);
		
		String height=js.executeScript("return window.innerHeight;").toString();
		String width=js.executeScript("return window.innerWidth;").toString();
		System.out.println(height);
		System.out.println(width);
		
		js.executeScript("window.scrollTo(0,500)");
		logger.log(Status.PASS, new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
		
		}
		catch(Exception e) {
			logger.log(Status.FAIL, new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
			logger.fail(e.getMessage());
		}
	}
}
