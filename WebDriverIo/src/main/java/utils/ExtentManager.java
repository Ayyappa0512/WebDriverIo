package utils;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	
	    
	public synchronized static ExtentReports createInstance(String name) {
		if (extent == null)  {   
		//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(name);//for 3 and 4 versions
			//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        //htmlReporter.config().setChartVisibilityOnOpen(true);
		// htmlReporter.config().setTheme(Theme.DARK);
        //htmlReporter.config().setDocumentTitle("Selenium WebDriverIO");
        //htmlReporter.config().setEncoding("utf-8");
       // htmlReporter.config().setReportName("WEbdriverExamples");
        
		ExtentSparkReporter spark = new ExtentSparkReporter(name);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Selenium WebDriverIO");
		spark.config().setReportName("WebDriverExamples");
			
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Ayyappa");
		}
        return extent;
    }
}
