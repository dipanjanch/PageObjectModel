package PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utility.LogClass;


public class BasePage {
	public static AndroidDriver<AndroidElement> driver;
	public static Properties property;
	public static ExtentReports report;
	public static ExtentTest reporter;
	
	public void setupFiles() throws IOException
	{
		property = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/global.properties");
		property.load(fs);
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/addTocart" + "sample" + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		LogClass.info("Extent Report initialized");
		
	}
	
	public static AndroidDriver<AndroidElement> getDriver() throws IOException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String device = property.getProperty("device");
		String UDID = (String) property.get("UDID");
		String appPackage = (String) property.get("AppPackage");
		String appActivity = (String) property.get("AppActivity");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("udid", UDID);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void quitDriver()
	{
		driver.quit();
	}
	
	
	public void clickElement(WebElement ele) throws InterruptedException {	
			ele.click();
			reporter.pass(ele+" is cicked");
		
		
	}

	
	public void setValueToField(WebElement ele, String val) {		
			ele.clear();
			ele.sendKeys(val);
			reporter.pass("Setting vaule "+val+" To "+ ele);
	}

	
	public boolean isElementDisplayed(WebElement ele) {
		waitForElementPresence(ele);
		return ele.isDisplayed();
	}

	public void waitForElementPresence(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	

}
