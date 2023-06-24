package basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Com6_CheckingDropdownSorted extends Base {
	
	
	@Test
	public void checkingdropdownSorted() {
		
		try {
		driver.get("https://www.twoplugs.com/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
		WebElement drpele = driver.findElement(By.name("category_id"));
		
		Select select = new Select(drpele);
		
		List<WebElement> list=select.getOptions();
		
		ArrayList<String> originallist = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		
		for(WebElement listitems:list) {
			originallist.add(listitems.getText());
			temp.add(listitems.getText());
		}
		
		System.out.println("original list : "+originallist);
		System.out.println("temp before sort : "+temp);
		
		Collections.sort(temp);
		System.out.println("temp before sort : "+temp);
		
		if(originallist.equals(temp)) {
			System.out.println("dropdown is in sorted order");
		}else
			System.out.println("dropdown is in unsorted order");
		logger.log(Status.PASS, new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
	}
	catch(Exception e) {
		logger.log(Status.FAIL,new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
		logger.fail(e.getMessage());
	}
	}
}
