package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Com5_JqurreyDropDown extends Base{

	
	@Test
	public void selectoptiondfromjqurreydropdown() {
		try {
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		Com5_JqurreyDropDown  obj = new Com5_JqurreyDropDown();
		//obj.selectchoicevalue(driver, "choice 1");
		//obj.selectchoicevalue(driver, "choice 1", "choice 2", "choice 2 2", "choice 5");
		obj.selectchoicevalue(driver, "All");
		logger.log(Status.PASS, new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
		}
		catch(Exception e) {
			logger.log(Status.FAIL, new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
			logger.fail(e.getMessage());
		}
	}
	
	public void selectchoicevalue(WebDriver driver,String...value) {
		
		List<WebElement> choicelist=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if(!value[0].equalsIgnoreCase("All")) {
			
			for(WebElement item:choicelist) {
				String text=item.getText();
				for(String choice:value) {
					if(choice.equalsIgnoreCase(text)){
						item.click();
						break;
					}
				}
			}
		}else {
			try {
			for(WebElement item:choicelist) {
				item.click();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
			
	}
	
}}
