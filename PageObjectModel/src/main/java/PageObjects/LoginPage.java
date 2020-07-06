package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BasePage{
	AndroidDriver<AndroidElement> driver;
	
	public LoginPage(AndroidDriver<AndroidElement> driver) throws IOException {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	public WebElement skipLogin;
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
	public WebElement signInButton;
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/new_user")
	public WebElement createAccount;
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_email_login']")
	public WebElement userNameTextbox;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='continue']")
	public WebElement continueButton;
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_password']")
	public WebElement passwordBox;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='signInSubmit']")
	public WebElement signinSubmitButton;
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='English - EN']")
	public WebElement languageRadioButton;
	
	
	public void clickSkipLogin()
	{
		skipLogin.click();
	}
	
	public void userLogin() throws InterruptedException
	{
		waitForElementPresence(signInButton);
		clickElement(signInButton);
		setValueToField(userNameTextbox, "7005683728");
		clickElement(continueButton);
		setValueToField(passwordBox, "Welcome@123");
		clickElement(signinSubmitButton);
	}

}
