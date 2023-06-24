package utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listerners extends TestListenerAdapter {
	
	@Override	
	public void onStart(ITestContext testContext)
	{	
		
	}
	@Override
	public void onTestStart(ITestResult tr) {
		
		System.out.println("Test case Starts: "+tr.getName());
	}
	@Override
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("Test case Sucessfull: "+tr.getName());
	}
	@Override
	public void onTestFailure(ITestResult tr)
	{
		System.out.println("Test case Failure:"+tr.getName());		
	}
	@Override
	public void onTestSkipped(ITestResult tr)
	{
		System.out.println("Test case Skipped:"+tr.getName());
	}
	@Override
	public void onFinish(ITestContext testContext)
	{
		
	}
}
