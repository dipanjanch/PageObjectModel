package utility;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import PageObjects.BasePage;

public class Listners extends BasePage implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		reporter.pass("Test case passed");
		String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		try {
			reporter.log(Status.INFO, "Snapshot below: ",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		reporter.fail("Test case failed");
		String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		try {
			reporter.log(Status.INFO, "Snapshot below: ",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
