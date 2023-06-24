package basics;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ConfigPro;
import utils.ExtentManager;


public class Base {
		public static ExtentReports extent;
		public static ExtentTest parentTest; 
		public static ExtentTest logger;
		//private static ThreadLocal parent = new ThreadLocal();
	    //private static ThreadLocal test = new ThreadLocal();
		public  WebDriver driver;
		ConfigPro config = new ConfigPro();
		//public Properties pro;
	
	//public static void main(String[] args) {
		@BeforeTest(alwaysRun=true)
		public synchronized void setup() {
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        String reportFileLocation = System.getProperty("user.dir")+"/test-output/Test-Report_" + timestamp + ".html";
			extent = ExtentManager.createInstance(reportFileLocation);
			//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileLocation);
			//extent.attachReporter(htmlReporter);
		}
				
		@Parameters({"browser"})
		@BeforeClass()
		public synchronized void launchBrowser(String br) {
			
			parentTest= extent.createTest(getClass().getSimpleName());
			//parent.set(parentTest);
			
			//Method=extent.createTest(this.getClass().getNestHost().getSimpleName());
			
			config.readconfig("G:\\WORK\\WebDriverIo\\src\\test\\resources\\Properties\\ConfigProperties.properties");
			//to open chrome browser
			//String s=config.readString("chromepath");
			//System.setProperty(config.readString("chromedriver"),s);
			//driver = new ChromeDriver();
			//String br="firefox";
			//to open firefoxbrowser
			if(br.equals("firefox")) {
				System.setProperty(config.readString("firefoxdriver"), config.readString("firefoxpath"));
				driver = new FirefoxDriver();
			}
			
			//to open in chrome
			if(br.equals("chrome")) {
				System.setProperty(config.readString("chromedriver"), config.readString("chromepath"));
				driver = new ChromeDriver();
			}
		
			driver.manage().window().maximize();
			
						
		}
		 @BeforeMethod
		    public synchronized void beforeMethod(Method method) {
			 logger = parentTest.createNode(method.getName());
			// test.set(logger);
		    }

		    @AfterMethod
		    public synchronized void afterMethod(Method method) throws IOException {
		        if (logger.getStatus() == Status.FAIL) {
		            logger.addScreenCaptureFromPath(capturescreen(driver, method.getName()));
		        }
		        else if (logger.getStatus() == Status.SKIP)
		            logger.skip(method.getName()+ " is Skiped");
		        else
		            logger.pass("Test passed");

		        extent.flush();
		    }
		
		@AfterClass(alwaysRun = true)
		public void close() {
			//if(result.getStatus() != ITestResult.FAILURE){
			driver.quit();
			extent.flush();
			//}
		}
		
		public String capturescreen(WebDriver driver,String name) {
			TakesScreenshot ts =(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "\\screenshots\\" + name + ".png";
			File trg = new File(System.getProperty("user.dir") + "\\screenshots\\" + name + ".png");
			try {
				FileUtils.copyFile(src, trg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return path;
		}
	
}
