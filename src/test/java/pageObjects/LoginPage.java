package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
//	Constructor
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
//	Locators
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailID;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	

	@FindBy(xpath = "//input[@value='Login']")
	WebElement Login;


public void setLoginEmail(String lemail) {
	emailID.sendKeys(lemail);

}
public void setLoginPassword(String lpwd) {
	password.sendKeys(lpwd);
}

public void clicklLoginBtn() {
	Login.click();
}
}

