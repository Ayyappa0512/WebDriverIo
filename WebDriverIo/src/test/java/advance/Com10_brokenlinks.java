package advance;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basics.Base;

public class Com10_brokenlinks extends Base {
	
	@Test
	public void brokenlinks() throws Exception {
		try {
		driver.get("http://www.deadlinkcity.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		int broken=0;
		
		for(WebElement ele:links) {
		//System.out.println(link.getText() + link.getAttribute("href"));
			
		String url = ele.getAttribute("href");
		if(url==null || url.isEmpty()) {
			System.out.println("url is empty");
			continue;
		}else {
		
		URL link = new URL(url);
		try {			
		HttpURLConnection httpcon = (HttpURLConnection) link.openConnection();
		httpcon.connect();
		if(httpcon.getResponseCode()>=400) {
			System.out.println(httpcon.getResponseCode()+ele.getText()+": This link is broken");
			broken++;
		}else {
			System.out.println(httpcon.getResponseCode()+ele.getText()+": This link is  valid");
		}
		}catch(Exception e) {
			System.out.println(e);
		}//catch(ClassCastException e) {
			//System.out.println(e.getStackTrace());
		//}
		}
		}
		
		System.out.println(broken);
		logger.log(Status.PASS, new Object(){}.getClass().getEnclosingMethod().getName() + " Passed");
		}
		catch(Exception e) {
			logger.log(Status.FAIL, new Object(){}.getClass().getEnclosingMethod().getName()+ " failed");
			logger.fail(e.getMessage());
		}
	}
}
