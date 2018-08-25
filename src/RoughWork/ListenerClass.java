package RoughWork;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName() + " module is onTestStart.");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		System.out.println(result.getMethod().getMethodName() + " module is onTestSuccess.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName() + " module is onTestFailure.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println(result.getMethod().getMethodName() + " module is onTestSkipped.");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		System.out.println(result.getMethod().getMethodName() + " module is onTestFailedButWithinSuccessPercentage.");
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println(context.getName() + " module is onStart.");
	}

	@Override
	public void onFinish(ITestContext context) {
	
		System.out.println(context.getName() + " module is onFinish.");
	}
	
	

}
