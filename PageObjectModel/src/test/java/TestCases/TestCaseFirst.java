package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.BasePage;
import PageObjects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.LogClass;

public class TestCaseFirst extends BasePage{
	
	public  AndroidDriver<AndroidElement> driver;
	LoginPage login;
	
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		LogClass.info("BeforeTest");
		setupFiles();
		driver = getDriver();
		login = new LoginPage(driver);
	}
	
	@Test
	public void addToCart() throws InterruptedException
	{
		reporter = report.createTest("Add to cart");
		LogClass.info("Test");
		login.userLogin();
		reporter.info("Login Sucessful");
	}
	
	@AfterTest
	public void quit()
	{
		LogClass.info("AfterTest");
		quitDriver();
	}

}
